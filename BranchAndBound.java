import java.util.*;
import java.util.*;
class BranchAndBound{
    private static int checkSolvable(List<Integer> elements) {
        int inversionCount = 0;
        for(int i = 0; i < elements.size(); i++) {
            for(int j = i+1; j < elements.size(); j++) {
                if(elements.get(j) != null && elements.get(i) > elements.get(j)) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }
    private static int findXPos(int[][] arr, int n) {
        
        for (int i = n - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (arr[i][j] == 0)
                    return n - i;
        return -1;
    }
	static int m=0,n=4;
	public static void main(String[] args){
		int p,i,j,n=4; //declaring some variables
        // input matrix
		// int[][] actualMatrix = new int[][] {
        //     {1,2,3,4},
        //     {5,6,0,8},
        //     {9,10,7,11},
        //     {13,14,15,12}
        // }; 
        // int[][] actualMatrix = new int[][] {
        //     {1,2,3,0},
        //     {5,6,7,4},
        //     {9,10,11,8},
        //     {13,14,15,12}
        // };
        int[][] actualMatrix = new int[][] {
            {6,13,7,10},
            {8,9,11,0},
            {15,2,12,5},
            {14,3,1,4}
        };
        // target matrix
		int[][] targetMatrix = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
        }; 
        // a temporary matrix
		int[][] temp = new int[10][10]; 
		int[][] resultMatrix = new int[10][10]; 
		// variable declaration
		int m=0,x=0,y=0,d=1000,minCost=0,l=0;
		// printing the input matrix
		// System.out.println("\nEntered Matrix is :\n");
		// for(i=0;i < n;i++)
		// {
		// 	for(j=0;j < n;j++)
		// 		System.out.print(actualMatrix[i][j] + " ");
		// 	System.out.println("\n");

		// }
		// // printing the target matrix
		// System.out.println("\nTarget Matrix is :\n");
		// for(i=0;i < n;i++)
		// {
		// 	for(j=0;j < n;j++)
		// 		System.out.print(targetMatrix[i][j] + " ");
		// 	System.out.println("\n");
		// }
        List<Integer> elements = new ArrayList<>();
        // actualMatrix = new int[][] {
        //     {1,8,2},
        //     {0,4,3},
        //     {7,6,5},
        // };
        // n=3;
        for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                if(actualMatrix[i][j] != 0) 
                    elements.add(actualMatrix[i][j]);
            }
        }
        int inversionCount = checkSolvable(elements);
        System.out.println("Inversion count: " + inversionCount);
        int xPos = findXPos(actualMatrix,n);
        System.out.println("x position: " + xPos);
        if((n % 2 > 0  && inversionCount % 2  == 0)||(inversionCount % 2 == 0 && xPos % 2 > 0) || (inversionCount % 2 > 0 && xPos % 2 == 0)) {
            System.out.println("The above problem is Solvable");
            System.out.println();
             while((check(actualMatrix,targetMatrix)==0))
            {
               l++; // level of the tree
            //     d=1000; // max
            //     // first store the position of the "0"
            //     for(i=0;i < n;i++)
            //         for(j=0;j < n;j++)
            //         {
            //             if(actualMatrix[i][j]==0)
            //             {
            //                 x=i; // row index
            //                 y=j; // column index
            //             }
            //         }
    
            //     //To move upwards
            //     for(i=0;i < n;i++)
            //         for(j=0;j < n;j++)
            //             temp[i][j]=actualMatrix[i][j];
            //     // if the "0" is in the first row there is no space to move upwards
            //     if(x!=0)
            //     {
            //         p=temp[x][y];
            //         temp[x][y]=temp[x-1][y];
            //         temp[x-1][y]=p;
            //     }
            //     // now calculate the cost for new matrix 
            //     m=calculate(temp,targetMatrix);
            //     minCost=l+m;
            //     if(minCost < d)
            //     {
            //         d=minCost;
            //         for(i=0;i < n;i++)
            //             for(j=0;j < n;j++)
            //                 resultMatrix[i][j]=temp[i][j];
            //     }
    
            //     //To move downwards
            //     for(i=0;i < n;i++)
            //         for(j=0;j < n;j++)
            //             temp[i][j]=actualMatrix[i][j];
            //     // if the "0" is in the last row we cannot move downwards
            //     if(x!=n-1)
            //     {
            //         p=temp[x][y];
            //         temp[x][y]=temp[x+1][y];
            //         temp[x+1][y]=p;
            //     }
            //     // calculate the cost of the temp matrix and if the cost is less than previous cost, copy it into resultMatrix
            //     m=calculate(temp,targetMatrix);
            //     minCost=l+m;
            //     if(minCost < d)
            //     {
            //         d=minCost;
            //         for(i=0;i < n;i++)
            //             for(j=0;j < n;j++)
            //                 resultMatrix[i][j]=temp[i][j];
            //     }
    
            //     //To move right side
            //     for(i=0;i < n;i++)
            //         for(j=0;j < n;j++)
            //             temp[i][j]=actualMatrix[i][j];
            //     // we can't move to right side if the "0" is in the last column
            //     if(y!=n-1)
            //     {
            //         p=temp[x][y];
            //         temp[x][y]=temp[x][y+1];
            //         temp[x][y+1]=p;
            //     }
            //     // calculate the cost of the temp matrix and if the cost is less than previous cost, copy it into resultMatrix
            //     m=calculate(temp,targetMatrix);
            //     minCost=l+m;
            //     if(minCost < d)
            //     {
            //         d=minCost;
            //         for(i=0;i < n;i++)
            //             for(j=0;j < n;j++)
            //                 resultMatrix[i][j]=temp[i][j];
            //     }
    
            //     //To move left
            //     for(i=0;i < n;i++)
            //         for(j=0;j < n;j++)
            //             temp[i][j]=actualMatrix[i][j];
            //         // we can't move left side if the "0" is in the first column
            //     if(y!=0)
            //     {
            //         p=temp[x][y];
            //         temp[x][y]=temp[x][y-1];
            //         temp[x][y-1]=p;
            //     }
            //     // calculate the cost of the temp matrix and if the cost is less than previous cost, copy it into resultMatrix
            //     m=calculate(temp,targetMatrix);
            //     minCost=l+m;
            //     if(minCost < d)
            //     {
            //         d=minCost;
            //         for(i=0;i < n;i++)
            //             for(j=0;j < n;j++)
            //                 resultMatrix[i][j]=temp[i][j];
            //     }
            //     System.out.println("Minimum cost : "+d);
            //     // printing the intermediate matrix
            //     System.out.println("\nCalculated Intermediate Matrix Value :\n");
            //     for(i=0;i < n;i++)
            //     {
            //         for(j=0;j < n;j++)
            //           System.out.print(resultMatrix[i][j] + " ");
            //         System.out.println();
            //         System.out.println();
            //     }
            //     System.out.println();
    
            //     for(i=0;i < n;i++)
            //         for(j=0;j < n;j++)
            //         {
            //             actualMatrix[i][j]=resultMatrix[i][j];
            //             temp[i][j]=0;
            //         }
            // }
        } else {
            System.out.println("The above problem is Not Solvable");
        }		
	}
    // method to calculate the cost
	public static int calculate(int[][] temp,int[][] targetMatrix)
	{
		int minCost=0;
		for(int i=0;i < n;i++)
			for(int j=0;j < n;j++)
			{
				if(temp[i][j]!=targetMatrix[i][j])
                    minCost++;
			}
		return minCost;
	}
	// method to check the given matrix with target matrix
	public static int check(int[][] actualMatrix,int[][] targetMatrix)
	{
		int flag=1;
		for(int i=0;i < n;i++)
			for(int j=0;j < n;j++)
				if(actualMatrix[i][j]!=targetMatrix[i][j])
					flag=0;
		return flag;
	}

}