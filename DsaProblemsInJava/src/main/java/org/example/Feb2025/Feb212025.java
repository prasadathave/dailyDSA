package org.example.Feb2025;

import java.util.HashSet;

public class Feb212025 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    private HashSet<Integer> vals = new HashSet<>();
    public Feb212025(TreeNode root) {
        if(root==null){
            return;
        }
        root.val = 0;
        this.vals.add(root.val);
        reconstruct(root);
    }

    private void reconstruct(TreeNode root){
        if(root==null){
            return;
        }
        int vl = root.val;
        if(root.left!=null){
            root.left.val = 2*vl+1;
            this.vals.add(root.left.val);
            reconstruct(root.left);
        }
        if(root.right!=null){
            root.right.val = 2*vl+2;
            this.vals.add(root.right.val);
            reconstruct(root.right);
        }
    }

    public boolean find(int target) {
        if(this.vals.contains(target)){
            return true;
        }
        return false;
    }
}
