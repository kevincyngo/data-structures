@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0;    //current length
    private int capacity = 0;   //max length

    //Initialize array with capacity
    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    //free space of entire array
    public void clear() {
        for (int i = 0; i < len; ++i) {
            arr[i] = null;
        }
        len = 0;

    }

    //add element, may need to double size
    public void add(T elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity++;
            } else {
                capacity *= 2;
            }
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; ++i) {
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    // Removes an element at the specified index in this array.
    public T removeAt(int rm_index) {
        if (rm_index >= len || rm_index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; j++, i++) {
            if (i == rm_index) j--;
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    //remove obj from array
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    //find index of obj, otherwise return -1
    public int indexOf(Object obj) {
        for (int i = 0; i < len; ++i) {
            if (obj == null) {
                if (arr[i] == null) return i;
            }
            else {
                if (obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    // Iterator is still fast but not as fast as iterative for loop
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return arr[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}