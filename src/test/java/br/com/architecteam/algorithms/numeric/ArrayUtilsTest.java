package br.com.architecteam.algorithms.numeric;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void testMaxProductUsingOnlyPositiveNumbers() {
	assertEquals(6, ArrayUtils.maxProduct(new int[] { 1, 2, 3 }));
    }

    @Test
    public void testMaxProductUsingMixedPositiveAndNegativeNumbers() {
	assertEquals(6, ArrayUtils.maxProduct(new int[] { -2, -3, 6 }));
	assertEquals(6, ArrayUtils.maxProduct(new int[] { -1, 2, 3 }));
    }

    @Test
    public void testMaxProductUsingOnlyNegativeNumbers() {
	assertEquals(15, ArrayUtils.maxProduct(new int[] { -2, -3, -5 }));
    }

}
