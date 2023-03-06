package tutorial7;

public class BinaryMaxHeap {

    protected Integer[] elements;

    // example
    /**
     * - - - - - 16 - - - - -
     * - - - - / \ - - - -
     * - - - - 10 14 - - - -
     * - - - / \ / \ - - -
     * - - - 9 7 1 4 - - -
     * 
     * indices
     * - - - - - 0 - - - - -
     * - - - - / \ - - - -
     * - - - - 1 2 - - - -
     * - - - / \ / \ - - -
     * - - - 3 4 5 6 - - -
     * 
     */

    public BinaryMaxHeap(int size) {
        this.elements = new Integer[size];
    }

    // parent (i)
    Integer parent(int index) {
        // returns the index of the parent
        return (int) Math.ceil((index - 1) / 2);
    }

    // leftChild(i)
    Integer leftChild(int index) {
        // returns the index of the left child
        if (index + 1 >= elements.length) {
            return null;
        }
        return index + 1;
    }

    // rightChild(i)
    Integer rightChild(int index) {
        // returns the index of the right child
        if (index + 2 >= elements.length) {
            return null;
        }
        return index + 2;
    }

    // siftUp(i)
    void siftUp(int index) {
        // sifts up the element at index i
        // until the heap property is restored
        Integer parentIndex = parent(index);
        if (parentIndex == null) {
            // we're at the root
            return;
        }
        Integer parentValue = elements[parentIndex];
        Integer currentValue = elements[index];

        if (parentValue < currentValue) {
            // swap
            elements[parent(index)] = currentValue;
            elements[index] = parentValue;
            siftUp(parent(index));
        }
    }

    // insert(p)
    void insert(int value) {
        System.out.println("inserting " + value);
        int index = findNextEmptyLeaf();
        System.out.println("find next empty leaf: " + index);
        elements[index] = value;

        System.out.println("Starting siftup(" + index + ") of value=" + value);
        siftUp(index);
    }

    // siftDown(i)
    void siftDown(int index) {
        System.out.println("Calling siftDown(" + index + ")");
        // sifts down the element at index i
        // until the heap property is restored
        Integer leftChildIndex = leftChild(index);
        Integer rightChildIndex = rightChild(index);

        // 4 cases:
        // both null,
        // left null right non-null,
        // left non-null right null
        // both non-null

        Integer currentValue = elements[index];
        if (leftChildIndex == null && rightChildIndex == null) {
            return;
        } else if (leftChildIndex == null && rightChildIndex != null && elements[rightChildIndex] != null) {
            // sift right if needed
            Integer rightChildValue = elements[rightChildIndex];
            if (currentValue < rightChildValue) {
                // swap
                elements[rightChildIndex] = currentValue;
                elements[index] = rightChildValue;
                siftDown(rightChildIndex);
            }
        } else if (leftChildIndex != null && rightChildIndex == null && elements[leftChildIndex] != null) {
            // sift left if needed
            Integer leftChildValue = elements[leftChildIndex];
            if (currentValue < leftChildValue) {
                // swap
                elements[leftChildIndex] = currentValue;
                elements[index] = leftChildValue;
                siftDown(leftChildIndex);
            }
        } else {
            // both non-null
            if (elements[leftChildIndex] != null && elements[rightChildIndex] != null) {
                Integer leftChildValue = elements[leftChildIndex];
                Integer rightChildValue = elements[rightChildIndex];
                if (leftChildValue > rightChildValue) {
                    // swap
                    elements[leftChildIndex] = currentValue;
                    elements[index] = leftChildValue;
                    siftDown(leftChildIndex);
                } else if (leftChildValue < rightChildValue) {
                    // swap
                    elements[rightChildIndex] = currentValue;
                    elements[index] = rightChildValue;
                    siftDown(rightChildIndex);
                }
            }
        }
    }

    int findNextEmptyLeaf() {
        int i = 0;
        while (i < elements.length) {
            if (elements[i] == null) {
                return i;
            }
            i++;
        }
        return i;
    }

    // extractMax()
    int extractMax() {
        // returns the maximum element
        // and removes it from the heap
        Integer max = elements[0];
        Integer leafIndex = findNextEmptyLeaf()-1;
        elements[0] = elements[leafIndex];
        elements[leafIndex] = null;
        siftDown(0);
        return max;
    }

    // remove(i)
    void remove(int index) {
        // removes the element at index i
        elements[index] = 2000000000;
        siftUp(index);
        extractMax();
    }
}
