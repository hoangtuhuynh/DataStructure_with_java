/**
 * 
 */
package edu.cpp.cs2400.structures.hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class Login {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		String un = sc.nextLine();
		
		Scanner pwf = new Scanner(new File(un+".pw"));
		
		System.out.println();
	}

}
