import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTest {

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        assertEquals("Другая булочка", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"sour cream", 200);
        burger.addIngredient(ingredient);
        assertTrue("Ингредиент не добавился", burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient ingredientFirstFilling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredientSecondFilling = new Ingredient(IngredientType.FILLING, "sausage", 300);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFirstFilling);
        burger.addIngredient(ingredientSecondFilling);
        burger.moveIngredient(0, 2);
        assertEquals("Перенос ингредиентов неверный", ingredientSauce, burger.ingredients.get(2));
    }
}

