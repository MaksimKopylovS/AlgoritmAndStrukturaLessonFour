package max_sk.deque;

public interface Deque<T> {
    public void addFirst(T value);
    public void addLast(T value);
    public T showFirst();
    public T showLast();
    public T getFirstElement();
    public T getLastElement();
}
