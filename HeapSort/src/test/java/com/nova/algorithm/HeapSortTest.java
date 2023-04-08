package com.nova.algorithm;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {
    /**
     * 在第 3 组测试（测试案例 5 和 6）时，待排序的对象属于此类
     *
     * @param first  第一个参数，主要关键字
     * @param second 第二个参数，次要关键字
     */
    private record ImmutablePair(int first, int second) implements Comparable<ImmutablePair>, Serializable {
        @Override
        public int compareTo(ImmutablePair o) {
            if (this.first != o.first) {
                return this.first - o.first;
            } else {
                return this.second - o.second;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ImmutablePair that = (ImmutablePair) o;
            return first == that.first && second == that.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "ImmutablePair {" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    /**
     * 基于 junit 框架的单元测试 - 共包含 6 个案例
     */
    @Test
    void heapSort() {
        // 测试案例 1 和 2
        Integer[] array = new Integer[]{3, 4, 1, 2};
        HeapSort.heapSort(array, Comparator.naturalOrder());
        assertArrayEquals(new Integer[]{
                1, 2, 3, 4
        }, array);
        System.out.println(Arrays.toString(array));
        HeapSort.heapSort(array, Comparator.reverseOrder());
        assertArrayEquals(new Integer[]{
                4, 3, 2, 1
        }, array);
        System.out.println(Arrays.toString(array));

        // 测试案例 3 和 4
        array = new Integer[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        HeapSort.heapSort(array, Comparator.naturalOrder());
        assertArrayEquals(new Integer[]{
                -7, -5, -4, -1, -1, 0, 0, 4, 7, 9
        }, array);
        System.out.println(Arrays.toString(array));
        HeapSort.heapSort(array, Comparator.reverseOrder());
        assertArrayEquals(new Integer[]{
                9, 7, 4, 0, 0, -1, -1, -4, -5, -7
        }, array);
        System.out.println(Arrays.toString(array));

        // 测试案例 5 和 6
        ImmutablePair[] immutablePairs = new ImmutablePair[]{
                new ImmutablePair(1, -2),
                new ImmutablePair(2, 3),
                new ImmutablePair(-1, 2),
                new ImmutablePair(1, -1)
        };
        HeapSort.heapSort(immutablePairs, Comparator.naturalOrder());
        assertArrayEquals(new ImmutablePair[]{
                new ImmutablePair(-1, 2), new ImmutablePair(1, -2), new ImmutablePair(1, -1), new ImmutablePair(2, 3)
        }, immutablePairs);
        System.out.println(Arrays.toString(immutablePairs));
        HeapSort.heapSort(immutablePairs, Comparator.comparingInt(o -> -o.first * o.second));
        assertArrayEquals(new ImmutablePair[]{
                new ImmutablePair(2, 3), new ImmutablePair(1, -1), new ImmutablePair(1, -2), new ImmutablePair(-1, 2)
        }, immutablePairs);
        System.out.println(Arrays.toString(immutablePairs));
    }
}
