package duh.app

import org.scalatra._
import scalate.ScalateSupport
import duh.models.Account
import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json._
import org.json4s.JsonAST.JValue

class MyScalatraServlet extends ScalatramongodbStack with JacksonJsonSupport {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say<a href="hello-scalate">hello to Scalate</a>
        .
      </body>
    </html>
  }

  import org.slf4j.{Logger, LoggerFactory}
  val logger =  LoggerFactory.getLogger(getClass)

  get("/echo/?:what?") {
    assert(Account.count >= 0)

    logger.info("Total accounts {}", Account.count)
    
    val what = params.getOrElse("what", "void")
    <p>Echoing { what }!</p>
  }

  // Sets up automatic case class to JSON output serialization, required by
  // the JValueResult trait.
  protected implicit val jsonFormats: Formats = DefaultFormats

  // Before every action runs, set the content type to be in JSON format.
  //  before() {
  //    contentType = formats("json")
  //  }

  get("/accounts") {
    s"Stored Accounts: ${Account.count}"
  }
  
  post("/accounts") {
    contentType = formats("json")
    
    val accountJson = parsedBody.extract[JValue] \ "account"
    
    // simple extraction
    // val key = (accountJson \ "key").extract[String]
    // val description = (accountJson \ "description").extract[String]
    
    // case class extraction
    val account = accountJson.extract[Account]
    account.save

    Map("msg" -> s"Account '${account.key}' was created.")
  }

}
