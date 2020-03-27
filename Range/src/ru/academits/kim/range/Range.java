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
        if ((Math.max(from, to) < Math.min(range.from, range.to)) || (Math.max(range.from, range.to) < Math.min(from, to))) {
            return null;
        }

        if ((Math.max(range.from, range.to) >= Math.max(from, to)) && (Math.min(range.from, range.to) <= Math.min(from, to))) {
            return new Range(Math.min(from, to), Math.max(from, to));
        }

        if (Math.max(from, to) >= Math.max(range.from, range.to) && Math.min(from, to) <= Math.min(range.from, range.to)) {
            return new Range(Math.min(range.from, range.to), Math.max(range.from, range.to));
        }

        if (Math.min(to, from) < Math.min(range.to, range.from)) {
            return new Range(Math.min(range.from, range.to), Math.max(from, to));
        }

        return new Range(Math.min(from, to), Math.max(range.from, range.to));
    }

    public Range[] getUnion(Range range) {
        if (Math.max(range.from, range.to) >= Math.max(from, to) && Math.min(range.from, range.to) <= Math.min(from, to)) {
            return new Range[]{new Range(Math.min(range.from, range.to), Math.max(range.from, range.to))};
        }

        if (Math.max(from, to) >= Math.max(range.from, range.to) && Math.min(from, to) <= Math.min(range.from, range.to)) {
            return new Range[]{new Range(Math.min(from, to), Math.max(from, to))};
        }

        if (Math.min(from, to) < Math.min(range.from, range.to) && Math.max(from, to) >= Math.min(range.from, range.to)) {
            return new Range[]{new Range(Math.min(from, to), Math.max(range.from, range.to))};
        }

        if (Math.min(range.from, range.to) < Math.min(from, to) && Math.max(range.from, range.to) > Math.min(from, to)) {
            return new Range[]{new Range(Math.min(range.from, range.to), Math.max(from, to))};
        }

        if (Math.max(from, to) < Math.min(range.from, range.to)) {
            return new Range[]{new Range(Math.min(from, to), Math.max(from, to)), new Range(Math.min(range.from, range.to), Math.max(range.from, range.to))};
        }

        return new Range[]{new Range(Math.min(range.from, range.to), Math.max(range.from, range.to)), new Range(Math.min(from, to), Math.max(from, to))};
    }

    public Range[] getDifference(Range range) {
        double epsilon = 1.0e-10;
        if (Math.abs(Math.max(from, to) - Math.max(range.from, range.to)) <= epsilon && Math.abs(Math.min(from, to) - Math.min(range.from, range.to)) <= epsilon) {
            return new Range[0];
        }

        if (Math.max(from, to) < Math.min(range.from, range.to) || Math.max(range.from, range.to) < Math.min(from, to)) {
            return new Range[]{new Range(Math.min(from, to), Math.max(from, to))};
        }

        if (Math.max(range.from, range.to) >= Math.max(from, to) && Math.min(range.from, range.to) <= Math.min(from, to)) {
            return null;
        }

        if (Math.max(from, to) > Math.max(range.from, range.to) && Math.min(from, to) < Math.min(range.from, range.to)) {
            return new Range[]{new Range(Math.min(from, to), Math.min(range.from, range.to)), new Range(Math.max(range.from, range.to), Math.max(from, to))};
        }

        if (Math.min(from, to) < Math.min(range.from, range.to)) {
            return new Range[]{new Range(Math.min(from, to), Math.min(range.from, range.to))};
        }

        return new Range[]{new Range(Math.max(range.from, range.to), Math.max(from, to))};
    }

    public String toString() {
        return "[" + from + ", " + to + "]";
    }
}