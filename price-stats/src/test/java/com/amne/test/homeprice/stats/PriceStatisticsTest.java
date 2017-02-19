package com.amne.test.homeprice.stats;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.amne.homeprice.stats.*;
public class PriceStatisticsTest {

	@Test
	public void getIncreasingSubRangeTest() {
		PriceStatistics ps = new PriceStatistics();
		List<Integer> window = new ArrayList<Integer>();
		window.add(5);
		window.add(6);
		window.add(7);
		window.add(4);
		window.add(4);
		window.add(5);
		window.add(6);
		window.add(7);
		
		assertEquals(9,ps.getIncreasingSubRange(window));
	}
	
	@Test
	public void getSeries()
	{
		for(int i=0; i<20000; i++)
		{
			System.out.print("188930 194123 201345 154243 154243 ");
//			System.out.print("4200 5001 6002 1000 9999 ");
//			System.out.print("32 70 33 99 77 ");

		}
	}

}
