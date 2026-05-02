class Solution {
    public int climbStairs(int n) 
    {
        int n1 = 1 , n2 = 2;  
        if (n == 1)
            return n1;
        if (n == 2)
            return n2;
        while(n - 2 > 0)
        {
            n2 = n2 + n1; 
            n1 = n2 - n1;
            n--;
        }
        return n2;   
    }
}
