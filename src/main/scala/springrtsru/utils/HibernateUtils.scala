package springrtsru.utils

import java.util.Date
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

import springrtsru.model.{News, Tag}

import scala.collection.JavaConversions._

object HibernateUtils {
  var entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory( "ru.springrts.persistence" )
  var entityManager: EntityManager = entityManagerFactory.createEntityManager()

  def main( args : Array[String]) {

    entityManager.getTransaction.begin()

    var tag : Tag = new Tag("Balanced Annihilation")

    entityManager.persist(tag)
    entityManager.flush() // to get tag's id

    var tags : java.util.List[Tag] = new java.util.ArrayList[Tag]()
    tags.add(tag)

    entityManager.persist( new News("Релиз игры Balanced Annihilation: версия 9.36!", "Balanced Annihilation", "9.36", "[teh]decay",
      "https://springfiles.com/spring/games/balanced-annihilation-85", "./images/Loadscreens/hotlips.jpg", "http://aa.aa.aa/video",
      "                                    <b>Изменения баланса:</b><br/>\n                                    " +
        "- В обломки металла теперь сложнее попасть -> будет больше металла на поле боя<br/>\n                                    " +
        "- Исправлена проблема: в закрытый випер сложно попасть (ракетная установка core 2 уровня)<br/>\n                                    " +
        "- Исправления для функциональности \"установить цель\"<br/>\n                                    " +
        "<br/>\n                                    " +
        "<b>Другие изменения:</b><br/>\n                                    " +
        "- Добавлен набор курсоров от BAR (можно включить/отключить с помощью /cursor)<br/>\n                                    " +
        "- Радиус парализованной противоракетной системы будет мигать<br/>\n                                    " +
        "- Курсоры неактивных наблюдателей будут постепенно исчезать<br/>\n                                    " +
        "- Удален виджет \"SmoothScroll\" (плавная прокрутка) - больше не нужен<br/>\n                                    " +
        "- Добавлено еще больше сообщений о смерти игрока<br/>\n                                    " +
        "- Эффект появления командира переделан в виджет (который можно включать/отключать)<br/>\n                                    " +
        "- Уменьшено количество дикой живности на земле<br/>\n                                    " +
        "- Различные изменения, необходимые для поддержки движка Spring 102<br/>",
      new Date(), tags))
//    entityManager.persist( new News( ) )
//    entityManager.persist( new News( ) )
    entityManager.getTransaction.commit()

    entityManager.getTransaction.begin()
    val allNews = entityManager.createQuery("from News", classOf[News]).getResultList.toList
    entityManager.getTransaction.commit()

    allNews foreach println

    entityManager.close()
  }
}
