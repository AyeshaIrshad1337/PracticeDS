package Avl_Trees;
class node {
    int data, height;
    node left, right;

    node(int d) {
        data = d;
        height = 0;
    }
}
public class Insertion {
 int max(int a,int b){
     return (a>b)?a:b;
 }
 int height(node root){
     if(root==null) return -1;
     return root.height;
 }
 int getBalanceFactor(node root){
     if(root==null) return 0;
     return height(root.left) - height(root.right);
 }
 node RightLeftRotate(node x){
node y=x.right;
node T2=y.left;
y.left=x;
x.right=T2;
x.height=1+max(height(x.left),height(x.right));
y.height=1+max(height(y.left),height(y.right));
return y;
 }
 node leftrightRotate(node x){
     node y =x.left;
     node T2 =y.right;
     y.right=x;
     x.left=T2;
     x.height=1+max(height(x.left),height(x.right));
     y.height=1+max(height(y.left),height(y.right));
     return y;
 }
    node insert(node root,int data){
        if(root==null) return new node(data);
        if(root.data<data)
            root.left=insert(root.left,data);
        else if(root.data>data)
            root.right=insert(root.right,data);
        else return root;
        root.height=1+max(height(root.left),height(root.right));
        int balance = getBalanceFactor(root);

        if (balance > 1 && data < root.left.data)
            return leftrightRotate((root));

        if (balance < -1 && data > root.right.data)
            return RightLeftRotate(root);

        if (balance > 1 && data > root.left.data) {
            root.left = leftrightRotate(root.left);
            return RightLeftRotate(root);
        }

        if (balance < -1 && data < root.right.data) {
            root.right = RightLeftRotate(root.right);
            return leftrightRotate(root);
        }
        return root;
    }

}
