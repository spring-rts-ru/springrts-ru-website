name := "springrts-ru-website"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"

libraryDependencies += "org.apache.wicket" % "wicket" % "7.2.0"

//libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"

libraryDependencies += "org.hsqldb" % "hsqldb" % "2.3.3"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.12"

libraryDependencies += "org.hibernate" % "hibernate-core" % "5.1.0.Final"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final"

libraryDependencies += "org.springframework" % "spring-context" % "4.2.5.RELEASE"

libraryDependencies += "org.springframework" % "spring-web" % "4.2.5.RELEASE"

libraryDependencies += "org.springframework" % "spring-aop" % "4.2.5.RELEASE"

libraryDependencies += "org.apache.wicket" % "wicket-spring" % "7.2.0"

libraryDependencies += "org.springframework.data" % "spring-data-jpa" % "1.9.4.RELEASE"

enablePlugins(JettyPlugin)

publishArtifact in (Compile, packageBin) := false

