package main;
public class AVLTree {
	private AVLNode root = null;

	public AVLTree() {
	    this.root = null;
	  }

	  public AVLTree(AVLNode root) {
	    this.root = root;
	  }

	  public void insert(int newValue) {
	    if (root == null) {
	      AVLNode newNode = new AVLNode();
	      newNode.value = newValue;
	      this.root = newNode;
	    } else {
	      AVLNode newParent = this.root.insert(newValue);
	      if (newParent != null) {
	        this.root = newParent;
	      }
	    }
	  }

	  public String toString() {
	    if (root == null) {
	      return "null\n";
	    } else {
	      return "Balance: " + this.root.getBalance() + "\n" + this.root.nodeToString(0);
	    }
	  }
	}