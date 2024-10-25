package org.example.oct2024;


import java.util.ArrayList;
import java.util.List;

public class oct242024 {
    private void logWhomAreWeComparing(TreeNode root1,TreeNode root2){
        if(root1==null){
            System.out.print("root1 was null ");
        }
        if(root1!=null){
            System.out.println("root1 was "+root1.val+" ");
        }
        if(root2==null){
            System.out.print(" root2 was null ");
        }
        if (root2!=null){
            System.out.println(" root2 was "+root2.val+" ");
        }
        System.out.println();

    }
    private List<Integer> provideChildValueList(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        if(root.left!=null){
            list.add(root.left.val);
        }
        if(root.right!=null){
            list.add(root.right.val);
        }
        return list;
    }
    private boolean compareLists(List<Integer> l1,List<Integer> l2){
        if(l1.size()!=l2.size()){
            return false;
        }
        for(Integer elem: l1){
            if(!l2.contains(elem)){
                return false;
            }
        }
        for(Integer elem: l2){
            if(!l1.contains(elem)){
                return false;
            }
        }
        return true;
    }
    private void printChildren(TreeNode root1 , TreeNode root2){
        if(root1==null){
            System.out.print(" root1 was null ");
        }
        if(root1!=null){
            System.out.print("root1 was -"+ root1.val + " ");
            if(root1.left==null){
                System.out.print(" root1-left was null ");
            }
            if(root1.left!=null){
                System.out.print(" root1-left was "+root1.left);
            }
            if(root1.right==null){
                System.out.print(" root1-right was null ");
            }
            if(root1.right!=null){
                System.out.print(" root1-right was "+root1.right);
            }
        }

        if(root2==null){
            System.out.print(" root2 was null ");
        }
        if(root2!=null){
            System.out.print("root2 was -"+ root2.val + " ");
            if(root2.left==null){
                System.out.print(" root2-left was null ");
            }
            if(root2.left!=null){
                System.out.print(" root2-left was "+root2.left);
            }
            if(root2.right==null){
                System.out.print(" root2-right was null ");
            }
            if(root2.right!=null){
                System.out.print(" root2-right was "+root2.right);
            }
        }

    }

    private boolean areNodesEqual(TreeNode root1,TreeNode root2){
        if(root1!=null && root2!=null && root1.val== root2.val){
            return true;
        }
        if(root1!=null && root2!=null && root1.val!= root2.val){
            return false;
        }
        return root1 == null && root2 == null;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        logWhomAreWeComparing(root1,root2);
//        printChildren(root1,root2);
        if((root1==null && root2!=null) ||(root1!=null && root2==null)){
            return false;
        }
        if (root1 == null){
            return true;
        }
        if(root1.val!= root2.val){
            return false;
        }
        boolean result = true;
        int attemptedCounters = 0;
        if(areNodesEqual(root1.left,root2.left)){
            attemptedCounters++;
            result = result && flipEquiv(root1.left,root2.left);
        }
        if(areNodesEqual(root1.right,root2.right)){
            attemptedCounters++;
            result = result & flipEquiv(root1.right,root2.right);
        }
        if(areNodesEqual(root1.left,root2.right)){
            attemptedCounters++;
            result = result & flipEquiv(root1.left,root2.right);
        }
        if(areNodesEqual(root1.right,root2.left)){
            attemptedCounters++;
            result = result & flipEquiv(root1.right,root2.left);
        }
        List<Integer> l1 = provideChildValueList(root1);
        List<Integer> l2 = provideChildValueList(root2);

        if(!compareLists(l1,l2)){
            return false;
        }
        if(attemptedCounters<2){
            return false;
        }


        return result;
    }
}
