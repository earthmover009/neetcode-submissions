class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxSeq = 0;
        for( var num : numSet ){
            if(!numSet.contains(num-1)){
                int seq = 0;
                int start = num;
                while(numSet.contains(start)){
                    start++;
                    seq++;
                }
                if(maxSeq < seq) {
                    maxSeq = seq;
                }
            }
        }
        return maxSeq;
    }
}
