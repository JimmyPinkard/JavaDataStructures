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
    public static <Type> Type[] fromList(List<Type> list)
    {
        final int size = list.size();
        final Type[] arr = (Type[]) new Object[size];
        for(int i = 0; i < size; ++i)
        {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static <Type> void arrayCopy(final Type[] destination, final Type[] source)
    {
        final int length = source.length;
        int j = 0;
        for(int i = 0; i < length; ++i)
        {
            if(source[i] == null)
            {
                continue;
            }
            destination[j++] = source[i];
        }
    }
}