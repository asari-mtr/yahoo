package models

import scala.xml.XML
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

case class Rss(val title:String, val link:String, val pubDate:Date)

object Rss {
  def get():List[Rss] = {

    val xml = XML.load(new URL("http://rss.dailynews.yahoo.co.jp/fc/rss.xml"))

    val format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US)

    var items = List.empty[Rss]

    for (item <- xml \\ "item") {
        val pubDate = (item \ "pubDate").text
        val date = format.parse(pubDate)
        items = Rss(
            ((item \ "title").text),
            ((item \ "link").text),
            date) :: items
    }

    items
  }
}
