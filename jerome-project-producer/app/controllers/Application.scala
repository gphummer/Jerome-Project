package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import akka.actor.{ActorSystem, ActorRef}
import play.api.libs.json._
import services.{KafkaProducer, KafkaSender}


object Application extends Controller {

  val system = ActorSystem("KafkaClients")

  val grant: String = "Grant"

  val kafkaProducer: ActorRef = system.actorOf(KafkaSender.props("test"), "producer")

  def index = Action {
    Ok(views.html.index("Enter something already, techie scum."))
  }

//  val personForm = Form(
//    mapping(
//      "full_name" -> nonEmptyText
//    )(Person.apply)(Person.unapply)
//  )

  val singleForm = Form(
    single(
      "full_name" -> nonEmptyText
    )
  )

  def sendPerson = Action { implicit request =>
    val p = singleForm.bindFromRequest.get
    kafkaProducer ! p
    Redirect(routes.Application.index())
  }

//  def sendPerson = Action(BodyParsers.parse.anyContent) { request =>
//    val p = request.body.asText.toString
//    Person.addPerson(Person(p))
////    kafkaProducer ! p
//    kafkaProducer ! p
//    Ok(Json.obj("status" -> "OK"))
//  }

}