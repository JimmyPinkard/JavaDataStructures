
public class DoublyLinkedList<Type>
{}
    /*
    private Type data;
    private DoublyLinkedList<Type> next;
    private DoublyLinkedList<Type> prev;
    private int size;

    public DoublyLinkedList()
    {
        this.data = null;
        this.prev = null;
        this.next = null;
        size = 0;
    }

    public void add(Type data)
    {
        if(this.data == null)
        {
            ++size;
            this.data = data;
            return;
        }
        DoublyLinkedList<Type> tail = getNode(size - 1);
        DoublyLinkedList<Type> next = new DoublyLinkedList<>();
        tail.next = next;
        next.data = data;
        next.prev = tail;
        next.next = null;
        ++size;
    }

    public Type remove(final int index) throws IndexOutOfBoundsException
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedList<Type> prev = getNode(index - 1);
        DoublyLinkedList<Type> next = prev.next.next;
        Type removed = prev.next.data;
        --size;
        if(next == null)
        {
            prev.next = null;
            return removed;
        }
        prev.next = next;
        next.prev = prev;
        return removed;
    }

    public Type get(final int index) throws IndexOutOfBoundsException
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }

    public void set(final int index, Type data) throws IndexOutOfBoundsException
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedList<Type> current = getNode(index);
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

    public Type prev()
    {
        Type data = prev.data;
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
    public Type[] toArray()
    {
        Type[] arr = (Type[]) new Object[size];
        DoublyLinkedList<Type> current = this;
        for(int i = 0; i < size; ++i)
        {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }


    //Utility functions
    //Go to the Nth list of the list
    public DoublyLinkedList<Type> getNode(final int index) throws IndexOutOfBoundsException
    {
        if(outOfBounds(index))
        {
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedList<Type> current = this;
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
*/