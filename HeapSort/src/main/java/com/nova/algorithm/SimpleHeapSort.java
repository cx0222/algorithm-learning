package com.nova.algorithm;

public class SimpleHeapSort {
    /**
     * @param array 待排序的数组
     * @param i     需要交换的第一个元素对应的下标 i
     * @param j     需要交换的第二个元素对应的下标 j
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * @param i 需要调整的节点的索引
     */
    private static void heapify(int[] array, int size, int i) {
        while (true) {
            int left = (i << 1) + 1, right = (i << 1) + 2, largest = i;
            if (left < size && array[left] > array[largest]) {
                largest = left;
            }
            if (right < size && array[right] > array[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(array, i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    /**
     * 对数组进行堆排序
     */
    public static void heapSort(int[] array) {
        int size = array.length;
        if (size == 1) {
            return;
        }
        int index = (size - 2) >> 1;
        while (index >= 0) {
            heapify(array, size, index--);
        }
        index = size - 1;
        while (index >= 0) {
            swap(array, index, 0);
            heapify(array, index, 0);
            --index;
        }
    }
}
