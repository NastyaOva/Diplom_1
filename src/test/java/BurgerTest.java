import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

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
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertNull(burger.ingredients);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient thirdIngredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.moveIngredient(0, 2);
        assertEquals("Перенос ингредиентов неверный", firstIngredient, burger.ingredients.get(2));
    }
    
    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("red bun", 300);
        burger.setBuns(bun);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float price = burger.getPrice();
        assertEquals("Неверная сумма бургера", 900f, price, 0.01f);
    }
}

