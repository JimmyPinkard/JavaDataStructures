public class Tests
{

    public static void main(final String[] args)
    {
        /*
        testLinkedList();
        testDoublyLinkedList();
        testCircularlyLinkedList();
        binarySearchTreeTest();
        stackTest();
        queueTest();
        testArrayList();
        testAVLTree();
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
        nums.destroy();
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

    public static void binarySearchTreeTest()
    {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addAll(new int[]{1, 2, 3, 4, 5, 6, -1});
        System.out.println("Forwards\n");
        binaryTree.inOrder(binaryTree);
        System.out.println("\nBackwards\n");
        binaryTree.inOrder(binaryTree, false);
        System.out.println("\nGet parent\n");
        binaryTree.destroy();
    }

    public static void testAVLTree()
    {
        AVLTree avlTree = new AVLTree();
        int n = 1000, asymptote = balancedHeight(n);
        System.out.println("We should never do more than " + asymptote + " operations");
        for(int i = 1; i <= n; ++i)
        {
            avlTree = avlTree.add(i);
        }
        avlTree.inOrder(avlTree);
        //Perfectly balanced as all things should be
        if(isBalanced(avlTree, n))
        {
            System.out.println("\"Perfectly Balanced as all things should be.\"");
        }
        System.out.println("\nHeight of the tree: " + avlTree.getHeight());
        avlTree.destroy();
    }

    private static boolean isBalanced(final AVLTree tree, final int n)
    {
        for(int i = 1; i <= n; ++i)
        {
            var node = tree.get(i);
            int factor = tree.balanceFactor(node);
            //Becomes unbalanced as n->inf
            if(factor > 1 || factor < -1)
            {
                System.out.println("Unbalanced at Node: " + node.getData() + " Factor: " + node.balanceFactor(node));
                return false;
            }
        }
        return true;
    }

    //Used for calculating the asymptote
    private static double logBase(final double base, final double x)
    {
        return Math.log(x) / Math.log(base);
    }

    //Calculates the asymptote
    private static int balancedHeight(final int n)
    {
        return (int)Math.ceil(1.4405 * logBase(2, n + 2) - 1.3277);
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

    public static void queueTest()
    {
        final Queue<Integer> queue = new Queue<>(10);
        for (int i = 10; i <= 100; i += 10)
        {
            queue.enqueue(i);
        }
        while(!queue.isEmpty())
        {
            System.out.println(queue.dequeue());
        }
    }
    public static void testArrayList()
    {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= 5; ++i)
        {
            nums.add(i);
        }
        System.out.println(nums);
        nums.set(2, 69);
        System.out.println(nums.remove(2));
        System.out.println(nums.get(0) + nums.get(nums.size() - 1));
        Object[] arr = nums.toArray();
        System.out.println(Array.toString(arr));
        nums.destroy();
    }
}