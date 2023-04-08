package com.nova.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SimpleHeapSortTest {
    /**
     * 基于 junit 框架的单元测试 - 共包含 3 个案例
     */
    @Test
    void heapSort() {
        // 测试案例 1
        int[] array = new int[]{3, 4, 1, 2};
        SimpleHeapSort.heapSort(array);
        assertArrayEquals(new int[]{
                1, 2, 3, 4
        }, array);
        System.out.println(Arrays.toString(array));

        // 测试案例 2
        array = new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        SimpleHeapSort.heapSort(array);
        assertArrayEquals(new int[]{
                -7, -5, -4, -1, -1, 0, 0, 4, 7, 9
        }, array);
        System.out.println(Arrays.toString(array));

        // 测试案例 3
        array = new int[]{Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        SimpleHeapSort.heapSort(array);
        assertArrayEquals(new int[]{
                -2147483648, 0, 2147483647
        }, array);
        System.out.println(Arrays.toString(array));
    }
}
