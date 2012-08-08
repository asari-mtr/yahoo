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
    val items = Rss.get
    Ok(toJson(Map("items" -> toJson(items.map(i => Map("title" -> i.title, "link" -> i.link))))))
  }
  
}
