class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;   
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            rightSum = rightSum - nums[i];

            if (i == 0) {
                res[i] = rightSum - nums[i] * (n - 1);
            } 
            else if (i == n - 1) {
                res[i] = nums[i] * (n - 1) - leftSum;
            } 
            else {
                res[i] = nums[i] * i - leftSum
                       + rightSum - nums[i] * (n - i - 1);
            }

            leftSum = leftSum + nums[i];
        }

        return res;
    }
}
