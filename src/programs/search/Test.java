package programs.search;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 9;
        System.out.println(test.search(nums, target));
    }

    public int search(int[] nums, int target) {

        int pivot = 0;
        int left = 0;
        int i = 0;
        int j = nums.length - 1;
        int right = nums.length - 1;

        while (left < right) {

            int middle = (left + right) / 2;

            if (middle < right && nums[middle] > nums[middle + 1]) {
                pivot = middle;
            }
            if (middle > left && nums[middle] < nums[middle - 1]) {
                pivot = middle - 1;
            }
            if (nums[0] >= nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        while (i < j) {

            int middle = (left + right) / 2;
            if (target == nums[middle]) return target;
            if (target < pivot) {
                i++;
            } else {
                j--;
            }

        }

        return -1;
    }


}

