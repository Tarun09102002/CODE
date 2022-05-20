import java.util.*;
 
class SubsetHelper{
  int set[];
  int sum;

  Stack<Integer> finalSubset;
  boolean hasSolution;
  
  SubsetHelper(int set[], int sum){
      this.set = set;
      this.sum = sum;
      this.finalSubset = new Stack<>();
      hasSolution = false;
  }
  
  public void solve(int tempSum, int index){   
    //return false if s value exceed sum
    if(tempSum>sum)
        return;
 
    //check if stack has the right subsets of numbers
    if(tempSum==sum){
        hasSolution = true;
 
        //display stack contents
        displayFinalSubsets();
 
        //Though found a solution but deliberately returning to find more
        return;
    }
        
    for(int i=index; i<set.length; i++){
        //Adding element to the stack
        finalSubset.push(set[i]);
 
        //add set[i] to the 's' and recusively start from next number
        solve(tempSum+set[i],i+1);
 
        //Removing element from stack i.e Backtracking
        finalSubset.pop();
    }

  }
  
  //Function to display stack content
  private void displayFinalSubsets(){
    for (Integer item: finalSubset){
      System.out.print(item+" ");
    }
        System.out.println();
  }
   
}
 
public class Subset
{
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of elements: ");
            int n = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the elements one by one: ");
            int set[] = new int[n];
            for(int i = 0; i < n; i++) {
                set[i] = sc.nextInt();
                sc.nextLine();
            }
            System.out.println("Enter the sum: ");
            int sum = sc.nextInt();
            sc.nextLine();

            SubsetHelper helper = new SubsetHelper(set, sum);
            helper.solve(0,0);
            
            if(helper.hasSolution == false) {
                System.out.print("No Solution");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}