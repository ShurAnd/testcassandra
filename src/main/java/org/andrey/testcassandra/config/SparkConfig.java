package org.andrey.testcassandra.config;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {
    @Bean
    public SparkSession sparkSession() {
        SparkConf sparkConf = new SparkConf()
                .setAppName("Testing Cassandra With Hadoop And Spark")
                .setMaster("spark://127.0.0.1:7077")
                .set("spark.executor.memory", "2g")
                .set("spark.driver.memory", "2g")
                .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");

        return SparkSession.builder()
                .config(sparkConf)
                .getOrCreate();
    }
}
