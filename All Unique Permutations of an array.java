import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> uniquePerms(List<Integer> arr, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        ans.add(new ArrayList<>(arr));
        set.add(new ArrayList<>(arr));

        if (n == 1)
            return ans;

        while (true) {
            int ind = -1;
            for (int i = n - 2; i >= 0; i--) {
                if (arr.get(i) < arr.get(i + 1)) {
                    ind = i;
                    break;
                }
            }

            for (int i = n - 1; i > ind && ind != -1; i--) {
                if (arr.get(i) > arr.get(ind)) {
                    swap(arr, i, ind);
                    break;
                }
            }

            reverse(arr, ind + 1, n - 1);

            if (set.contains(arr))
                break;

            ans.add(new ArrayList<>(arr));
            set.add(new ArrayList<>(arr));
        }

        ans.sort((a, b) -> {
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        return ans;
    }

    private void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution ob = new Solution();
        List<Integer> arr1 = Arrays.asList(1, 2, 1);
        int n1 = arr1.size();
        List<List<Integer>> res1 = ob.uniquePerms(arr1, n1);
        printResult(res1);

        List<Integer> arr2 = Arrays.asList(4, 5);
        int n2 = arr2.size();
        List<List<Integer>> res2 = ob.uniquePerms(arr2, n2);
        printResult(res2);
    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}
