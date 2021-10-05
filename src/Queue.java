public class Queue<Type>
{
    private int index;
    private int capacity;
    private Type[] arr;

    public Queue(final int capacity)
    {
        this.capacity = capacity;
        index = -1;
        arr = (Type[]) new Object[capacity];
    }

    public void enqueue(Type data)
    {
        if(isFull())
        {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        arr[++index] = data;
    }

    public Type dequeue()
    {
        if(isEmpty())
        {
            throw new NullPointerException("Queue is empty");
        }
        final Type data = arr[0];
        for(int i = 0; i < index; ++i)
        {
            arr[i] = arr[i + 1];
        }
        --index;
        return data;
    }

    public int size()
    {
        return index;
    }

    public boolean isEmpty()
    {
        return index == -1;
    }

    public boolean isFull()
    {
        return index == capacity - 1;
    }
}
