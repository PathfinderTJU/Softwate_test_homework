package cn.tju.ex04;

import static org.junit.Assert.*;
import org.junit.Test;


public class BackPackTest {
    
	@Test
	public void testBackPack() {	 
		int m = 5; //最大容量
		int n = 4; //物品数目
		int[] w = new int[]{2, 1, 3, 2}; //物品重量
	    int[] p = new int[]{3, 2, 4, 2}; //物品价值
	    int excepted = 7; //dp数组
	    
	    //c[n][m]为解：前3个物品，容量不超过10的最大容量
		assertEquals(excepted, BackPack.BackPack_Solution(m, n, w, p)[n][m]);
	}
	
}
