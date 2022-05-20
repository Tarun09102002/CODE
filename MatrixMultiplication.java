import java.util.*;
class MatrixMultiplication
{
	static int MatrixMultSeq(ArrayList<Integer> p, int n)
	{
		int m[][] = new int[n][n];

		int i, j, k, L, q; 

        // initialize the matrix to 0
		for (i = 1; i < n; i++)  
			m[i][i] = 0;

		
		for (L = 2; L < n; L++) 
		{
			for (i = 1; i < n - L + 1; i++)// L is the length of chain 
			{
				j = i + L - 1; 
				if (j == n) 
					continue; //skip the current iteration and continue 
				m[i][j] = Integer.MAX_VALUE; 
				
				for (k = i; k <= j - 1; k++)
				{
				                                 // q = cost/scalar multiplications
					q = m[i][k] + m[k + 1][j] + p.get(i - 1) * p.get(k) * p.get(j);
					if (q < m[i][j])              //while adding parentheses to all possible locations if we get minimum vlaue we store it
						m[i][j] = q;
				}
			}
		}

		return m[1][n - 1]; // we return the lowest number of possible operations
	}


	public static void main(String args[])
	{
		int t, n;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		int[] value = new int[t];
		while(t-->0){
	        ArrayList<Integer> arr = new ArrayList<>();
		n= in.nextInt();                            //number of matrices
		int[][] matrixI = new int[n][2];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<2; j++){
				matrixI[i][j]= in.nextInt();  //take input of index for each matrix
			}	
		}
		for(int i = 0; i<n; i++){
			for(int j = 0; j<2; j++){
				if(i>0){
					j++;
				}
				arr.add(matrixI[i][j]);        //converting 2d array input into a chain of indexes
				}
			}	
		int size = arr.size();
	    value[t]=MatrixMultSeq(arr, size);
		}
		System.out.println("The least number of multiplication operations to be done:");
		for(int i=value.length-1;i>=0;i--){	
		System.out.println(value[i]);
		}	
	}
}
