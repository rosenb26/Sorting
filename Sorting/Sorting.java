import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorting{
	
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> list){ 
	
		for(int i = 0; i < list.size() - 1; i++){
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(i) > list.get(j)){
					this.swap(list, i, j);
				}
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
		for(int i = 10000; i <= 100000; i += 10000){
			ArrayList<Integer> list = tester.fillRandom(i, 100000);
			long start = System.currentTimeMillis();
			tester.insertionSort(list);
			long end = System.currentTimeMillis();
			
			System.out.println(i + " values: " + (end - start) + " ms");

		}
		
		
	}
}