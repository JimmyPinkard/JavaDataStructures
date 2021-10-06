public interface List<Type>
{
    public void add(final Type data);
    public Type remove(final int index);
    public Type get(final int index);
    public void set(final int index, final Type data);
    public int size();
    public Type[] toArray();
    public void destroy();
    public boolean isOutOfBounds(int index);
}