package it.lucadom.aoc2023.day3;

import it.lucadom.aoc2023.shared.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

record Engine(int rows, int cols, String[][] schematic) {

    public Engine(List<String> input) {
        this(input.size(), input.get(0).length(), input.stream()
                .map(s -> s.split(""))
                .toArray(String[][]::new));
    }

    public List<PartNumber> partNumbers() {
        return candidates().stream()
                .filter(candidate -> neighbours(candidate).stream().anyMatch(isSymbol()))
                .toList();
    }

    private Predicate<Coord> isSymbol() {
        return coord -> value(coord).matches("[^.0-9]");
    }

    public List<PartNumber> candidates() {
        List<PartNumber> candidates = new ArrayList<>();
        int row = 0;
        int col = 0;
        StringBuilder number = new StringBuilder();
        for (int i=0; i< rows; i++) {
            if (!number.isEmpty()) {
                candidates.add(new PartNumber(new Coord(row, col), Integer.parseInt(number.toString())));
                number = new StringBuilder();
            }
            for(int j=0; j<cols; j++) {
                if (schematic[i][j].matches("[0-9]")) {
                    if (number.isEmpty()) {
                        row = i;
                        col = j;
                    }
                    number.append(schematic[i][j]);
                } else if (!number.isEmpty()) {
                    candidates.add(new PartNumber(new Coord(row, col), Integer.parseInt(number.toString())));
                    number = new StringBuilder();
                }
            }
        }
        return candidates;
    }

    public List<Coord> neighbours(PartNumber partNumber) {
        List<Coord> neighbours = new ArrayList<>();
        int startRow = partNumber.start().row();
        int startCol = partNumber.start().col();
        int length = partNumber.length();
        if (startRow > 0) {
            if (startCol > 0) {
                // add top left corner neighbour
                neighbours.add(new Coord(startRow-1, startCol-1));
            }
            // add above part number neighbours
            for (int i=startCol; i<startCol+length; i++) {
                neighbours.add(new Coord(startRow-1, i));
            }
            if (startCol+length < cols) {
                // add top right corner neighbour
                neighbours.add(new Coord(startRow-1, startCol+length));
            }
        }
        if (startCol > 0) {
            // add left neighbour
            neighbours.add(new Coord(startRow, startCol-1));
        }
        if (startCol+length < cols) {
            // add right neighbour
            neighbours.add(new Coord(startRow, startCol+length));
        }
        if (startRow+1 < rows) {
            if (startCol > 0) {
                // add bottom left corner neighbour
                neighbours.add(new Coord(startRow+1, startCol-1));
            }
            // add below part number neighbours
            for (int i=startCol; i<startCol+length; i++) {
                neighbours.add(new Coord(startRow+1, i));
            }
            if (startCol+length < cols) {
                // add bottom right corner neighbour
                neighbours.add(new Coord(startRow+1, startCol+length));
            }
        }
        return neighbours;
    }

    public String value(Coord coord) {
        return schematic[coord.row()][coord.col()];
    }
    public List<Gear> gears() {
        Map<Coord, List<PartNumber>> gearsCandidate = new HashMap<>();
        for (PartNumber partNumber : partNumbers()) {
            neighbours(partNumber).forEach(coord -> {
                if (value(coord).equals("*")) {
                    // part number is near a gear @ coord
                    gearsCandidate.computeIfAbsent(coord, key -> new ArrayList<>()).add(partNumber);
                }
            });
        }
        return gearsCandidate.entrySet().stream()
                .filter(gc -> gc.getValue().size() == 2) // keep only gears near to 2 part numbers
                .map(gc -> new Gear(gc.getKey(), gc.getValue().get(0).number(), gc.getValue().get(1).number()))
                .toList();
    }
}
