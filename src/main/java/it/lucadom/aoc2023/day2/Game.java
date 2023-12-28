package it.lucadom.aoc2023.day2;

import java.util.Arrays;
import java.util.List;

public record Game(int id, List<Cubes> cubes) {

    public static Game fromString(String row) {
        String[] game = row.split(": ");
        int id = Integer.parseInt(game[0].split(" ")[1]);
        String[] cubes = game[1].split("; ");
        return new Game(id, Arrays.stream(cubes).map(Cubes::fromString).toList());
    }

    public Cubes minimum() {
        int blue = 0;
        int red = 0;
        int green = 0;

        for (Cubes cube : cubes) {
            blue = Math.max(blue, cube.blue());
            red = Math.max(red, cube.red());
            green = Math.max(green, cube.green());
        }

        return new Cubes(blue, red, green);
    }

}
