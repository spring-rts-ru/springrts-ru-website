package springrtsru.pages

class MainPage extends BasePage {
  override def getTitle: String = "Новости Spring"

  override def getPageIndex: PageIndex = News
}
