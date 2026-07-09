class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] opArr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for( int num : nums ){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a,b) -> Integer.compare(map.get(b), map.get(a)));
        for(int i = 0; i < k; i++ ){
            opArr[i] = keys.get(i);
        }
        return opArr;
    }
}
