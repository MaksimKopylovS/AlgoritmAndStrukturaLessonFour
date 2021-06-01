package max_sk.linked_list_iterator;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public LinkedList() {
        firstNode = new Node<T>(null, null, null);
        lastNode = new Node<T>(null, null, null);
        firstNode.setNextElement(lastNode);
        lastNode.setPrevElement(firstNode);
        size++;
        size++;
    }

    public void deletFistElement(){
        firstNode = firstNode.getNextElement();
        size--;
    }
    public void deletLastElement(){
        lastNode = lastNode.getNextElement();
        size--;
    }

    public T showLast() {
        return lastNode.getPrevElement().getCurrentElement();
    }

    public T showFirst() {
        return firstNode.getNextElement().getCurrentElement();
    }

    public void addFirst(T data) {
        Node<T> node = firstNode;
        node.setCurrentElement(data);
        node.setNextElement(firstNode.getNextElement());
        firstNode = new Node<>(null, null, node);
        node.setPrevElement(firstNode);
        size++;
    }

    public void addLast(T data) {
        Node<T> node = lastNode;
        node.setCurrentElement(data);
        node.setPrevElement(lastNode.getPrevElement());
        lastNode = new Node<>(null, node, null);
        node.setNextElement(lastNode);
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int count = 1;

            @Override
            public boolean hasNext() {
                return count < size - 1;
            }

            @Override
            public T next() {
                return getNextElementForIndex(count++);
            }
        };
    }
    public T getNextElementForIndex(int index){
        Node<T> node = firstNode;
        for (int i = 0; i < index; i++){
            node = getNextElement(node);
        }
        return node.getCurrentElement();
    }

    public Node<T> getNextElement(Node<T> current){
        return current.getNextElement();
    }

    private static class Node<T> {
        private T currentElement;
        private Node<T> nextElement;
        private Node<T> prevElement;

        public Node(T currentElement, Node<T> prevElement, Node<T> nextElement) {
            this.currentElement = currentElement;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }

        public T getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<T> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<T> prevElement) {
            this.prevElement = prevElement;
        }
    }

}
