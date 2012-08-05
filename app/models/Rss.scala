package models

import java.util.Date

case class Rss(val title:String, val link:String, val pubDate:Date)

object Rss {
  def get():List[Rss] = {
      Rss("hello", "yahoo.co.jp", new Date()) :: Nil
  }
}
