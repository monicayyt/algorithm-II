class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int start, end, num = nums.length;
        
        int l = 0, r = num - 1;
        
        while(l < r){
            int mid = l + ( r - l ) / 2;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
        if(nums[l] != target) {
            return new int[] {-1, -1};
        }
        
        start = l;
        
        r = num - 1;
        
        while(l < r) {
            int mid = l + (r - l + 1) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }   
        }
        
        end = l;
        
        return new int[] {start, end};
    }
}