package models

import play.api.libs.json._


case class Person(name: String)

object Person {

  implicit val personWrites = Json.writes[Person]
  implicit val personReads = Json.reads[Person]

  var people = List(Person("Grant Hummer"), Person("Jerome Thibaud"), Person("Thomas Lee"))

  def addPerson(p: Person) = people = people ::: List(p)

  implicit val personFormat = Json.format[Person]
}
