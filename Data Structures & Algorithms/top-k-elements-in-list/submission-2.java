class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[] {entry.getKey(), entry.getValue()});
        }

        arr.sort((x, y) -> y[1] - x[1]);

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = arr.get(i)[0];
        }

        return ans;
    }
}
