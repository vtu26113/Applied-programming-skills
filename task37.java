class Solution {
    public boolean solve(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if((p!=null && q==null) || (p==null && q!=null) || p.val!=q.val) return false;

        boolean left = solve(p.left, q.left);
        boolean right = solve(p.right, q.right);
        return left && right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }
}
