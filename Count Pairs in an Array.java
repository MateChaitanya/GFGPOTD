class Solution {
    public int countPairs(int[] arr, int n) {
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(i * arr[i]);
        }
        List<Integer> temp = new ArrayList<>(v);
        Collections.sort(temp);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = upperBound(temp, v.get(i));
            int y = lowerBound(temp, v.get(i));
            ans = ans + (temp.size() - x);
            temp.remove(y);
        }
        return ans;
    }
    
    private int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
