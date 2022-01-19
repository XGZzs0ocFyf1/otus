package dto

import model.Country

case class CountryDto(
  name   : String,
  capital: String,
  area   : Double
)

object CountryDto {
  def createDto(country: Country): CountryDto =
    CountryDto(
      name = country.name.common,
      capital = country.capital.head,
      area = country.area
    )
}
