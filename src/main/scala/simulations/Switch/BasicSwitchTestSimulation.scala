///*
//Author: Kesavan
//Reference docs: https://gatling.io/docs/2.3/http/websocket/
//
//*/
//
//package simulations.Switch
//
//import io.gatling.core.Predef._
//import io.gatling.http.Predef._
//
//class BasicSwitchTestSimulation extends Simulation {
//  val server = "adaptor"
//  val port = "7070"
//  val cPath = "/adaptorPath"
//
//  val baseurl = s"http://$server:$port/$cPath"
//  val wsurl = s"ws://$server:$port/$cPath"
//
//  val httpProtocol = http
//    .baseURL(baseurl)
//    .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
//    .acceptHeader("""*/*""")
//    .acceptEncodingHeader("""gzip,deflate,sdch""")
//    .acceptLanguageHeader("""en-US,en;q=0.8,fi;q=0.6""")
//    .contentTypeHeader("""application/json; charset=UTF-8""")
//    .userAgentHeader("""Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.143 Safari/537.36""")
//    .wsBaseURL(wsurl)
//
//  val scn = scenario("websocketloadtest").group("Create Process") {
//    exec(ws("connect")
//      .open(wsurl))
//      .exec(
//        ws("Trial request 1")
//          //to send message as text
//          .sendText("""{"messageType":"loginMessage","channel":"3","userId":"10","timestamp":"1458459904939"}"""))
//          .pause(21474800)
//
//    //to send message as bytes
//    // .sendBytes(bytes: Expression[Array[Byte]])
//
//  };
//
//  //val sample = scenario("socket").exec()
//  setUp(scn.inject(
//    //heavisideUsers(40000) over(500)
//    constantUsersPerSec(10) during (400)
//  )).protocols(httpProtocol)
//}
