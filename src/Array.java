public class Array
{
    public static <Type> String toString(Type[] arr)
    {
        int length = arr.length;
        StringBuilder contents = new StringBuilder("[");
        for(int i = 0; i < length - 1; ++i)
        {
            contents.append(arr[i]).append(", ");
        }
        contents.append(arr[length - 1]).append("]");
        return contents.toString();
    }
    public static <Type> LinkedList<Type> toLinkedList(Type[] arr)
    {
        LinkedList<Type> list = new LinkedList<>();
        for(Type data : arr)
        {
            list.add(data);
        }
        return list;
    }
}