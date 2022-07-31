class week2 {
  static int count=0;
	/* arr[] ---> Input Array
	data[] ---> Temporary array to store current combination
	start & end ---> Starting and Ending indexes in arr[]
	index ---> Current index in data[]
	r ---> Size of a combination to be printed */
	static void thenDoThis(int arr[], int length, int l, int index, int data[], int i)
	{
		// Current combination is ready to be printed,
		// print it
		
		if (index == l) {
			int sum=1;
			for (int j = 0; j < l; j++)
				{
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

		// end function case
		if (i >= length)
			return;

		// current is included, put next at next
		// location
		data[index] = arr[i];
		thenDoThis(arr, length, l, index + 1, data, i + 1);

		// current is excluded, replace it with
		thenDoThis(arr, length, l, index, data, i + 1);
	}

	// The main function that prints all combinations
	// of size r in arr[] of size n. This function
	// mainly uses combinationUtil()
	static void doThis(int arr[], int length, int l)
	{

		int data[] = new int[l];

		// Print all combination using temporary
		thenDoThis(arr, length, l, 0, data, 0);
	}

	/* Driver function to check for above function */
	public static void main(String[] args)
	{
		int arr[] = { 10,10,5,0,2,1,2,5 };
		int l = 3;
		int length = arr.length;
		doThis(arr, length, l);
	}
}