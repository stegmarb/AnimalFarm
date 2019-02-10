package service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Animals;
import model.Feature;

public class FarmArea {

    public static void printOutField(int x, int y) {
        printBanner(x);
        x+=2; y+=2;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("╠");
                } else if (i == y - 1 && j == 0) {
                    System.out.print("╚");
                } else if (i == 0 && j == x - 1) {
                    System.out.print("╣");
                } else if (i == y - 1 && j == x - 1) {
                    System.out.print("╝");
                } else if (i == 0 || i == y - 1) {
                    System.out.print("═");
                } else if (j == 0 || j == x - 1) {
                    System.out.print("║");
                } else {
                    pickAnimal();
                }
            }
            System.out.println();
        }
    }

    public static void printBanner(int x) {
        String longerTile = "Animal Farm";
        String shorterTitle = "Farm";
        int withFence = x + 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < withFence; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print("╔");
                    } else if (j == withFence - 1) {
                        System.out.print("╗");
                    } else {
                        System.out.print("═");
                    }
                } else {
                    if (x < shorterTitle.length()) {
                        if (j == 1 || j == withFence - 1) {
                            System.out.print("║");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (x < longerTile.length()) {
                        if (j == 0 || j == withFence - 1) {
                            System.out.print("║");
                        } else {
                            int sides = (withFence - shorterTitle.length()) / 2;
                            if (j <= sides || j > sides + shorterTitle.length()) {
                                System.out.print(" ");
                            } else {
                                System.out.print(shorterTitle.charAt(j - sides - 1));
                            }
                        }
                    } else {
                        if (j == 0 || j == withFence - 1) {
                            System.out.print("║");
                        } else {
                            int sides = (withFence - longerTile.length()) / 2;
                            if (j <= sides || j > sides + longerTile.length()) {
                                System.out.print(" ");
                            } else {
                                System.out.print(longerTile.charAt(j - sides - 1));
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static void pickAnimal() {
        List<String> elements = Stream.concat(Animals.returnElements().stream(), Feature.returnElements().stream())
            .collect(
                Collectors.toList());
        if (ThreadLocalRandom.current().nextInt(10) < 4) {
            System.out.print(elements.get(ThreadLocalRandom.current().nextInt(elements.size())));
        } else {
            System.out.print(" ");
        }
    }
}
