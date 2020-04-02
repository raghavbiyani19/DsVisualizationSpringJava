/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package testabc;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;

public class BSTree {
    
    BSTNode root;
    private ArrayList<BSTNode> nods = new ArrayList<BSTNode>();

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(int data) {
        BSTNode newNode = new BSTNode(data);
        if (this.isEmpty() || nods.isEmpty()) {
            root = newNode;
            this.insertRoot(newNode);
        } else {
            BSTNode t = root;
            while (true) {
                if (data < t.getData()) {
                    if (t.getLeft() == null) {
                        t.setLeft(newNode);
                        this.insertLeft(newNode);
                        break;
                    } else {
                        t = t.getLeft();
                    }
                } else if (data > t.getData()) {
                    if (t.getRight() == null) {
                        t.setRight(newNode);
                        this.insertRight(newNode);
                        break;
                    } else {
                        t = t.getRight();
                    }
                } else {
                    break; //duplicate key (data) just break;    
                }
            }

        }
    }

    private void insertRoot(BSTNode root) {
        root.setPostion_X(630);
        root.setPostion_Y(10);
        nods.add(root);
    }

    private void insertLeft(BSTNode leftNode) {
        BSTNode nodeParent = this.locateParent(leftNode.getData());
        if (nodeParent == root) {
            leftNode.setPostion_X(330);
            leftNode.setPostion_Y(100);
            int x1 = nodeParent.getPostion_X() + 20;
            int y1 = nodeParent.getPostion_Y() + 80;
            int x2 = leftNode.getPostion_X() + 20;
            int y2 = leftNode.getPostion_Y() + 55;
            Line line = new Line(x1, y1, x2, y2);
            leftNode.setLine(line);
            nods.add(leftNode);
        } else {
            int px1 = nodeParent.getLine().getX1();
            int px2 = nodeParent.getLine().getX2();
            int py1 = nodeParent.getLine().getY1();
            int py2 = nodeParent.getLine().getY2();
            int px1px2 = (px1 - px2) / 2;
            int py1py2 = (py2 - py1);
            leftNode.setPostion_X(nodeParent.getPostion_X() - Math.abs(px1px2));
            leftNode.setPostion_Y(nodeParent.getPostion_Y() + py1py2 + 10);
            int x1 = nodeParent.getPostion_X() + 20;
            int y1 = nodeParent.getPostion_Y() + 80;
            int x2 = leftNode.getPostion_X() + 20;
            int y2 = leftNode.getPostion_Y() + 55;
            Line line = new Line(x1, y1, x2, y2);
            leftNode.setLine(line);
            nods.add(leftNode);
        }

    }

    private void insertRight(BSTNode rightNode) {
        BSTNode nodeParent = this.locateParent(rightNode.getData());
        if (nodeParent == root) {
            rightNode.setPostion_X(930);
            rightNode.setPostion_Y(100);
            int x1 = nodeParent.getPostion_X() + 20;
            int y1 = nodeParent.getPostion_Y() + 80;
            int x2 = rightNode.getPostion_X() + 20;
            int y2 = rightNode.getPostion_Y() + 55;
            Line line = new Line(x1, y1, x2, y2);
            rightNode.setLine(line);
            nods.add(rightNode);
        } else {
            int px1 = nodeParent.getLine().getX1();
            int px2 = nodeParent.getLine().getX2();
            int py1 = nodeParent.getLine().getY1();
            int py2 = nodeParent.getLine().getY2();
            int px1px2 = (px1 - px2) / 2;
            int py1py2 = (py2 - py1);
            rightNode.setPostion_X(nodeParent.getPostion_X() + Math.abs(px1px2));
            rightNode.setPostion_Y(nodeParent.getPostion_Y() + py1py2 + 10);
            int x1 = nodeParent.getPostion_X() + 20;
            int y1 = nodeParent.getPostion_Y() + 80;
            int x2 = rightNode.getPostion_X() + 20;
            int y2 = rightNode.getPostion_Y() + 55;
            Line line = new Line(x1, y1, x2, y2);
            rightNode.setLine(line);
            nods.add(rightNode);
        }

    }

    public void printTree(BSTNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            printTree(root.getLeft());
            printTree(root.getRight());
        }
    }

    public BSTNode locate(int data) {
        if (this.isEmpty()) {
            return null;
        } else {
            BSTNode current = root;
            while (current != null) {
                if (current.getData() == data) {
                    return current;
                } else if (data < current.getData()) {
                    current = current.getLeft();
                } else if (data > current.getData()) {
                    current = current.getRight();
                }
            }
            return null;
        }
    }

    public BSTNode locateParent(int data) {
        BSTNode current = root;
        if (current.getData() == data) {
            return null;
        }
        while (current != null) {
            if (current.getLeft() != null) {
                if (current.getLeft().getData() == data) {
                    return current;
                }
            }
            if (current.getRight() != null) {
                if (current.getRight().getData() == data) {
                    return current;
                }
            }
            if (data < current.getData()) {
                current = current.getLeft();
            } else if (data > current.getData()) {
                current = current.getRight();
            }
        }
        return null;
    }

    public BSTNode maxLeftNode(BSTNode subroot) {
        BSTNode current = subroot;
        current = current.getLeft();
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    public int delete(int data) {
        BSTNode current = this.locate(data);
        if (current == null) {
            return -1;
        }
        if (this.isEmpty()) {
            return -1;
        }
        // Delete root.....
        if (current.getLeft() == null && current.getRight() == null) {
            if (root == current) {
                current = null;
                this.deleteNodeLeaf(data);
                return data;
            }
        }
        // Delete leaf node.....
        if (current.getLeft() == null && current.getRight() == null) {
            BSTNode n = locateParent(current.getData());
            if (current.getData() < n.getData()) {
                n.setLeft(null);
                this.deleteNodeLeaf(data);
            } else if (current.getData() > n.getData()) {
                n.setRight(null);
                this.deleteNodeLeaf(data);
            }
            // Delete node has one child.....
        } else {
            if (current.getLeft() != null && current.getRight() == null) {
                if (current == root) {
                    this.dRoot();
                    current = current.getLeft();
                } else {
                    BSTNode n = locateParent(current.getData());
                    if (current.getData() > n.getData()) {
                        this.dLOne_Child(current.getData());
                        n.setRight(n.getRight().getLeft());
                    } else {
                        this.dLOne_Child(current.getData());
                        n.setLeft(n.getLeft().getLeft());
                    }
                }
            } else if (current.getLeft() == null && current.getRight() != null) {
                if (current == root) {
                    this.dRoot();
                    current = current.getRight();
                } else {
                    BSTNode n = locateParent(current.getData());
                    if (current.getData() > n.getData()) {
                        this.dROne_Child(current.getData());
                        n.setRight(n.getRight().getRight());
                    } else {
                        this.dROne_Child(current.getData());
                        n.setLeft(n.getLeft().getRight());
                    }
                }
                // Delete node has two child......    
            } else if (current.getLeft() != null && current.getRight() != null) {
                BSTNode temp = maxLeftNode(current);
                BSTNode n = locateParent(temp.getData());
                this.dTwo_child(current.getData(), temp.getData());
                current.setData(temp.getData());
                if (temp.getData() > n.getData()) {
                    this.dNode(temp);
                    n.setRight(n.getRight().getLeft());
                } else {
                    this.dNode(temp);
                    n.setLeft(n.getLeft().getLeft());
                }
            }

        }
        return data;
    }
    
    private void dRoot (){
        nods.remove(0);
        this.reArray();
    }
    
    private void dTwo_child(int olddata,int newdata){
        BSTNode node;
        for (int i = 0; i < nods.size(); i++) {
            if(nods.get(i).getData() == olddata){
                node = nods.get(i);
                node.setData(newdata);
                nods.set(i, node);
            }
        }
    }
    
    private void dNode(BSTNode temp){
        nods.remove(temp);
        this.reArray();
    }

    private void dLOne_Child(int data) {
        BSTNode nodeD = locateNode(data);
        BSTNode nodeN = locateNode(nodeD.getLeft().getData());
        nodeN.setLine(nodeD.getLine());
        nodeN.setPostion_X(nodeD.getPostion_X());
        nodeN.setPostion_Y(nodeD.getPostion_Y());
        nods.remove(nodeD);
        this.reArray();
    }

    private void dROne_Child(int data) {
        BSTNode nodeD = locateNode(data);
        BSTNode nodeN = locateNode(nodeD.getRight().getData());
        nodeN.setLine(nodeD.getLine());
        nodeN.setPostion_X(nodeD.getPostion_X());
        nodeN.setPostion_Y(nodeD.getPostion_Y());
        nods.remove(nodeD);
        this.reArray();
    }

    private void deleteNodeLeaf(int data) {
        nods.remove(locateNode(data));
    }

    private BSTNode locateNode(int data) {
        for (int i = 0; i < nods.size(); i++) {
            if (nods.get(i).getData() == data) {
                return nods.get(i);
            }
        }
        return null;
    }

    private void reArray() {
        ArrayList<BSTNode> newNods = new ArrayList<BSTNode>();
        newNods.addAll(nods);
        nods.removeAll(nods);
        BSTree tree = new BSTree();
        for (int i = 0; i < newNods.size(); i++) {
            tree.insert(newNods.get(i).getData());
        }
        nods.addAll(tree.getNods());
    }

    public ArrayList<BSTNode> getNods() {
        return nods;
    }

}