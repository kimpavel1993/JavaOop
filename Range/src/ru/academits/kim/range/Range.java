package ru.academits.kim.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number >= from) && (number <= to);
    }

    public Range getIntersection(Range range) {
        double minTo = Math.min(to, range.to);
        double maxFrom = Math.max(from, range.from);

        if ((to <= range.from) || (range.to <= from)) {
            return null;
        }

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range range) {
        double minTo = Math.min(to, range.to);
        double maxTo = Math.max(to, range.to);
        double minFrom = Math.min(from, range.from);
        double maxFrom = Math.max(from, range.from);

        if ((range.to > to && range.from < from) || (to > range.to && from < range.from) || (maxFrom <= minTo)) {
            return new Range[]{new Range(minFrom, maxTo)};
        }

        return new Range[]{new Range(from, to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
        double minTo = Math.min(to, range.to);
        double maxFrom = Math.max(from, range.from);

        if (from == range.from && to == range.to) {
            return new Range[0];
        }

        if (range.to > to && range.from < from) {
            return null;
        }

        if (minTo < maxFrom) {
            return new Range[]{new Range(from, to)};
        }

        if (to > range.to && from < range.from) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from < range.from) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(range.to, to)};
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }
}