package springrtsru.utils

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

import springrtsru.model.News

import scala.collection.JavaConversions._

object HibernateUtils {
  var entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory( "com.natalinobusa.jpa.HibernateJpaScalaTutorial" )
  var entityManager: EntityManager = entityManagerFactory.createEntityManager()

  def main( args : Array[String]) {

    entityManager.getTransaction.begin()
//    entityManager.persist( new News( ) )
//    entityManager.persist( new News( ) )
//    entityManager.persist( new News( ) )
    entityManager.getTransaction.commit()

    entityManager.getTransaction.begin()
    val allBuddies = entityManager.createQuery("From Buddy", classOf[News]).getResultList.toList
    entityManager.getTransaction.commit()

    allBuddies foreach println

    entityManager.close()
  }
}
