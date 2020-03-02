package cn.tju.ex01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class moneyTest {
	
	public boolean expected;
	public int sum;
	
	public moneyTest(boolean expected, int sum) {
		this.expected = expected;
		this.sum = sum;
	}
	
	@Parameters
	public static Collection<Object[]> calcValues(){
		return Arrays.asList(new Object[][] {
			{true, 0},
			{true, 10},
			{true, 20},
			{true, 30},
			{true, 16},
			{false, 19},
			{true, 93},
			{false, 100}
		});
	}
	
	@Test
	public void testCalc() {
		assertTrue(expected == money.calc(sum));
	}
	
}
