package myutils;

import java.util.Arrays;

public class MyIntegerArrayList {

    private int[] elements;
    private int size;

    public MyIntegerArrayList(int n) {
        if (n > 0) {
            this.elements = new int[n];
            size = 0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void ensureCapacity(int newCapacity) {
        int curr = elements.length;
        if (newCapacity > curr) {
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void rangeCheck(int requestIndex) {
        if (requestIndex < 0 || requestIndex > size)
            throw new IndexOutOfBoundsException();
    }

    public void add(int index, int element) {
        this.rangeCheck(index);
        if (size == elements.length) {
            ensureCapacity(elements.length * 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1,
                size - index);

        elements[index] = element;
        size++;
    }

    public void add(int element) {
        this.add(size, element);
    }

    public int remove(int index) {
        rangeCheck(index);
        int oldElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size] = 0;
        size--;
        return oldElement;
    }

    public boolean removeByValue(int element) {
        boolean index = false;
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                index = true;
                this.remove(i);
            }
        }
        return index;
    }

    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public void set(int index, int value) {
        rangeCheck(index);
        elements[index] = value;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        System.arraycopy(elements, 0, arr, 0, size);
        return arr;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        MyIntegerArrayList list = new MyIntegerArrayList(1);
        for (int i = 0; i < 10; i++)
            list.add(i);
        list.add(5,100);
        System.out.println(list.size());
        System.out.println(list.get(5));
        list.remove(5);
        System.out.println(Arrays.toString(list.toArray()));
    }
}