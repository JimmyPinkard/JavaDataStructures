package trees;

//I'm using doubles because it should work for most numeric types
public class BinaryTree
{
    private int data;
    private BinaryTree left;
    private BinaryTree right;
    public BinaryTree()
    {
        data = 0;
        left = null;
        right = null;
    }
    public BinaryTree(final int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    public double data()
    {
        return data;
    }
    public BinaryTree get(final int value)
    {
        BinaryTree tree;
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

    public BinaryTree searchAdd(final int value)
    {
        BinaryTree tree;
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
        BinaryTree tree = searchAdd(data);
        if(goRight(data, tree))
        {
            tree.right = new BinaryTree(data);
            return;
        }
        tree.left = new BinaryTree(data);
    }

    public void addAll(final int[] nums)
    {
        for(final int num : nums)
        {
            add(num);
        }
    }

    public BinaryTree getParent(final BinaryTree child)
    {
        if(goRight(child.data, this) && right.data == child.data)
        {
            return this;
        }
        else if(!goRight(child.data, this) && left.data == child.data)
        {
            return this;
        }
        else if(goRight(child.data, this))
        {
            return right.getParent(child);
        }
        return left.getParent(child);
    }

    public void inOrder(final BinaryTree node)
    {
        inOrder(node, true);
    }

    public void inOrder(final BinaryTree node, final boolean forward)
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

    public void deleteTree()
    {
        left = null;
        right = null;
        data = 0;
    }

    //Utility function determining whether to go right
    private boolean goRight(final double value, final BinaryTree tree)
    {
        return value > tree.data;
    }

    //Utility function to check if it's a leaf node
    private boolean isLeaf()
    {
        return left == null && right == null;
    }
}