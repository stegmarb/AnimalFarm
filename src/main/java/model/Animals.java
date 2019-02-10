package model;

import java.util.ArrayList;
import java.util.List;

public enum Animals implements Element {
    COW("C"),
    PIG("P"),
    GOAT("G"),
    DOG("D");

    public String name;

    Animals(String name) {
        this.name = name;
    }

    public static List<String> returnElements() {
        List<String> animals = new ArrayList<>();
        for (Animals animal: values()) {
            animals.add(animal.name);
        }
        return animals;
    }
}
