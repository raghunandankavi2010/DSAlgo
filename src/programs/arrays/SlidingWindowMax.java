/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.arrays;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Given an array of integers A. There is a sliding window of size B which
 * is moving from the very left of the array to the very right.
 * You can only see the w numbers in the window. Each time the sliding window moves
 * rightwards by one position. You have to find the maximum for each window.
 * The following example will give you more clarity.
 * <p>
 * The array A is [1 3 -1 -3 5 3 6 7], and B is 3.
 * This is similar to sliding window finding the median problem.
 */
public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        Comparator<Integer> comparator = (a, b) -> arr[a] != arr[b]
                ? Integer.compare(arr[a], arr[b])
                : a - b;
        TreeSet<Integer> smalls = new TreeSet<>(comparator);
        TreeSet<Integer> bigs = new TreeSet<>(comparator);
        int[] result = new int[arr.length - windowSize + 1];

        for (int i = 0; i < arr.length; i++) {
            addNum(i, smalls, bigs);
            if (i + 1 >= windowSize) {
                int start = i - windowSize + 1;
                result[start] = findMax(smalls, bigs, arr);

                if (!smalls.remove(start)) {
                    bigs.remove(start);
                }
                // rebalance if necessary
                if (smalls.size() < bigs.size()) {
                    smalls.add(bigs.pollFirst());
                }
            }
        }
        for (int num : result) {
            System.out.print(num + " ");
        }

    }

    private static int findMax(TreeSet<Integer> smalls, TreeSet<Integer> bigs, int[] nums) {
        if (smalls.isEmpty()) { // ideally should never happen
            return 0;
        } else if (smalls.size() > bigs.size()) {
            return nums[bigs.first()];
        } else {
            return nums[smalls.last()];
        }
    }

    private static void addNum(int num, TreeSet<Integer> smalls, TreeSet<Integer> bigs) {
        if (smalls.size() == bigs.size()) {
            bigs.add(num);// you need to do this for cases when array is already sorted
            smalls.add(bigs.pollFirst()); // when array is sorted this will help
        } else if (smalls.size() > bigs.size()) {
            smalls.add(num);
            bigs.add(smalls.pollLast());
        } // "smalls" will never be smaller size than "bigs"
    }
}
