package trees;

public class AVLTree
{
    private int data;
    private AVLTree left;
    private AVLTree right;
    private AVLTree parent;

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
    public double data()
    {
        return data;
    }
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
        //Root node
        if(isRoot())
        {
            this.data = data;
            return this;
        }
        AVLTree tree = searchAdd(data);
        if(goRight(data, tree))
        {
            tree = tree.balance();
            tree.right = new AVLTree(data, null, null, tree);
        }
        else
        {
            tree.left = new AVLTree(data, null, null, tree);
            tree = tree.balance();
        }
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

    //Might delete
    public AVLTree getParent(final AVLTree child)
    {
        if(goRight(child.data, this) && right.data == child.data)
        {
            return this;
        }
        else if(!goRight(child.data, this) && left.data == child.data)
        {
            return this;
        }
        //it's the root
        if(data == child.data)
        {
            return null;
        }
        else if(goRight(child.data, this))
        {
            return right.getParent(child);
        }
        return left.getParent(child);
    }

    public void inOrder(final AVLTree node)
    {
        inOrder(node, true);
    }

    public void inOrder(final AVLTree node, final boolean forward)
    {
        if(forward)
        {
            if(node == null)
            {
                return;
            }
            inOrder(node.left, true);
            System.out.println(node.data);
            inOrder(node.right, true);
            return;
        }
        if(node == null)
        {
            return;
        }
        inOrder(node.right, false);
        System.out.println(node.data);
        inOrder(node.left, false);
    }

    public void destroy()
    {
        left = null;
        right = null;
        data = 0;
    }

    public AVLTree balance()
    {
        int factor = balanceFactor(this);
        System.out.println(factor);
        AVLTree tree = this;
        if(factor > 1)
        {
            tree = rightRotation();
        }
        else if(factor < -1)
        {
            tree = leftRotation();
        }
        return tree;
    }

    public int balanceFactor(AVLTree tree)
    {
        if(tree == null)// || (tree.left == null && tree.right == null))
        {
            return 0;
        }
        int leftHeight = balanceFactor(tree.left);
        if (leftHeight == -1)
        {
            return -1;
        }
        int rightHeight = balanceFactor(tree.right);
        if(rightHeight == -1)
        {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Utility function for right rotation
    public AVLTree rightRotation()
    {
        if(this.left == null)
        {
            return this;
        }
        final AVLTree newRoot = this.left;
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

    //Utility function to check if it's a leaf node
    private boolean isLeaf()
    {
        return left == null && right == null;
    }

    private boolean isRoot()
    {
        return this.parent == null && this.left == null && this.right == null && this.data == 0;
    }
}
