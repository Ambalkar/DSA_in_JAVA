package DSA_in_JAVA;

public class All_Problem_File {

	
//	 //Problem 1: print star pattern 
//	
//	*
//	**
//	***
//	****
//	 
//	 
//		// Solution 1:
//		public static void main(String[] args) {
//			for (int line = 0; line <= 4; line++) {
//				for (int star = 0; star <= line; star++) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
//		}
//
//	}
// 
//
// 	//Problem 2: inverted star pattern
// 
// 
// ****
// ***
// **
// *
// 
//	  //Solution 2:
//	  
	public static void main(String[] args) {
		int n=4;
		for(int line=1;line<=n;line++) {
			for(int star =1;star<=n-line+1;star++) {
				System.out.print("*");
			}
		System.out.println();
		
		}
		
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	