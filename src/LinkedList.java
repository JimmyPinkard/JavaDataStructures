public class LinkedList<Type> implements List<Type>
{
    private Type data;
    private LinkedList<Type> next;
    private int size;
    public LinkedList()
    {
        this.data = null;
        this.next = null;
        size = 0;
    }

    public LinkedList(Type[] array)
    {
        this.data = null;
        this.next = null;
        size = 0;
        fromArray(array);
    }

    @Override
    public void add(Type data)
    {
        if(this.data == null)
        {
            ++size;
            this.data = data;
            return;
        }
        LinkedList<Type> tail = getNode(size - 1);
        LinkedList<Type> next = new LinkedList<>();
        tail.next = next;
        next.data = data;
        next.next = null;
        ++size;
    }

    @Override
    public Type remove(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<Type> prev = getNode(index - 1);
        LinkedList<Type> next = prev.next.next;
        Type removed = prev.next.data;
        --size;
        if(next == null)
        {
            prev.next = null;
            return removed;
        }
        prev.next = next;
        return removed;
    }

    @Override
    public Type get(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    @Override
    public void set(final int index, Type data)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<Type> current = getNode(index);
        current.data = data;
    }

    public Type peek()
    {
        if(data == null)
        {
            throw new NullPointerException();
        }
        return data;
    }

    public Type next()
    {
        Type data = next.data;
        if(data == null)
        {
            throw new NullPointerException();
        }
        return data;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public Type[] toArray()
    {
        Type[] arr = (Type[]) new Object[size];
        LinkedList<Type> current = this;
        for(int i = 0; i < size; ++i)
        {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    public LinkedList<Type> fromArray(final Type[] arr)
    {
        LinkedList<Type> list = new LinkedList<>();
        for(Type data : arr)
        {
            list.add(data);
        }
        return list;
    }

    @Override
    public void destroy()
    {
        next = null;
        data = null;
        size = 0;
    }

    @Override
    public String toString()
    {
        StringBuilder contents = new StringBuilder("[");
        for(int i = 0; i < size - 1; ++i)
        {
            contents.append(getNode(i)).append(", ");
        }
        contents.append(getNode(size - 1)).append("]");
        return contents.toString();
    }

    //Utility functions
    //Go to the Nth list of the list
    public LinkedList<Type> getNode(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        LinkedList<Type> current = this;
        for(int i = 0; i < index; ++i)
        {
            current = current.next;
        }
        return current;
    }

    //Checks if an index is in bounds
    @Override
    public boolean isOutOfBounds(int index)
    {
        return index > size || index < 0;
    }
}