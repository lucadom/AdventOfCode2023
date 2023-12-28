package it.lucadom.aoc2023.day3;

import it.lucadom.aoc2023.shared.Coord;

record Gear(Coord coord, int first, int second) {

    public int ratio() {
        return first * second;
    }
};
