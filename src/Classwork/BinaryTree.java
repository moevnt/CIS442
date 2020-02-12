package Classwork;

//import sun.invoke.empty.Empty;
import java.util.Comparator;
public class BinaryTree <AnyType extends Comparable<AnyType>>{
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

	public int sameNodes(BinaryNode t){
		int count = 0;
		for (int i=0;i<size();i++){
			if(t.left != null && t.right != null)
				if(t.left.element == t.right.element)
					count++;
		}
		return count;
	}

	public int longestPatternWithRoot(BinaryNode t){
		int count = 0;
		return longestPatternWithRoot(t,count);
	}

	private int longestPatternWithRoot(BinaryNode t, int count){
		int element = (int) t.element;
		int left=0, right=0;

		if(t.left != null)
			 left = (int) t.left.element;
		if(t.right != null)
			right = (int) t.right.element;
		if (right<element && left<element) {
			System.out.println(element);
			return ++count;
		}
		else if(right>element && left>element){
			longestPatternWithRoot(t.left,++count);
			return longestPatternWithRoot(t.right,count);
		}
		else if (right>element)
			return longestPatternWithRoot(t.right,++count);
		else {
			System.out.println(element);
			return longestPatternWithRoot(t.left, ++count);
		}
	}
	public int longestPattern(BinaryNode t){
		int count = 0;
		/*
		while(node has children)
			Look at given node
			compare to children
			if(children > node)
				follow node and increase count if the current length is greater than count and increase reference node
			if(children < node)
				follow node and increase reference node
		 */
		return count;
	}

	public static void main(String[] args){
		BinaryTree tree = new BinaryTree<>();

		root = new BinaryNode(21);

	//	tree.insert(20,root);
		tree.insert(22,root);
		tree.insert(23,root);
		tree.insert(24,root);
		tree.insert(25,root);

//		for (int i=0;i<10;i--){
//			//int insert = (int) (Math.random()*100);
//			tree.insert(i+22,root);
//		}
		System.out.println(root.toString());
		System.out.println("Sum: "+tree.sum(root));
		System.out.println("number of even: "+tree.evenItems(root));
		System.out.println("Number of same: "+tree.sameNodes(root));
		System.out.println("Length: " + tree.longestPattern(root));
	}
}
