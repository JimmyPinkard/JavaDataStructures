//I'm using ints because it should work for most numeric types
public class BinarySearchTree
{
    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;
    public BinarySearchTree()
    {
        data = 0;
        left = null;
        right = null;
    }
    public BinarySearchTree(final int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    public BinarySearchTree(final Integer[] arr)
    {
        addAll(arr);
    }
    public BinarySearchTree(final int data, final BinarySearchTree left, final BinarySearchTree right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public BinarySearchTree(final BinarySearchTree tree)
    {
        this.data = tree.data;
        this.left = tree.left;
        this.right = tree.right;
    }
    public int data()
    {
        return data;
    }
    public BinarySearchTree get(final int value)
    {
        BinarySearchTree tree;
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

    public BinarySearchTree searchAdd(final int value)
    {
        BinarySearchTree tree;
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

    public void add(final int data)
    {
        if(this.isLeaf() && this.data == 0)
        {
            this.data = data;
            return;
        }
        BinarySearchTree tree = searchAdd(data);
        //Node exists already
        if(data == tree.data)
        {
            System.out.printf("Node %d already exists\n", tree.data);
            return;
        }
        if(goRight(data, tree))
        {
            tree.right = new BinarySearchTree(data);
            return;
        }
        tree.left = new BinarySearchTree(data);
    }

    public void addAll(final int[] nums)
    {
        for(final int num : nums)
        {
            add(num);
        }
    }
    public void addAll(final Integer[] nums)
    {
        if(nums == null)
        {
            return;
        }
        for(final Integer num : nums)
        {
            add(num);
        }
    }

    public BinarySearchTree getParent(final BinarySearchTree child)
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

    public void inOrder(final BinarySearchTree node)
    {
        inOrder(node, true);
    }

    public void inOrder(final BinarySearchTree node, final boolean forward)
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

    //Private methods

    //Utility function determining whether to go right
    private boolean goRight(final double value, final BinarySearchTree tree)
    {
        return value > tree.data;
    }

    private boolean isRightChild(final BinarySearchTree parent, final BinarySearchTree child)
    {
        //Pointer specific that's why I'm not using .equals()
        return parent.right == child;
    }

    private boolean isLeftChild(final BinarySearchTree parent, final BinarySearchTree child)
    {
        //Pointer specific that's why I'm not using .equals()
        return parent.right == child;
    }

    //Utility function to check if it's a leaf node
    private boolean isLeaf()
    {
        return left == null && right == null;
    }
}