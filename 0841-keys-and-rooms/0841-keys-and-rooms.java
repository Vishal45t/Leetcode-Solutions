class Solution {
    public static void check(List<List<Integer>> rooms, int source, boolean[] vis, Stack<Integer> pq) {
        pq.add(source);
        while (!pq.empty()) {
            int ele = pq.pop();
            if (vis[ele]) {
                continue;
            }
            vis[ele] = true;
            for (int i = 0; i < rooms.get(ele).size(); i++) {
                pq.push(rooms.get(ele).get(i));
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        Stack<Integer> pq = new Stack<>();
        check(rooms, 0, vis, pq);
        for (boolean val : vis) {
            if (val == false) {
                return false;
            }
        }
        return true;
    }
}