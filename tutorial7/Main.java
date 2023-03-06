package tutorial7;

public class Main {

    public static void main(String[] args) {
        int[] elements = { 16,
                10, 14,
                9, 7, 1, 4,
                2, 8, 3 };
        int nodes = calculateNodes(4);

        BinaryMaxHeap bmh = new BinaryMaxHeap(nodes);
        for (int i : elements) {
            bmh.insert(i);
        }

        printBinaryMaxHeap(bmh);

        System.out.println("\n\n");

        bmh.extractMax();

        printBinaryMaxHeap(bmh);

        bmh.remove(1);

        System.out.println("\n\n");

        printBinaryMaxHeap(bmh);

        System.out.println();

        System.out.println("Left child index of 0: " + bmh.leftChild(0));
        System.out.println("Right child index of 0: " + bmh.rightChild(0));

    }

    // calculates amount of space for a given tree height
    public static int calculateNodes(int height) {
        int sum = 0;
        for (int i = 0; i < height; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }

    static int PowerOf2(int power) {
        return (1 << power);
    }

    public static void printBinaryMaxHeap(BinaryMaxHeap bmh) {
        int currentLevel = 0;
        int maxPerLevel = PowerOf2(currentLevel);
        for (int i = 0; i < bmh.elements.length; i++) {
            if (i == maxPerLevel - 1) {
                System.out.println("\n");
                currentLevel++;
                maxPerLevel = PowerOf2(currentLevel);
            }
            System.out.print(" " + bmh.elements[i]);
        }
    }

}
