public class week8 {
    //declaring required variables
	static int keys=0;
	static String[] foundKeys;
	static boolean[][] traveled;
	static int collectedKeys=0;
	static int travel=-1;
	// Assign sizes
	public static void assignKeys(int r, int c){
		traveled =new boolean[r][c];
		foundKeys=new String[r*c];

	}

	static int[] findStartingPoint(String[][] a, String c){
		// search for number of keys
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(isLowerCase(a[i][j])){
					keys++;
				}
			}
		}
		//searching starting point using binary search
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				

			    if (a[i][j] == c) {
				   return new int[] { i, j };
			    }
			}
		 }
		 return new int[] { -1, -1 };
		}
	
	// Check if loewrcase
	private static boolean isLowerCase(String string) {
		return Character.isLowerCase(string.charAt(0));
	}
	// check if uppercase
	private static boolean isUpperCase(String string) {
		return Character.isUpperCase(string.charAt(0));
	}
	// function to check lower case else return required output
	static int doThis(int w,int e,int r,int c,String[][]A){
		travel++;
		if(isLowerCase(A[w][e])){
			collectedKeys++;
			foundKeys[collectedKeys]=A[w][e].toUpperCase();
			if(collectedKeys==keys){
				return travel;
			}
			return UniquePathHelper(w,e,r,c,A);
		}
		return UniquePathHelper(w,e,r,c,A);
	}
	// function to check uppercase else return required output
	static void firstDoThis(int i,int j,int r,int c,String[][]A){
		traveled[i][j]=true;
		if(isUpperCase(A[i][j])){
			for(int l=0;l<5;l++){
                    String st=foundKeys[l];
                    if(st==null){
					continue;
				}
				String v1=A[i][j];
				if(v1.equals(st)){
					doThis(i,j,r,c,A);
				}
			}
		}
		else{
			doThis(i,j,r,c,A);
		}
	}

	static int UniquePathHelper(int i, int j, int r, int c,String[][] A)
	{
		// boundary condition 
		if (i == r || j == c) {
		return 0;
		}
		try{
			if(i+1<r &&j<c&& A[i+1][j] != "#" && !traveled[i+1][j]){
				firstDoThis(i+1,j,r,c,A);
			}
		}
		catch(Exception e){

		}
		try{
			if(i<r &&j+1<c && A[i][j+1] != "#"  && !traveled[i][j+1]){
				firstDoThis(i,j+1,r,c,A);
			}
		}
		catch(Exception e){

		}
		try{
			if(i<r &&j-1<c && A[i][j-1] != "#" && !traveled[i][j-1]){
				firstDoThis(i,j-1,r,c,A);
			}
		}
		catch(Exception e){

		}
		try{
			if(i-1<r &&j<c && A[i-1][j] != "#" && !traveled[i-1][j]){
				firstDoThis(i-1,j,r,c,A);
			}
		}
		catch(Exception e){
			
		}
			
		
		return -99999;
	}

	static int uniquePathsWithObstacles(String[][] A)
	{	
		int[] array0 =findStartingPoint(A,"@");
		int r = A.length, c = A[0].length;
		assignKeys(r, c);
		int i=array0[0];
		int j=array0[1];
		return UniquePathHelper(i, j, r, c, A);
	}

	// Driver Code
	public static void main(String[] args)
	{	week8 g=new week8();
		String[][] A = {
			{"@", "*", "a","*","#"},
			{"#", "#", "#","*","#"},
			{"b", "*", "A","*","B"}
		};
		int r = A.length, c = A[0].length;
		uniquePathsWithObstacles(A);
		System.out.println("FoundKeys:- ");
		for(int  i=0;i<foundKeys.length;i++){
			System.out.println(foundKeys[i]);
		}
		System.out.println("Traveled:- ");
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(traveled[i][j] +", " );
			}
			System.out.println();
		}
		System.out.println("Collected Keys:- "+ collectedKeys);
		System.out.println("Travel:- "+travel);
		System.out.println("Kays:- "+keys);
		System.out.println("lower:- "+isLowerCase(A[0][2]));
	}
}
