package it.lucadom.aoc2023.day10;

import it.lucadom.aoc2023.shared.Coord;

import java.util.List;
import java.util.NoSuchElementException;

public record PuzzleMap(String[][] tiles) {

    public static PuzzleMap fromInput(List<String> input) {
        String[][] tiles = input.stream().map(row -> row.split("")).toArray(String[][]::new);
        return new PuzzleMap(tiles);
    }

    public long stepsToFarthestTileFromStart() {
        long steps = 0;
        Coord start = start();
        Coord current = start;
        Direction direction = null;
        do {
            if (canGoUp(direction, current)) {
                current = current.up();
                direction = Direction.UP;
            } else if (canGoRight(direction, current)) {
                current = current.right();
                direction = Direction.RIGHT;
            } else if (canGoDown(direction, current)) {
                current = current.down();
                direction = Direction.DOWN;
            } else if (canGoLeft(direction, current)) {
                current = current.left();
                direction = Direction.LEFT;
            }
            steps++;
        } while (!start.equals(current));
        return steps / 2;
    }


    private boolean canGoUp(Direction from, Coord position) {
        return !Direction.DOWN.equals(from) &&
                position.row() > 0 &&
                "J|LS".contains(tileAt(position)) &&
                "7|FS".contains(tileAt(position.up()));
    }

    private boolean canGoRight(Direction from, Coord position) {
        return !Direction.LEFT.equals(from) &&
                position.col() < cols() - 1 &&
                "L-FS".contains(tileAt(position)) &&
                "J-7S".contains(tileAt(position.right()));
    }

    private boolean canGoDown(Direction from, Coord position) {
        return !Direction.UP.equals(from) &&
                position.row() < rows() - 1 &&
                "7|FS".contains(tileAt(position)) &&
                "J|LS".contains(tileAt(position.down()));
    }

    private boolean canGoLeft(Direction from, Coord position) {
        return !Direction.RIGHT.equals(from) &&
                position.col() > 0 &&
                "J-7S".contains(tileAt(position)) &&
                "L-FS".contains(tileAt(position.left()));
    }

    public Coord start() {
        for (int i=0; i<tiles.length; i++) {
            for (int j=0; j<tiles[0].length; j++) {
                if (tiles[i][j].equals("S")) {
                    return new Coord(i, j);
                }
            }
        }
        throw new NoSuchElementException();
    }

    public int cols() {
        return tiles[0].length;
    }

    public int rows() {
        return tiles.length;
    }

    private String tileAt(Coord position) {
        return tiles[position.row()][position.col()];
    }

}
