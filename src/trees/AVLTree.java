package trees;

public class AVLTree
{
    private int data;
    private AVLTree left;
    private AVLTree right;
    private AVLTree parent;

    //Constructors

    public AVLTree()
    {
        data = 0;
        left = null;
        right = null;
        parent = null;
    }
    public AVLTree(final int data)
    {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
    public AVLTree(final int data, final AVLTree parent)
    {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }
    public AVLTree(final int data, final AVLTree left, final AVLTree right, final AVLTree parent)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public AVLTree(final AVLTree tree)
    {
        data = tree.data;
        left = tree.left;
        right = tree.right;
        parent = tree.parent;
    }

    //Getters and setters

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public AVLTree getLeft()
    {
        return left;
    }

    public void setLeft(AVLTree left)
    {
        this.left = left;
    }

    public AVLTree getRight()
    {
        return right;
    }

    public void setRight(AVLTree right)
    {
        this.right = right;
    }

    public AVLTree getParent()
    {
        return parent;
    }

    public void setParent(AVLTree parent)
    {
        this.parent = parent;
    }


    //Gets the node
    public AVLTree get(final int value)
    {
        AVLTree tree;
        if(value == data)
        {
            return this;
        }
        else if(goRight(value, this))
        {
            tree = right;
        }
        else
        {
            tree = left;
        }
        if(tree == null)
        {
            throw new NullPointerException("Does not exist in tree.");
        }
        return tree.get(value);
    }

    public AVLTree searchAdd(final int value)
    {
        AVLTree tree;
        if(value == data)
        {
            return this;
        }
        else if(goRight(value, this))
        {
            tree = right;
        }
        else
        {
            tree = left;
        }
        if(tree == null)
        {
            return this;
        }
        return tree.searchAdd(value);
    }

    public AVLTree add(final int data)
    {
        AVLTree tree = searchAdd(data);
        //Root node
        if(isDefault())
        {
            this.data = data;
            return this;
        }
        //Node exists already
        if(data == tree.data)
        {
            System.out.printf("Node %d already exists\n", tree.data);
            return this;
        }
        if(goRight(data, tree))
        {
            tree.right = new AVLTree(data, tree);
        }
        else
        {
            tree.left = new AVLTree(data, tree);
        }
        tree = this.balance(this);
        return tree;
    }

    public static AVLTree addAll(final int[] nums)
    {
        AVLTree tree = new AVLTree();
        for(final int num : nums)
        {
            tree = tree.add(num);
        }
        return tree;
    }

    public void inOrder(final AVLTree node)
    {
        if(node == null)
        {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void reverseOrder(final AVLTree node)
    {
        if(node == null)
        {
            return;
        }
        reverseOrder(node.right);
        System.out.println(node.data);
        reverseOrder(node.left);
    }

    //Simplicity overload
    public String toString()
    {
        return toString(this, new StringBuilder());
    }

    public String toString(final AVLTree node, final StringBuilder builder)
    {
        if(node == null)
        {
            return builder.toString();
        }
        builder.append(node.data).append("\n");
        toString(node.left, builder);
        toString(node.right, builder);
        return builder.toString();
    }

    public void destroy()
    {
        left = null;
        right = null;
        data = 0;
    }

    /*
    public AVLTree balance()
    {
        AVLTree tree = this;
        int factor = balanceFactor(tree);
        if(factor > 1)
        {
            tree = tree.rightRotation(tree.left);
        }
        else if(factor < -1)
        {
            tree = tree.leftRotation();
        }
        tree.left = tree.left.balance();
        tree.right = tree.right.balance();
        //To balance the subtrees
        //tree = tree.balance(tree);
        return tree;
    }
    */

    public AVLTree balance(AVLTree tree)
    {
        if(tree == null || tree.isLeaf())
        {
            return tree;
        }
        int factor = balanceFactor(tree);
        if(factor > 1)
        {
            tree = tree.rightRotation(tree.left);
        }
        else if(factor < -1)
        {
            tree = tree.leftRotation();
        }
        tree.left = balance(tree.left);
        tree.right = balance(tree.right);
        //To balance the subtrees
        //tree = tree.balance(tree);
        return tree;
    }

    public int balanceFactor(AVLTree node)
    {
        //Leaf node
        if(node == null)
        {
            return 0;
        }
        int leftHeight = getLeftHeight(node) - 1, rightHeight = getRightHeight(node) - 1;
        return leftHeight - rightHeight;
    }

    public int getLeftHeight(AVLTree node)
    {
        if(node == null || isLeaf())
        {
            return 0;
        }
        return getLeftHeight(node.left) + 1;
    }

    public int getRightHeight(AVLTree node)
    {
        if(node == null || isLeaf())
        {
            return 0;
        }
        return getRightHeight(node.right) + 1;
    }

    //Utility function for right rotation
    public AVLTree rightRotation(AVLTree newRoot)
    {
        if(this.left == null)
        {
            return this;
        }
        final AVLTree parent = this.parent;
        this.left.parent = newRoot;
        this.left = newRoot.right;
        newRoot.right = this;
        this.parent = newRoot;
        newRoot.parent = parent;
        if(newRoot.parent == null)
        {
            return newRoot;
        }
        if(parent.left == this)
        {
            parent.left = newRoot;
        }
        else if(parent.right == this)
        {
            parent.right = newRoot;
        }
        return newRoot;
    }

    public AVLTree leftRotation()
    {
        if(this.right == null)
        {
            return this;
        }
        final AVLTree newRoot = this.right;
        final AVLTree parent = this.parent;
        this.right = newRoot.left;
        if(newRoot.left != null)
        {
            this.right.parent = this;
        }
        newRoot.left = this;
        this.parent = newRoot;
        newRoot.parent = parent;
        if(parent == null)
        {
            return newRoot;
        }
        if(parent.left == this)
        {
            parent.left = newRoot;
        }
        else if(parent.right == this)
        {
            parent.right = newRoot;
        }
        return newRoot;
    }

    /*
    public void leftRightRotation()
    {
        leftRotation();
        rightRotation();
    }

    public void rightLeftRotation()
    {
        rightRotation();
        leftRotation();
    }
    */

    //Utility function determining whether to go right
    private boolean goRight(final double value, final AVLTree tree)
    {
        return value > tree.data;
    }

    private boolean isRightChild(final AVLTree parent, final AVLTree child)
    {
        //Pointer specific that's why I'm not using .equals()
        return parent.right == child;
    }

    private boolean isLeftChild(final AVLTree parent, final AVLTree child)
    {
        //Pointer specific that's why I'm not using .equals()
        return parent.left == child;
    }

    //Utility function to check if it's a leaf node
    private boolean isLeaf()
    {
        return this.left == null && this.right == null;
    }

    //Utility to check if it's the default root node
    private boolean isDefault()
    {
        return this.parent == null && this.left == null && this.right == null && this.data == 0;
    }

    //Utility to check if it's the root node
    private boolean isRoot()
    {
        return this.parent == null;
    }
}