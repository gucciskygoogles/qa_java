import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    @Test
    public void testLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionNoMane() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(expectedFood, lion.getFood());
    }

    @RunWith(Parameterized.class)
    public static class InvalidSexTest {
        @Parameterized.Parameters
        public static Object[] data() {
            return new Object[] {"Неизвестный", "", "Мужчина", "Женщина"};
        }

        @Parameterized.Parameter
        public String sex;

        @Mock
        private Feline mockFeline;

        @Test
        public void testLionInvalidSex() {
            MockitoAnnotations.initMocks(this);
            Exception exception = null;
            try {
                new Lion(sex, mockFeline);
            } catch (Exception e) {
                exception = e;
            }
            assertNotNull(exception);
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }
}