package guru.springframework.repository;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * created 01.11.2020
 *
 * @author Alexander Verkhoturkin
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
