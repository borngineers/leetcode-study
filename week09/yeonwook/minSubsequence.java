package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	public static void main(String args[]) { 
		
		int[] a = new int[] {4,3,10,9,8};
		System.out.println(new SubClass().minSubsequence(a));
	}
}

class SubClass {
	public List<Integer> minSubsequence(int[] nums) {
		
		/*
		 * 1. nums -> List에 담기, 담으면서 total_sum 계산
		 * 2. List 내림차순 정렬
		 * 3. sub_sum이 total_sum/2 보다 클때까지 List에 담아서 return 
		 * 질문1. Also return the answer sorted in non-increasing order. 무슨말?ㅋㅋ
		 * 질문1. Note the subsequence has to returned in non-decreasing order. 무슨말?ㅋㅋ
		 */
		
		List<Integer> returnList = new ArrayList<Integer>();
		List<Integer> descList = new ArrayList<Integer>();
		
		double total_sum = 0;
		for(int a:  nums) {
			total_sum += a;
			descList.add(a);
		}
		
		Collections.sort(descList);
		Collections.reverse(descList);
		
		int sub_sum = 0;
		for(Integer b : descList) {
			sub_sum += b;
			returnList.add(b);
			
			if(sub_sum > (total_sum/2)) {
				break;
			}
		}
		
		return returnList;
	}
}
