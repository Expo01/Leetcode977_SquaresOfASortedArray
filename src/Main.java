import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] pass = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(new Solution().sortedSquares(pass)));
    }
}

// this is what i was tryring to do, but they did it better. no middle point found and added starting at end index of
// result and decrementing so thy didn't hav to work from middle out
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int sq;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                sq = nums[right];
                right--;
            } else {
                sq = nums[left];
                left++;
            }
            result[i] = sq * sq;
        }

        return result;
    }
}

// passed 5 test cases, but then ran into issues.  this is obviously very lengthy, but using skills i have.
//class Solution {
//    public int[] sortedSquares(int[] nums) {
//        int positiveIndex = 0;
//        while(nums[positiveIndex]<0){
//        positiveIndex++; //found first index with positive value
//        }
//
//        int negativeIndex = positiveIndex-1; // defined first index that is either a 0 or negative value
//
//        int[] mergedSquared = new int[nums.length]; // created a merged array of the two subarrays split from nums
//        int mergedIndex = 0; // defined start index to begin assigning values
//
//        while(negativeIndex >= 0 && positiveIndex <= nums.length-1){ // while both are in bounds
//            if(Math.abs(nums[negativeIndex])<nums[positiveIndex]){ // if abs value of neg # < positive #
//                mergedSquared[mergedIndex] = (int)Math.pow(nums[negativeIndex],2); // assign the index to sqaure of that
//                // lower value
//                negativeIndex--; // decrement working from middle out to 0
//            } else{ // if its not less, then its ether greater or equal
//                mergedSquared[mergedIndex] = (int)Math.pow(nums[positiveIndex],2); // so add squarerd positive value at
//                // merged index
//                positiveIndex++; // increment working middle out to end-1
//            }
//            mergedIndex++; // increment mergedIndex regardless of pos index orr neg index added to merged
//        }
//        // loop ended where either neg index or pos index still in bounds, the other will be one out of bounds
//
//        if(negativeIndex < 0){ // if neg index OOB then  add remaining + index values to merged
//            while(positiveIndex < nums.length){
//                mergedSquared[mergedIndex] = (int)Math.pow(nums[positiveIndex],2);
//                mergedIndex++;
//                positiveIndex++;
//            } // positive index will end at nums.length = OOB
//        } else{
//            while (negativeIndex>= 0){ // else positive index OOB so add remaining ng index values until indx at 0
//                mergedSquared[mergedIndex] = (int)Math.pow(nums[negativeIndex],2);
//                mergedIndex++;
//                negativeIndex++;
//            }
//        }
//        return mergedSquared; //return sorted squared array
//    }
//}

// take first half of list of < 0, loop starting from end index and merge into a sorted and second
// half starting from start index, merge two arrays into third array then redefine each index as the
// square of the start value
// this would be O(n) to split, then O(n) to merge, then O(n) to square. O(3n). probably could
// be better, but not a horrible idea