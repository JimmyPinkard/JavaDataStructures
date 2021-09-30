package trees;

//I'm using doubles because it should work for most numeric types
public class BinarySearchTree
{
    private double data;
    private BinarySearchTree left;
    private BinarySearchTree right;
    public BinarySearchTree()
    {
        data = 0;
        left = null;
        right = null;
    }
    public BinarySearchTree(final double data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    public double get(final double value)
    {
        BinarySearchTree tree;
        if(value == data)
        {
            return data;
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
            return data;
        }
        return tree.getNode(value).data;
    }
    public BinarySearchTree getNode(final double value)
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
        return tree.getNode(value);
    }

    public void add(final double data)
    {
        BinarySearchTree tree = getNode(data);
        if(goRight(data, tree))
        {
            tree.right = new BinarySearchTree(data);
            return;
        }
        tree.left = new BinarySearchTree(data);
    }

    public void addAll(final double[] nums)
    {
        for(final double num : nums)
        {
            add(num);
        }
    }

    //Utility function determining whether or not to go right
    private boolean goRight(final double value, final BinarySearchTree tree)
    {
        return value > tree.data;
    }

    //Utility function to check if it's a leaf node
    private boolean isLeaf()
    {
        return left == null && right == null;
    }
}
