class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        for(String str : arr) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }

        for(String str : arr) {
            if(freqMap.get(str) == 1) {
                if(k == 1) {
                    return str;
                } else {
                    k--;
                }
            }
        }

        return "";
    }
}