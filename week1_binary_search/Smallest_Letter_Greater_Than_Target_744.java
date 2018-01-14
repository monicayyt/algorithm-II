class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int len = letters.length;
        System.out.println(letters[0]);
        if (letters[len - 1]<= target) {
            return letters[0];
        }
        
        if (letters[0] > target) {
            return letters[0];
        }
        
        int l = 0, r = len - 1;
        int mid;
        
        while(l<r){
            mid = l + (r-l) / 2;
            if(letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        } 
        
        return letters[r];
    }
}