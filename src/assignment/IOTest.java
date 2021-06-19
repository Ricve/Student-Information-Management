package assignment;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class IOTest {

	public static void main(String[] args){
		StuInf inf=new StuInf();
		/*ÃÌº”*/
		inf.addStudent(new Students("Mike",12,"nowhere","123"));
		inf.addStudent(new Students("John",13,"nowhere","1234"));
		inf.addStudent(new Students("Eric",14,"nowhere","1235"));
		inf.addStudent(new Students("Eric",14,"nowhere","1236"));
		
		
		File file =new File("src/data.txt");
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		BufferedWriter bw=null;
		try {
			/*∂¡»Î*/
			if(!file.exists())
				file.createNewFile();
			fileReader=new FileReader(file);
			Scanner in=new Scanner(fileReader);
			while(in.hasNext()) {
				System.out.println(in.nextLine());
			}
//			System.out.println("here");
			/*–¥ªÿ*/
			fileWriter=new FileWriter("src/output.txt");
			bw=new BufferedWriter(fileWriter);
			Students student=null;
			Iterator<Students> it= inf.stuset.iterator();
			while (it.hasNext()) {
				student=it.next();
				bw.write(student.getName());
				bw.write(" ");
				bw.write(Integer.toString(student.getAge()));
				bw.write(" ");
				bw.write(student.getNativePlace()); 
				bw.write(" ");
				bw.write(student.getTelNum());
				bw.newLine();
			}
			bw.flush();
			
			in.close();
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
