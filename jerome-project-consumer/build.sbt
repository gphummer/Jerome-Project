name := """jerome-project-consumer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

resolvers += "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.10" % "0.8.2-beta",
  "com.101tec" % "zkclient" % "0.3",
  jdbc,
  anorm,
  cache,
  ws
)


fork in run := true