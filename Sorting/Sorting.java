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
		/* Used to time the algorithm(s) and generate the data for the graphs
		for(int i = 10000; i <= 100000; i += 10000){
			ArrayList<Integer> list = tester.fillRandom(i, 100000);
			long start = System.currentTimeMillis();
			tester.bubbleSort(list);
			long end = System.currentTimeMillis();
			
			System.out.println(i + " values: " + (end - start) + " ms");

		}
		*/
		
		
		
		
	}
}