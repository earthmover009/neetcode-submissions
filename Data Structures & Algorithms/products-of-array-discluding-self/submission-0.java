class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int currentIdx = 0;
        int j = 1;
        List<Integer> list = new ArrayList<>();
        while(currentIdx < nums.length){
            if(j != currentIdx) {
                list.add(nums[j]);
            }
            if(j == nums.length-1){
                map.put(currentIdx, List.copyOf(list));
                list.clear();
                currentIdx++;
                j = 0;
            } else {
                j++;
            }
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for( var values : map.values() ){
            arr[i] = values.stream().reduce(1, (a,b) -> a*b);
            i++;
        }
        return arr;
    }
}  
