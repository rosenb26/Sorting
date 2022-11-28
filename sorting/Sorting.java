import heap.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorting{
	
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> list){ 
	
		for(int i = 0; i < list.size() - 1; i++){
			
			boolean swapMade = false;
			for(int j = 0; j < list.size() - i - 1; j++){
				
				if(list.get(j) > list.get(j + 1)){
					this.swap(list, j, j + 1);
					swapMade = true;
				}
				
			}
			if(!swapMade){
				break;
			}
			
		}
		return list;
	}
	
	public ArrayList<Integer> insertionSort(ArrayList<Integer> list){
		/* Insertion sort is Shell sort with a starting gap of 1. */
		return this.shellSort(list, 1);
	}
	
	public ArrayList<Integer> selectionSort(ArrayList<Integer> list){
		for(int i = 0; i < list.size() - 1; i++){
			int minValue = list.get(i);
			int minIndex = i;
			for(int j = i + 1; j < list.size(); j++){
			
				if(list.get(j) < minValue){
					minIndex = j;
					minValue = list.get(j);
				}
			}
			this.swap(list, i, minIndex);
		}
		return list;
	}
	
	public ArrayList<Integer> mergeSort(ArrayList<Integer> list){
		if(list.size() == 1){
			return list;
		}
		ArrayList<Integer> list1 = this.splitList(list, 1);
		ArrayList<Integer> list2 = this.splitList(list, 2);
		
		list1 = this.mergeSort(list1);
		list2 = this.mergeSort(list2);
		
		ArrayList<Integer> merged = this.merge(list1, list2);
		return merged;
	}
	
	public ArrayList<Integer> splitList(ArrayList<Integer> list, int half){
		ArrayList<Integer> split = new ArrayList<>();
		int start;
		int end;
		
		if(half == 1){
			start = 0;
			end = list.size()/2;
		}
		else{
			start = list.size()/2;
			end = list.size();
		}
		
		for(int i = start; i < end; i++){
			split.add(list.get(i));
		}
		return split;
	}
	
	public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
		ArrayList<Integer> merged = new ArrayList<>();
		int m = list1.size();
		int n = list2.size();
		int i = 0, j = 0;
		while(i < m && j < n){
			if(list1.get(i) < list2.get(j)){
				merged.add(list1.get(i));
				i++;
			}
			else if(list1.get(i) > list2.get(j)){
				merged.add(list2.get(j));
				j++;
			}
			else{
				merged.add(list1.get(i));
				merged.add(list2.get(j));
				i++;
				j++;
			}
		}
		if(i == list1.size()){
			while(j < list2.size()){
				merged.add(list2.get(j));
				j++;
			}
		}
		else{
			while(i < list1.size()){
				merged.add(list1.get(i));
				i++;
			}
		}
		return merged;
	}
	
	
	public void swap(ArrayList<Integer> list, int i, int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public ArrayList<Integer> shellSort(ArrayList<Integer> list){
		return this.shellSort(list, list.size()/2);
	}
	
	/**
	* Implements a Shell sort with a given starting gap.
	* A starting gap of 1 is equivalent to an insertion sort.
	*/
	private ArrayList<Integer> shellSort(ArrayList<Integer> list, int gap){
		
		while(gap >= 1){
			
			int i = gap;
			
			while(i < list.size()){
				int index = i;
				
				int n = 1;
				while(i - n*gap >=0 && list.get(i) < list.get(i - n*gap)){
					index = i - n*gap;
					n++;
				}
				if(index != i){
					this.shellInsert(list, index, i, gap);
				}
				i++;
			}
			
			gap /= 2;
		}
		return list;
	}
	
	public void shellInsert(ArrayList<Integer> list, int start, int end, int gap){
		int temp = list.get(end);
		for(int i = end; i > start; i -= gap){
			list.set(i, list.get(i - gap));
		}
		list.set(start, temp);		
	}
	
	public ArrayList<Integer> quickSort(ArrayList<Integer> list){
		return this.quickSort(list, 0, list.size() - 1);
	}
	
	private ArrayList<Integer> quickSort(ArrayList<Integer> list, int start, int end){
		if(start >= end){
			return list;
		}
		list = this.medianToFront(list, start, end);
		int pivotIndex = this.partition(list, start, end);
		this.quickSort(list, start, pivotIndex - 1);
		this.quickSort(list, pivotIndex + 1, end);
		return list;
	}
	
	private int partition(ArrayList<Integer> list, int start, int end){
		int nextBiggestIndex = start + 1;
		int nextSmallestIndex = end;
		while(nextBiggestIndex < nextSmallestIndex){
		
			while(list.get(start) >= list.get(nextBiggestIndex)){
				nextBiggestIndex++;
				if(nextBiggestIndex == list.size()){
					break;
				}
			}
			while(list.get(start) < list.get(nextSmallestIndex)){
				nextSmallestIndex--;
			}
			if(nextBiggestIndex < nextSmallestIndex){
				this.swap(list, nextBiggestIndex, nextSmallestIndex);
			}
			
		}
		if(nextSmallestIndex < nextBiggestIndex){
			this.swap(list, start,nextSmallestIndex);
		}
		return nextSmallestIndex;
		
	}
	
	private ArrayList<Integer> medianToFront(ArrayList<Integer> list, int start, int end){
		int middle = (end + start)/2;
		if(list.get(start) > list.get(middle)){
			this.swap(list, start, middle);
		}
		if(list.get(middle) > list.get(end)){
			this.swap(list, middle, end);
		}
		if(list.get(start) < list.get(middle)){
			this.swap(list, start, middle);
		}
		return list;
	}
	
	public ArrayList<Integer> heapSort(ArrayList<Integer> list){
		int n = list.size();
		Heap<Integer> heap = new MinHeap<>();
		for(int i = 0; i < n; i++){
			heap.add(list.get(i));
		}
		list.clear();
		for(int i = 0; i < n; i++){	
			list.add(heap.remove());
		}
		return list;
	}
	
	public ArrayList<Integer> fillRandom(int n, int bound){
		Random rng = new Random();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			list.add(rng.nextInt(bound));
		}
		return list;
	}
	
	
	
	public static void main(String[] args){
			Sorting tester = new Sorting();
			/*
			int start = 10000;
			int end = 100*start;
			for(int i = start; i <= end; i += start){
				ArrayList<Integer> list = tester.fillRandom(i, 100000);
				long startTime = System.currentTimeMillis();
				tester.heapSort(list);
				long endTime = System.currentTimeMillis();
				list.add(end - start);
				
				System.out.println(i + " values: " + (endTime - startTime) + " ms; ");					
				
			}*/
			ArrayList<Integer> list = tester.fillRandom(10, 100);
			System.out.println("b4 sorting: " + list);
			list = tester.heapSort(list);
			System.out.println("after sorting: " + list);
			
	}
}