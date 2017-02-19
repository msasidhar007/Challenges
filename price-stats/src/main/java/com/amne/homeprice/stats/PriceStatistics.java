package com.amne.homeprice.stats;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class PriceStatistics {

	public static void main(String[] args) throws IOException {
		
		//Declaring required variables
		Integer n = 0;
		Integer k = 0;
		int count = 0;
		Integer ws = 0;
		StringTokenizer tokenize = null;
		String inputFilePath = "";
		String outputFilePath = "";
		List<Integer> salesPriceList = new ArrayList<Integer>();
		
		//Check for arguments whether two arguments are provided for execution
		if (args.length > 0 && args.length==2){
			inputFilePath = args[0];
			outputFilePath = args[1];
			PrintStream out = new PrintStream(new FileOutputStream(outputFilePath + "/output.txt"));
			System.setOut(out);

			Path input = Paths.get(inputFilePath + "/input.txt");
			PriceStatistics ps = new PriceStatistics();
			List<String> inputData = Files.lines(input).collect(Collectors.toList());
			for(String val : inputData)
			{
				tokenize = new StringTokenizer(val, " ");
				if(inputData.indexOf(val) == 0)
				{	
					while(tokenize.hasMoreTokens()){
						count++;
						if(count == 1)
			            n = Integer.parseInt(tokenize.nextToken());
						else if(count == 2)
				        k = Integer.parseInt(tokenize.nextToken());
			        }	
				}
				else if(inputData.indexOf(val) == 1)
				{
					while(tokenize.hasMoreTokens()){
						salesPriceList.add(Integer.parseInt(tokenize.nextToken()));
					}
				}
			}
			
			//Validation check for n & k values
			if(n<k)
			{
				System.out.println("n value is less than k value, please correct the input and resubmit");
			}
			else if(n==0 || k==0)
			{
				System.out.println("Invalid Input either n value or k value is zero, please correct the input and resubmit");
			}
			else if(n != salesPriceList.size())
			{
				System.out.println("Number of sales price data given : " + tokenize.countTokens());
				System.out.println("Invalid Input Data");
			}
			else
			{	
			//window size 	
			ws = n-k+1;
			
			//for each window we will calculate increasing subrange and decreasing subrange
			// & by subtracting both values we will get desired result
			for (int i=0; i<= ws-1 ; i++)
			{	
				List<Integer> subsetSales = new ArrayList<Integer>();
				subsetSales = salesPriceList.subList(i, k+i);
				int incsubrange = ps.getIncreasingSubRange(subsetSales);
				int decsubrange = ps.getDecreasingSubRange(subsetSales);
				int result = incsubrange - decsubrange;
				System.out.println(result);
			}
			}
        }
		else 
		{
			System.out.println("Please provide both input & output directory locations");
		}
	}

	/**
	 * Function will iterate through the subset provided and will calculate for increasing subrange
	 * @param window
	 * @return increasing subrange
	 */
	public int getIncreasingSubRange(List<Integer> window)
	{
		Integer incseq = 1;
		int incsubrange = 0;
		for (Integer i = 0,j=1; i < window.size(); i++,j++) {
			if(j==window.size())
			{
				j = j-1;
			}
			if(window.get(i) < window.get(j))
			{
				incseq++;
			}
			else
			{
				incsubrange = incsubrange + (incseq * (incseq - 1))/2;
				incseq = 1;
			}
			
		}
		return incsubrange ;
	}
	
	/**
	 * Function will iterate through the subset provided and will calculate for decreasing subrange
	 * @param window
	 * @return decreasing subrange
	 */
	public int getDecreasingSubRange(List<Integer> window)
	{
		Integer decseq = 1;
		int decsubrange = 0;
		for (Integer i = 0,j=1; i < window.size(); i++,j++) {
			if(j==window.size())
			{
				j = j-1;
			}
			if(window.get(i) > window.get(j))
			{
				decseq++;
			}
			else
			{
				decsubrange = decsubrange + (decseq * (decseq - 1))/2;
				decseq = 1;
			}			
		}
		return decsubrange ;
	}
}
