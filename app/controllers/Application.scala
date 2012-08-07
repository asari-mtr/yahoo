package controllers

import play.api._
import play.api.mvc._

import play.api.libs.json._
import play.api.libs.json.Json._

import play.api.libs.ws.WS

import models.Rss

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(Rss.get()))
  }

  def read = Action {
    Async {
      WS.url("http://rss.dailynews.yahoo.co.jp/fc/rss.xml").get().map { response =>
        val item = Rss.getYahoo(response.body)
        Ok(toJson(
            Map("status" -> "OK", "message" -> response.body.toString)
        ))
      }
    }
  }
  
}
