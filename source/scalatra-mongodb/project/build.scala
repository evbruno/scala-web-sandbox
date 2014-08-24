import sbt._

import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._
import sbtassembly.Plugin._
import sbtassembly.Plugin.AssemblyKeys._

object ScalatramongodbBuild extends Build {
  val Organization = "duh.scalatra"
  val Name = "scalatra-mongodb"
  val Version = "1.0-SNAPSHOT"
  val ScalaVersion = "2.11.1"
  val ScalatraVersion = "2.3.0"
  val CasbahMongoDBVersion = "2.7.3"
  val JettyWebappVersion = "9.1.3.v20140225"

  lazy val project = Project (
    "scalatra-mongodb",
    file("."),
    settings = ScalatraPlugin.scalatraWithJRebel ++ scalateSettings ++ assemblySettings ++ Seq(
      mainClass in assembly := Some("duh.app.JettyLauncher"),
      jarName in assembly := "ScalatraSandbox.jar",
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "org.eclipse.jetty" % "jetty-webapp" % JettyWebappVersion % "container;compile",
        "org.eclipse.jetty" % "jetty-plus" % JettyWebappVersion % "container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar")),
        
        // json related libs
        "org.scalatra" %% "scalatra-json" % "2.3.0",
        "org.json4s"   %% "json4s-jackson" % "3.2.9",
        
        // MongoDB
        "org.mongodb" %% "casbah" % CasbahMongoDBVersion,
        
        "ch.qos.logback" % "logback-classic" % "1.1.1"
      ),
      scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
        Seq(
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "templates",
            Seq.empty,  /* default imports should be added here */
            Seq(
              Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
            ),  /* add extra bindings here */
            Some("templates")
          )
        )
      }
    )
  )
}
