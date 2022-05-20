import java.util.*;
public class SetCover {
    
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in universal set: ");
        int univSize = sc.nextInt();
        System.out.println();
        ArrayList<Integer> universalSet = new ArrayList<>();
        System.out.println("Enter the elements of the universal subset");
        for(int i=0; i<univSize; i++){
            universalSet.add(sc.nextInt());
        }
        System.out.print("Enter the number of subsets: ");
        int numOfSubsets = sc.nextInt();
        System.out.println();
        //create an array list of array lost to store the subsets
        ArrayList<ArrayList> subsets = new ArrayList<>();
        ArrayList<Integer> costs = new ArrayList<>();
        Map<ArrayList,Integer> subsetCostMap = new HashMap<>();

        for(int i=0; i<numOfSubsets; i++){
            System.out.print("Enter the size of subset "+(i+1) + ": ");
            int x = sc.nextInt();
            System.out.println();
            ArrayList<Integer> subset = new ArrayList<>();
            System.out.println("Enter the elements of subset "+(i+1) + ": ");
            for(int j=0; j<x; j++){
                subset.add(sc.nextInt());
            }
            System.out.print("Enter the cost of subset "+(i+1) + ": ");
            int c = sc.nextInt();
            System.out.println();
            costs.add(c);
            subsets.add(subset);
            subsetCostMap.put(subset, c);
        }
        ArrayList<String> answer = new ArrayList<>();
        SetCover obj = new SetCover();
        int cost=0;
        while (!universalSet.isEmpty()){
            //while loop to continue till the universal set is not empty
            ArrayList<Integer> s = new ArrayList<>();
            int index = obj.minCostSet(subsets, subsetCostMap);
            //add all the elements of the subset with minimum cost into s
            s.addAll(subsets.get(index));
            answer.add("s"+(index+1));
            cost+=subsetCostMap.get(s);
            for(int i=0; i<subsets.size(); i++){
                subsetCostMap.remove(subsets.get(i));
            }
            for(int j=0;j<s.size();j++){
                //remove all the elements of the selected subset from the universal set
                universalSet.remove(Integer.valueOf(s.get(j)));
                for(int x=0; x<subsets.size(); x++){
                    //remove all the elements of the selected subset from the other sets
                    subsets.get(x).remove(Integer.valueOf(s.get(j)));
                }
            }
            for(int i=0; i<subsets.size(); i++){
                subsetCostMap.put(subsets.get(i), costs.get(i));
            }
        }
        System.out.println("Cost = "+cost);
        System.out.println(answer);
    }

    //function to calculate the subset with minimum cost
    public int minCostSet(ArrayList<ArrayList> set, Map<ArrayList, Integer> subsetCostMap){
        int minCost = Integer.MAX_VALUE;
        int index=-1;
        for(int i = 0; i< set.size(); i++){
            if(! set.get(i).isEmpty()) { // Only run when the subset is not empty
                //calculate the each subset cost
                int cost = subsetCostMap.get(set.get(i))/set.get(i).size();
                if(cost<minCost){
                    minCost=cost;
                    index=i;
                }
            }
        }
        //return the set with the minimum cost
        return index;
    }
}