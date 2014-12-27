val wicket = "org.apache.wicket" % "wicket" % "7.0.0-M4"
val postgresql = "org.postgresql" % "postgresql" % "9.3-1102-jdbc41"

lazy val root = (project in file(".")).
  settings(
      name := "springrts.ru website",
      version := "0.1",
      scalaVersion := "2.11.4",

      libraryDependencies += wicket,
      libraryDependencies += postgresql
  )

// disable .jar publishing
publishArtifact in (Compile, packageBin) := false

// create an Artifact for publishing the .war file
artifact in (Compile, packageWar) := {
  val previous: Artifact = (artifact in (Compile, packageWar)).value
  previous.copy(`type` = "war", extension = "war")
}

// add the .war file to what gets published
addArtifact(artifact in (Compile, packageWar), packageWar)
