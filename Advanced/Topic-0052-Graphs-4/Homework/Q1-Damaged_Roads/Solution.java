public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int m = B.size();

        List<Pair> costWithDirection = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            // 1 is for vertical direction
            costWithDirection.add(new Pair(A.get(i), 1));
        }

        for(int i = 0; i < m; i++) {
            // 0 is for horizontal direction
            costWithDirection.add(new Pair(B.get(i), 0));
        }

        costWithDirection.sort((p1, p2) -> p1.cost.compareTo(p2.cost));

        n++;
        m++;

        int minCost = 0;
        int mod = 1000 * 1000 * 1000 + 7;

        for(Pair pair : costWithDirection) {

            int cost = pair.cost;
            int direction = pair.direction;

            if(direction == 0) {
                minCost += n * cost;
                minCost %= mod;
                m--;
            }

            else {
                minCost += m * cost;
                minCost %= mod;
                n--;
            }
        }

        return minCost;

    }
}

class Pair {
    Integer cost;
    Integer direction;

    public Pair(int cost, int direction) {
        this.cost = cost;
        this.direction = direction;
    }
}
