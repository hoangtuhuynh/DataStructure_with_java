/**
 * 
 */
package edu.cpp.cs2400.structures.hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class CreatePassword {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		String un = sc.nextLine();
		System.out.println("Enter Password:");
		String pwd = sc.nextLine();
		
		File file = new File(un + ".pw");
		PrintWriter pw = new PrintWriter(file);
		
		char[] chars = pwd.toCharArray();
		
		for(char c : chars) {
			pw.write(c+42);
		}
		
		pw.println();
		
		pw.close();
	}

}
