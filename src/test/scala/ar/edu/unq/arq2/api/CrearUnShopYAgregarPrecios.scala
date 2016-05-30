package ar.edu.unq.arq2.api

import io.gatling.core.Predef._
import io.gatling.core.body.StringBody
import io.gatling.http.Predef._
import scala.concurrent.duration._

class CrearUnShopYAgregarPrecios extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080/api/v1")
    .acceptHeader("application/json")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1")

  val scn = scenario("Scenario Name")
    // buscar un shop
    .exec(http("request_1_shops")
      .get("/shops")
      .queryParam("offset", "0")
      .queryParam("limit", "5")
      .asJSON)
    .pause(2)
    // crear un shop (no esta el que buscabamos)
    .exec(http("request_2_shops")
      .post("/shops")
      .body(new StringBody("{\n   \"name\": \"Coto Avellaneda\",\n   \"location\": \"Avellaneda\",\n   \"address\": \"Av. Italia 300\",\n   \"latitude\": \"-34.664883\",\n   \"longitude\": \"-58.362313\"\n}"))
      .asJSON)
    .pause(1)
    // crear algunos precios en ese shop
    .exec(http("request_3_found-prices")
      .post("/found-prices")
      .body(new StringBody("{\n   \"shop_id\": \"573cd27b612a8772df745c11\",\n   \"product_id\": \"7794626006968\",\n   \"price\": 122.18,\n   \"datetime\": \"2016-04-02T15:51:15-03:00\"\n}"))
      .asJSON)
    .pause(1)
    .exec(http("request_4_found-prices")
      .post("/found-prices")
      .body(new StringBody("{\n   \"shop_id\": \"573cd27b612a8772df745c11\",\n   \"product_id\": \"7794626006968\",\n   \"price\": 122.18,\n   \"datetime\": \"2016-04-02T15:51:15-03:00\"\n}"))
      .asJSON)
    .pause(1)
    .exec(http("request_5_found-prices")
      .post("/found-prices")
      .body(new StringBody("{\n   \"shop_id\": \"573cd27b612a8772df745c11\",\n   \"product_id\": \"7794626006968\",\n   \"price\": 122.18,\n   \"datetime\": \"2016-04-02T15:51:15-03:00\"\n}"))
      .asJSON)
    .pause(1)
    .exec(http("request_6_found-prices")
      .post("/found-prices")
      .body(new StringBody("{\n   \"shop_id\": \"573cd27b612a8772df745c11\",\n   \"product_id\": \"7794626006968\",\n   \"price\": 122.18,\n   \"datetime\": \"2016-04-02T15:51:15-03:00\"\n}"))
      .asJSON)

  setUp(scn
    .inject(
      atOnceUsers(10),
      rampUsers(10) over(5 seconds),
      constantUsersPerSec(20) during(15 seconds))
    .protocols(httpConf))
}
