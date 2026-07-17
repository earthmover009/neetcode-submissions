class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0){
            return new int[0];
        }
        int left = 0;
        int right = 1;
        while(left < right && right != numbers.length) {
            if(numbers[left] + numbers[right] == target){
                return new int[]{left+1, right+1};
            }
            if(right == numbers.length-1) {
                left++;
                right = left + 1;
            } else {
                right++;
            }
        }
        return new int[0];
    }
}
