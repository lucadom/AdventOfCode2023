package it.lucadom.aoc2023.day1;

import it.lucadom.aoc2023.Puzzle;

import java.util.List;

public class Puzzle1_2 implements Puzzle {

    @Override
    public String solve(List<String> input) {
        Long sum = input.stream()
                .map(Puzzle1_2::extractNumber)
                .mapToLong(Long::longValue)
                .sum();
        return String.valueOf(sum);
    }

    record StrNum(String target, String replacement) {}

    private static final List<StrNum> strNums = List.of(
            new StrNum("one", "1"),
            new StrNum("two", "2"),
            new StrNum("three", "3"),
            new StrNum("four", "4"),
            new StrNum("five", "5"),
            new StrNum("six", "6"),
            new StrNum("seven", "7"),
            new StrNum("eight", "8"),
            new StrNum("nine", "9")
    );

    public static Long extractNumber(String str) {
        boolean replacedAllStrNums = false;
        String replaced = str;
        while (!replacedAllStrNums) {
            StrNum toReplace = null;
            int index = replaced.length();
            for (StrNum strNum : strNums) {
                int idx = replaced.indexOf(strNum.target());
                if (idx >= 0 && idx < index) {
                    index = idx;
                    toReplace = strNum;
                }
            }
            if (toReplace != null) {
                replaced = replaced.replaceFirst(toReplace.target(), toReplace.replacement());
            } else {
                replacedAllStrNums = true;
            }
        }

        replaced = replaced.replaceAll("[^0-9]", "");
        String firstDigit = String.valueOf(replaced.charAt(0));

        replacedAllStrNums = false;
        replaced = str;
        while (!replacedAllStrNums) {
            StrNum toReplace = null;
            int index = -1;
            for (StrNum strNum : strNums) {
                int idx = replaced.lastIndexOf(strNum.target());
                if (idx >= 0 && idx > index) {
                    index = idx;
                    toReplace = strNum;
                }
            }
            if (toReplace != null) {
                replaced = replaced.replaceFirst(toReplace.target(), toReplace.replacement());
            } else {
                replacedAllStrNums = true;
            }
        }
        replaced = replaced.replaceAll("[^0-9]", "");
        String lastDigit = String.valueOf(replaced.charAt(replaced.length()-1));

        return Long.parseLong(firstDigit + lastDigit);
    }

}
