package assignment;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class IOTest {

	public static void main(String[] args){
		StuInf inf=new StuInf();
		/*Ìí¼Ó*/
//		inf.addStudent(new Students("Mike",12,"nowhere","123"));
//		inf.addStudent(new Students("John",13,"nowhere","1234"));
//		inf.addStudent(new Students("Eric",14,"nowhere","1235"));
//		inf.addStudent(new Students("Eric",14,"nowhere","1236"));
//		readFromTxt(inf);
//		saveAsTxt(inf);
		inf.readFromTxt();
		inf.saveAsTxt();

	}

}
