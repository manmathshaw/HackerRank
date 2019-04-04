package practicegeeks;

public class CountOnes {
	public static void main(String args[]) {
       CountOnes ob = new CountOnes();
       int arr[] = {1,1,1,1};
       int n = arr.length;
       System.out.println("Count of 1's in given array is " + ob.countOnes(arr, 0, n-1) );
    }
	int countOnes(int arr[], int low, int high) {
		int index = ( low + high ) / 2;
		if(index == high) {
			return index+1;
		}
		if(index < high) {
			if(arr[index] == 1) {
				if(arr[index+1] == 0) {
					return index+1;
				} else {
					return countOnes(arr, index+1, high);
				}
			} else {
				if(arr[index-1] == 1) {
					return index;
				} else {
					return countOnes(arr, 0, index-1);
				}
			}
		}
		return 0;
	}
}
