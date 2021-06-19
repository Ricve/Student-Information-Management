package assignment;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class StudentInfManager {
	public static void main(String[] args) {
		new StuInfFrame();
		
	}
}
@SuppressWarnings("serial")
class StuInfFrame extends JFrame {
	/*��弰���*/
	private JPanel welPanel;//��ӭ�������
	private JButton welButton;//��ӭ������밴ť
	private JPanel mainPanel;//���������
	private JScrollPane scrollPane;
	private JButton addButton;//��Ӱ�ť
	private JButton findButton;//���Ұ�ť
	private JButton changeButton;//�޸İ�ť
	private JButton deleteButton;//ɾ����ť
	private DefaultTableModel model;
	private JTable table;//��������Ϣչʾ��
	private JPanel addPanel;
	private JPanel findPanel;
	private JButton backToMainButton;//���������水ť
	private JTextField nameOfAddPanel;
	private JTextField ageOfAddPanel;
	private JTextField NativeOfAddPanel;
	private JTextField TelOfAddPanel;
	private JButton addStudent;
	private JTextField findTextField;
	private JButton findStudent;
	private JButton changeStudent;
	private JButton deleteStudent;
	private DefaultTableModel resultmodel;
	private JTable resulttable;//��ѯ��Ϣչʾ��
	private JButton backtoMainfromFind;
	private JPanel changePanel;
	private JTextField nameOfchangePanel;
	private JTextField ageOfchangePanel;
	private JTextField nativeOfchangePanel;
	private JTextField telOfchangePanel;
	private JButton confirmChange;
	private JButton backtoMainfromChange;
	/*��Ϣ������*/
	StuInf inf=new StuInf();
	Object[][] rowData;
	Object[][] resultRowData;
	Students temp=null;//��ѯ����ѧ��
	/*���췽��*/
	public StuInfFrame() {
		super("Student Information Management");
		setSize(600, 400);
		
		/*��ӭ����*/
		welPanel=new JPanel();//��ӭ���
		welPanel.setLayout(null);
		add(welPanel,BorderLayout.CENTER);
		welButton=new JButton("����ϵͳ");
		JLabel weLabel=new JLabel("��ӭ����ѧ����Ϣ����ϵͳ");//��ӭ����Label
		weLabel.setFont(new Font("΢���ź�", Font.BOLD, 30));
		weLabel.setBounds(100, 50, 400, 100);
		welButton.setBounds(250, 280, 100, 30);
		welPanel.add(weLabel);//���Label�����
		welPanel.add(welButton);//���Button�����
		welButton.addActionListener(new MyActionListener());//��Ӽ���������ť
		
		/*������*/
		mainPanel=new JPanel();
//		mainPanel.setBackground(Color.black);
		mainPanel.setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
//		JPanel downPanel=new JPanel();
//		topPanel.setBackground(Color.cyan);
//		downPanel.setBackground(Color.blue);
		mainPanel.add(topPanel,BorderLayout.NORTH);
//		mainPanel.add(downPanel,BorderLayout.CENTER);
		
		
		addButton=new JButton("���ѧ��");
		findButton=new JButton("����ѧ��");
		changeButton=new JButton("������Ϣ");
		deleteButton=new JButton("ɾ��ѧ��");
		topPanel.add(addButton);
		topPanel.add(findButton);
		topPanel.add(changeButton);
		topPanel.add(deleteButton);
		
		inf.readFromTxt();
//		inf.addStudent(new Students("Mike",12,"nowhere","123"));
//		inf.addStudent(new Students("John",13,"nowhere","1234"));
//		inf.addStudent(new Students("Eri",14,"nowhere","1245"));
//		inf.addStudent(new Students("Er",14,"nowhere","1236"));
//		inf.addStudent(new Students("MiK",12,"nowhere","123"));
//		inf.addStudent(new Students("Joh",13,"nowhere","1234"));
//		inf.addStudent(new Students("E",14,"nowhere","1235"));
//		inf.addStudent(new Students("Err",14,"nowhere","1236"));
//		inf.addStudent(new Students("Mi",12,"nowhere","123"));
//		inf.addStudent(new Students("Jo",13,"nowhere","1234"));
//		inf.addStudent(new Students("Eee",14,"nowhere","1235"));
//		inf.addStudent(new Students("Erdc",14,"nowhere","1236"));
//		inf.addStudent(new Students("Mis",12,"nowhere","123"));
//		inf.addStudent(new Students("J",13,"nowhere","1234"));
//		inf.addStudent(new Students("Eer",14,"nowhere","1235"));
//		inf.addStudent(new Students("Ec",14,"nowhere","1236"));

		rowData=inf.SwitchToTable();
		String[] columnNames = {"���", "����", "����", "����", "�绰����"};
        // ����һ�����ָ�� ��ͷ �� ����������
		model = new DefaultTableModel(rowData, columnNames);//
		table = new JTable(model){//�˴���дEditable��������Ϊ���ܱ༭
			@Override
            public boolean isCellEditable(int rowIndex, int ColIndex){
            	return false;
            }
		};
		  // ���ñ��������ɫ
        table.setForeground(Color.BLACK);// ������ɫ
        table.setFont(new Font(null, Font.PLAIN, 14));// ������ʽ
        table.setSelectionForeground(Color.DARK_GRAY);// ѡ�к�������ɫ
        table.setSelectionBackground(Color.LIGHT_GRAY);// ѡ�к����屳��
        table.setGridColor(Color.GRAY);// ������ɫ

        // ���ñ�ͷ
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));// ���ñ�ͷ����������ʽ
        table.getTableHeader().setForeground(Color.BLACK);// ���ñ�ͷ����������ɫ
        table.getTableHeader().setResizingAllowed(false);// ���ò������ֶ��ı��п�
        table.getTableHeader().setReorderingAllowed(false);// ���ò������϶������������

        // �����и�
        table.setRowHeight(30);
        // ��һ���п�����Ϊ40
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        // ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
		// �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
        scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane,BorderLayout.CENTER);//��ӹ�����嵽 ���������
//        downPanel.add(scrollPane);
		
        addButton.addActionListener(new MyActionListener());
        findButton.addActionListener(new MyActionListener());
        changeButton.addActionListener(new MyActionListener());
        deleteButton.addActionListener(new MyActionListener());
		addPanel=new JPanel();
		findPanel=new JPanel();
		
		
		/*���ѧ������*/
		backToMainButton=new JButton("����");
		addStudent=new JButton("���");
		addStudent.addActionListener(new MyActionListener());
		backToMainButton.addActionListener(new MyActionListener());
		addPanel.setLayout(null);
		addPanel.add(backToMainButton);
		addPanel.add(addStudent);
		backToMainButton.setBounds(410, 230, 80, 40);
		addStudent.setBounds(110, 230, 80, 40);
		
		JLabel addPanelLabel=new JLabel("������Ҫ���ѧ������Ϣ");//��ӭ����Label
		addPanelLabel.setFont(new Font("����", Font.BOLD, 20));
		addPanel.add(addPanelLabel);
		addPanelLabel.setBounds(180, 0, 400, 80);
		
		JLabel nameLabel=new JLabel("����");//��ӭ����Label
		nameLabel.setFont(new Font("����", Font.BOLD, 15));
		addPanel.add(nameLabel);
		nameLabel.setBounds(73, 100, 40, 30);
		
		JLabel ageLabel=new JLabel("����");
		ageLabel.setFont(new Font("����", Font.BOLD, 15));
		addPanel.add(ageLabel);
		ageLabel.setBounds(211,100, 40, 30);
		
		JLabel NativeLabel=new JLabel("����");
		NativeLabel.setFont(new Font("����", Font.BOLD, 15));
		addPanel.add(NativeLabel);
		NativeLabel.setBounds(331,100, 40, 30);
		
		JLabel TelLabel=new JLabel("�绰");
		TelLabel.setFont(new Font("����", Font.BOLD, 15));
		addPanel.add(TelLabel);
		TelLabel.setBounds(469,100, 40, 30);
		
		nameOfAddPanel=new JTextField(10);
		nameOfAddPanel.setBounds(48, 130, 90, 30);
		addPanel.add(nameOfAddPanel);
		
		ageOfAddPanel=new JTextField(10);
		ageOfAddPanel.setBounds(186, 130, 90, 30);
		addPanel.add(ageOfAddPanel);
		
		NativeOfAddPanel=new JTextField(10);
		NativeOfAddPanel.setBounds(306, 130, 90, 30);
		addPanel.add(NativeOfAddPanel);
		
		TelOfAddPanel=new JTextField(10);
		TelOfAddPanel.setBounds(444, 130, 90, 30);
		addPanel.add(TelOfAddPanel);
		
		/*����ѧ������*/
		findTextField=new JTextField(10);
		findPanel.add(new JLabel("ѧ������:"),BorderLayout.NORTH);
		findPanel.add(findTextField,BorderLayout.NORTH);
		
		findStudent=new JButton("����ѧ��");
		findStudent.addActionListener(new MyActionListener());
		findStudent.setPreferredSize(new Dimension(85,25));
		findPanel.add(findStudent,BorderLayout.NORTH);
		
		changeStudent=new JButton("������Ϣ");
		changeStudent.addActionListener(new MyActionListener());
		changeStudent.setPreferredSize(new Dimension(85,25));
		findPanel.add(changeStudent,BorderLayout.NORTH);
		
		deleteStudent=new JButton("ɾ��ѧ��");
		deleteStudent.addActionListener(new MyActionListener());
		deleteStudent.setPreferredSize(new Dimension(85,25));
		findPanel.add(deleteStudent,BorderLayout.NORTH);
		
		backtoMainfromFind=new JButton("����");
		backtoMainfromFind.addActionListener(new MyActionListener());
		backtoMainfromFind.setPreferredSize(new Dimension(85,25));
		findPanel.add(backtoMainfromFind,BorderLayout.NORTH);
		/*���ҽ�����*/
		String[] findpanelcolumnNames = {"����", "����", "����", "�绰����"};
		resultRowData=new Object[1][4];
		for (int i = 0; i < 4; i++) {
			resultRowData[0][i]="";
		}
		resultmodel = new DefaultTableModel(resultRowData, findpanelcolumnNames);
		resulttable = new JTable(resultmodel){//�˴���дEditable��������Ϊ���ܱ༭
			@Override
            public boolean isCellEditable(int rowIndex, int ColIndex){
            	return false;
            }
		};
				/*��ѯ����������*/
		// ���ñ��������ɫ
        resulttable.setForeground(Color.BLACK);// ������ɫ
        resulttable.setFont(new Font(null, Font.PLAIN, 14));// ������ʽ
        resulttable.setSelectionForeground(Color.DARK_GRAY);// ѡ�к�������ɫ
        resulttable.setSelectionBackground(Color.LIGHT_GRAY);// ѡ�к����屳��
        resulttable.setGridColor(Color.GRAY);// ������ɫ

        // ���ñ�ͷ
        resulttable.getTableHeader().setFont(new Font(null, Font.BOLD, 14));// ���ñ�ͷ����������ʽ
        resulttable.getTableHeader().setForeground(Color.BLACK);// ���ñ�ͷ����������ɫ
        resulttable.getTableHeader().setResizingAllowed(false);// ���ò������ֶ��ı��п�
        resulttable.getTableHeader().setReorderingAllowed(false);// ���ò������϶������������

        // �����и�
        resulttable.setRowHeight(30);
        // ��һ���п�����Ϊ40
        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
        
		findPanel.add(resulttable.getTableHeader(), BorderLayout.CENTER);
	    findPanel.add(resulttable, BorderLayout.CENTER);
	    
	    /*�޸�ѧ������*/
	    changePanel=new JPanel();
	    backtoMainfromChange=new JButton("����");
		confirmChange=new JButton("�޸�");
		confirmChange.addActionListener(new MyActionListener());
		backtoMainfromChange.addActionListener(new MyActionListener());
		changePanel.setLayout(null);
		changePanel.add(backtoMainfromChange);
		changePanel.add(confirmChange);
		backtoMainfromChange.setBounds(410, 230, 80, 40);
		confirmChange.setBounds(110, 230, 80, 40);
		
		JLabel changePanelLabel=new JLabel("�������޸�ѧ������Ϣ");//��ӭ����Label
		changePanelLabel.setFont(new Font("����", Font.BOLD, 20));
		changePanel.add(changePanelLabel);
		changePanelLabel.setBounds(180, 0, 400, 80);
		
		JLabel nameLabel2=new JLabel("����");//��ӭ����Label
		nameLabel2.setFont(new Font("����", Font.BOLD, 15));
		changePanel.add(nameLabel2);
		nameLabel2.setBounds(73, 100, 40, 30);
		
		JLabel ageLabel2=new JLabel("����");
		ageLabel2.setFont(new Font("����", Font.BOLD, 15));
		changePanel.add(ageLabel2);
		ageLabel2.setBounds(211,100, 40, 30);
		
		JLabel NativeLabel2=new JLabel("����");
		NativeLabel2.setFont(new Font("����", Font.BOLD, 15));
		changePanel.add(NativeLabel2);
		NativeLabel2.setBounds(331,100, 40, 30);
		
		JLabel TelLabel2=new JLabel("�绰");
		TelLabel2.setFont(new Font("����", Font.BOLD, 15));
		changePanel.add(TelLabel2);
		TelLabel2.setBounds(469,100, 40, 30);
		
		nameOfchangePanel=new JTextField(10);
		nameOfchangePanel.setBounds(48, 130, 90, 30);
		changePanel.add(nameOfchangePanel);
		
		ageOfchangePanel=new JTextField(10);
		ageOfchangePanel.setBounds(186, 130, 90, 30);
		changePanel.add(ageOfchangePanel);
		
		nativeOfchangePanel=new JTextField(10);
		nativeOfchangePanel.setBounds(306, 130, 90, 30);
		changePanel.add(nativeOfchangePanel);
		
		telOfchangePanel=new JTextField(10);
		telOfchangePanel.setBounds(444, 130, 90, 30);
		changePanel.add(telOfchangePanel);
		
		
		
		/*��������*/
		setResizable(false);//���ɸı䴰�ڴ�С
		setLocationRelativeTo(null);//������ʾ
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source==welButton) {
				changeContentPane(mainPanel);
			}else if(source==addButton) {
				changeContentPane(addPanel);
			}else if(source==findButton ||source==changeButton|| source==deleteButton) {
				changeContentPane(findPanel);
			}else if(source==backToMainButton||source==backtoMainfromFind||source==backtoMainfromChange) {
				changeContentPane(mainPanel);
			}else if(source==addStudent) {//���ѧ��������Ӱ�ť
				new JOptionPane();
				if(nameOfAddPanel.getText().equals("") || ageOfAddPanel.getText().equals("") || NativeOfAddPanel.getText().equals("") || TelOfAddPanel.getText().equals("")) {
					JOptionPane.showMessageDialog(addPanel,"ѧ����Ϣ����Ϊ�գ�","����",JOptionPane.WARNING_MESSAGE);
				}else {
					System.out.println(inf.stuset.size());
					inf.addStudent(new Students(nameOfAddPanel.getText(),Integer.parseInt(ageOfAddPanel.getText()),NativeOfAddPanel.getText(),TelOfAddPanel.getText()));
					System.out.println(inf.stuset.size());
					rowData=inf.SwitchToTable();
	//				for (int i= 0;  i< inf.stuset.size(); i++) {
	//					for (int j = 0; j < 5; j++) {
	//						System.out.print(rowData[i][j]+" ");
	//					}
	//					System.out.println();
	//				}
					reTable();//����ػ�
					inf.saveAsTxt();//��ʱ������txt
					JOptionPane.showMessageDialog(addPanel, "ѧ����Ϣ��ӳɹ���","��ӳɹ�",JOptionPane.INFORMATION_MESSAGE);
					nameOfAddPanel.setText("");
					ageOfAddPanel.setText("");
					NativeOfAddPanel.setText("");
					TelOfAddPanel.setText("");
					changeContentPane(mainPanel);
				}
			}else if(source==findStudent) {//������� ���Ұ�ť
				temp=inf.FindStudent(findTextField.getText());
				if(temp==null) {
					JOptionPane.showMessageDialog(findPanel,"��ѧ�������ڣ�","����",JOptionPane.WARNING_MESSAGE);
				}else {
					String[] findpanelcolumnNames = {"����", "����", "����", "�绰����"};
					inf.UpdateResult(resultRowData, temp);
					resultmodel.setDataVector(resultRowData, findpanelcolumnNames);
					resultmodel.fireTableDataChanged();
			        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
				}
			}else if(source==changeStudent) {//������� ���İ�ť
				if(temp==null) {
					JOptionPane.showMessageDialog(findPanel,"δȷ��Ҫ���ĵ�ѧ�������Ȳ��ң�","����",JOptionPane.WARNING_MESSAGE);
				}else {
					changeContentPane(changePanel);
				}
				
			}else if(source==deleteStudent) {//������� ɾ����ť
				if(temp==null) {
					JOptionPane.showMessageDialog(findPanel,"δȷ��Ҫɾ����ѧ�������Ȳ��ң�","����",JOptionPane.WARNING_MESSAGE);
				}
				inf.DeleteStudent(temp.getName());//����ɾ������
				inf.saveAsTxt();//��ʱ������txt
				/*��ղ�ѯ��������򼰱��*/
				findTextField.setText("");
				JOptionPane.showMessageDialog(findPanel, "ѧ����Ϣɾ���ɹ���","ɾ���ɹ�",JOptionPane.INFORMATION_MESSAGE);
				temp=null;
				String[] findpanelcolumnNames = {"����", "����", "����", "�绰����"};
				inf.UpdateResult(resultRowData, temp);
				resultmodel.setDataVector(resultRowData, findpanelcolumnNames);
				resultmodel.fireTableDataChanged();
		        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
				/*������������*/
				rowData=inf.SwitchToTable();
				reTable();
//				changeContentPane(mainPanel);
			}else if(source==confirmChange) {//���ý��� ȷ�ϰ�ť
				if(nameOfchangePanel.getText().equals("") || ageOfchangePanel.getText().equals("") || nativeOfchangePanel.getText().equals("") || telOfchangePanel.getText().equals("")) {
					JOptionPane.showMessageDialog(changePanel,"�޸�ѧ����ϢΪ�գ�","����",JOptionPane.WARNING_MESSAGE);
				}else{
			        /*��ȡ�޸Ľ�����Ϣ*/
					temp.setName(nameOfchangePanel.getText());
					temp.setAge(Integer.parseInt(ageOfchangePanel.getText()));
					temp.setNativePlace(nativeOfchangePanel.getText());
					temp.setTelNum(telOfchangePanel.getText());
					rowData=inf.SwitchToTable();
					inf.saveAsTxt();//��ʱ������txt�ļ�
					reTable();
					JOptionPane.showMessageDialog(changePanel, "ѧ����Ϣ�޸ĳɹ���","�޸ĳɹ�",JOptionPane.INFORMATION_MESSAGE);
					/*����޸Ľ��������*/
					nameOfchangePanel.setText("");
					ageOfchangePanel.setText("");
					nativeOfchangePanel.setText("");
					telOfchangePanel.setText("");
					/*��ղ�ѯ��������򼰱��*/
					findTextField.setText("");
					temp=null;
					String[] findpanelcolumnNames = {"����", "����", "����", "�绰����"};
					inf.UpdateResult(resultRowData, temp);
					resultmodel.setDataVector(resultRowData, findpanelcolumnNames);
					resultmodel.fireTableDataChanged();
			        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
					
			        changeContentPane(mainPanel);
				}
			}
		}
	}
	public void reTable() {
		String[] columnNames = {"���", "����", "����", "����", "�绰����"};
        // ����һ�����ָ�� ��ͷ �� ����������
		// ����ץȡmodel
//		DefaultTableModel tModel = new DefaultTableModel(rowData,columnNames); 
		// Ӧ��model��table
//		table = new JTable(tModel){
//	         public boolean isCellEditable(int rowIndex, int ColIndex){
//	            	return false;
//	         }
//		};

		// ���������ť�����¼�����setDataVector()����������Model������
		model.setDataVector(rowData, columnNames);
		model.fireTableDataChanged();
		System.out.println("here");
	}
	
    public void changeContentPane(Container contentPane) {//�л����
        this.setContentPane(contentPane);
        this.revalidate();
    }
}
