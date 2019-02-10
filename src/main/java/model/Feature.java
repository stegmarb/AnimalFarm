package model;

import java.util.ArrayList;
import java.util.List;

public enum Feature implements Element {
    TREE("T"),
    BUSH("B"),
    POND("P");

    private String name;

    Feature(String name) {
        this.name = name;
    }

    public static List<String> returnElements() {
        List<String> features = new ArrayList<>();
        for (Feature feature: values()) {
            features.add(feature.name);
        }
        return features;
    }
}
