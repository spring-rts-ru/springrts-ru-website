package springrtsru.pages.games

import springrtsru.pages.{Games, PageIndex, BasePage}

class ZerokGamePage extends BasePage {
  override def getTitle: String = "Zero-K RTS"

  override def getPageIndex: PageIndex = Games
}
