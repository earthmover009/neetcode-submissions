class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for( int num : nums ){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return map.keySet().stream()
                .sorted((a, b) -> Integer.compare(map.get(b), map.get(a)))
                .limit(k).mapToInt(i -> i).toArray();
    }
}
