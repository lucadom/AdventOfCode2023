package it.lucadom.aoc2023.day8;

import java.util.Iterator;

public class LoopIterator implements Iterator<Character> {

    private final String str;
    int pos = 0;

    public LoopIterator(String str) {
        this.str = str;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Character next() {
        char c = str.charAt(pos);
        if (pos == str.length() - 1) {
            pos = 0;
        } else {
            pos++;
        }
        return c;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
