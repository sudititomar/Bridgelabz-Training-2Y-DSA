import java.util.*;

public class Problem3 {
    public static class CheckResult {
        boolean completed;
        int comparisons;

        CheckResult(boolean completed, int comparisons) {
            this.completed = completed;
            this.comparisons = comparisons;
        }
    }

    public static CheckResult nestedLoopCheck(int[] completed, int[] prerequisites) {
        int comparisons = 0;
        for (int prereq : prerequisites) {
            boolean found = false;
            for (int course : completed) {
                comparisons++;
                if (course == prereq) {
                    found = true;
                    break;
                }
            }
            if (!found) return new CheckResult(false, comparisons);
        }
        return new CheckResult(true, comparisons);
    }

    public static CheckResult hashSetCheck(int[] completed, int[] prerequisites) {
        int comparisons = 0;
        HashSet<Integer> completedSet = new HashSet<>();
        for (int course : completed) {
            completedSet.add(course);
        }

        for (int prereq : prerequisites) {
            comparisons++;
            if (!completedSet.contains(prereq)) {
                return new CheckResult(false, comparisons);
            }
        }
        return new CheckResult(true, comparisons);
    }

    public static void performanceAnalysis() {
        int n = 40, m = 5, students = 100000;
        long nestedComparisons = (long) n * m * students;
        System.out.printf("Nested: %d comparisons/day%n", nestedComparisons);

        int concurrent = 10000;
        long memoryBytes = (long) n * 8 * concurrent;
        System.out.printf("HashSet: %.1f MB concurrent%n", memoryBytes / (1024.0*1024));
    }
}
