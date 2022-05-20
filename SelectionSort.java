import java.io.*;
class SelectionSort {
	public static void main(String[] args) {
		int i,j,n,small,index,swapCounter;
		int x[] = SelectionSort.selectCase(); // Let user select from best,worst and random case
		n = x.length;
		for(i = 0;i < n;i++) {
			swapCounter = 0;
			small = x[i]; // set the small to the element at the ith index
			index = i; // set the index as i
			for(j = i+1;j < n;j++) {
				if(small > x[j]) {
					// if the small is greater than the any element in the array then set small as that element and index as the element's index
					swapCounter++;
					small = x[j];
					index = j;
				}
			}
			System.out.println("At i = " + i + " ");
			
			// Swap the smallest element with the current ith element.
			x[index] = x[i]; 
			x[i] = small;

			System.out.print("Current array: ");
			SelectionSort.display(x, n);
			System.out.println("Changes: " + swapCounter);
			System.out.println();
		}
		System.out.println("Sorted Array : ");
		SelectionSort.display(x, n);
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
			int bestcase[] = new int[]{79, 159, 239, 319, 399, 479, 559, 639, 719, 799};
			int worstcase[] = new int[]{799, 719, 639, 559, 479, 399, 319, 239, 159, 79};
			int randomcase[] = new int[]{319, 159, 639, 79, 399, 799, 559, 239, 719, 479};
			int ch;
			System.out.println("-----Menu-----");
			System.out.println("\n1. Best case \n2. Worst case \n3. Random case");
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