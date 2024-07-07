//2. Add Two Numbers Leetcode

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.


 // Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 


 // Solution 1: Iterative (Time: O(max(N, M)), Space: O(max(N, M)))
//In this we are here to find the sum of the 2 lists which are reversed so we should summ them and 
//return the sum in the form of linked list
//so here comes the trick part as sum will be easy if we get any carry generally we 
//will do sum from right to left so we add them to left
// but here as the lists are reversed so we should add the carry to right 
// so it will be balanced as it revresed
/// so we willl take a dummy head list node and we will return it last
// as the dummy node is assigned to the current
// initalise the carry to 0
// in this we  will check the list is empty or not if not 
// we will add it to the sum as x and y y wiht the carry//
//after that we will take the carry from the sum as we will add to the next number
// again afer all this if any carry remains we will add to the next node and we return the dummy .next as dummy first node is 0
 public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = carry + x + y;
            carry = sum / 10;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}