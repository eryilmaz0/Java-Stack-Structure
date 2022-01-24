package Base.Package.Stack;

public interface Stack<T> {
    public void clear();
    public void printStackInfo();
    public boolean pop(T value);
    public void push();
    public boolean add(int orderNumber, T value);
    public boolean replace(int orderNumber, T value);
}
