package edu.sdsc.mmtf.exercises;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution08 {

	/** Calculate +/-2 for values in JavaPairRDD.
	 *
	 * @author Yana Valasatava
	 */

	public static void main(String[] args) {

		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName(Solution08.class.getSimpleName());
		JavaSparkContext sc = new JavaSparkContext(conf);

		List<Tuple2<String, Integer>> data = Arrays.asList(
				new Tuple2("first", 2),
				new Tuple2("second", 15));

		JavaRDD rdd = sc.parallelize(data);
		JavaPairRDD pairRdd = JavaPairRDD.fromJavaRDD(rdd);

		// TODO
		// calculate +/-2 for values in JavaPairRDD
		JavaPairRDD<Integer, String> newPairRdd = pairRdd.flatMapValues(new Function<Integer, Iterable<String>>() {
			@Override
			public Iterable<String> call(Integer value) throws Exception {
				List<String> list = new ArrayList<>();
				list.add(value+" + 2 = "+ (value+2));
				list.add(value+" - 2 = "+ (value-2));
				return list;
			}
		});
		newPairRdd.foreach(t -> System.out.println(t._1 + ": " + t._2));

		sc.close();
	}
}
