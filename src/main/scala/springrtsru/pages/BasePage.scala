package springrtsru.pages

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label

abstract class BasePage extends WebPage {
  def getTitle: String

  add(new Label("title", getTitle).setRenderBodyOnly(true))
}
