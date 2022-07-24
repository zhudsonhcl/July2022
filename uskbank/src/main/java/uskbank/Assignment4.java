package uskbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Assignment4 {
	public static void main(String[] args) {
		//Setting example lists
		ArrayList<Integer> exampleList = new ArrayList<Integer>();
		exampleList.add(1);
		exampleList.add(2);
		exampleList.add(3);
		exampleList.add(4);
		exampleList.add(5);
		exampleList.add(6);
		
		LinkedList<Integer> exampleLink = new LinkedList<Integer>();
		exampleLink.add(11);
		exampleLink.add(12);
		exampleLink.add(13);
		exampleLink.add(14);
		exampleLink.add(15);
		exampleLink.add(16);
		
		HashSet<Integer> exampleHash = new HashSet<Integer>();
		exampleHash.add(21);
		exampleHash.add(22);
		exampleHash.add(23);
		exampleHash.add(24);
		exampleHash.add(25);
		exampleHash.add(26);
		
		
		System.out.println("Program 1");
		System.out.println("Original ArrayList: " + exampleList);
		System.out.println("After reverse: " + reverseList(exampleList));
		
		System.out.println();
		System.out.println("Program 2");
		System.out.println("Original ArrayList: " + exampleList);
		System.out.println("Swapping three and five...");
		System.out.println("After swap: " + swapList(exampleList, 2, 4));
		
		System.out.println();
		System.out.println("Program 3");
		System.out.println("Original LinkedList: " + exampleLink);
		System.out.println("Starting at 14");
		System.out.println("Iterate: " + iterateList(exampleLink, 3));
		
		System.out.println();
		System.out.println("Program 4");
		System.out.println("Original LinkedList: " + exampleLink);
		System.out.println("Replacing 14 with 67...");
		System.out.println("After replace: " + replaceInList(exampleLink, 3, 67));
		
		System.out.println();
		System.out.println("Program 5");
		System.out.println("Original Hashset: " + exampleHash);
		System.out.println("New Array: " + Arrays.toString(hashToArray(exampleHash)));
		
	}
	
	public static ArrayList<Integer> reverseList(ArrayList<Integer> example) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i = example.size()-1; i >= 0; i--) {
			newList.add(example.get(i));
		}
		
		return newList;
	}
	
	public static ArrayList<Integer> swapList(ArrayList<Integer> example, int first, int second){
		ArrayList<Integer> newList = new ArrayList<>(example);
		
		newList.set(first, example.get(second));
		newList.set(second, example.get(first));
		
		return newList;
	}
	
	public static String iterateList(LinkedList<Integer> example, int start){
		StringBuilder list = new StringBuilder();
		
		for(int i = start; i < example.size(); i++) {
			list.append(example.get(i) + ", ");
		}
		
		for(int i = 0; i < start; i++) {
			list.append(example.get(i) + ", ");
		}
		
		return list.toString();
	}
	
	public static LinkedList<Integer> replaceInList(LinkedList<Integer> example, int start, int num){
		example.set(start, num);
		return example;
	}
	
	public static int[] hashToArray(HashSet<Integer> example) {
		int exampleArray[] = new int[example.size()];
		
		int counter = 0;
		
		for(int num : example) {
			exampleArray[counter++] = num;
		}
		
		return exampleArray;
		
	}
	
}
