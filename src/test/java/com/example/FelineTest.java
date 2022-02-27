package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatTest() throws Exception {
        List<String> actualFood = feline.eatMeat();
        assertEquals(actualFood, Arrays.asList("Животные","Птицы","Рыба"));
    }

    @Test
    public void getKittensTest(){
        int actualKittens = feline.getKittens();
        assertEquals(1, actualKittens);
    }

    @Test
    public void getKittensCountTest(){
        int actualKittens = feline.getKittens(3);
        assertEquals(3, actualKittens);
    }

    @Test
    public void getFamilyTest(){
        String actualKind = feline.getFamily();
        assertEquals("Кошачьи", actualKind);
    }
}