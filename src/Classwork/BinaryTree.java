package Classwork;

//import sun.invoke.empty.Empty;

public class BinaryTree <AnyType>{
	private static BinaryNode root;

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

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			return new BinaryNode<>(x, null, null);

		t.left = insert(x, t.left);
		return t;
	}

	public int size(){
		return BinaryNode.getSize(root);
	}

	public int evenItems(BinaryNode t){
		int count = 0;
		for (int i=0;i<size();i++){
			int element =(int) t.element;
			if(element%2 == 0)
				count++;
			t=t.left;
		}
		return count;
	}

	public int sum(BinaryNode t){
		int sum=0;
		for (int i=0;i<size();i++){
			sum += (int) t.element;
			t = t.left;
		}
		return sum;
	}


	public static void main(String[] args){
		BinaryTree tree = new BinaryTree<>();

		root = new BinaryNode(21);

		for (int i=0;i<10;i++){
			int insert = (int) (Math.random()*100);
			tree.insert(insert,root);
		}
		System.out.println(root.toString());
		System.out.println("Sum: "+tree.sum(root));
		System.out.println("number of even: "+tree.evenItems(root));
	}
}
