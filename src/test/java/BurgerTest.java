import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
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
        assertTrue("Ингредиент не удалился", burger.ingredients.isEmpty());
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

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(300F);
        burger.setBuns(bun);
        Mockito.when(firstIngredient.getPrice()).thenReturn(100F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(200F);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        float price = burger.getPrice();
        assertEquals("Неверная сумма бургера", 900f, price, 0.01f);
    }

    @Test
    public void getReceiptBunTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("red bun");
        burger.setBuns(bun);
        String receipt = burger.getReceipt();
        assertTrue("Строки такой нет", receipt.contains("(==== red bun ====)"));
    }

    @Test
    public void getReceiptIngredientTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("red bun");
        burger.setBuns(bun);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("hot sauce");
        burger.addIngredient(firstIngredient);
        String receipt = burger.getReceipt();
        assertTrue("Строки такой нет", receipt.contains("= sauce hot sauce ="));
    }

    @Test
    public void getReceiptPriceTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(200F);
        burger.setBuns(bun);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(300F);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String receipt = burger.getReceipt();
        assertTrue("Строки такой нет", receipt.contains("Price: 900"));
    }
}

