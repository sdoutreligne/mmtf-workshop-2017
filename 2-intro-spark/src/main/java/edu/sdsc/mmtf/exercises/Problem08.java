package edu.sdsc.mmtf.exercises;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Problem08 {

	/** Calculate +/-2 for values in JavaPairRDD.
	 *
	 * @author Yana Valasatava
	 */

	public static void main(String[] args) {

		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName(Problem08.class.getSimpleName());
		JavaSparkContext sc = new JavaSparkContext(conf);

		List<Tuple2<String, Integer>> data = Arrays.asList(
				new Tuple2("first", 2),
				new Tuple2("second", 4));

		JavaRDD rdd = sc.parallelize(data);
		JavaPairRDD pairRdd = JavaPairRDD.fromJavaRDD(rdd);

		// TODO
		// calculate +/-2 for values in JavaPairRDD


		sc.close();
	}
}
