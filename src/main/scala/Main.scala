import dto.CountryDto
import io.circe.generic.auto._
import io.circe.parser.decode
import io.circe.syntax._
import model.Country

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.language.implicitConversions
import scala.util.{Failure, Success, Try}

object Main extends App {

  val url = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json"

  //возможно здесь имело бы смысл подумать над несколькими попытками подключения при разовой недоступности ресурса
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


  Try(args(0)) match {
    case Success(value) =>
      println(s"Сохраняю в файл $value")
      Try {
        Files.write(Paths.get(s"$value.json"), json.getBytes(StandardCharsets.UTF_8))
      } match {
        case Success(_) => println(s"Успешно сохранено")
        case Failure(exception) => println(s" Не удалось сохранить\n$exception")
      }
    case _ => println("Что-то пошло не так. Посмотри мануал.") //я думаю пользователю не интересно что там сломалось
  }


}

