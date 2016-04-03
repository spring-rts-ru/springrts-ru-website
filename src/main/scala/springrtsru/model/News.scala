package springrtsru.model

import java.util.Date
import javax.persistence.{Id, GenerationType, GeneratedValue, Entity}

import scala.beans.BeanProperty

@Entity
class News (@BeanProperty var title : String, @BeanProperty var appName : String, @BeanProperty var appVersion : String,
            @BeanProperty var user_created : String, @BeanProperty var downloadLink : String,
            @BeanProperty var imageLink : String, @BeanProperty var videoLink : String,
            @BeanProperty var text : String, @BeanProperty var publicationDate: Date,
            @BeanProperty var version : Int) extends Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Int = _

  // Default constructor for hibernate
  // No public visibility required
//  private def this() = this()

  override def toString = s"News($id, $title, $appName, $appVersion, $user_created, $downloadLink, $imageLink, $videoLink, $text, $publicationDate, $version)"
}
