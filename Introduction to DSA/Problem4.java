public class Problem4 {
    public static String sortingDecision(int size, String dataType) {
        if (size < 50) return "Insertion Sort";
        if (size < 10000) {
            if (dataType.equals("nearly_sorted")) return "Insertion Sort";
            if (dataType.equals("random")) return "Quick Sort";
            return "Merge Sort";
        }
        if (dataType.equals("reverse")) return "Merge Sort";
        return "Quick Sort";
    }

    public static boolean mysteryFasterThanMerge(int n) {
        double mystery = 5.0 * n * n + 100 * n + 1000;
        double mergeSort = 10.0 * n * (Math.log(n) / Math.log(2));
        return mystery < mergeSort;
    }

    public static void decisionTreeDemo() {
        String[][] cases = {
                {"1000", "nearly_sorted"}, {"1000", "random"}, {"1000", "reverse"},
                {"50000", "nearly_sorted"}, {"50000", "random"}, {"50000", "reverse"}
        };

        for (String[] cas : cases) {
            int n = Integer.parseInt(cas[0]);
            String type = cas[1];
            String algo = sortingDecision(n, type);
            System.out.printf("n=%d, %s -> %s%n", n, type, algo);
        }
    }
}
