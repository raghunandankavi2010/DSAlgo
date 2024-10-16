package programs.arrays;


import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] arr ={5,6,7};
        int k = 3;
        double[] output = new SlidingWindowMedian().medianSlidingWindow(arr,k);
        for(double num:output){
            System.out.print(num+" ");
        }
    }

    private double[] medianSlidingWindow(int[] nums, int k){
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b]
                ? Integer.compare(nums[a], nums[b])
                : a - b;

        TreeSet<Integer> minHeap = new TreeSet<>(comparator);
        TreeSet<Integer> maxheap = new TreeSet<>(comparator.reversed());

        int ans = 0;
        double[] result = new double[nums.length-k+1];
        for(int i=0;i<nums.length;i++) {
          if(i-k==0){
              minHeap.remove(i-k);
              maxheap.remove(i-k);
          }

            minHeap.add(i);

            maxheap.add(minHeap.pollFirst());

            balanceHeaps(minHeap,maxheap);

            if(i>= k-1)
                result[ans++] = getMedian(minHeap,maxheap,k,nums);
        }

        return result;
    }

    private Double getMedian(TreeSet<Integer> minHeap, TreeSet<Integer> maxheap, int k, int[] nums) {
        if(k%2 ==0 ) return((double) (nums[minHeap.first()] + nums[maxheap.first()]/2));
        return (double) nums[minHeap.first()];
    }

    private void balanceHeaps(TreeSet<Integer> minHeap, TreeSet<Integer> maxheap) {

        if(maxheap.size() > minHeap.size())
            minHeap.add(maxheap.pollFirst());
    }
}

