package controllers

import models.Person._
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc._
import play.api._
import akka.actor.{ActorSystem, ActorRef}
import services.{KafkaConsumer}



object Application extends Controller {

  val system = ActorSystem("KafkaClients")

  // make a consumer for the "topic1" topic
//  val kafkaConsumer: ActorRef = system.actorOf(KafkaConsumer.props("test"), "consumerlisten")


  // start consuming events on the "peeps" group
//  kafkaConsumer ! "test"

  def index = Action {
    Ok(views.html.index("Make my day, punk"))
  }

  def receivePerson = Action(BodyParsers.parse.json) { request =>
    val p = request.body.validate[Person]
    p.fold(
      errors => {
        BadRequest(Json.obj("status" -> "Ok", "message" -> JsError.toFlatJson(errors)))
      },
      person => {
        addPerson(person)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }



}