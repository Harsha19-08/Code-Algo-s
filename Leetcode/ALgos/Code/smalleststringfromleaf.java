
//leetcode 988 Smallest String Starting From Leaf

// You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

// Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

// As a reminder, any shorter prefix of a string is lexicographically smaller.

// For example, "ab" is lexicographically smaller than "aba".
// A leaf of a node is a node that has no children.



// Solution 1: Recursive DFS  (Time: O(N), Space: O(H))
//In this our main aim is to get the string from the leaf node to the root node 
// so in this we will creating a string smallest (for lexicographically smallest) and current string to store the current traversal 
//we will first go in dfs and take the first root node to current string and traverse to the left until 
// left and right becomes null and the we will add them suppose in example
//         z
//       /   \
//      b     d
//     / \   / \
//    b   d a   c
// in this first we add the z to the current string and then we will chech if any left and right re null
//then we traverse through dfs and move left and add b and again sam check and move to the b
// after that we will check if the current node s left and rgiht are nul then it is "yes"
//then we will reverse the current string and check if the smallest is empty or not 
//if it is empty them we will add current string to smallest/ if not we will compare the current
//string with the smallest and if it is smaller then we will add the current
// in the above example as the curr str is "zbd" an smallest becomes "zbd"
// then we back track and remove the last element from the current string and then move to the right
// and then we will check if the left and right are null then we will reverse the current string and check if the smallest is empty or not
// then the current string becosm dbz after check smallest remains same "zbd"
//after we backtrarxk and  curr = zda //as revrese becoms adz as the smallest becomes smallest =adz
//again backtrack and checkzdc\cdz and smallesst finally becomes zda /adz 
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder path, StringBuilder smallest) {
        if (node == null) return;
        
        // Append current node's character to the path
        path.append((char)('a' + node.val));
        
        // If it's a leaf node, compare and update smallest
        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse(); // backtrack by reversing again
        }
        
        // Recursively traverse left and right subtrees
        dfs(node.left, path, smallest);
        dfs(node.right, path, smallest);
        
        // Backtrack: remove the current node's character from the path
        path.setLength(path.length() - 1);
    }
}