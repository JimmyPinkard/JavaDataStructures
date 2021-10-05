public class Stack<Type>
{
    private int capacity;
    private Type[] arr;
    private int top;
    public Stack(final int capacity)
    {
        this.capacity = capacity;
        top = -1;
        arr = (Type[]) new Object[capacity];
    }
    public void push(Type data)
    {
        if(!isFull())
        {
            arr[++top] = data;
            return;
        }
        System.err.println("Stack is full");
    }
    public Type pop()
    {
        if(isEmpty())
        {
            throw new NullPointerException("Can't pop off something that is empty");
        }
        final Type popped = arr[top];
        arr[top--] = null;
        return popped;
    }
    public int size()
    {
        return top;
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
    public boolean isFull()
    {
        return top == capacity - 1;
    }
}
