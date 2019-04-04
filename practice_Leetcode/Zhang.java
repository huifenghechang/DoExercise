import java.util.Stack;

public class Zhang {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public void beh_traverse2(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode tCur = root;
            TreeNode t;
            while (tCur != null || !stack.isEmpty()) {
                while (tCur != null) {
                    stack.push(tCur);
                    tCur = tCur.left;
                }
                t = stack.peek().right;
                if (t != null) {
                    tCur = t;
                } else {
                    t = stack.pop();
                    System.out.print(t.val + " ");
                }
            }
        }
    }
}
