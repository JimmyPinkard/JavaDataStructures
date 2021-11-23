public class ArrayList<Type> implements List<Type>
{
    private Type[] arr;
    private int size;
    public ArrayList()
    {
        size = 0;
        arr = null;
    }
    @Override
    public void add(final Type data)
    {
        if(arr != null)
        {
            final Type[] temp = (Type[]) new Object[size];
            Array.arrayCopy(temp, arr);
            arr = (Type[]) new Object[++size];
            Array.arrayCopy(arr, temp);
            arr[size - 1] = data;
            return;
        }
        arr = (Type[]) new Object[++size];
        arr[0] = data;
    }

    public void addAll(final Type[] inputs)
    {
        if(inputs == null)
        {
            return;
        }
        size += inputs.length;
        if(inputs.length == 0)
        {
            return;
        }
        if(arr == null)
        {
            arr = (Type[]) new Object[size];
            Array.arrayCopy(arr, inputs);
            return;
        }
        arr = Array.arrayCombo(arr, inputs);
    }

    @Override
    public Type remove(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        final Type data = arr[index];
        for(int i = index; i < size - 1; ++i)
        {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        Type[] copy = (Type[]) new Object[size];
        Array.arrayCopy(copy, arr);
        arr = copy;
        return data;
    }

    @Override
    public Type get(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public void set(final int index, final Type data)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = data;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Type[] toArray()
    {
        Type[] copy = (Type[]) new Object[size];
        for(int i = 0; i < size; ++i)
        {
            copy[i] = arr[i];
        }
        return arr;
    }

    @Override
    public void destroy()
    {
        arr = null;
        size = -1;
    }

    @Override
    public boolean isOutOfBounds(final int index)
    {
        return index < 0 && index >= size;
    }
    @Override
    public String toString()
    {
        return Array.toString(arr);
    }
}