import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxTreeSumNew {
    public static int dfs(List<Integer> parent, List<Integer> values, int nodes) {
        int maxSum1 = 0;
        int maxSum2 = 0;
        for (int i = 1; i < parent.size(); i++) {
            if (parent.get(i) == nodes) {
                int temp = dfs(parent, values, i);
                if (temp > maxSum1) {
                    maxSum2 = maxSum1;
                    maxSum1 = temp;
                } else if (temp > maxSum2 && temp < maxSum1) {
                    maxSum2 = temp;
                }
            }
        }
        int max = Math.max(Math.max(maxSum1 + maxSum2 + values.get(nodes), maxSum1 + values.get(nodes)), values.get(nodes));
        return max;
    }

    public static void main(String[] args) {
       /* test1();
        test2();*/
        test3();
    }

    private static void test1() {
        int[] parent = {-1, 0, 1, 2, 0};
        int[] values = {-2, 10, 10, -3, 10};
        int max = dfs(Arrays.stream(parent).boxed().collect(Collectors.toList()),
                Arrays.stream(values).boxed().collect(Collectors.toList()), 0);
        System.out.println("MAX: " + max);
    }
    private static void test2() {
        int[] parent = {-1, 0, 1, 2, 0};
        int[] values = {5, 7, -10, 4, 15};
        int max = dfs(Arrays.stream(parent).boxed().collect(Collectors.toList()),
                Arrays.stream(values).boxed().collect(Collectors.toList()), 0);
        System.out.println("MAX: " + max);
    }
    private static void test3() {
        int[] parent = {-1, 0, 0, 1, 1,1};
        int[] values = {4, -1, -3, 5, 7, -2};
        int max = dfs(Arrays.stream(parent).boxed().collect(Collectors.toList()),
                Arrays.stream(values).boxed().collect(Collectors.toList()), 0);
        System.out.println("MAX: " + max);
    }
}
