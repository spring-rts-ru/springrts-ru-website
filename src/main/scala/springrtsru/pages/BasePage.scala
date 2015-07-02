package springrtsru.pages

import org.apache.wicket.AttributeModifier
import org.apache.wicket.markup.html.{WebMarkupContainer, WebPage}
import org.apache.wicket.markup.html.basic.Label

trait PageIndex
case object Home extends PageIndex
case object News extends PageIndex
case object HowToInstall extends PageIndex
case object Media extends PageIndex
case object About extends PageIndex
case object Widgets extends PageIndex

abstract class BasePage extends WebPage {
  def getTitle: String
  def getPageIndex: PageIndex

  val newsLink = new WebMarkupContainer("newsLink")
  add(newsLink)
  val howToPlayLink = new WebMarkupContainer("howToPlayLink")
  add(howToPlayLink)
  val mediaLink = new WebMarkupContainer("mediaLink")
  add(mediaLink)

  getPageIndex match {
    case News => newsLink.add(new AttributeModifier("class", "active"))
    case HowToInstall => howToPlayLink.add(new AttributeModifier("class", "active"))
    case Media => mediaLink.add(new AttributeModifier("class", "active"))
    case _ =>
  }

  add(new Label("title", getTitle).setRenderBodyOnly(true))
}
