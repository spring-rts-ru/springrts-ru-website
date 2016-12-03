package springrtsru.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import springrtsru.model.News

@Repository
trait NewsRepository extends JpaRepository[News, java.lang.Long] {

}
