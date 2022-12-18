package Avl_Trees;

import static javax.swing.Spring.height;

class Node{
    int data;
    int height;
    Node left,right;
    Node(int data){
        this.data=data;
        this.height=0;
    }
}
public class AvlIntto {
int max(int a, int b){
    return (a>b)?a:b;
}
int height(Node root){
    if(root==null){
        return -1;
    }
    return root.height;
}
int BalanceFacter(Node root){
    if(root==null){
        return -1;
    }
    return height(root.left)- height(root.right);
}
    Node insert(Node root,int data){
        if(root==null) return new Node(data);
        if(root.data<data)
        root.left=insert(root.left,data);
        else if(root.data>data)
            root.right=insert(root.right,data);
        else return root;
root.height=1+max(height(root.left),height(root.right));
    return root;
    }
    void preOrder(Node root){
        if(root==null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.data+" "+" Balance Factor is: "+BalanceFacter(root));
        preOrder(root.right);
    }

    public static void main(String[] args) {
    AvlIntto obj = new AvlIntto();
    Node root=null;
    root=obj.insert(root,5);
    root=obj.insert(root,10);
    root=obj.insert(root,15);
    root=obj.insert(root,20);
    root=obj.insert(root,25);
    obj.preOrder(root);
    }
}
