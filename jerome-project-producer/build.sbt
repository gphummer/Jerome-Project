name := """jerome-project-producer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

resolvers += "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.11" % "0.8.2.1",
  "com.101tec" % "zkclient" % "0.3",
  jdbc,
  anorm,
  cache,
  ws
)


fork in run := true