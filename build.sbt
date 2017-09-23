name := "springrts-ru-website"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"

libraryDependencies += "org.apache.wicket" % "wicket" % "7.9.0"

libraryDependencies += "org.apache.wicket" % "wicket-spring" % "7.9.0"

libraryDependencies += "org.postgresql" % "postgresql" % "42.1.1"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.2.10.Final"

libraryDependencies += "org.springframework" % "spring-context" % "4.3.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-web" % "4.3.8.RELEASE"

libraryDependencies += "org.springframework" % "spring-aop" % "4.3.8.RELEASE"

libraryDependencies += "org.springframework.data" % "spring-data-jpa" % "1.11.3.RELEASE"

enablePlugins(JettyPlugin)

publishArtifact in (Compile, packageBin) := false

