import trees.BinaryTree;

public class Tests
{
    public static void main(final String[] args)
    {
        /*
        testLinkedList();
        testDoublyLinkedList();
        testCircularlyLinkedList();
        binaryTreeTest();
        stackTest();
         */
    }

    public static void testLinkedList()
    {
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= 5; ++i)
        {
            nums.add(i);
        }
        System.out.println(nums);
        int x = nums.remove(2);
        System.out.println(x);
        System.out.println(nums);
        for(int i = 0; i < nums.size(); ++i)
        {
            nums.set(i, nums.get(i) * 2);
        }
        System.out.println(nums);
        System.out.println(Array.toString(nums.toArray()));
        nums.deleteList();
    }

    public static void testDoublyLinkedList()
    {
        DoublyLinkedList<Integer> nums = new DoublyLinkedList<>();
        for(int i = 1; i <= 5; ++i)
        {
            nums.add(i);
        }
        System.out.println(nums);
        int x = nums.remove(2);
        System.out.println(x);
        System.out.println(nums);
        for(int i = 0; i < nums.size(); ++i)
        {
            nums.set(i, nums.get(i) * 2);
        }
        System.out.println(nums);
        for(int i = nums.size() - 1; i > 0; --i)
        {
            System.out.println(nums.getNode(i).prev() * i);
        }
    }

    public static void testCircularlyLinkedList()
    {
        CircularlyLinkedList<Integer> nums = new CircularlyLinkedList<>();
        for(int i = 1; i <= 5; ++i)
        {
            nums.add(i);
        }
        System.out.println(nums);
        int x = nums.remove(2);
        System.out.println(x);
        System.out.println(nums);
        for(int i = 0; i < nums.size(); ++i)
        {
            nums.set(i, nums.get(i) * 2);
        }
        System.out.println(nums);
        System.out.println(nums.peek().equals(nums.getNode(nums.size() - 1).head()));
    }

    public static void binaryTreeTest()
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addAll(new int[]{1, 2, 3, 4, 5, 6, -1});
        System.out.println("Forwards\n");
        binaryTree.inOrder(binaryTree);
        System.out.println("\nBackwards\n");
        binaryTree.inOrder(binaryTree, false);
        System.out.println("\nGet parent\n");
        try
        {
            System.out.println(binaryTree.getParent(binaryTree.get(69)).data());
        }
        catch (NullPointerException e)
        {
            System.err.println(e);
        }
    }

    public static void stackTest()
    {
        final Stack<Integer> stack = new Stack<>(10);
        for (int i = 10; i <= 100; i += 10)
        {
            stack.push(i);
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}