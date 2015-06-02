package models

import play.api.libs.json._

/**
 * Created by gphummer on 5/27/15.
 */
object Person {

  case class Person(name: String)

  implicit val personWrites = Json.writes[Person]
  implicit val personReads = Json.reads[Person]

  var people = List(Person("Grant Hummer"), Person("Jerome Thibaud"), Person("Thomas Lee"))

  def addPerson(p: Person) = people = people ::: List(p)

  implicit val personFormat = Json.format[Person]
}
