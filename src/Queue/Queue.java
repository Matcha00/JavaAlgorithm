package Queue;

import javax.xml.soap.Node;

/**
 * Created by apple on 2018/5/3.
 */
public class Queue<Item> {

    private Node first;
    private Node last;
    int N = 0;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 入列
    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        N++;
    }

    // 出列

    public  Item dequeue() {
        if (isEmpty()) return null;

        Node node = first;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return node.item;
    }
    public static void main(String[] args){
        Queue<String> test = new Queue<String>();
        test.enqueue("a");
        test.enqueue("b");
        int len = test.size();
        for (int i = 0; i < len; i++) {
            System.out.println("dequeue--->" + test.dequeue());
        }
    }

}
