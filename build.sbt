name := "springrts-ru-website"

version := "1.0"

scalaVersion := "2.11.4"

jetty()

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"

libraryDependencies += "org.apache.wicket" % "wicket" % "7.0.0-M4"

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1102-jdbc41"

publishArtifact in (Compile, packageBin) := false
