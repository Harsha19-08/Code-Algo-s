// 7. Reverse Integer
// Given a 32-bit signed integer, reverse digits of an integer.
//as there will be overflow occuring as the reversing th 
//interger is easy but the overflow is the main problem
//so as the large no like 1534236469 will be reversed to 9646324351
//so we will check if the no is negative or not if it is we will make it positive
//and then we will reverse the no and check if it is greater than the max value of integer
//so in thi whern the range of integre is overflown we will simpley return the 0;


class Solution {
    public int reverse(int x) {
  int reversed = 0;

    while (x != 0) {
        int pop = x % 10;
        x /= 10;

        // Check for integer overflow/underflow
         if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) return 0;


        reversed = reversed * 10 + pop;
    }

    return reversed;
}
}

/*
 * Example 1: Reversing a Positive Number
Let's reverse 1,534,236,469.

Start with reversed = 0

Process each digit from right to left:

Digit 9 (last digit of 1,534,236,469):
reversed = 0 * 10 + 9 = 9
Digit 6 (next digit):
reversed = 9 * 10 + 6 = 96
Continue this until we process 4 (last few digits):
reversed = 96463243 (after processing up to 3)
Digit 1:
Here, reversed = 96463243 * 10 + 1 = 964632431
Digit 5:
Now, reversed = 964632431 * 10 + 5 = 9646324315
Since 964632431 > 214748364, this condition is true, meaning adding the next digit would cause overflow.
The function will return 0.
 */