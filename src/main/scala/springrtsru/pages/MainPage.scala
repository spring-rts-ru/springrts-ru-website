package springrtsru.pages

import java.text.SimpleDateFormat
import java.util
import java.util.{Collections, Locale}

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.image.ExternalImage
import org.apache.wicket.markup.html.link.ExternalLink
import org.apache.wicket.markup.html.list.{ListItem, ListView}
import springrtsru.model._

object MainPage {
  val newsList: util.List[News] = new util.ArrayList[News]()
}

class MainPage extends BasePage {
  override def getTitle: String = "Новости Spring"

  override def getPageIndex: PageIndex = News

    if (MainPage.newsList.isEmpty) {
      MainPage.newsList.addAll(newsRepo.findAll())

      Collections.sort[News](MainPage.newsList, (o1: News, o2: News) => {
        o2.publicationDate.compareTo(o1.publicationDate)
      })

      MainPage.newsList.removeIf(x => MainPage.newsList.indexOf(x) > 10)
    }

  var newsBlock = new ListView("newsBlock", MainPage.newsList) {
    override def populateItem(item: ListItem[News]): Unit = {
      val newsPost = item.getModelObject

      val sdf = new SimpleDateFormat("dd MMMMM yyyy", new Locale("ru"))
      val newsDate = new Label("newsDate", sdf.format(newsPost.publicationDate))
      item.add(newsDate)

      val tags = new ListView("tags", newsPost.tags) {
        override def populateItem(item: ListItem[Tag]): Unit = {
          val tag = item.getModelObject
          val tagItem = new Label("newsTag", tag.getTitle)
          item.add(tagItem)
        }
      }
      item.add(tags)

      val newsTitle = new Label("newsTitle", newsPost.title)
      item.add(newsTitle)

      val newsText = new Label("newsText", newsPost.text)
      newsText.setEscapeModelStrings(false)
      item.add(newsText)

      val image = new ExternalImage("newsImage", newsPost.imageLink)
      item.add(image)

      val downloadLink = new ExternalLink("downloadLink", newsPost.downloadLink)
      item.add(downloadLink)

      val gameVersion = new Label("gameVersion", newsPost.appVersion)
      downloadLink.add(gameVersion)

      val newsGameName = new Label("newsGameName", newsPost.appName)
      downloadLink.add(newsGameName)
    }
  }
  add(newsBlock)

}
