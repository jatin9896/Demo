import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MaxTreeSumNew1 {
    public static int dfs(List<Integer> parent, List<Integer> values, int nodes) {
        return dfsInternal(parent,values, nodes).getKey();
    }
        public static Pair<Integer, Integer> dfsInternal(List<Integer> parent, List<Integer> values, int nodes) {
        ArrayList<Integer> maxSubTreeArray = new ArrayList<>();
        ArrayList<Integer> processedMaxSubTreeArray = new ArrayList<>();
        for (int i = 1; i < parent.size(); i++) {
            if (parent.get(i) == nodes) {
                Pair<Integer, Integer> temp = dfsInternal(parent, values, i);
                maxSubTreeArray.add(temp.getKey());
                processedMaxSubTreeArray.add(temp.getValue());
            }
        }
        int maxSubTree = maxSubTreeArray.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(0);
        List<Integer> sorted = processedMaxSubTreeArray.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int maxSum1 = (sorted.size() > 0) ? sorted.get(0) : 0;
        int maxSum2 = (sorted.size() > 1) ? sorted.get(1) : 0;
        if((maxSum1 + maxSum2 + values.get(nodes)) > maxSubTree) {
            return new Pair<Integer, Integer>(Math.max(maxSum1 + maxSum2 + values.get(nodes), values.get(nodes)), Math.max(maxSum1 + values.get(nodes), values.get(nodes)));
        }
        else {
            return new Pair<>(maxSubTree, Math.max(maxSum1 + values.get(nodes), values.get(nodes)));
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
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
    private static void test4() {
        int[] parent = {-1, 0, 0, 1, 1,1,4,4,5};
        int[] values = {4, -1, -3, 5, 7, -2, 8, 9, 50};
        int max = dfs(Arrays.stream(parent).boxed().collect(Collectors.toList()),
                Arrays.stream(values).boxed().collect(Collectors.toList()), 0);
        System.out.println("MAX: " + max);
    }
    private static void test5() {
        int[] parent = {-1, 0, 0, 1, 1,1,3,4,4,5};
        int[] values = {4, -1, -3, 5, 7, -2,55, 8, 9, 50};
        int max = dfs(Arrays.stream(parent).boxed().collect(Collectors.toList()),
                Arrays.stream(values).boxed().collect(Collectors.toList()), 0);
        System.out.println("MAX: " + max);
    }
}
