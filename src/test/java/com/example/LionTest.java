package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    private final String sex;
    private final boolean mane;
    private final int count;
    private final List<String> food;

    public LionTest(String sex, boolean mane, int count, List<String> food){
        this.sex = sex;
        this.mane = mane;
        this.count = count;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[] getMane() {
        return new Object[][] {
                {"Самец", true, 1, Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Самка", false, 1, Arrays.asList("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(mane, actual);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittensCount = lion.getKittens();
        assertEquals(count,actualKittensCount);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(food, actualFood);
    }

    @Test
    public void doesHaveManeElse() {
        Exception exception = null;
        try {
            Lion lion = new Lion("Не самец ", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}