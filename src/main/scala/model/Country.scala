package model

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import scala.io.Source
import scala.util.Using

case class Country(
  name   : Name,
  capital: List[String],
  area   : Double,
  region : String
) {
  override def toString: String =
    s"Country(name: $name,capital: $capital,area: $area, region: $region)"

}






