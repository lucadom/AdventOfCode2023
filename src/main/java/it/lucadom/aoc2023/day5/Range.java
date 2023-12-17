package it.lucadom.aoc2023.day5;

public record Range(long destinationStart, long sourceStart, long length) {

    public boolean containsSource(long source) {
        return source >= sourceStart && source < sourceStart + length;
    }

    public boolean containsDestination(long destination) {
        return destination >= destinationStart && destination < destinationStart + length;
    }

    public long destination(long source) {
        return containsSource(source) ? destinationStart + source - sourceStart : source;
    }

    public long source(long destination) {
        return containsDestination(destination) ? destination - destinationStart + sourceStart : destination;
    }

}
