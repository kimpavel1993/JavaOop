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

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
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

    public static Range getIntersection(Range firstRange, Range secondRange) {
        if (firstRange == null || secondRange == null) {
            return null;
        } else if (Math.max(firstRange.from, firstRange.to) < Math.min(secondRange.from, secondRange.to)) {
            return null;
        } else if (Math.max(secondRange.from, secondRange.to) < Math.min(firstRange.from, firstRange.to)) {
            return null;
        } else if ((secondRange.to >= firstRange.to) && (secondRange.from <= firstRange.from)) {
            return new Range(firstRange.from, firstRange.to);
        } else if (Math.max(firstRange.from, firstRange.to) >= Math.max(secondRange.from, secondRange.to) && Math.min(firstRange.from, firstRange.to) <= Math.min(secondRange.from, secondRange.to)) {
            return new Range(secondRange.from, secondRange.to);
        } else if (Math.min(firstRange.to, firstRange.from) < Math.min(secondRange.to, secondRange.from)) {
            return new Range(secondRange.from, firstRange.to);
        } else {
            return new Range(firstRange.from, secondRange.to);
        }
    }

    public static Object getUnion(Range firstRange, Range secondRange) {
        if (Math.max(secondRange.from, secondRange.to) >= Math.max(firstRange.from, firstRange.to) && Math.min(secondRange.from, secondRange.to) <= Math.min(firstRange.from, firstRange.to)) {
            return new Range(secondRange.from, secondRange.to);
        } else if (Math.max(firstRange.from, firstRange.to) >= Math.max(secondRange.from, secondRange.to) && Math.min(firstRange.from, firstRange.to) <= Math.min(secondRange.from, secondRange.to)) {
            return new Range(firstRange.from, firstRange.to);
        } else if (Math.min(firstRange.from, firstRange.to) < Math.min(secondRange.from, secondRange.to) && Math.max(firstRange.from, firstRange.to) > Math.min(secondRange.from, secondRange.to)) {
            return new Range(firstRange.from, secondRange.to);
        } else if (Math.min(secondRange.from, secondRange.to) < Math.min(firstRange.from, firstRange.to) && Math.max(secondRange.from, secondRange.to) > Math.min(firstRange.from, firstRange.to)) {
            return new Range(secondRange.from, firstRange.to);
        }

        Range[] arrayRange = new Range[2];

        if (Math.max(firstRange.from, firstRange.to) < Math.min(secondRange.from, secondRange.to)) {
            arrayRange[0] = new Range(firstRange.from, firstRange.to);
            arrayRange[1] = new Range(secondRange.from, secondRange.to);

            return arrayRange;
        } else {
            arrayRange[0] = new Range(secondRange.from, secondRange.to);
            arrayRange[1] = new Range(firstRange.from, firstRange.to);

            return arrayRange;
        }
    }

    public static Object getDifference(Range r1, Range r2) {
        if (r1 == null || r2 == null) {
            return null;
        } else if (Math.max(r1.from, r1.to) < Math.min(r2.from, r2.to)) {
            return new Range(r1.from, r1.to);
        } else if (Math.max(r2.from, r2.to) < Math.min(r1.from, r1.to)) {
            return new Range(r1.from, r1.to);
        } else if (Math.max(r2.from, r2.to) >= Math.max(r1.from, r1.to) && Math.min(r2.from, r2.to) <= Math.min(r1.from, r1.to)) {
            return null;
        } else if (Math.max(r1.from, r1.to) >= Math.max(r2.from, r2.to) && Math.min(r1.from, r1.to) <= Math.min(r2.from, r2.to)) {
            Range[] arrayRange = new Range[2];

            arrayRange[0] = new Range(r1.from, r2.from);
            arrayRange[1] = new Range(r2.to, r1.to);

            return arrayRange;
        } else if (Math.min(r1.from, r1.to) < Math.min(r2.from, r2.to)) {
            return new Range(r1.from, r2.from);
        } else {
            return new Range(r2.to, r1.to);
        }
    }

    public void print() {
        System.out.printf("(%s, %s)%n", from, to);
    }
}