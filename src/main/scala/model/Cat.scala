package model

import model.Gender.Gender

trait  Fluffy

case class Cat(
              name: String,
              age: Int,
              fluff: Fluff,
              gender: Option[String]
              )
  extends Fluffy

