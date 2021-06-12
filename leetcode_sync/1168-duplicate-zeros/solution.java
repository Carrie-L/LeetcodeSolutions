class Solution {
    public void duplicateZeros(int[] arr) {
        // int n = arr.length;
        // for(int i=0; i<n; i++){
        //     if(arr[i]==0){
        //         for(int j=n-1; j>i;j--){
        //             arr[j] = arr[j-1];
        //         }
        //         arr[i] =0;
        //         i++;
        //     }
        // }
        int i = 0, sh = 0;
        for (i = 0; sh + i < arr.length; ++i) sh += arr[i] == 0 ? 1 : 0;
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < arr.length) arr[i + sh] = arr[i];
            if (arr[i] == 0) arr[i + --sh] = arr[i];
        }
    }
}
