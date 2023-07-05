package model;

import java.util.Arrays;

public class NumLogic {
	public void execute(Num num) {
		//String numString = num.getNums();
		String[] data = num.getNums().split(",");
		int[] nums = new int [data.length];
		
		int count=0;
		int sum=0;
		for(int i=0; i<data.length; i++) {
			nums[i] = Integer.parseInt(data[i]);
			count++;
			sum +=nums[i];
		}
		
		Arrays.sort(nums);
		
		//num.setNums(numString);
		num.setSize(count);
		num.setMax(nums[nums.length-1]);
		num.setMin(nums[0]);
		num.setTotal(sum);
	}

}
