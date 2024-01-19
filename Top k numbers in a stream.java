import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> kTop(List<Integer> arr, int N, int K) {
        List<Integer> top = new ArrayList<>(Arrays.asList(new Integer[K + 1]));
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < N; i++) {
            mp.put(arr.get(i), mp.getOrDefault(arr.get(i), 0) + 1);
            top.set(K, arr.get(i));

            int index = top.subList(0, K).indexOf(arr.get(i));
            for (int j = index; j >= 0; --j) {
                if (mp.get(top.get(j)) < mp.get(top.get(j + 1))) {
                    swap(top, j, j + 1);
                } else if ((mp.get(top.get(j)).equals(mp.get(top.get(j + 1))))
                        && (top.get(j) > top.get(j + 1))) {
                    swap(top, j, j + 1);
                } else {
                    break;
                }
            }

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < K && top.get(i) != 0; ++i) {
                temp.add(top.get(i));
            }
            ans.add(temp);
        }

        return ans;
    }

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
