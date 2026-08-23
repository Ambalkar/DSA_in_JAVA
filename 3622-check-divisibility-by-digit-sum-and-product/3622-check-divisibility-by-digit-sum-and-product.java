class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int product = 1;
        
        // Extract digits and calculate sum and product
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        
        // Check if n is divisible by (sum + product)
        return n % (sum + product) == 0;
    }
}