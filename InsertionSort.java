import java.io.*;
class InsertionSort
{
	public static void main(String[] args)
	{
		int i,j,n,y,swapCounter;
		int x[] = InsertionSort.selectCase(); // Let user select from best,worst and random case
		n = x.length;
		for(i = 1;i < n;i++)
		{
			swapCounter = 0;
			y = x[i];  // set the y to the element at the ith index
			System.out.println("At i = " + i + " ");
			System.out.print("Current array: ");
			InsertionSort.display(x, n);
			for(j = i - 1;j >= 0 && y < x[j];j--) // it will go inside the loop only when the current element is smaller than its previous element
			{
				// here we are swapping both of them
				swapCounter++;
				x[j+1] = x[j];
				x[j] = y;
			}
			System.out.println("Swaps = " + swapCounter);
			System.out.println();
		}
		System.out.println("Sorted Array : ");
		InsertionSort.display(x, n);
	}
	public static void display(int[] x, int n) {
		int i;
		for(i = 0;i < n;i++)
			System.out.print(x[i]+ " ");
		System.out.println();
	}	
	public static int[] selectCase() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int bestcase[] = {79, 159, 239, 319, 399, 479, 559, 639, 719, 799};
			int worstcase[] = {799, 719, 639, 559, 479, 399, 319, 239, 159, 79};
			int randomcase[] = {319, 159, 639, 79, 399, 799, 559, 239, 719, 479};
			int ch;
			System.out.println("-----Menu-----");
			System.out.println("\n1. Best case \n2. Worst case \n3.Random case");
			System.out.println("\nEnter the choice: ");
			ch = Integer.parseInt(br.readLine());
			switch(ch) {
				case 1:
						return bestcase;
				case 2:
						return worstcase;
				case 3: 
						return randomcase;
				default:
						System.exit(0);
			}
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		} 
		return null;
	}
}