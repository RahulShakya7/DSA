class week2 {
  static int count=0;
	// arr[] ---> Array to be inputted
	// data[] ---> Temporary array
	// start & end ---> Starting and Ending indexes for arr
	// indx ---> data[] index for the instance
	// r ---> Size of a combination to be printed 
	static void loopArray(int arr[], int length, int l, int indx, int data[], int i){
		
		if (indx == l) {
			int sum=1;
			for (int j = 0; j < l; j++){
					sum=sum*data[j];
				}
			for(int k=0;k<arr.length;k++){
				if(sum==arr[k] && sum!=0 && count==0){
					System.out.println(arr[k]);
					count++;
				}
			}
			return;
		}

		if (i >= length)
			return;

		// current is included, move next to next position
		data[indx] = arr[i];
		loopArray(arr, length, l, indx + 1, data, i + 1);

		// current is excluded, replace it with
		loopArray(arr, length, l, indx, data, i + 1);
	}

	// Print combinations
	static void doThis(int arr[], int length, int l){
		int data[] = new int[l];

		// Print all combination using temporary
		loopArray(arr, length, l, 0, data, 0);
	}

	// Driver function
	public static void main(String[] args){
		int arr[] = { 10,10,5,0,2,1,2,5 };
		int l = 3;
		int length = arr.length;
		doThis(arr, length, l);
	}
}