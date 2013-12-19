package br.com.architecteam.algorithms.numeric;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Given an array with at least size 2, calculate the maximum product between
     * any 2 numbers
     * 
     * @param nums an array with size >= 2
     * 
     * @return the maximum possible product between any 2 numbers
     */
    public static int maxProduct(int[] nums) {
	if (nums == null || nums.length < 2) {
	    throw new IllegalArgumentException();
	}
	
	int small = Integer.MAX_VALUE;
	int smallest = Integer.MAX_VALUE;
	int big = Integer.MIN_VALUE;
	int biggest = Integer.MIN_VALUE;
	
	for (int i : nums) {
	    if (i < small) {
		small = i;
		if (small < smallest) {
		    int tmp = smallest;
		    smallest = small;
		    small = tmp;
		}
	    }
	    if (i > big) {
		big = i;
		if (big > biggest) {
		    int tmp = biggest;
		    biggest = big;
		    big = tmp;
		}
	    }
	}
	
	
	return Math.max(small * smallest, big * biggest);
    }

}
