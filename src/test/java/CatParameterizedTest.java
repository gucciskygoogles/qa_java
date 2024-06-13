

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class CatParameterizedTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @Parameterized.Parameter
    public List<String> expectedFood;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {List.of("Мясо")},
                {List.of("Рыба")},
                {List.of("Птица")}
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
}
