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
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 */
public class ArrayMedian {

    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        findMedian(nums1,nums2);
    }
    // 1. Merge 2 arrays
    // 2. if the length of new array is odd median is arr[length/2]
    // 3. else median is (arr[length-1/2]+arr[length/2)/2
    private static void findMedian(int[] nums1,int[] nums2){
        int totalLength = nums1.length+nums2.length;
        int[] mergedArr = new int[totalLength];
        int k = 0;
        int m = 0;
        int n = 0;
        while(m < nums1.length && n < nums2.length){
            if(nums1[m]<nums2[n]){
                mergedArr[k]= nums1[m];
                m++;
            }else{
                mergedArr[k] =nums2[n];
                n++;
            }
            k++;
        }
        while(m< nums1.length){
            mergedArr[k]= nums1[m];
            m++;
            k++;
        }

        while(n< nums2.length){
            mergedArr[k]= nums2[n];
            n++;
            k++;
        }

        for(int number:mergedArr){
            System.out.print(number+" ");
        }
        System.out.println();
        double median;
        if(mergedArr.length%2==0){
            median = (double)(mergedArr[(mergedArr.length-1)/2] + mergedArr[mergedArr.length/2])/2.0;

        }else{
            median = mergedArr[mergedArr.length/2];
        }
        System.out.println(median);
    }
}
