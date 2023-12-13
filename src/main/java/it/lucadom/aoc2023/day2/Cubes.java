package it.lucadom.aoc2023.day2;

public record Cubes(int blue, int red, int green) {
    public static Cubes fromString(String set) {
        String[] cubesCount = set.split(", ");
        int blue = 0;
        int red = 0;
        int green = 0;
        for (String cc : cubesCount) {
            String[] split = cc.split(" ");
            switch (split[1]) {
                case "blue": blue = Integer.parseInt(split[0]); break;
                case "red": red = Integer.parseInt(split[0]); break;
                case "green": green = Integer.parseInt(split[0]); break;
            }
        }
        return new Cubes(blue, red, green);
    }

    boolean valid(Cubes max) {
        return blue <= max.blue && red <= max.red && green <= max.green;
    }

    int power() {
        if (red == 0 && green == 0 && blue == 0) {
            return 0;
        }
        return Math.max(red, 1) * Math.max(green, 1) * Math.max(blue, 1);
    }
};
