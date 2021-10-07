public class CircularlyLinkedList<Type> implements List<Type>
{
    private Type data;
    private CircularlyLinkedList<Type> head;
    private CircularlyLinkedList<Type> next;
    private int size;
    public CircularlyLinkedList()
    {
        this.data = null;
        this.head = this;
        this.next = null;
        size = 0;
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
        CircularlyLinkedList<Type> tail = getNode(size - 1);
        CircularlyLinkedList<Type> next = new CircularlyLinkedList<>();
        tail.next = next;
        next.data = data;
        next.next = null;
        next.head = tail.head;
        ++size;
    }

    @Override
    public Type remove(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        CircularlyLinkedList<Type> prev = getNode(index - 1);
        CircularlyLinkedList<Type> next = prev.next.next;
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
        CircularlyLinkedList<Type> current = getNode(index);
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

    public Type head()
    {
        Type data = head.data;
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
        CircularlyLinkedList<Type> current = this;
        for(int i = 0; i < size; ++i)
        {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public String toString()
    {
        StringBuilder contents = new StringBuilder("[");
        for(int i = 0; i < size - 1; ++i)
        {
            contents.append(get(i)).append(", ");
        }
        contents.append(get(size - 1)).append("]");
        return contents.toString();
    }

    //Utility functions
    //Go to the Nth list of the list
    public CircularlyLinkedList<Type> getNode(final int index)
    {
        if(isOutOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        CircularlyLinkedList<Type> current = this;
        for(int i = 0; i < index; ++i)
        {
            current = current.next;
        }
        return current;
    }

    @Override
    public void destroy()
    {
        data = null;
        next = null;
        head = null;
        size = 0;
    }

    //Checks if an index is in bounds
    @Override
    public boolean isOutOfBounds(int index)
    {
        return index > size || index < 0;
    }
}
