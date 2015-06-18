package springrtsru.pages

import org.apache.wicket.markup.html.basic.Label

class AboutPage extends BasePage {
  add(new Label("message", "Hello spring!"))

  override def getTitle: String = "Все о русскоязычном сообществе Spring"
}
