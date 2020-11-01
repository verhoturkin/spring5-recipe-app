package guru.springframework.service;

import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * created 02.11.2020
 *
 * @author Alexander Verkhoturkin
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
