package springrtsru

import org.apache.wicket.{RuntimeConfigurationType, Page}
import org.apache.wicket.core.request.handler.ListenerInterfaceRequestHandler
import org.apache.wicket.core.request.mapper.MountedMapper
import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.request.{IRequestHandler, Url}
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.request.mapper.info.PageComponentInfo
import org.apache.wicket.request.mapper.parameter.PageParametersEncoder
import springrtsru.pages._
import springrtsru.pages.games.{I944GamePage, NOTAGamePage, ZerokGamePage, BAGamePage}
import springrtsru.pages.howto.{InstallNOTAPage, InstallBAPage}

class SpringrtsRuApplication extends WebApplication {
  override def getHomePage: Class[_ <: Page] = classOf[MainPage]

  override def init(): Unit = {
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/widgetsPacks", classOf[WidgetsPacks]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/media", classOf[MediaPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/videos", classOf[VideosPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/news", classOf[MainPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/history", classOf[HistoryPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/howto", classOf[HowToInstallPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/GameDeveliomentCompleteGuide", classOf[UnitDevPage]))

    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/ba", classOf[BAGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/zerok", classOf[ZerokGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/nota", classOf[NOTAGamePage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/games/1944", classOf[I944GamePage]))

    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/howto/install/ba", classOf[InstallBAPage]))
    getRootRequestMapperAsCompound.add(new MountedMapperWithoutPageComponentInfo("/howto/install/nota", classOf[InstallNOTAPage]))
  }

  override def getConfigurationType: RuntimeConfigurationType = RuntimeConfigurationType.DEPLOYMENT

  private class MountedMapperWithoutPageComponentInfo(mountPath: String, pageClass: Class[_ <: IRequestablePage])
    extends MountedMapper(mountPath, pageClass, new PageParametersEncoder()) {
    override def encodePageComponentInfo(url: Url, info: PageComponentInfo): Unit = {}

    override def mapHandler(requestHandler: IRequestHandler): Url =
      if (requestHandler.isInstanceOf[ListenerInterfaceRequestHandler]) {
        null
      } else {
        super.mapHandler(requestHandler)
      }
  }
}
