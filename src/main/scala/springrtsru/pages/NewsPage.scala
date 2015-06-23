package springrtsru.pages

class NewsPage extends BasePage {
  override def getTitle: String = "Новости Spring"

  override def getPageIndex: PageIndex = News
}
