import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline mockFeline;

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public boolean hasMane;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLionSex() throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @RunWith(Parameterized.class)
    public static class LionInvalidSexParameterizedTest {

        @Mock
        private Feline mockFeline;

        @Parameterized.Parameter
        public String sex;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Неизвестный"},
                    {""},
                    {"Мужчина"},
                    {"Женщина"}
            });
        }

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testLionInvalidSexExceptionMessage() {
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
