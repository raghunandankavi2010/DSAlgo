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

package programs.hackerank;

import java.util.Arrays;

public class FindMedian {

    private static double findMedian(int[] arr) {
        Arrays.sort(arr);
        for (int number : arr) {
            System.out.print("" + number + " ");
        }
        int n = arr.length;
        double median;
        if (n % 2 == 0) {
            median = (double)(arr[(n-1)/2] + arr[n/2])/2.0;
        } else {
            median =  arr[n / 2];
        }

        return median;

    }

    public static void main(String[] args)  {
        int[] arr = {1,2,3,4,5,6};
        double result = findMedian(arr);
        double avg  = findAvg(arr);
        System.out.println("Median is :" + result);
        System.out.println("Avg is :" + avg);

    }

    private static double findAvg(int[] arr) {
        double sum=0;
        int n = arr.length;
        for (int number : arr) {
            sum += number;
        }
        return sum/n;
    }
}
