name := "springrts-ru-website"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"

libraryDependencies += "org.apache.wicket" % "wicket" % "7.5.0"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1212.jre7"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.21"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.21"

libraryDependencies += "dom4j" % "dom4j" % "1.6.1"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.1.2.Final"

libraryDependencies += "org.springframework" % "spring-context" % "4.3.4.RELEASE"

libraryDependencies += "org.springframework" % "spring-web" % "4.3.4.RELEASE"

libraryDependencies += "org.springframework" % "spring-aop" % "4.3.4.RELEASE"

libraryDependencies += "org.apache.wicket" % "wicket-spring" % "7.5.0"

libraryDependencies += "org.springframework.data" % "spring-data-jpa" % "1.10.5.RELEASE"

enablePlugins(JettyPlugin)

publishArtifact in (Compile, packageBin) := false

