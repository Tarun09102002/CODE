import java.util.Scanner;

class KMP {
	static void matchPattern(String pattern, String ogString)
	{
		int n = ogString.length();
		int m = pattern.length();

		// create lps[] that will hold the longest prefix suffix values for pattern
		int lps[] = new int[m];
		int j = 0; // index for pattern
		boolean flag = false;
		// Preprocess the pattern (calculate lps[] array)
		preProcessLPS(pattern, m, lps);
		for(int i=0; i < lps.length; i++) {
			System.out.println(lps[i]);
		}
		int i = 0; // index for ogString
		while (i < n) {
			if (pattern.charAt(j) == ogString.charAt(i)) {
				j++;
				i++;
			}
			if (j == m) {
				System.out.println("Pattern found "+ "at index " + (i - j));
				j = lps[j - 1];
				flag = true;
			}
			// mismatch after j matches
			else if (i < n && pattern.charAt(j) != ogString.charAt(i)) {
				// Do not match lps[0..lps[j-1]] characters, they will match anyway
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		if(!flag) {
			System.out.println("No matching pattern found in the string!");
		}
	}

	static void preProcessLPS(String pattern, int m, int lps[])
	{
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to m-1
		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else 
			{
				if (len != 0) {
					len = lps[len - 1];
				}
				else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
        
	}

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the original string: ");
        String originalString = sc.nextLine();
        System.out.println("Enter the pattern: ");
        String pattern = sc.nextLine();
		matchPattern(pattern, originalString);
	}
}
