public class LinkedList<Type>
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

    public Type remove(final int index)
    {
        if(outOfBounds(index))
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

    public Type get(final int index)
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    public void set(final int index, Type data)
    {
        if(outOfBounds(index))
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

    public int size()
    {
        return size;
    }

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
        if(outOfBounds(index))
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
    private boolean outOfBounds(int index)
    {
        return index > size || index < 0;
    }
}