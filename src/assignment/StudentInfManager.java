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
	/*面板及组件*/
	private JPanel welPanel;//欢迎界面面板
	private JButton welButton;//欢迎界面进入按钮
	private JPanel mainPanel;//主界面面板
	private JScrollPane scrollPane;
	private JButton addButton;//添加按钮
	private JButton findButton;//查找按钮
	private JButton changeButton;//修改按钮
	private JButton deleteButton;//删除按钮
	private DefaultTableModel model;
	private JTable table;//主界面信息展示表
	private JPanel addPanel;
	private JPanel findPanel;
	private JButton backToMainButton;//返回主界面按钮
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
	private JTable resulttable;//查询信息展示表
	private JButton backtoMainfromFind;
	private JPanel changePanel;
	private JTextField nameOfchangePanel;
	private JTextField ageOfchangePanel;
	private JTextField nativeOfchangePanel;
	private JTextField telOfchangePanel;
	private JButton confirmChange;
	private JButton backtoMainfromChange;
	/*信息管理集合*/
	StuInf inf=new StuInf();
	Object[][] rowData;
	Object[][] resultRowData;
	Students temp=null;//查询到的学生
	/*构造方法*/
	public StuInfFrame() {
		super("Student Information Management");
		setSize(600, 400);
		
		/*欢迎界面*/
		welPanel=new JPanel();//欢迎面板
		welPanel.setLayout(null);
		add(welPanel,BorderLayout.CENTER);
		welButton=new JButton("进入系统");
		JLabel weLabel=new JLabel("欢迎来到学生信息管理系统");//欢迎界面Label
		weLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
		weLabel.setBounds(100, 50, 400, 100);
		welButton.setBounds(250, 280, 100, 30);
		welPanel.add(weLabel);//添加Label至面板
		welPanel.add(welButton);//添加Button至面板
		welButton.addActionListener(new MyActionListener());//添加监听器至按钮
		
		/*主界面*/
		mainPanel=new JPanel();
//		mainPanel.setBackground(Color.black);
		mainPanel.setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
//		JPanel downPanel=new JPanel();
//		topPanel.setBackground(Color.cyan);
//		downPanel.setBackground(Color.blue);
		mainPanel.add(topPanel,BorderLayout.NORTH);
//		mainPanel.add(downPanel,BorderLayout.CENTER);
		
		
		addButton=new JButton("添加学生");
		findButton=new JButton("查找学生");
		changeButton=new JButton("更改信息");
		deleteButton=new JButton("删除学生");
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
		String[] columnNames = {"序号", "姓名", "年龄", "籍贯", "电话号码"};
        // 创建一个表格，指定 表头 和 所有行数据
		model = new DefaultTableModel(rowData, columnNames);//
		table = new JTable(model){//此处重写Editable方法，改为不能编辑
			@Override
            public boolean isCellEditable(int rowIndex, int ColIndex){
            	return false;
            }
		};
		  // 设置表格内容颜色
        table.setForeground(Color.BLACK);// 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));// 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);// 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);// 选中后字体背景
        table.setGridColor(Color.GRAY);// 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));// 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.BLACK);// 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(false);// 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);// 设置不允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(30);
        // 第一列列宽设置为40
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
		// 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane,BorderLayout.CENTER);//添加滚动面板到 主界面面板
//        downPanel.add(scrollPane);
		
        addButton.addActionListener(new MyActionListener());
        findButton.addActionListener(new MyActionListener());
        changeButton.addActionListener(new MyActionListener());
        deleteButton.addActionListener(new MyActionListener());
		addPanel=new JPanel();
		findPanel=new JPanel();
		
		
		/*添加学生界面*/
		backToMainButton=new JButton("返回");
		addStudent=new JButton("添加");
		addStudent.addActionListener(new MyActionListener());
		backToMainButton.addActionListener(new MyActionListener());
		addPanel.setLayout(null);
		addPanel.add(backToMainButton);
		addPanel.add(addStudent);
		backToMainButton.setBounds(410, 230, 80, 40);
		addStudent.setBounds(110, 230, 80, 40);
		
		JLabel addPanelLabel=new JLabel("请输入要添加学生的信息");//欢迎界面Label
		addPanelLabel.setFont(new Font("宋体", Font.BOLD, 20));
		addPanel.add(addPanelLabel);
		addPanelLabel.setBounds(180, 0, 400, 80);
		
		JLabel nameLabel=new JLabel("姓名");//欢迎界面Label
		nameLabel.setFont(new Font("宋体", Font.BOLD, 15));
		addPanel.add(nameLabel);
		nameLabel.setBounds(73, 100, 40, 30);
		
		JLabel ageLabel=new JLabel("年龄");
		ageLabel.setFont(new Font("宋体", Font.BOLD, 15));
		addPanel.add(ageLabel);
		ageLabel.setBounds(211,100, 40, 30);
		
		JLabel NativeLabel=new JLabel("籍贯");
		NativeLabel.setFont(new Font("宋体", Font.BOLD, 15));
		addPanel.add(NativeLabel);
		NativeLabel.setBounds(331,100, 40, 30);
		
		JLabel TelLabel=new JLabel("电话");
		TelLabel.setFont(new Font("宋体", Font.BOLD, 15));
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
		
		/*查找学生界面*/
		findTextField=new JTextField(10);
		findPanel.add(new JLabel("学生姓名:"),BorderLayout.NORTH);
		findPanel.add(findTextField,BorderLayout.NORTH);
		
		findStudent=new JButton("查找学生");
		findStudent.addActionListener(new MyActionListener());
		findStudent.setPreferredSize(new Dimension(85,25));
		findPanel.add(findStudent,BorderLayout.NORTH);
		
		changeStudent=new JButton("更改信息");
		changeStudent.addActionListener(new MyActionListener());
		changeStudent.setPreferredSize(new Dimension(85,25));
		findPanel.add(changeStudent,BorderLayout.NORTH);
		
		deleteStudent=new JButton("删除学生");
		deleteStudent.addActionListener(new MyActionListener());
		deleteStudent.setPreferredSize(new Dimension(85,25));
		findPanel.add(deleteStudent,BorderLayout.NORTH);
		
		backtoMainfromFind=new JButton("返回");
		backtoMainfromFind.addActionListener(new MyActionListener());
		backtoMainfromFind.setPreferredSize(new Dimension(85,25));
		findPanel.add(backtoMainfromFind,BorderLayout.NORTH);
		/*查找界面表格*/
		String[] findpanelcolumnNames = {"姓名", "年龄", "籍贯", "电话号码"};
		resultRowData=new Object[1][4];
		for (int i = 0; i < 4; i++) {
			resultRowData[0][i]="";
		}
		resultmodel = new DefaultTableModel(resultRowData, findpanelcolumnNames);
		resulttable = new JTable(resultmodel){//此处重写Editable方法，改为不能编辑
			@Override
            public boolean isCellEditable(int rowIndex, int ColIndex){
            	return false;
            }
		};
				/*查询表格界面设置*/
		// 设置表格内容颜色
        resulttable.setForeground(Color.BLACK);// 字体颜色
        resulttable.setFont(new Font(null, Font.PLAIN, 14));// 字体样式
        resulttable.setSelectionForeground(Color.DARK_GRAY);// 选中后字体颜色
        resulttable.setSelectionBackground(Color.LIGHT_GRAY);// 选中后字体背景
        resulttable.setGridColor(Color.GRAY);// 网格颜色

        // 设置表头
        resulttable.getTableHeader().setFont(new Font(null, Font.BOLD, 14));// 设置表头名称字体样式
        resulttable.getTableHeader().setForeground(Color.BLACK);// 设置表头名称字体颜色
        resulttable.getTableHeader().setResizingAllowed(false);// 设置不允许手动改变列宽
        resulttable.getTableHeader().setReorderingAllowed(false);// 设置不允许拖动重新排序各列

        // 设置行高
        resulttable.setRowHeight(30);
        // 第一列列宽设置为40
        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
        
		findPanel.add(resulttable.getTableHeader(), BorderLayout.CENTER);
	    findPanel.add(resulttable, BorderLayout.CENTER);
	    
	    /*修改学生界面*/
	    changePanel=new JPanel();
	    backtoMainfromChange=new JButton("返回");
		confirmChange=new JButton("修改");
		confirmChange.addActionListener(new MyActionListener());
		backtoMainfromChange.addActionListener(new MyActionListener());
		changePanel.setLayout(null);
		changePanel.add(backtoMainfromChange);
		changePanel.add(confirmChange);
		backtoMainfromChange.setBounds(410, 230, 80, 40);
		confirmChange.setBounds(110, 230, 80, 40);
		
		JLabel changePanelLabel=new JLabel("请输入修改学生的信息");//欢迎界面Label
		changePanelLabel.setFont(new Font("宋体", Font.BOLD, 20));
		changePanel.add(changePanelLabel);
		changePanelLabel.setBounds(180, 0, 400, 80);
		
		JLabel nameLabel2=new JLabel("姓名");//欢迎界面Label
		nameLabel2.setFont(new Font("宋体", Font.BOLD, 15));
		changePanel.add(nameLabel2);
		nameLabel2.setBounds(73, 100, 40, 30);
		
		JLabel ageLabel2=new JLabel("年龄");
		ageLabel2.setFont(new Font("宋体", Font.BOLD, 15));
		changePanel.add(ageLabel2);
		ageLabel2.setBounds(211,100, 40, 30);
		
		JLabel NativeLabel2=new JLabel("籍贯");
		NativeLabel2.setFont(new Font("宋体", Font.BOLD, 15));
		changePanel.add(NativeLabel2);
		NativeLabel2.setBounds(331,100, 40, 30);
		
		JLabel TelLabel2=new JLabel("电话");
		TelLabel2.setFont(new Font("宋体", Font.BOLD, 15));
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
		
		
		
		/*窗口设置*/
		setResizable(false);//不可改变窗口大小
		setLocationRelativeTo(null);//居中显示
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
			}else if(source==addStudent) {//添加学生面板的添加按钮
				new JOptionPane();
				if(nameOfAddPanel.getText().equals("") || ageOfAddPanel.getText().equals("") || NativeOfAddPanel.getText().equals("") || TelOfAddPanel.getText().equals("")) {
					JOptionPane.showMessageDialog(addPanel,"学生信息输入为空！","警告",JOptionPane.WARNING_MESSAGE);
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
					reTable();//表格重绘
					inf.saveAsTxt();//及时保存至txt
					JOptionPane.showMessageDialog(addPanel, "学生信息添加成功！","添加成功",JOptionPane.INFORMATION_MESSAGE);
					nameOfAddPanel.setText("");
					ageOfAddPanel.setText("");
					NativeOfAddPanel.setText("");
					TelOfAddPanel.setText("");
					changeContentPane(mainPanel);
				}
			}else if(source==findStudent) {//查找面板 查找按钮
				temp=inf.FindStudent(findTextField.getText());
				if(temp==null) {
					JOptionPane.showMessageDialog(findPanel,"该学生不存在！","警告",JOptionPane.WARNING_MESSAGE);
				}else {
					String[] findpanelcolumnNames = {"姓名", "年龄", "籍贯", "电话号码"};
					inf.UpdateResult(resultRowData, temp);
					resultmodel.setDataVector(resultRowData, findpanelcolumnNames);
					resultmodel.fireTableDataChanged();
			        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
				}
			}else if(source==changeStudent) {//查找面板 更改按钮
				if(temp==null) {
					JOptionPane.showMessageDialog(findPanel,"未确定要更改的学生，请先查找！","警告",JOptionPane.WARNING_MESSAGE);
				}else {
					changeContentPane(changePanel);
				}
				
			}else if(source==deleteStudent) {//查找面板 删除按钮
				if(temp==null) {
					JOptionPane.showMessageDialog(findPanel,"未确定要删除的学生，请先查找！","警告",JOptionPane.WARNING_MESSAGE);
				}
				inf.DeleteStudent(temp.getName());//调用删除函数
				inf.saveAsTxt();//及时保存至txt
				/*清空查询界面输入框及表格*/
				findTextField.setText("");
				JOptionPane.showMessageDialog(findPanel, "学生信息删除成功！","删除成功",JOptionPane.INFORMATION_MESSAGE);
				temp=null;
				String[] findpanelcolumnNames = {"姓名", "年龄", "籍贯", "电话号码"};
				inf.UpdateResult(resultRowData, temp);
				resultmodel.setDataVector(resultRowData, findpanelcolumnNames);
				resultmodel.fireTableDataChanged();
		        resulttable.getColumnModel().getColumn(3).setPreferredWidth(120);
				/*更新主界面表格*/
				rowData=inf.SwitchToTable();
				reTable();
//				changeContentPane(mainPanel);
			}else if(source==confirmChange) {//更该界面 确认按钮
				if(nameOfchangePanel.getText().equals("") || ageOfchangePanel.getText().equals("") || nativeOfchangePanel.getText().equals("") || telOfchangePanel.getText().equals("")) {
					JOptionPane.showMessageDialog(changePanel,"修改学生信息为空！","警告",JOptionPane.WARNING_MESSAGE);
				}else{
			        /*获取修改界面信息*/
					temp.setName(nameOfchangePanel.getText());
					temp.setAge(Integer.parseInt(ageOfchangePanel.getText()));
					temp.setNativePlace(nativeOfchangePanel.getText());
					temp.setTelNum(telOfchangePanel.getText());
					rowData=inf.SwitchToTable();
					inf.saveAsTxt();//及时保存至txt文件
					reTable();
					JOptionPane.showMessageDialog(changePanel, "学生信息修改成功！","修改成功",JOptionPane.INFORMATION_MESSAGE);
					/*清空修改界面输入框*/
					nameOfchangePanel.setText("");
					ageOfchangePanel.setText("");
					nativeOfchangePanel.setText("");
					telOfchangePanel.setText("");
					/*清空查询界面输入框及表格*/
					findTextField.setText("");
					temp=null;
					String[] findpanelcolumnNames = {"姓名", "年龄", "籍贯", "电话号码"};
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
		String[] columnNames = {"序号", "姓名", "年龄", "籍贯", "电话号码"};
        // 创建一个表格，指定 表头 和 所有行数据
		// 首先抓取model
//		DefaultTableModel tModel = new DefaultTableModel(rowData,columnNames); 
		// 应用model到table
//		table = new JTable(tModel){
//	         public boolean isCellEditable(int rowIndex, int ColIndex){
//	            	return false;
//	         }
//		};

		// 点击搜索按钮触发事件，用setDataVector()方法来更新Model的数据
		model.setDataVector(rowData, columnNames);
		model.fireTableDataChanged();
		System.out.println("here");
	}
	
    public void changeContentPane(Container contentPane) {//切换面板
        this.setContentPane(contentPane);
        this.revalidate();
    }
}
