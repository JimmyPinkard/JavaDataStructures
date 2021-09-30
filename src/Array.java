public class Array<Type>
{
    private Type[] arr;
    public final int length;
    public Array(Type[] arr)
    {
        this.arr = arr;
        this.length = arr.length;
    }

    public Array(final int length)
    {
        this.length = length;
    }

    public void set(final int index, Type data)
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = data;
    }

    public void setArray(Type[] arr)
    {
        this.arr = arr;
    }

    public Type get(final int index)
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public String toString()
    {
        StringBuilder contents = new StringBuilder("[");
        for(int i = 0; i < length - 1; ++i)
        {
            contents.append(arr[i]).append(", ");
        }
        contents.append(arr[length - 1]).append("]");
        return contents.toString();
    }

    //Checks if an index is in bounds
    private boolean outOfBounds(int index)
    {
        return index > length || index < 0;
    }
}