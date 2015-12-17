package springrtsru.pages.games

import springrtsru.pages.{Games, PageIndex, BasePage}

class BAGamePage extends BasePage {
  override def getTitle: String = "Balanced Annihilation RTS"

  override def getPageIndex: PageIndex = Games
}
