package springrtsru.utils

import java.util.Date
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

import springrtsru.model.News

import scala.collection.JavaConversions._

object HibernateUtils {
  var entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory( "ru.springrts.persistence" )
  var entityManager: EntityManager = entityManagerFactory.createEntityManager()

  def main( args : Array[String]) {

    entityManager.getTransaction.begin()
    entityManager.persist( new News("titlee", "BA", "1.1.1", "jamerlan", "http://aaa.aaa.aa", "http://aa.aa.aa/1.png", "http://aa.aa.aa/video", "test test text", new Date()))
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
