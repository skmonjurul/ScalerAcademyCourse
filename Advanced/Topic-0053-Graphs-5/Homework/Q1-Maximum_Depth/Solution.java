public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F) {

        boolean[] visited = new boolean[A + 1];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i <= A; i++) {
            adjacency.add(new ArrayList<Integer> ());
        }


        for(int i = 0; i < B.size(); i++) {
            int u = B.get(i);
            int v = C.get(i);

            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }


        List<List<Integer>> valuePerRow = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            valuePerRow.add(new ArrayList<Integer> ());
            for(int i = 1; i <= size; i++) {
                int u = queue.poll();
                valuePerRow.get(level).add(D.get(u - 1));

                for(Integer v : adjacency.get(u)) {
                    if(!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }

            level++;
        }

        // now level is maxLevel + 1;

        for(List<Integer> row : valuePerRow) {
            Collections.sort(row);
        }


        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < E.size(); i++) {
            int l = E.get(i) % level;
            int value = F.get(i);
            boolean isFound = false;
            for(Integer num : valuePerRow.get(l)) {
                if(num < value) continue;
                result.add(num);
                isFound = true;
                break;
            }

            if(!isFound) result.add(-1);
        }



        return result;
    }
}
