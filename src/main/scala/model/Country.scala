package model

case class Country(
  name   : Name,
  capital: List[String],
  area   : Double,
  region : String
) {
  override def toString: String =
    s"Country(name: $name,capital: $capital,area: $area, region: $region)"

}






