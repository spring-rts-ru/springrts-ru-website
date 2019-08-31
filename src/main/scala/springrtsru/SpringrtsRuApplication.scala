package springrtsru

import org.apache.wicket.spring.injection.annot.SpringComponentInjector
import org.apache.wicket.{Page, RuntimeConfigurationType}
import org.apache.wicket.core.request.handler.ListenerRequestHandler
import org.apache.wicket.core.request.mapper.MountedMapper
import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.request.{IRequestHandler, Url}
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.request.mapper.info.PageComponentInfo
import org.apache.wicket.request.mapper.parameter.PageParametersEncoder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import springrtsru.pages._
import springrtsru.pages.games._
import springrtsru.pages.howto.{InstallBAPage, InstallNOTAPage}

import scala.beans.BeanProperty

@Component(value = "wicketApplication")
class SpringrtsRuApplication extends WebApplication {
  override def getHomePage: Class[_ <: Page] = classOf[MainPage]

  @Autowired
  @BeanProperty
  var applicationContext : ApplicationContext = _


  override def init(): Unit = {
    super.init()

    getComponentInstantiationListeners add new SpringComponentInjector(this, applicationContext, true)


    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/widgetsPacks", classOf[WidgetsPacks]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/videos", classOf[VideosPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/news", classOf[MainPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/history", classOf[HistoryPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/howto", classOf[HowToInstallPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/GameDeveliomentCompleteGuide", classOf[UnitDevPage]))

    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/ba", classOf[BAGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/zerok", classOf[ZerokGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/nota", classOf[NOTAGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/1944", classOf[I944GamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/ta", classOf[TechAnnihilationGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/xta", classOf[XTAGamePage]))

    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/howto/install/ba", classOf[InstallBAPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/howto/install/nota", classOf[InstallNOTAPage]))

//    getComponentInstantiationListeners add new SpringComponentInjector(this)
  }

  override def getConfigurationType: RuntimeConfigurationType = RuntimeConfigurationType.DEVELOPMENT
//  override def getConfigurationType: RuntimeConfigurationType = RuntimeConfigurationType.DEPLOYMENT

  private class MountedMapperWithoutPageComponentInfo(mountPath: String, pageClass: Class[_ <: IRequestablePage])
    extends MountedMapper(mountPath, pageClass, new PageParametersEncoder()) {
    override def encodePageComponentInfo(url: Url, info: PageComponentInfo): Unit = {}

    override def mapHandler(requestHandler: IRequestHandler): Url =
      if (requestHandler.isInstanceOf[ListenerRequestHandler]) {
        null
      } else {
        super.mapHandler(requestHandler)
      }
  }
}
