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
	
		int i = list.size() - 1;
		while(i > 0){
		
			int index = i;
			for(int j = i - 1; j >= 0; j--){
			
				if(list.get(j) > list.get(i)){
					index = j;
				}
			}
			if(index == i){
				i--;
			}
			else{
				list.add(index, list.remove(i));
				
			}
		}
		return list;
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
			for(int i = 10000; i <= 500000; i += 10000){
			ArrayList<Integer> list = tester.fillRandom(i, 100000);
			long start = System.currentTimeMillis();
			tester.mergeSort(list);
			long end = System.currentTimeMillis();
			
			System.out.println(i + " values: " + (end - start) + " ms");
			}*/
			 
	}
}