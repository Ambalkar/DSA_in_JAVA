package DSA_in_JAVA;

import java.util.Scanner;


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
//	public static void main(String[] args) {
//		int n = 5;
//		int num = 1;
//
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print(num + " ");
//				num++;
//			}
//			System.out.println();
//		}
//	}
//}
//	
//	Problem 8: Print reverse of a number by taking number as a input from the user.
//	
//	Solution 8:
//		
//		public static void main(String[] args) {
//			Scanner s = new Scanner(System.in);
//			System.out.println("Enter the number");
//			int num = s.nextInt();
//			while(num>0) {
//				int rev_num=num%10;
//				System.out.print(rev_num);
//				num=num/10;
//			}
//			System.out.println();
//		}
//	}
//		
//	Output:
//		Enter the number
//		45631
//		13654
//	Problem 9: Check if the number entered by the user is prime or not.
	
//	Solution 9:
	
//	public static void main(String[] args) {
//		System.out.println("Enter the number");
//		Scanner s = new Scanner(System.in);
//		int num = s.nextInt();
//		boolean prime = true;
//		if (num <= 1) {
//			prime = false;
//			System.out.println("The number is invalid");
//		} else {
//			for (int i = 2; i <= num / 2; i++) {
//				if (num % i == 0) {
//					prime = false;
//					break;
//				}
//			}
//		}
//		if (prime) {
//			System.out.println("The number is prime");
//		} else {
//			System.out.println("The number is not prime");
//		}
//	}
//}
//	Output: Enter the number
//	8
//	The number is not prime
//
// DSA Topic 1: Array
// Defination: An array is a data structure that can hold a fixed number of values of the same type. It is used to store multiple values in a single variable, instead of declaring separate variables for each value. Arrays are indexed, meaning that each element in the array can be accessed using its index.
// Creating an Arraay:
// int[] arr = new int[5]; // creates an array of integers with a size of 5
// int[] arr = {1, 2, 3, 4, 5}; // creates an array of integers with the specified values
//Operations on Array:
// 1. Insert
// 2. Delete
// 3. Traverse
// 4. Search
// 5. Update
// Taking input from the user and storing it in an array:
// public static void main(String[] args) {
//     Scanner s = new Scanner(System.in);
//     System.out.println("Enter the size of the array");
//     int size = s.nextInt();
//     int[] arr = new int[size];
//     System.out.println("Enter the elements of the array");
//     for (int i = 0; i < size; i++) {
//         arr[i] = s.nextInt();
//     }
//     System.out.println("The elements of the array are:");
//     for (int i = 0; i < size; i++) {
//         System.out.print(arr[i] + " ");
//         }
//     }
// }
// Output:
// Enter the size of the array
// 5
// Enter the elements of the array
// 1 2 3 4 5
// The elements of the array are:
// 1 2 3 4 5
//
//Updating the array using call by reference 
//	public static void Update(int marks[]) {
//		for (int i = 0; i < marks.length; i++) {
//			marks[i] = marks[i] + 1;
//		}
//	}
//
//	public static void main(String[] args) {
//		int marks[] = { 99, 60, 57 };
//		Update(marks);
//		for (int i = 0; i < marks.length; i++) {
//			System.out.print(marks[i]+ " ");
//		}
//		System.out.println();
//	}
//}
	
	
	

