plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "org.andrey"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.apache.spark:spark-sql_2.13:3.5.5")
	{
		exclude(group="org.slf4j")
	}
	implementation("org.apache.spark:spark-core_2.13:3.5.5")
	{
		exclude(group="org.slf4j")
	}
	implementation("org.apache.hadoop:hadoop-hdfs:3.4.1")
	{
		exclude(group="ch.qos.reload4j")
		exclude(group="org.slf4j")
	}

	implementation("org.apache.hadoop:hadoop-client:3.4.1")
	{
		exclude (group="ch.qos.reload4j")
	}
	implementation("org.apache.hadoop:hadoop-common:3.4.1")
	{
		exclude (group="ch.qos.reload4j")
	}
	implementation("org.springframework.boot:spring-boot-starter-data-cassandra")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
