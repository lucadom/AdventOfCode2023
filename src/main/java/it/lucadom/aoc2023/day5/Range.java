package it.lucadom.aoc2023.day5;

public record Range(long destinationStart, long sourceStart, long length) {

    public boolean contains(long source) {
        return source >= sourceStart && source < sourceStart + length;
    }
    public long destination(long source) {
        return contains(source) ? destinationStart + source - sourceStart : source;
    }
}
