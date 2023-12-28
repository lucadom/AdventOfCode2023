package it.lucadom.aoc2023.shared;

public record Coord(int row, int col) {

    public Coord up() {
        return new Coord(row - 1, col);
    }

    public Coord right() {
        return new Coord(row, col + 1);
    }

    public Coord down() {
        return new Coord(row + 1, col);
    }

    public Coord left() {
        return new Coord(row, col - 1);
    }
}
