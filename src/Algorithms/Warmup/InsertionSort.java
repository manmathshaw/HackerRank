package practicegeeks;

public class InsertionSort {
	void sort(int arr[])
    {
        int n = arr.length;
        int temp = 0;
        for (int i=1; i<n; ++i) {
            /*int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;*/
        		for(int j=i-1; j>=0; j--) {
        			if(arr[j] > arr[i]) {
        				temp = arr[i];
        				arr[i] = arr[j];
        				arr[j] = temp;
        			}
        		}
        }
    }
 
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[]) {        
        int arr[] = {12, 11, 13, 5, 6};
 
        InsertionSort ob = new InsertionSort();        
        ob.sort(arr);
         
        printArray(arr);
    }
}
