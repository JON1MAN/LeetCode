package graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        dfs(rooms, 0, visited);
        boolean result = false;
        for (int room : visited) {
            if (room == 0) return false;
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, Integer to, int[] visited) {
        visited[to] = 1;
        List<Integer> keys = rooms.get(to);
        for (Integer key : keys) {
            if (visited[key] != 1) {
                dfs(rooms, key, visited);
            }
        }
    }

    @org.junit.Test
    @Test
    public void test1() {
        Problem841 problem841 = new Problem841();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());
        assertTrue(problem841.canVisitAllRooms(rooms));
    }


}
