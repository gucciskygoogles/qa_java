package com.example;

import java.util.List;

public class Cat {

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }
    // коммент для коммита
    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
