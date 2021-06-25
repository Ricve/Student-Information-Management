package assignment;

import java.io.*;
import java.util.*;

public class StuInf{
	public HashSet<Students> stuset;
	public StuInf() {
		stuset=new HashSet<Students>();
	}
	public void addStudent(Students stu) {//添加学生
		stuset.add(stu);
	}
	public Students FindStudent(String name) {//按Name查找学生
		Students student =null;
		boolean found=false;
		Iterator<Students> it= stuset.iterator();
		while (it.hasNext()) {
			student=it.next();
			if(student.getName().equals(name)) {
				found=true;
				break;
			}
		}
		if(found)
			return student;
		else
			return null;
	}
	public void DeleteStudent(String name) {
		Students toDelete =FindStudent(name);
		if(toDelete!=null)
			stuset.remove(toDelete);
	}
	public Object[][] SwitchToTable() {//将哈希表转换为二维数组以供JTable使用
		Object[][] rowData=new Object[stuset.size()][5];
		Students student =null;
		Iterator<Students> it= stuset.iterator();
		for (int i = 0; it.hasNext(); i++) {
			student=it.next();
			rowData[i][0]=i+1;
			rowData[i][1]=student.getName();
			rowData[i][2]=student.getAge();
			rowData[i][3]=student.getNativePlace();
			rowData[i][4]=student.getTelNum();
		}
		return rowData;
	}
	public void UpdateResult(Object[][]data,Students student) {
		if(student==null) {
			data[0][0]="";
			data[0][1]="";
			data[0][2]="";
			data[0][3]="";
		}else {
			data[0][0]=student.getName();
			data[0][1]=student.getAge();
			data[0][2]=student.getNativePlace();
			data[0][3]=student.getTelNum();			
		}
	}
	/*读入*/
	public void readFromTxt() {
		File file =new File("src/data.txt");
		FileReader fileReader=null;
		try {
			if(!file.exists())
				file.createNewFile();
			fileReader=new FileReader(file);
			Scanner in=new Scanner(fileReader);
			while(in.hasNext()) {
				addStudent(new Students(in.next(),in.nextInt(),in.next(),in.next()));
			}
			in.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void saveAsTxt() {/*写回*/
		FileWriter fileWriter=null;
		BufferedWriter bw=null;
		try {
			fileWriter=new FileWriter("src/data.txt");
			bw=new BufferedWriter(fileWriter);
			Students student=null;
			Iterator<Students> it=stuset.iterator();
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
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
class Students {
	private String Name;
	private int Age;
	private String NativePlace;
	private String TelNum;
	public Students() {}
	public Students(String name, int age, String nativePlace, String telNum) {
		super();
		Name = name;
		Age = age;
		NativePlace = nativePlace;
		TelNum = telNum;
	}
	
	@Override
	public String toString() {
		return "Name:"+Name+" Age:"+Age+" Native:"+NativePlace+" Tel:"+TelNum;
	}
	/*重写了haseCode和equals，此处认为仅Name相同时即两对象相同*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getNativePlace() {
		return NativePlace;
	}
	public void setNativePlace(String nativePlace) {
		NativePlace = nativePlace;
	}
	public String getTelNum() {
		return TelNum;
	}
	public void setTelNum(String telNum) {
		TelNum = telNum;
	}
	
	
}
