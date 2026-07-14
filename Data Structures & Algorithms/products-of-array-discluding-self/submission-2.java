class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int[] arr = new int[nums.length];
        int pre = arr[0] = 1;
        int post = 1;
        for( int i = 1; i < nums.length; i++ ){
            arr[i] = pre * nums[i-1];
            pre = arr[i];
        }
        for( int j = nums.length-1; j >=0 ; j-- ){
            arr[j] = post * arr[j];
            post = post * nums[j];
        }
        return arr;
    }
}  
