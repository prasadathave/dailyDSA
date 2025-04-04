package org.example.Apr2025;

import org.example.nov2024.Nov172024;

public class April042025 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    private Nov172024.Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Nov172024.Pair<>(null, 0);
        }

        Nov172024.Pair<TreeNode, Integer> left = dfs(root.left);
        Nov172024.Pair<TreeNode, Integer> right = dfs(root.right);

        if (left.getValue() > right.getValue()) {
            return new Nov172024.Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Nov172024.Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Nov172024.Pair<>(root, left.getValue() + 1);
    }
}
