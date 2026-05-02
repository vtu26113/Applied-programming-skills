import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(i, map.get(email), parent);
                }
            }
        }

        Map<Integer, Set<String>> merged = new HashMap<>();

        for (String email : map.keySet()) {
            int root = find(map.get(email), parent);
            merged.putIfAbsent(root, new TreeSet<>());
            merged.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (int root : merged.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(root).get(0));
            list.addAll(merged.get(root));
            result.add(list);
        }

        return result;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px != py) parent[py] = px;
    }
}
