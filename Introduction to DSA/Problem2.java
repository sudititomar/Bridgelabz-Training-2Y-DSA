public class Problem2 {
    public static class SearchResult {
        boolean found;
        int comparisons;

        SearchResult(boolean found, int comparisons) {
            this.found = found;
            this.comparisons = comparisons;
        }
    }

    public static SearchResult linearSearch(String[] userList, String target) {
        int comparisons = 0;
        for (int i = 0; i < userList.length; i++) {
            comparisons++;
            if (userList[i].equals(target)) {
                return new SearchResult(true, comparisons);
            }
        }
        return new SearchResult(false, comparisons);
    }

    public static SearchResult binarySearch(String[] sortedList, String target) {
        int left = 0, right = sortedList.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            comparisons++;

            int cmp = sortedList[mid].compareTo(target);
            if (cmp == 0) return new SearchResult(true, comparisons);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return new SearchResult(false, comparisons);
    }

    public static boolean hashSearch(HashMap<String, Boolean> userMap, String target) {
        return userMap.containsKey(target);
    }

    public static void analyzeComplexity() {
        int[] sizes = {100, 1000, 10000, 100000, 1000000, 10000000};
        System.out.println("n\tLinear\tBinary\tHash");
        for (int n : sizes) {
            int linearOps = n;
            int binaryOps = 32 - Integer.numberOfLeadingZeros(n);
            int hashOps = 1;
            System.out.printf("%d\t%d\t%d\t%d%n", n, linearOps, binaryOps, hashOps);
        }
    }
}
