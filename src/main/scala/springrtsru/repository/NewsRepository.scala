package springrtsru.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import springrtsru.model.News

@Repository
trait NewsRepository extends CrudRepository[News, java.lang.Long] {

}
