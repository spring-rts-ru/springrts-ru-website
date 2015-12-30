package springrtsru.pages.games

import springrtsru.pages.{BaseContentPage, Games, PageIndex}

class ZerokGamePage extends BaseContentPage {
  override def getTitle: String = "Zero-K RTS"

  override def getPageIndex: PageIndex = Games
}
