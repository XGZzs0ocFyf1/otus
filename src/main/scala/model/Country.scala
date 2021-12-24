package model

case class Afn(
                name: String,
                symbol: String
              )

case class Currencies(
                       AFN: Afn
                     )

case class Demonyms(
                     eng: Eng,
                     fra: Eng
                   )

case class Eng(
                f: String,
                m: String
              )

case class Idd(
                root: String,
                suffixes: Seq[String]
              )

case class Name(
                 common: String,
                 official: String,
                 native: Native
               )

case class Native(
                   prs: String,
                   pus: String,
                   tuk: String
                 )

case class Prs(
                official: String,
                common: String
              )

case class Country(
                          name: Name,
                          tld: Seq[String],
                          cca2: String,
                          ccn3: String,
                          cca3: String,
                          cioc: String,
                          independent: Boolean,
                          status: String,
                          unMember: Boolean,
                          currencies: Currencies,
                          idd: Idd,
                          capital: Seq[String],
                          altSpellings: Seq[String],
                          region: String,
                          subregion: String,
                          languages: Native,
                          translations: Translations,
                          latlng: Seq[Int],
                          landlocked: Boolean,
                          borders: Seq[String],
                          area: Int,
                          flag: String,
                          demonyms: Demonyms
                        )

case class Translations(
                         ces: Prs,
                         cym: Prs,
                         deu: Prs,
                         est: Prs,
                         fin: Prs,
                         fra: Prs,
                         hrv: Prs,
                         hun: Prs,
                         ita: Prs,
                         jpn: Prs,
                         kor: Prs,
                         nld: Prs,
                         per: Prs,
                         pol: Prs,
                         por: Prs,
                         rus: Prs,
                         slk: Prs,
                         spa: Prs,
                         swe: Prs,
                         urd: Prs,
                         zho: Prs
                       )

