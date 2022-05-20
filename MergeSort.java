import java.io.*;
class MergeSort {
    public static void main(String[] args) {
        int n,i;
        int x[] = MergeSort.selectCase(); // Let user select from best,worst and random case
        n = x.length;        
        //Actual sort
        MergeSort.mergeSort(x,0,n-1);
        System.out.println("Sorted array");
        MergeSort.display(x,n);
    }
    public static void mergeSort(int[] x,int lb,int ub) {
        int mid;
        if(lb<ub) {
            mid=(lb+ub)/2;
            // break the left and right part
            mergeSort(x,lb,mid);//left part
            mergeSort(x,mid+1,ub);//right part
            //join the left and right part
            merge(x,lb,mid,ub);
        }
    }
    public static void merge(int[] x,int lb1,int ub1,int ub2) {
        int i,j,k,temp[] = new int[x.length];
        k=0;//temp array's 1st loc
        i=lb1;//left part's 1st loc
        j=ub1+1;//right part's 1st loc
        //Until there are elements in left/right part compare them and take the smallest one
        int changesCounter = 0;
        while(i<=ub1 && j<=ub2) {
            if(x[i]<x[j]) 
                temp[k++]=x[i++];
            else {
                temp[k++]=x[j++];
                changesCounter++;
            }
        }
        // System.out.print("Subarray: ");
        // MergeSort.display(temp, temp.length);
        System.out.println("Changes: " + changesCounter);
        //If i reach here .... either left or right part is empty
        //Now if there are elements in left part then put it into temp
        while(i<=ub1)
            temp[k++]=x[i++];
        //And if there are elements in right part then put it into temp
        while(j<=ub2)
            temp[k++]=x[j++];
        System.out.print("Current array: ");
        MergeSort.display(x,x.length);
        for(i=lb1,j=0;i<=ub2;i++,j++) {
            x[i]=temp[j];
        }
        System.out.print("Changed array: ");
        MergeSort.display(x,x.length);
        System.out.println();
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
			System.out.println("1. Best case \n2. Worst case \n3.Random case");
			System.out.println("Enter the choice: ");
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