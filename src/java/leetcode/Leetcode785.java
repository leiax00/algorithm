package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode785 {
    public boolean isBipartite(int[][] graph) {
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();
        groupA.add(0);
        groupB.addAll(Arrays.stream(graph[0]).boxed().collect(Collectors.toList()));
        for (int i = 1; i < graph.length; i++) {
            if (groupA.contains(i)) {
                if (groupB.contains(i)) {
                    return false;
                }
                int finalI = i;
                List<Integer> tmp = Arrays.stream(graph[i]).filter(item -> !groupB.contains(finalI)).boxed().collect(Collectors.toList());
                if (tmp.size() != graph[i].length) {
                    return false;
                }
                groupB.addAll(tmp);
            }
        }
        return true;
    }
}
