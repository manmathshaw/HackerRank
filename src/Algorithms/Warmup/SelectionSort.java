package practicegeeks;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);

	}
	void sort(int arr[]) {
		int n = arr.length;
		int min_indx = 0;
		int temp = 0;
		for(int i=0; i<n-1; i++) {
			min_indx = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[min_indx]) {
					min_indx = j;
				}
			}
			if(i != min_indx) {
				temp = arr[min_indx];
				arr[min_indx] = arr[i];
				arr[i] = temp;
			}
		}
	}
	void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
