class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int idx = 0, count = 0;

        while(idx < flowerbed.length) {
            int prev = getSafe(flowerbed, idx - 1);
            int next = getSafe(flowerbed, idx + 1);

            if(flowerbed[idx] == 0 && prev != 1 && next != 1) {
                flowerbed[idx] = 1;
                count++;
            }
            idx += 2;
        }
        return count >= n;
    }

    private int getSafe(int[] arr, int pos) {
        if(-1 < pos && pos < arr.length) {
            return arr[pos];
        }
        return 0;
    }
}