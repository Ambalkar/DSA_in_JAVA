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
//	public static void main(String[] args) {
//		int n=5;
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				System.out.print("*_");
//			}
//			System.out.println();
//		}
//	}
//		
//}     
//	
	
//	Problem 6: Print X pattern
//	*     *
//	  * *
//	   *
//	  * *
//	*     *
//	   
//	
//	Solution 6:
	

//	public static void main(String[] args) {
//		int n = 5;
//		for (int row = 1; row <= n; row++) {
//			for (int col = 1; col <= n; col++) {
//				if (col - row == 0 || col + row == n + 1) {
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
//	}
//}
	
//	Problem 7: Print Floyd's Triangle
//	
//	1
//	2 3
//	4 5 6
//	7 8 9 10
//	11 12 13 14 15
	
//	
//	Solution 7:
//		
//	
	public static void main(String[] args) {
		int n = 5;
		int num = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
	}
}