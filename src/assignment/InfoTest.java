package assignment;

public class InfoTest {
	public static void main(String[] args) {
			StuInf inf=new StuInf();
			/*���*/
			inf.addStudent(new Students("Mike",12,"nowhere","123"));
			inf.addStudent(new Students("John",13,"nowhere","1234"));
			inf.addStudent(new Students("Eric",14,"nowhere","1235"));
			inf.addStudent(new Students("Eric",14,"nowhere","1236"));
//			inf.stuset.add(new Students("Mike",12,"nowhere",123));
			
			
			
			/*����*/
			Students tofind=inf.FindStudent("Eric");
			if(tofind!=null) {
				tofind.setAge(0);				
				System.out.println(tofind);
			}
			else
				System.out.println("Not Found");
			
			/*ɾ��*/
//			System.out.println(inf.stuset.size());
//			inf.DeleteStudent("Eric");
			System.out.println(inf.stuset);

			//����HashSetתΪ��ά����
//			Object[][] rowData=new Object[20][4];
//			rowData=inf.SwitchToTable();
//			for (int i= 0;  i< inf.stuset.size(); i++) {
//				for (int j = 0; j < 5; j++) {
//					System.out.print(rowData[i][j]+" ");
//				}
//				System.out.println();
//			}
	}


}

