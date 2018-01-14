class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        if (heaters.length == 0 || houses.length == 0) {
            return -1;
        }

        int radius = 0, radiusL, radiusR;
        int heaterPos = 0;
        Arrays.sort(heaters); //
        for(int house : houses) {
            
            heaterPos = heaterInd(heaters, house);
            System.out.println(heaterPos);
            if (heaterPos == 0) {
                radiusL = Integer.MAX_VALUE;
            } else {
                radiusL = house - heaters[heaterPos - 1];
            }
               
            if (heaterPos == heaters.length) {
                radiusR = Integer.MAX_VALUE;
            }else{
                radiusR = heaters[heaterPos] - house;
            }
            
            radius = Math.max(radius, Math.min(radiusL, radiusR)); 
        } 
        return radius;
    }
    
    public int heaterInd(int[] heaters, int house) {
        int l = 0, r = heaters.length; // r = heater.length instead of r = heater.length - 1 to make sure binary search contains 
                                            // at least two values in the case of only one heater. It returns heater.length if only one                                                 //  heater.
        int m;
        while(l < r) {
            m = l + (r - l) / 2;
            if (heaters[m] >= house) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}