package org.example.dec2024;

import org.example.oct2024.oct222024;

public class Dec202024 {
    private void reverseIt(int level, oct222024.TreeNode rootLeft, oct222024.TreeNode rootRight){
        if(rootLeft==null || rootRight==null){
            return;
        }

        if(level%2==0){

            int v = rootLeft.val;
            rootLeft.val = rootRight.val;
            rootRight.val = v;

        }
        reverseIt(level+1,rootLeft.left,rootRight.right);
        reverseIt(level+1,rootLeft.right,rootRight.left);
    }
    public oct222024.TreeNode reverseOddLevels(oct222024.TreeNode root) {
        reverseIt(0,root.left,root.right);
        return root;
    }
}
