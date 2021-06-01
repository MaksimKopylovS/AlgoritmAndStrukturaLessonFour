package max_sk.deque;

public class DequeImpl<T> implements Deque<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public DequeImpl(){
        firstNode = new Node<T>(null, null, null);
        lastNode = new Node<T>(null, null, null);
        firstNode.setNextElement(lastNode);
        lastNode.setPrevElement(firstNode);
    }

    @Override
    public void addFirst(T data){
        Node<T> next = firstNode;
        next.setCurrentElement(data);
        firstNode = new Node<T>(null, null,next );
        next.setPrevElement(firstNode);
        size++;
    }

    @Override
    public void addLast(T data){
        Node<T> pred = lastNode;
        pred.setCurrentElement(data);
        lastNode = new Node<T>(null, pred, null );
        pred.setNextElement(lastNode);
        size++;
    }

    @Override
    public T showFirst(){
        return firstNode.getNextElement().getCurrentElement();
    }

    @Override
    public T showLast(){
        return lastNode.prevElement.currentElement;
    }

    @Override
    public T getFirstElement() {
        Node<T> first = firstNode.getNextElement();
        firstNode = firstNode.getNextElement();
        size--;
        return first.getCurrentElement();
    }

    @Override
    public T getLastElement() {
        Node<T> last = lastNode.getPrevElement();
        lastNode = lastNode.getPrevElement();
        size--;
        return last.getCurrentElement();
    }

    public int getSize(){
        return size;
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

    public static void main(String[] args) {
        DequeImpl<String> deque = new DequeImpl<String>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.addLast("D");
        deque.addLast("F");

        System.out.println("Первый: " + deque.showFirst() + " Последний: " + deque.showLast());
        System.out.println(deque.getSize());
        System.out.println(deque.getFirstElement());
        System.out.println("Первый: " + deque.showFirst() + " Последний: " + deque.showLast());
        System.out.println(deque.getSize());
        System.out.println(deque.getLastElement());
        System.out.println("Первый: " + deque.showFirst() + " Последний: " + deque.showLast());
        System.out.println(deque.getSize());
    }

}
