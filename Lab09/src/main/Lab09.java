package main;

public class Lab09 {
	public static void add(AVLTree tree, int value) {
	    tree.insert(value);
	    System.out.printf("After insert %d:\n", value);
	    System.out.print(tree);
	    System.out.println("");
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		System.out.println("Initial:");
		System.out.println(tree);

		// double rotation right
		/*
	    add(tree, 2);
		add(tree, 1);
		add(tree, 6);
		add(tree, 7);
		add(tree, 4);
		add(tree, 3);
		add(tree, 5);
		*/

	    // double rotation left:
	    add(tree, 6);
	    add(tree, 7);
	    add(tree, 2);
	    add(tree, 1);
	    add(tree, 4);
	    add(tree, 3);
	    add(tree, 5);

	    System.out.println("\n\nAnother test");
	    AVLTree tree2 = new AVLTree();
	    tree2.insert(12);
	    tree2.insert(5);
	    tree2.insert(2);
	    System.out.print(tree2);
	}
}
