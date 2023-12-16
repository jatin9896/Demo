import java.io.*;
import java.util.*;

    class MaxSumTree {

        // Function to add edge
        static void addEdge(ArrayList<ArrayList<Integer> > adj,
                            int s, int d)
        {
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        static int result = 0;

        // Helper function to calculate
        // the maximum path sum using DFS
        public static void
        findMaximumPathSum(int currentNode,
                           int previousNode,
                           ArrayList<ArrayList<Integer> > adj,
                           int A[])
        {

            // Nodes to which currentNode
            // is connected to
            ArrayList<Integer> v = adj.get(currentNode);
            int maximumBranchSum1 = 0, maximumBranchSum2 = 0;
            for (int i = 0; i < v.size(); i++) {

                // Checking whether the branch
                // is visited already
                if (v.get(i) == previousNode) {
                    continue;
                }
                findMaximumPathSum(v.get(i),
                        currentNode, adj,
                        A);

                // Storing the maximum of value of branch path
                // sums maximumBranchSum1 will store the maximum
                // value maximumBranchSum2 will store the 2nd
                // most maximum value
                if (A[v.get(i)] > maximumBranchSum1) {
                    maximumBranchSum2
                            = maximumBranchSum1;
                    maximumBranchSum1
                            = A[v.get(i)];
                }
                else {
                    maximumBranchSum2 = Math.max(
                            maximumBranchSum2, A[v.get(i)]);
                }
            }
            result = Math.max(result, A[currentNode]
                    + maximumBranchSum1
                    + maximumBranchSum2);

            // Updating the value of current node with
            // maximum path sum including currentNode
            A[currentNode] += maximumBranchSum1;
        }

        // Driver code
        public static void main(String[] args)
        {
            int N = 6;
            int A[] = { 4, -1, -3, 5, 7, -2 };
            ArrayList<ArrayList<Integer> > adj
                    = new ArrayList<ArrayList<Integer> >(N);

            for (int i = 0; i < N; i++)
                adj.add(new ArrayList<Integer>());

            addEdge(adj, 0, 1);
            addEdge(adj, 0, 2);
            addEdge(adj, 1, 3);
            addEdge(adj, 1, 4);
            addEdge(adj, 1, 5);

            // Driver code
            findMaximumPathSum(0, -1, adj, A);
            System.out.println(result);
        }
    }