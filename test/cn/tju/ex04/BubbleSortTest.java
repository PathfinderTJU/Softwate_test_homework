package cn.tju.ex04;

import static org.junit.Assert.*;
import org.junit.Test;

public class BubbleSortTest {
		
	@Test
	public void testBubble() {
		int[] expected = new int[]{-1,0,1,2,2};
		int[] origin = new int[]{2,-1,2,1,0};
		assertArrayEquals(expected, BubbleSort.BubbleSort(origin));
	}
}
