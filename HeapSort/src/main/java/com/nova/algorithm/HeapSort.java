package com.nova.algorithm;

import java.util.Comparator;

public class HeapSort {
    private static int size;

    /**
     * @param i 完全二叉树中的某个节点（根节点除外）的索引
     * @return 返回该节点的父节点的索引
     */
    private static int getFather(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("i < 1, which is an illegal index.");
        }
        return (i - 1) >> 1;
    }

    /**
     * @param i 完全二叉树中的某个节点的索引
     * @return 返回该节点的左子节点的索引
     */
    private static int getLeftChild(int i) {
        return (i << 1) + 1;
    }

    /**
     * @param i 完全二叉树中的某个节点的索引
     * @return 返回该节点的右子节点的索引
     */
    private static int getRightChild(int i) {
        return (i << 1) + 2;
    }

    /**
     * @param array 待排序的数组
     * @param i     需要交换的第一个元素对应的下标 i
     * @param j     需要交换的第二个元素对应的下标 j
     */
    private static <T> void swap(T[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IllegalArgumentException("i < 0 || j < 0 || i >= size || j >= size, which is an illegal index.");
        }
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * @param i 需要调整的节点的索引
     */
    private static <T> void heapify(T[] array, int size, int i, Comparator<T> c) {
        if (i < 0) {
            throw new IllegalArgumentException("i < 0, which is an illegal index.");
        }
        while (true) {
            int left = getLeftChild(i), right = getRightChild(i), largest = i;
            if (left < size && c.compare(array[left], array[largest]) > 0) {
                largest = left;
            }
            if (right < size && c.compare(array[right], array[largest]) > 0) {
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
     * 构建堆
     */
    private static <T> void buildHeap(T[] array, Comparator<T> c) {
        int last = getFather(size - 1);
        while (last >= 0) {
            heapify(array, size, last--, c);
        }
    }

    /**
     * 对数组进行堆排序
     */
    public static <T> void heapSort(T[] array, Comparator<T> c) {
        size = array.length;
        if (size == 1) {
            return;
        }
        buildHeap(array, c);
        int index = size - 1;
        while (index >= 0) {
            swap(array, index, 0);
            heapify(array, index, 0, c);
            --index;
        }
    }
}
