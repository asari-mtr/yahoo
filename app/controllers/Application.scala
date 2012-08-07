package controllers

import play.api._
import play.api.mvc._

import play.api.libs.json._
import play.api.libs.json.Json._

import models.Rss

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(Rss.get()))
  }

  def read = Action {
    Ok(toJson(
        Map("status" -> "OK", "message" -> "Hello World")
    ))
  }
  
}
