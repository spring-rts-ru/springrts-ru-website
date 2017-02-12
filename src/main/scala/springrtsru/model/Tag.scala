package springrtsru.model

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name = "tags")
class Tag (p_title: String) {
  @Id
  @SequenceGenerator(name = "tag_id_seq_gen", sequenceName = "tag_id_seq", allocationSize = 1)
  var id: Int = _

  @BeanProperty
  var title : String = p_title

  private def this() = this(null)

  override def toString = s"Tag($id, $title)"
}

