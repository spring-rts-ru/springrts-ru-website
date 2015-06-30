name := "springrts-ru-website"

version := "1.0"

scalaVersion := "2.11.7"

jetty()

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"

libraryDependencies += "org.apache.wicket" % "wicket" % "7.0.0-M6"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.12"

publishArtifact in (Compile, packageBin) := false

