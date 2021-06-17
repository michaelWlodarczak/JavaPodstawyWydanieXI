package rozdzial6.innerClass.staticInnerClass;

public class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }


        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

    }
    /*
        Znajduje najwieksza i najmniejsza wartosc w tablicy
        double[] values - tablica liczb zmiennoprzecinkowych
        return - para liczb w ktorej pierwsza jest najmniejsza, a druga najwieksza
         */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }return new Pair(min,max);
    }
}
