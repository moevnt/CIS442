package Classwork;

//HR: Evan Monteith, Textbook, In class notes
import java.util.Comparator;

public class BinarySearchTree<AnyType extends Comparable<AnyType>> {

	private static BinaryNode root;
	private Comparator<? super AnyType> cmp;
	private AnyType element;
	private BinaryNode<AnyType> left;
	private BinaryNode<AnyType> right;
	private int count;
	private int leafCount;
	private int fullNodeCount;

	public BinarySearchTree() {
		this(null);
	}

	public static void setRoot(BinaryNode root) {
		BinarySearchTree.root = root;
	}

	public static BinaryNode getRoot() {
		return root;
	}

	public BinarySearchTree(Comparator<? super AnyType> c) {
		root = null;
		cmp = c;
	}

	private int myCompare(AnyType lhs, AnyType rhs) {
		if (cmp != null)
			return cmp.compare(lhs, rhs);
		else
			return ((Comparable) lhs).compareTo(rhs);
	}

	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			return false;

		int compareResult = myCompare(x, t.element);

		if (compareResult < 0)
			return contains(x, t.left);
		else if (compareResult > 0)
			return contains(x, t.right);
		else
			return true;
	}

	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}

	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (t != null)
			while (t.right != null)
				t = t.right;
		return t;
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {

		if (t == null)
			return new BinaryNode<>(x, null, null);

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0)
			t.left = insert(x, t.left);
		else if (compareResult > 0)
			t.right = insert(x, t.right);
		else
			;

		return t;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {

		if (t == null)
			return t;

		int compareResult = x.compareTo(t.getElement());

		if (compareResult < 0)
			t.left = remove(x, t.left);
		else if (compareResult > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) {
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else
			t = (t.left != null) ? t.left : t.right;

		return t;
	}

	public void printRange(AnyType k1, AnyType k2, BinaryNode<AnyType> t) {

		if (t == null)
			return;

		if (t.getElement().compareTo(k1) > 0 && t.getElement().compareTo(k2) < 0) {
			System.out.println(t.getElement());
			printRange(k1, k2, t.getRight());
			printRange(k1, k2, t.getLeft());
		}
		if (t.getElement().compareTo(k1) < 0)
			printRange(k1, k2, t.getRight());
		else
			printRange(k1, k2, t.getLeft());
	}

	public boolean isSimilar(BinaryNode t1, BinaryNode t2) {

		if (t1 == null && t2 == null)
			return true;

		else if (t1 != null && t2 != null) {
			isSimilar(t1.right, t2.right);
			return isSimilar(t1.left, t2.left);
		} else
			return false;
	}


	private int countNodes(BinaryNode<AnyType> t) {

		if (t.right == null && t.left == null) { // is leaf
			count++;
			return count;
		}
		else if (t.right !=null && t.left == null) { // only right child
			count++;
			return countNodes(t.right);
		}
		else if (t.left != null && t.right == null) { // only left child
			count++;
			return countNodes(t.left);
		}
		else {  // 2 nodes
			count++;
			countNodes(t.right);
			return countNodes(t.left);
		}
	}

	public int countLeaf(BinaryNode<AnyType> t) {

		if (t.isLeaf()) {  // is leaf
			leafCount++;
			return leafCount;
		}
		else if (t.right !=null && t.left == null)  // only right child
			return countLeaf(t.right);

		else if (t.left != null && t.right == null)  // only left child
			return countLeaf(t.left);

		else {  // 2 nodes
			countLeaf(t.right);
			return countLeaf(t.left);
		}
	}

	public int countFullNodes(BinaryNode<AnyType> t){
		if (t.right != null && t.left != null) {  // is full
			fullNodeCount++;
			countFullNodes(t.left);
			return countFullNodes(t.right);
		}
		else if (t.right !=null && t.left == null)  // only right child
			return countFullNodes(t.right);

		else if (t.left != null && t.right == null)  // only left child
			return countFullNodes(t.left);

		else {  // leaf
			return fullNodeCount;
		}
	}

	public boolean searchTreeOrderProperty(BinaryNode<AnyType> t) {
		if (t.left != null && t.right != null) {
			if (t.left.element.compareTo(t.element) == 1 || t.right.element.compareTo(t.element) == -1)
				return false;
			else if (t.left.element.compareTo(t.element) == -1 || t.right.element.compareTo(t.element) == 1) {
				searchTreeOrderProperty(t.left);
				return searchTreeOrderProperty(t.right);
			}
		}
		return true;
	}

	public static void main (String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		root = new BinaryNode(3);

		bst.insert(6,root);
		bst.insert(5,root);
		bst.insert(2,root);
		bst.insert(4,root);
		bst.insert(7,root);
		bst.insert(1,root);



	/*	for(int i=0;i<10;i++){
			int temp = (int) (100*Math.random());
			bst.insert(temp, bst.getRoot());
		}
*/
		System.out.println(root.toString());
		System.out.println();
//		System.out.println("Full Nodes: "+bst.countFullNodes(root));
//		System.out.println("Count: " + bst.countNodes(root));
//		System.out.println("Leaf count: "+bst.countLeaf(root));
//		System.out.println("Min: " + bst.findMin(root));
//		System.out.println("Max: " + bst.findMax(root));
//		System.out.println("STOP: "+bst.searchTreeOrderProperty(root));

	}
}
