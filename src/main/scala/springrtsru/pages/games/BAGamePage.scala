package springrtsru.pages.games

import springrtsru.pages.{BaseContentPage, Games, PageIndex}

class BAGamePage extends BaseContentPage {
  override def getTitle: String = "Balanced Annihilation RTS"

  override def getPageIndex: PageIndex = Games
}
