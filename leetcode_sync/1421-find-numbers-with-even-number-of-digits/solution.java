class Solution {
    
   
    
    public int findNumbers(int[] nums) {
        int evenNumber = 0;
        for(int i=0;i<nums.length;i++){
            int count=1;
            int result = nums[i]/10;
            while(result!=0){
                result = result/10;
                count+=1;
            }  
            if(count%2==0) evenNumber++;
        }
        return evenNumber;
    }
    
//     public void getNumers(int n){
//         int result = n/10;
//         count++;
//         if(result != 0){
//             getNumers(result);
//         }
//     }
    
}
