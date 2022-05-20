import java.io.*;

class SubstringMatching
{
    public static int searchString(String s,int sIndex, String s1, int s1Index) {
        int len1;
        len1 = s1.length(); // length of the string to be searched
    
        if(s1Index == len1) {
            return sIndex - len1;  // base condition
        } 
        if(s.charAt(sIndex) == s1.charAt(s1Index)) {
            // will come here if the character matches and will increment both the indices
            return searchString(s, ++sIndex, s1, ++s1Index);
        } else {
            // will come here if the characters dont match and will increment the sIndex but reset the s1Index to 0
            return searchString(s, ++sIndex, s1, 0);
        }
    }
	public static void main(String[] args)
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String s1;
		String s = new String();
		try
		{
            System.out.println("Enter the string : ");
            s = br.readLine();
            System.out.println("Enter the text to search : ");
            s1 = br.readLine();
            if(s.length() < s1.length()) {
                // if the substring's length greater than the original string
                System.out.println("The substring is greater than the original string!");
                return;
            }
            if(s1.length() == 0) {
                // if the substring is empty
                System.out.println("Please enter the substring to be searched!");
                return;
            }
            if(s.contains(s1)) { 
                // check whether the s1 is present in s
                int index = SubstringMatching.searchString(s,0,s1,0);
                if(index != -1) {
                    System.out.println("First occurrence of " + s1 + " is at index: " + index);
                }
            }
            else
                System.out.println("The entered string is not present!!");
			
		}
		catch(IOException e)
		{}
	}
    
	
}