class Solution {   //nearabout o(n) but in worst case it is O(nsquare)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(root.val == p.val || root.val == q.val)return root;
        boolean pInLeft = check(root.left,p.val);
        boolean qInRight = check(root.right,q.val);
        if(pInLeft && !qInRight){
            return lowestCommonAncestor(root.left,p,q);
        }else if(!pInLeft && qInRight){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
    public boolean check(TreeNode root,int val ){
        if(root == null)return false;
        if(root.val == val)return true;
        return check(root.left, val) || check(root.right, val);
    }   
}
