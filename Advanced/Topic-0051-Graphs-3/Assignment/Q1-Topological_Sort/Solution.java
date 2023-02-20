public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        List<List<Integer>> adjacency = new ArrayList<>();

        for(int i = 0; i <= A; i++) {
            adjacency.add(new ArrayList<>());
        }

        int[] noOfComingEdge = new int[A + 1];
        boolean[] visited = new boolean[A + 1];

        for(List<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjacency.get(u).add(v);
            noOfComingEdge[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= A; i++) {
            if(noOfComingEdge[i] == 0) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }


        while(!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for(Integer e : adjacency.get(u)) {
                noOfComingEdge[e]--;
            }

            for(int i = 1; i <= A; i++) {
                if(noOfComingEdge[i] == 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    break;
                }
            }

        }

        return result;
    }
}
