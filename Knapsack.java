import java.util.*;  
public class Knapsack  
{  
    // method to get maximum profit  
    private static double getMaxProfit(int[] w, int[] v, int capacity)  
    {  
        // length of the array  
        int size = w.length, i;  
        // array of storing all the items  
        Items[] iValue = new Items[size];  
        for (i = 0; i < size; i++)   
        {  
            // storing the items  
            iValue[i] = new Items(w[i], v[i], i);  
        }  
        // sorting the items on the basis of cost  
        Arrays.sort(iValue, new Comparator<Items>()   
        {  
            @Override  
            public int compare(Items i1, Items i2)  
            {  
                return i2.cost.compareTo(i1.cost);  
            }  
        });  
        System.out.println("After Sorting according to cost: ");
        System.out.print("Weight: ");
        for(i=0; i < size; i++) {
            System.out.print((int)iValue[i].weight + " ");
        }
        System.out.println();
        System.out.print("Profits: ");
        for(i=0; i < size; i++) {
            System.out.print((int)iValue[i].profit + " ");
        }
        System.out.println();
        System.out.println("-----Calculating Maximum Profit-----");
        // contains the maximum profit that is possible   
        // for the given capacity of the knapsack  
        double totalProfit = 0d;  
        for (i = 0; i < size; i++)   
        {  
            // obtaining the current weight and profit of the ith item  
            int currWt = (int)iValue[i].weight;  
            int currVal = (int)iValue[i].profit; 
            System.out.println("Current weight: " + currWt);
            System.out.println("Current profit: " + currVal);
            System.out.println("Capacity of sack before: " + capacity);
            if (capacity - currWt >= 0)   
            {  
                // the current capacity of the knapsack allows the item to be taken as a whole  
                capacity = capacity - currWt;  
                totalProfit = totalProfit + currVal; 
                System.out.println("Capacity of sack after: " + capacity);
                System.out.println("Current profit value in sack: " + totalProfit);

            }  
            else   
            {  
                // when an item can not be picked as a whole we break the item and take a portion of it   
                // such that we get the maximum profit in the knapsack  
                double fraction = ((double)capacity / (double)currWt);  
                totalProfit = totalProfit + (currVal * fraction);  
                capacity = (int)(capacity - (currWt * fraction));  
                System.out.println("Capacity of sack after: " + capacity);
                System.out.println("Fractional profit: " + (currVal * fraction));
                System.out.println("Current profit value in sack: " + totalProfit);
                // the knapsack is full no need to proceed further  
                break;  
            }  
        }  
        System.out.println("-----------------------------------------------");
        return totalProfit;  
    }  
    static class Items   
    {  
        Double cost;  
        double weight, profit, index;  
        // item profit function  
        public Items(int weight, int profit, int index)  
        {  
            this.weight = weight;  
            this.profit = profit;  
            this.index = index;  
            cost = new Double((double)profit / (double)weight);  
        }  
    }   
// main method  
    public static void main(String argvs[])  
    {  
        // input arrays  
        int[] weights = { 2, 3, 5, 7, 1, 4, 1};  
        int[] profits = { 10, 5, 15, 7, 6, 18, 3};  
        // capacity of the knapsack  
        int capacity = 15;  
        System.out.println("Actual input: ");
        System.out.print("Weight: ");
        for(int i=0; i < weights.length; i++) {
            System.out.print(weights[i] + " ");
        }
        System.out.println();
        System.out.print("Values: ");
        for(int i=0; i < weights.length; i++) {
            System.out.print(profits[i] + " ");
        }
        System.out.println();
        double maxProfit = getMaxProfit(weights, profits, capacity);
        // printing the max profit  
        System.out.println("Maximum profit that can be obtained is = " + maxProfit);  
    }  

}  