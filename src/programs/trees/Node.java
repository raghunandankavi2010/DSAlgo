package programs.trees;

public class Node {

    private int data;
    private int hd;

    private Node leftNode,rightNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }


    public void setHd(int hd) {
        this.hd = hd;
    }

    public int getHd() {
        return hd;
    }


}
