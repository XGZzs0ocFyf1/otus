import model.Country

import java.nio.file.{Files, Path}

object Main extends App{
  import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

  sealed trait Foo
  case class Bar(xs: Vector[String]) extends Foo
  case class Qux(i: Int, d: Option[Double]) extends Foo

  val foo: Foo = Qux(13, Some(14.0))

  val json = foo.asJson.noSpaces
  println(json)

  val decodedFoo = decode[Foo](json)
  println(decodedFoo)


  val input = Files.readString( Path.of("single.json"))
 // println(s"input size = ${input.size()}")

  val sample = input.substring(200)
  println(s"Фрагмент прочитанный из файла $sample")

  val a = parse(sample).getOrElse(Json.Null)
  println(s" a = $a")
//
//  decode[List[Country]](input) match {
//    case Left(value) => println("Не получилось распарсить строку")
//    case Right(value) =>
//      println("Получилось распарсить строку")
//      println(value.size)
//  }







}
