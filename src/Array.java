public class Array
{
    public static String toString(final Object[] arr)
    {
        if(arr == null)
        {
            return null;
        }
        int length = arr.length;
        StringBuilder contents = new StringBuilder("[");
        for(int i = 0; i < length - 1; ++i)
        {
            contents.append(arr[i]).append(", ");
        }
        contents.append(arr[length - 1]).append("]");
        return contents.toString();
    }
    public static void printArray(final Object[] arr)
    {
        if(arr == null)
        {
            return;
        }
        System.out.println(Array.toString(arr));
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
    public static <Type> Type[] arrayCombo(final Type[] first, final Type[] second)
    {
        final int length = second.length + first.length;
        Type[] arr = (Type[]) new Object[length];
        int j = 0;
        for(int i = 0; i < first.length; ++i)
        {
            if(first[i] == null)
            {
                continue;
            }
            arr[j++] = first[i];
        }
        for(int i = 0; i < second.length; ++i)
        {
            if(second[i] == null)
            {
                continue;
            }
            arr[j++] = second[i];
        }
        if(j < length)
        {
            var temp = (Type[]) new Object[j];
            Array.arrayCopy(temp, arr);
            arr = (Type[]) new Object[j];
            Array.arrayCopy(arr, temp);
        }
        return arr;
    }
}