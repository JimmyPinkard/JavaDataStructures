public class Array
{
    public static <Type> String toString(final Type[] arr)
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
    public static <Type> List<Type> toList(final Type[] arr)
    {
        List<Type> list = new ArrayList<>();
        for(Type data : arr)
        {
            list.add(data);
        }
        return list;
    }
    public static <Type> ArrayList<Type> toArrayList(final Type[] arr)
    {
        ArrayList<Type> list = new ArrayList<>();
        for(Type data : arr)
        {
            list.add(data);
        }
        return list;
    }
    public static <Type> LinkedList<Type> toLinkedList(final Type[] arr)
    {
        LinkedList<Type> list = new LinkedList<>();
        for(Type data : arr)
        {
            list.add(data);
        }
        return list;
    }
    public static <Type> void arrayCopy(final Type[] destination, final Type[] source)
    {
        final int length = source.length;
        for(int i = 0; i < length; ++i)
        {
            if(source[i] == null)
            {
                return;
            }
            destination[i] = source[i];
        }
    }
}