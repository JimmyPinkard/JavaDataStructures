import java.util.Arrays;

public class Tests
{
    public static void main(final String[] args)
    {
        /*
        testSingleLinkedList();
        testDoublyLinkedList();
        testCircularlyLinkedList();
         */
    }
    public static void testSingleLinkedList()
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
        System.out.println(Arrays.toString(nums.toArray()));
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
}
