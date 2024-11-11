class Solution {
    public void reverseString(char[] s) {
        // char temp=' ';
        // int l = s.length;
        // for (int i = 0; i < l/2; i++) {
        //     temp = s[i];
        //     s[i] = s[l-i-1];
        //     s[l-i-1] = temp;
        // }
        reverse(s, 0, s.length-1);
    }

public char[] reverse(char[] s, int left, int right){
        char temp=' ';
        if(left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            reverse(s, left+1, right-1);
        }
        
        return s;
    }

}
