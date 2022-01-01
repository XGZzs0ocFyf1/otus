import dto.CountryDto
import io.circe.generic.auto._
import io.circe.parser.decode
import io.circe.syntax._
import model.Country

import scala.io.Source

object Main extends App {
  val url = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json"
  val resource = Source.fromURL(url)
  val json = try {
    val data = resource.mkString
    val decoded = decode[List[Country]](data)
    decoded match {
      case Right(value) =>
        value
          .filter(_.region == "Africa")
          .sortBy(_.area)(Ordering[Double].reverse)
          .slice(0, 10)
          .map(CountryDto.createDto)
          .asJson
          .noSpaces
      case Left(value) => throw new RuntimeException(s"Parsing problems: $value")
    }
  } finally {
    resource.close
  }
  println(json)

//TODO write json to file
//  Files.write(Paths.get("lowered"), lower.getBytes())



}

