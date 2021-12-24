package model

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import model.Gender._


object CatStuff extends App{

  val fluff = Cat("Пушок", 1, Fluff("Белый", 10), None)
  println(fluff)

  val jsoned = fluff.asJson.noSpaces
  println(jsoned)

  val decodedCat = decode[Cat](jsoned)

  println(decodedCat.right.get)


}
