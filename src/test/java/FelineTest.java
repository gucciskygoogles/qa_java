import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;


public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        // Подготавливаем заглушку для метода getFood
        Feline felineSpy = spy(feline);
        List<String> expectedFood = List.of("Мясо");
        doReturn(expectedFood).when(felineSpy).getFood("Хищник");

        // Проверяем, что метод eatMeat возвращает правильное значение
        assertEquals(expectedFood, felineSpy.eatMeat());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        assertEquals(3, feline.getKittens(3));
    }
}
