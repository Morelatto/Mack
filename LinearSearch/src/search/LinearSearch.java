package search;

import java.lang.Math;

public class LinearSearch {

    public static int[] generateVector(int vectorSize) {
        int vector[] = new int[vectorSize];
        for (int index = 0; index < vector.length; index++) {
            vector[index] = getN(100);
        }
        printVector(vector);
        return vector;
    }

    public static void printVector(int[] vector) {
        for (int index : vector) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    public static boolean search(int[] vector, int element) {
        System.out.println(element);
        for (int index : vector) {
            if (index == element) {
                return true;
            }
        }
        return false;
    }

    private static int getN(int x) {
        return (int) (Math.random() * x);
    }

    public static void main(String[] args) {
        System.out.println(search(generateVector(getN(50)), getN(100)));
    }

}
