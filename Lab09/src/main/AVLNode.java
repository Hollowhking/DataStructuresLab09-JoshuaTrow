package main;


public class AVLNode {
    public AVLNode left = null;
    public AVLNode right = null;
    public int value = 0;
    public AVLNode parent = null;

    public AVLNode insert(int newValue) {
        // perform binary-search style insertion
        if (newValue < this.value) {
            // insert the value to the left sub-tree
            if (this.left == null) {
                AVLNode newNode = new AVLNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.left = newNode;
            } else {
                this.left.insert(newValue);
            }
        } else {
            // insert the value into the right sub-tree
            if (this.right == null) {
                AVLNode newNode = new AVLNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.right = newNode;
            } else {
                this.right.insert(newValue);
            }
        }

        return rebalance();
    }
//------------------------
    public AVLNode rebalance() {
		//2 possibilities <= -2 left rotation , >= +2 right rotation 
    	/*
    		
    	
    	
    	
    	
    	
    	*/
        // YOUR CODE GOES HERE:
    	int balancing = this.getBalance();
    	AVLNode newparent = null;
    	AVLNode X = null;
    	AVLNode Y = null;
    	
    	if (balancing <= -2) {
    		//check for left right or left left rotation 
    		if (this.left.right != null) {
    			System.out.println("LEFT RIGHT ROTATION");
    			newparent = this.left.right;
    			//reference children
    			X = newparent.left;
    			Y = newparent.right;
    			//Shift nodes
    			newparent.right = this;
    			newparent.left = this.left;
    			//shift parent reference
    			this.left.right = X;
    			this.left = Y;
    		}
    		else {//LEFT LEFT ROTATION
    			System.out.println("LEFT LEFT ROTATION");
    			newparent = this.left;
    			//reference children 
    			X = newparent.left.right;
    			Y = newparent.right;
    			//rearrange 
    			newparent.right = this;
    			this.parent = newparent;
    			//assign children:
    			newparent.left.right = X;
    			this.left = Y;
    		}
    	}
    	else if (balancing >= 2) {
    		if (this.right.left != null) {//RIGHT LEFT ROTATION 
    			System.out.println("RIGHT LEFT ROTATION");
    			newparent = this.right.left;
    			X = newparent.left;
    			Y = newparent.right;
    			//SHIFT NODES 
    			newparent.left = this;
    			newparent.right = this.right;
    			//shift parent refs 
    			this.right.parent = newparent;
    			this.parent = newparent;
    			//pass children: 
    			this.right.left = Y;
    			this.right = X;
    		}
    		else {
    			System.out.println("RIGHT RIGHT ROTATION");
    			newparent = this.right;
    			//ref chidlren:
    			X = newparent.right.left;
    			Y = newparent.left;
    			//rearange nodes
    			newparent.left = this;
    			this.parent = newparent;
    			//assign children:
    			newparent.right.left = X;
    			this.right = Y;
    		}
    	}
    	return newparent;
    }
//---------------------------

    public int getBalance() {
        int rightHeight = 0;
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }

        int leftHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }

        return rightHeight - leftHeight;
    }

    public int getHeight() {
        int leftHeight = 1;
        if (left != null) {
            leftHeight = left.getHeight() + 1;
        }

        int rightHeight = 0;
        if (right != null) {
            rightHeight = right.getHeight() + 1;
        }

        return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }

    public String nodeToString(int depth) {
        String result = "";

        if (this.right != null) {
            result += this.right.nodeToString(depth + 1);
        }

        for (int i = 0; i < depth; i++) {
            result += "\t";
        }
        result += this.value + "\n";

        if (this.left != null) {
            result += this.left.nodeToString(depth + 1);
        }

        return result;
    }
}