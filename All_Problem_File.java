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
//	public static void main(String[] args) {
//		int n=4;
//		for(int line=1;line<=n;line++) {
//			for(int star =1;star<=n-line+1;star++) {
//				System.out.print("*");
//			}
//		System.out.println();
//		
//		}
//		
//	}
//}	
//
//		Problem 3: Print Half pyramid pattern
//	1
//	12
//	123
//	1234
//	
//	
//		Solution 3:
//
//	public static void main(String[] args) {
//		for(int line = 1; line<=4; line++) {
//			for(int number = 1; number<=line; number++) {
//				System.out.print(number);
//			}
//			System.out.println();
//		}
//			
//	}
//
//}
//		Problem 4: Print Character Pattern
//	 A
//	 BC
//	 DEF
//	 GHIJ
//	 
//	
//		Solution 4: 
//	
//	public static void main(String[] args) {
//		int n = 4;
//		char ch = 'A';
//		for(int line = 1; line<=n;line++) {
//			for(int chars =1; chars<=line; chars++) {
//				System.out.print(ch);
//				ch++;
//			}
//			System.out.println();
//		}
//	}
//	
//}
	
//	Problem 5: Print Square Pattern using star(*) and space(_)
//	*_*_*_*_*_
//	*_*_*_*_*_
//	*_*_*_*_*_
//	*_*_*_*_*_
//	*_*_*_*_*_
//	
//	Solution 5: 
	public static void main(String[] args) {
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print("*_");
			}
			System.out.println();
		}
	}
		
}     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	