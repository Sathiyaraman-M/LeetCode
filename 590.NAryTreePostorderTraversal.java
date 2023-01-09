/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        traverse(root);
        return list;
    }

    private void traverse(Node root) {
        if(root != null) {
            for(var i: root.children) {
                traverse(i);
            }
            list.add(root.val);
        }
    }
}