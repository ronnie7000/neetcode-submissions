class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int ans = -1;

        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if(num == freq) {
                ans = ans < num ? num : ans;
            }
        }

        return ans;
    }
}