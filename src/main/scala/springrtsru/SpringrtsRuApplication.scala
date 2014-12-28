package springrtsru

import org.apache.wicket.Page
import org.apache.wicket.protocol.http.WebApplication
import springrtsru.pages.AboutPage

class SpringrtsRuApplication extends WebApplication {
  override def getHomePage: Class[_ <: Page] = classOf[AboutPage]
}
