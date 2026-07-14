class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int[] arr = new int[nums.length];
        int currentIdx = 0;
        int j = 1;
        arr[currentIdx] = 1;
        while(currentIdx < nums.length){
            if( j != currentIdx && j < nums.length){
                if(j == 0){
                    arr[currentIdx] = nums[j];
                } else {
                    arr[currentIdx] = arr[currentIdx] * nums[j];
                }
            } else if(j == nums.length){
                j = 0;
                currentIdx++;
                continue;
            }
            j++;
        }
        return arr;
    }
}  
