package org.andrey.testcassandra.services;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparkService {

    private final SparkSession sparkSession;

    @Autowired
    public SparkService(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public void processData() {

        Dataset<Row> data = sparkSession.read().json("hdfs://localhost:8020/data.json");

        data.show();
    }
}
