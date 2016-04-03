package springrtsru.pages

import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.{WebMarkupContainer, WebPage}
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.spring.injection.annot.SpringBean
import springrtsru.repository.NewsRepository

import scala.beans.BeanProperty

trait PageIndex
case object Home extends PageIndex
case object News extends PageIndex
case object History extends PageIndex
case object Media extends PageIndex
case object About extends PageIndex
case object Widgets extends PageIndex
case object Games extends PageIndex
case object HowTo extends PageIndex

abstract class BasePage extends WebPage {
  def getTitle: String
  def getPageIndex: PageIndex

  @SpringBean
  @BeanProperty
  var repo : NewsRepository = _

  val newsLink = new WebMarkupContainer("newsLink")
  add(newsLink)

  val historyLink = new WebMarkupContainer("historyLink")
  add(historyLink)

  val mediaLink = new WebMarkupContainer("mediaLink")
  add(mediaLink)

  val gamesLink = new WebMarkupContainer("gamesLink")
  add(gamesLink)

  val howToLink = new WebMarkupContainer("howToLink")
  add(howToLink)

  getPageIndex match {
    case News => newsLink.add(new AttributeModifier("class", "active"))
    case History => historyLink.add(new AttributeModifier("class", "active"))
    case Media => mediaLink.add(new AttributeModifier("class", "active"))
    case Games => gamesLink.add(new AttributeModifier("class", "active"))
    case HowTo => howToLink.add(new AttributeModifier("class", "active"))
    case _ =>
  }

  add(new Label("title", getTitle).setRenderBodyOnly(true))
}
