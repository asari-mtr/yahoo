package controllers

import play.api._
import play.api.mvc._

import models.Rss

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(Rss.get()))
  }
  
}
