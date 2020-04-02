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
public class BSTNode {

    private int data;
    private BSTNode left;
    private BSTNode right;
    private int postion_X;
    private int postion_Y;
    private Line line;

    public BSTNode(int data) {
        this.data = data;
        left = null;
        right = null;
        this.line = new Line(0,0,0,0);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getPostion_X() {
        return postion_X;
    }

    public void setPostion_X(int postion_X) {
        this.postion_X = postion_X;
    }

    public int getPostion_Y() {
        return postion_Y;
    }

    public void setPostion_Y(int postion_Y) {
        this.postion_Y = postion_Y;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
