package it.lucadom.aoc2023.day3;

import it.lucadom.aoc2023.shared.Coord;

record PartNumber(Coord start, int number) {
    public int length() {
        return String.valueOf(number).length();
    }

}
