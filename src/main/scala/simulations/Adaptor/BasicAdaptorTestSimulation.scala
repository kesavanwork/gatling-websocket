/*
Author: Kesavan
Reference docs: https://gatling.io/docs/2.3/http/websocket/

*/

package simulations.Adaptor

import environment.{ParamEnvironment, Param}
import testObjects.AccountVerification_ISO8583_Message
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicAdaptorTestSimulation extends Simulation {

  private val environmment = Param.currentEnvironment
  private val constructed_baseurl = "http://localhost:7990"
//  private val constructed_baseurl = environmment.url + ":" + environmment.mainPort
  println(s" the Constructed base url value constructed is $constructed_baseurl")

//  private val constructed_wsurl = environmment.url + ":" + environmment.mainPort
  private val constructed_wsurl = "http://localhost:7990"
  println(s" the constructed Web Socket url value constructed is $constructed_wsurl")

  val accountVerification_Message  =  AccountVerification_ISO8583_Message.accountVerificationMessage



  val httpProtocol = http
    .baseURL(constructed_baseurl)
    .acceptHeader("""*/*""")
    .acceptEncodingHeader("""gzip,deflate,sdch""")
    .contentTypeHeader("""application/json; charset=UTF-8""")
    .disableFollowRedirect
    .shareConnections
    .wsBaseURL(constructed_wsurl)

  val scn = scenario("websocketloadtest").group("Create Process") {
    exec(ws("connect")
      .open(constructed_wsurl))
      .exec(
        ws("Trial request 1")
          //to send message as text
          .sendText(accountVerification_Message))
  };
    //to send message as bytes
    // .sendBytes(bytes: Expression[Array[Byte]])

  setUp(scn.inject(
    constantUsersPerSec(1) during (10)
  )).protocols(httpProtocol)
}


/*
    //heavisideUsers(40000) over(500)
  //val sample = scenario("socket").exec()
//          .sendText("""{"messageType":"loginMessage","channel":"3","userId":"10","timestamp":"1458459904939"}"""))
 val server = "adaptor"
 val port = "7070"
 val cPath = "/adaptorPath"
 val baseurl = s"http://$server:$port/$cPath"
 val wsurl = s"ws://$server:$port/$cPath"

*/

//   private val httpConf = http.baseURL(environment.nftUrl)
//    .disableFollowRedirect
//    .shareConnections
//    .extraInfoExtractor(Prometheus.record)

//  val httpProtocol = http
//    .baseURL(baseurl)
//    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
//    .acceptHeader("""*/*""")
//    .acceptEncodingHeader("""gzip,deflate,sdch""")
//    .acceptLanguageHeader("""en-US,en;q=0.8,fi;q=0.6""")
//    .contentTypeHeader("""application/json; charset=UTF-8""")
//    .userAgentHeader("""Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36""")
//    .wsBaseURL(wsurl)

/*
val scn = scenario("websocketloadtest").group("Create Process") {
  exec(ws("connect")
    .open(wsurl))
    .exec(
      ws("Trial request 1")
        //to send message as text
        .sendText("""{"messageType":"loginMessage","channel":"3","userId":"10","timestamp":"1458459904939"}"""))
    .pause(21474800)

  //to send message as bytes
  // .sendBytes(bytes: Expression[Array[Byte]])

};

//val sample = scenario("socket").exec()
setUp(scn.inject(
  //heavisideUsers(40000) over(500)
  constantUsersPerSec(10) during (400)
)).protocols(httpProtocol)
}
*/

/*

   //Open a websocket connection
 .exec(ws("Connect WS")
   // to open
   .open("/room/chat?username=steph"))
   // if you want to give a think time before sending the request
   .pause(1)
   // if you want to add repeat
   .repeat(2, "i") {
     exec(ws("Say Hello WS")

       //to send message as text
       .sendText("""{"text": "Hello, I'm ${id} and this is message ${i}!"}""")

       //to send message as bytes
         //.sendBytes(bytes: Expression[Array[Byte]])

       // to check if we get a response in next 30 sec
       .check(wsAwait.within(30).until(1).regex(".*I'm still alive.*")))
       .pause(1)
   }

  //close websocket connection
 .exec(ws("Close WS").close)
*/

