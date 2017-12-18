/*Co Sci 940 -Discrete Structure
 * Md Haque 
 * Due date: 12/17/17 11:59 pm
 * Project: MergeSort Algorithm
 * ---------------------------
 * Mergersort Algorithm is a much more efficient algorithm
 * than Bubblesort , Inserttionsort or Selectionsort. While  time complexity
 * for the trhree mentioned is O(n^2), Mergesort is O(NlogN). To put it in prespective
 * In N = 10,000 then N^2= 100, 000, 000, and NlogN = 40,000. if sorting these many items
 * with mergesort takes 40 secs , it would take 28 hrs with algorithm having time complexity
 * N^2(Bubblesort, Insertionsort, Selectionsort)
 * 
 */
public class MergesSort {
	
	public static void mergeSort(int[] arr) {
		int[] workArr = new int[arr.length];
		int lo = 0;
		int hi = workArr.length - 1;
		recMergeSort(workArr, arr, lo, hi);
	}
	private static  void recMergeSort(int[] wArr, int[] arr, int l, int h) {
		if(l == h)
			return;
		else {
			int m= (l+h)/2; // m = mid
			recMergeSort(wArr, arr, l, m);
			recMergeSort(wArr, arr, m+1, h);
			merge(wArr, arr, l, m+1, h);
		}
	}
	private static  void merge(int[] wArr, int[] arr, int lPtr, int hPtr, int uBound) {
		int j = 0;
		int lBound = lPtr;
		int mid = hPtr - 1;
		int n = uBound - lBound + 1;
		
		////
		while(lPtr <= mid && hPtr <= uBound)
			if(arr[lPtr] < arr[hPtr])
				wArr[j++] = arr[lPtr++];
			else
				wArr[j++] = arr[hPtr++];
		//-------------------------------
		while(lPtr <= mid)
			wArr[j++] = arr[lPtr++];
		//-------------------------------
		while(hPtr <= uBound)
			wArr[j++] = arr[hPtr++];
		//----------------------------
		for(j = 0; j < n; j++)
			arr[lBound + j] = wArr[j];
		
	}
	public static void displayArr(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] intArr = {23, 47, 81, 95,7, 14, 39, 55, 62, 74, 0};
		displayArr(intArr);
		mergeSort(intArr);
		displayArr(intArr);
	}

}
