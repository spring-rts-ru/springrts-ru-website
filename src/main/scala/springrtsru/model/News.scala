package springrtsru.model

import java.util.Date
import javax.persistence._

import scala.beans.BeanProperty

import collection.JavaConversions._

@Entity
@Table(name = "news")
class News (p_title : String, p_appName : String, p_appVersion : String, p_userCreated : String, p_downloadLink : String,
            p_imageLink : String, p_videoLink : String, p_text : String, p_publicationDate: Date, p_tags : java.util.List[Tag]) extends Serializable {

  @Id
  @SequenceGenerator(name = "news_id_seq_gen", sequenceName = "news_id_seq", allocationSize = 1)
  var id: Int = _

  @BeanProperty
  var title : String = p_title

  @BeanProperty
  var appName : String = p_appName

  @BeanProperty
  var appVersion : String = p_appVersion

  @BeanProperty
  var userCreated : String = p_userCreated

  @Column(length = 1000)
  @BeanProperty
  var downloadLink : String = p_downloadLink

  @Column(length = 1000)
  @BeanProperty
  var imageLink : String = p_imageLink

  @Column(length = 1000)
  @BeanProperty
  var videoLink : String = p_videoLink

  @Column(length = 10000)
  @BeanProperty
  var text : String = p_text

  @BeanProperty
  var publicationDate: Date = p_publicationDate

  @Version
  @BeanProperty
  var version : Int = _

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name="news_tags",
    joinColumns = Array(new JoinColumn(name="news_id", foreignKey = new ForeignKey(name = "news_id_fk"))),
    inverseJoinColumns = Array(new JoinColumn(name="tag_id", foreignKey = new ForeignKey(name = "tag_id_fk")))
  )
  var tags: java.util.List[Tag] = p_tags

  private def this() = this(null, null, null, null, null, null, null, null, null, null)

  override def toString = s"News($id, $title, $appName, $appVersion, $userCreated, $downloadLink, $imageLink, $videoLink, $text, $publicationDate, $version, $tags)"
}
