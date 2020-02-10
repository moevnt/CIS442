package Classwork;

//import sun.invoke.empty.Empty;

public class BinaryTree <AnyType>{
    private BinaryNode<AnyType> root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(AnyType root){
        this.root = new BinaryNode<AnyType>(root, null, null);
    }

    public BinaryNode<AnyType> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<AnyType> root) {
        this.root = root;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void match(AnyType x, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2){
        root = new BinaryNode(x,t1.root,t2.root);

        if(this != t1)
            t1 = null;
        if(this != t2)
            t2 = null;
    }

    public int size(){
        return BinaryNode.getSize(root);
    }
}
