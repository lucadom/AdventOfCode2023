package it.lucadom.aoc2023.day10;

import it.lucadom.aoc2023.shared.Coord;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public record PuzzleMap(String[][] tiles) {

    public static PuzzleMap fromInput(List<String> input) {
        String[][] tiles = input.stream().map(row -> row.split("")).toArray(String[][]::new);
        return new PuzzleMap(tiles);
    }

    public List<Coord> loopPath() {
        List<Coord> loopPath = new ArrayList<>();
        Coord start = start();
        Coord current = start;
        Direction direction = null;
        do {
            loopPath.add(current);
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
        } while (!start.equals(current));
        return loopPath;
    }

    public List<Coord> loopCorners() {
        return loopPath().stream().filter(t -> !"|-".contains(tileAt(t))).toList();
    }

    public long stepsToFarthestTileFromStart() {
        return loopPath().size() / 2;
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
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
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

    public long tilesEnclosed() {
        long enclosed = 0;
        List<Coord> polygon = loopCorners();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                if (relationPP(new Coord(i, j), polygon) == 1) {
                    enclosed++;
                }
            }
        }
        return enclosed;
    }

    /**
     * Get relationship between a point and a polygon using ray-casting algorithm
     * (see https://stackoverflow.com/a/63436180)
     *
     * @param point the point to check
     * @param polygon the polygon
     * @return -1: outside, 0: on edge, 1: inside
     */
    public int relationPP(Coord point, List<Coord> polygon) {
        boolean inside = false;
        for (int i = polygon.size() -1, j = 0; j < polygon.size(); i = j, j++) {
            Coord a = polygon.get(i);
            Coord b = polygon.get(j);

            // corner cases
            if (point.col() == a.col() && point.row() == a.row() || 
                    point.col() == b.col() && point.row() == b.row()) {
                return 0;
            }
            if (a.row() == b.row() && point.row() == a.row() && between(point.col(), a.col(), b.col())) {
                return 0;
            }

            if (between(point.row(), a.row(), b.row())) { // if P inside the vertical range
                // filter out "ray pass vertex" problem by treating the line a little lower
                if (point.row() == a.row() && b.row() >= a.row() || point.row() == b.row() && a.row() >= b.row()) {
                    continue;
                }
                // calc cross product `PA X PB`, P lays on left side of AB if c > 0
            int c = (a.col() - point.col()) * (b.row() - point.row()) - (b.col() - point.col()) * (a.row() - point.row());
                if (c == 0) {
                    return 0;
                }
                if ((a.row() < b.row()) == (c > 0)) {
                    inside = !inside;
                }
            }
        }

        return inside? 1 : -1;
    }

    boolean between(int p, int a, int b) {
        return p >= a && p <= b || p <= a && p >= b;
    }
}