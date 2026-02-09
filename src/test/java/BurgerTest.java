import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;

public class BurgerTest {

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        assertEquals("Другая булочка", bun, burger.bun);
    }
}

