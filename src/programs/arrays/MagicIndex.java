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
 * Given a sorted array of distinct integers, Find the Magic index or Fixed point in the array.
 *
 * Magic Index or Fixed Point: Magic index or a Fixed point in an array is an index i in the array such that A[i] = i.
 */
public class MagicIndex {

    public static void main(String[] args){
        int[] arr = { -10, -5, 2,2, 2, 3, 4,7,9,12,13 };
        int magicIndexDuplicates = searchIndexDuplicates(arr,0,arr.length-1);
       // int magicIndex = searchIndex(arr,0,arr.length-1);
       // System.out.println(String.format("Magic Index is %d",magicIndex));
        System.out.println(String.format("Magic Index is %d",magicIndexDuplicates));
    }

    // this works if array is sorted and elements are unique
    private static int searchIndex(int[] arr, int low, int high) {
        int mid = (low+high)/2;
        if(arr[mid] == mid){
            return mid;
        }
        if(arr[mid]<mid){
            return searchIndex(arr,mid+1,high);
        }else{
            return searchIndex(arr,low,mid-1);
        }
    }

    // this works if array has duplicate elements
    private static int searchIndexDuplicates(int[] arr, int low, int high) {
        if(high<low){
            return -1;
        }
        int midIndex = (low+high)/2;
        int midValue = arr[midIndex];
        if(midValue == midIndex){ // if midIndex and value are same return midIndex
            return midIndex;
        }
        // search left part of array
        int leftIndex = Math.min(midIndex-1,midValue);
        int left = searchIndexDuplicates(arr,low,leftIndex);
        if(left>=0){
            return left;
        }
        // search right part of array
        int rightIndex = Math.max(midIndex+1,midValue);
        return searchIndexDuplicates(arr,rightIndex,high);

    }
}
