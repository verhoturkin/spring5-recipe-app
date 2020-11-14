package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * created 01.11.2020
 *
 * @author Alexander Verkhoturkin
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure pinch = unitOfMeasureRepository.findByDescription("Pinch")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure ounce = unitOfMeasureRepository.findByDescription("Ounce")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each")
                .orElseThrow(RuntimeException::new);

        UnitOfMeasure pint = unitOfMeasureRepository.findByDescription("Pint")
                .orElseThrow(RuntimeException::new);

        Category american = categoryRepository.findByDescription("American").orElseThrow(RuntimeException::new);
        Category mexican = categoryRepository.findByDescription("Mexican").orElseThrow(RuntimeException::new);

        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n");

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("The best guacamole keeps it simple: just ripe avocados, salt, a squeeze of lime, onions, chiles, cilantro, and some chopped tomato. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.\n");
        guacamole.setNotes(guacamoleNotes);

        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), each));
        guacamole.addIngredient(new Ingredient("salt", new BigDecimal(.25), teaspoon));
        guacamole.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoon));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(0.25), cup));
        guacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each));
        guacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoon));
        guacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), dash));
        guacamole.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5), each));

        guacamole.getCategories().add(american);
        guacamole.getCategories().add(mexican);

        recipes.add(guacamole);

        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setDifficulty(Difficulty.MODERATE);
        tacos.setPrepTime(20);
        tacos.setCookTime(15);
        tacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n");

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        tacos.setNotes(tacosNotes);

        tacos.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tacos, tablespoon));
        tacos.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), tacos, teaspoon));
        tacos.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), tacos, teaspoon));
        tacos.addIngredient(new Ingredient("sugar", new BigDecimal(1), tacos, teaspoon));
        tacos.addIngredient(new Ingredient("salt", new BigDecimal(.5), tacos, teaspoon));
        tacos.addIngredient(new Ingredient("clove of garlic, finely chopped", new BigDecimal(1), tacos, each));
        tacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tacos, tablespoon));
        tacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tacos, tablespoon));
        tacos.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tacos, tablespoon));
        tacos.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tacos, tablespoon));
        tacos.addIngredient(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(6), tacos, each));
        tacos.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), tacos, each));
        tacos.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), tacos, cup));
        tacos.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), tacos, each));
        tacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), tacos, each));
        tacos.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(.5), tacos, pint));
        tacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(.25), tacos, each));
        tacos.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), tacos, each));
        tacos.addIngredient(new Ingredient("sour cream", new BigDecimal(.5), tacos, cup));
        tacos.addIngredient(new Ingredient("milk", new BigDecimal(.25), tacos, cup));
        tacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(1), tacos, each));

        tacos.getCategories().add(american);
        tacos.getCategories().add(mexican);

        recipes.add(tacos);

        return recipes;
    }


}
