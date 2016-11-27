package springrtsru.pages

import org.apache.wicket.markup.html.basic.Label

class MainPage extends BasePage {
  override def getTitle: String = "Новости Spring"

  override def getPageIndex: PageIndex = News

  var firstNews = newsRepo.findAll().iterator().next()

  var gameVersion = new Label("gameVersion", firstNews.appVersion)
  add(gameVersion)

  var tag = new Label("newsTag", firstNews.tags.get(0).getTitle)
  add(tag)

}
