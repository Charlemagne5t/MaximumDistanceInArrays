import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE;
        int min1Index = -1;
        int min2 = Integer.MAX_VALUE;
        int min2Index = -1;
        int max1 = Integer.MIN_VALUE;
        int max1Index = -1;
        int max2 = Integer.MIN_VALUE;
        int max2Index = -1;

        for (int i = 0; i < arrays.size(); i++) {
            int first = arrays.get(i).get(0);
            int last = arrays.get(i).get(arrays.get(i).size() - 1);

            if (first <= min1) {
                min2 = min1;
                min2Index = min1Index;
                min1 = first;
                min1Index = i;
            } else if (first < min2) {
                min2 = first;
                min2Index = i;
            }

            if (last >= max1) {
                max2 = max1;
                max2Index = max1Index;
                max1 = last;
                max1Index = i;
            } else if (last > max2) {
                max2 = last;
                max2Index = i;
            }
        }

        if (min1Index != max1Index) {
            return max1 - min1;
        } else return Math.max(max1 - min2, max2 - min1);

    }
}