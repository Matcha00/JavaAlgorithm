package Stack;

import java.util.Iterator;

/**
 * Created by apple on 2018/5/2.
 */
public class ResizeArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public void push(Item item) { //添加到Stack
        System.out.println("brfore-->"+ a.length);
        if (N >= a.length) { // 判断索引是否超出数组长度，超出数组长度翻倍
            resize(2 * a.length);
        }
        System.out.println("after-->"+ a.length);
        System.out.println("brfore->"+ N);
        a[N++] = item;
        System.out.println("after->"+ N);
    }

    public  Item pop() { // 出栈
        System.out.println("brfore pop->"+ N);
        Item item = a[--N];
        if (N <=a.length / 4) { // 缩小数组长度
            resize(a.length / 2);
        }
        System.out.println("after pop->"+ N);
        return item;
    }

    public int size() { // 返回栈长度
        return a.length;
    }


    private void resize(int size) { //调整长度
        Item[] temp = (Item[]) new Object[size];

        for (int i = 0; i < N; i++ ) {
            temp[i] = a[i];
        }

        a = temp;
    }

    public boolean isEmpty() { // 判断栈是否有值
        return N == 0;
    }





    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args){

        ResizeArrayStack<String> test = new ResizeArrayStack<>();
        test.push("a");
        test.push("b");
        int length = test.size();

        for (int i = 0;i < length; i++) {
            System.out.println("pop->" + test.pop());
        }
    }



}

