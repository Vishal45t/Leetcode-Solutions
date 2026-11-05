class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while(num > 9){
            while(num != 0){
                int val = num%10;
                num = num/10;
                sum += val;
            }
            num = sum;
            sum = 0;
        }
        return num; 
    }
}