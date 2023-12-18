package it.lucadom.aoc2023;

import it.lucadom.aoc2023.day1.Puzzle1_1;
import it.lucadom.aoc2023.day1.Puzzle1_2;
import it.lucadom.aoc2023.day2.Puzzle2_1;
import it.lucadom.aoc2023.day2.Puzzle2_2;
import it.lucadom.aoc2023.day3.Puzzle3_1;
import it.lucadom.aoc2023.day3.Puzzle3_2;
import it.lucadom.aoc2023.day4.Puzzle4_1;
import it.lucadom.aoc2023.day4.Puzzle4_2;
import it.lucadom.aoc2023.day5.Puzzle5_1;
import it.lucadom.aoc2023.day5.Puzzle5_2;
import it.lucadom.aoc2023.day6.Puzzle6_1;
import it.lucadom.aoc2023.day6.Puzzle6_2;
import it.lucadom.aoc2023.day7.Puzzle7_1;

public class PuzzleSolver {

    public static void main(String[] args) {
        System.out.println("Puzzle 1.1: " + new Puzzle1_1().solve("puzzle1"));
        System.out.println("Puzzle 1.2: " + new Puzzle1_2().solve("puzzle1"));
        System.out.println("Puzzle 2.1: " + new Puzzle2_1().solve("puzzle2"));
        System.out.println("Puzzle 2.2: " + new Puzzle2_2().solve("puzzle2"));
        System.out.println("Puzzle 3.1: " + new Puzzle3_1().solve("puzzle3"));
        System.out.println("Puzzle 3.2: " + new Puzzle3_2().solve("puzzle3"));
        System.out.println("Puzzle 4.1: " + new Puzzle4_1().solve("puzzle4"));
        System.out.println("Puzzle 4.2: " + new Puzzle4_2().solve("puzzle4"));
        System.out.println("Puzzle 5.1: " + new Puzzle5_1().solve("puzzle5"));
        System.out.println("Puzzle 5.2: " + new Puzzle5_2().solve("puzzle5"));
        System.out.println("Puzzle 6.1: " + new Puzzle6_1().solve("puzzle6"));
        System.out.println("Puzzle 6.2: " + new Puzzle6_2().solve("puzzle6"));
        System.out.println("Puzzle 7.1: " + new Puzzle7_1().solve("puzzle7"));
    }

}
