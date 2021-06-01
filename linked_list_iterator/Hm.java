package max_sk.linked_list_iterator;

import java.util.Iterator;

public class Hm {
    public static void main(String[] args) {
        LinkedList<String> deque = new LinkedList<String>();

        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.addLast("X");
        deque.addLast("Y");
        deque.addLast("Z");

        deque.deletFistElement();
        deque.deletLastElement();

        for(String str : deque){
            System.out.println(str);
        }

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
