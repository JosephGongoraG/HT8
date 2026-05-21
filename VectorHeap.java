import java.util.ArrayList;

/**
 * Implementation of a Priority Queue using a MinHeap.
 * Elements use Comparable so they can be ordered according to their priority.
 * The smallest element according to compareTo() will always be the root of the heap.
 */
public class VectorHeap<E extends Comparable<E>>
        implements PriorityQueue<E> {

    /**
     * Internal storage for heap elements.
     */
    private ArrayList<E> data;

    /**
     * Constructs an empty VectorHeap.
     */
    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Inserts a new element to the end of the heap, then moves it up until it's a min heap.
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Removes and returns the element with the highest priority.
     * The root element is removed, the last element replaces the root, and the heap property is
     * restored by moving the element downward.
     */
    @Override
    public E remove() {

        if (isEmpty()) {
            return null;
        }

        E minVal = data.get(0);

        E lastVal = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, lastVal);
            percolateDown(0);
        }

        return minVal;
    }

    /**
     * Says whether the heap is empty.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Returns the number of elements in the heap.
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Moves an element up in the heap until it's a min heap.
     */
    private void percolateUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) < 0) {

                swap(index, parent);

                index = parent;

            } else {
                break;
            }
        }
    }

    /**
     * Moves an element down in the heap until it's a min heap.
     */
    private void percolateDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int smallest = index;

            if (left < data.size() &&
                    data.get(left).compareTo(data.get(smallest)) < 0) {

                smallest = left;
            }

            if (right < data.size() &&
                    data.get(right).compareTo(data.get(smallest)) < 0) {

                smallest = right;
            }

            if (smallest != index) {

                swap(index, smallest);

                index = smallest;

            } else {
                break;
            }
        }
    }

    /**
     * Swaps two elements inside the heap.
     */
    private void swap(int i, int j) {

        E temp = data.get(i);

        data.set(i, data.get(j));

        data.set(j, temp);
    }
}