package guru.springframework.repository;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * created 01.11.2020
 *
 * @author Alexander Verkhoturkin
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
