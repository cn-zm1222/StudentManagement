package com.zm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.zm.dao.UserDao;
import com.zm.daoimpl.UserDaoImpl;
import com.zm.entity.User;

import javax.swing.border.BevelBorder;
/**
 * 项目主窗体
 * 继承于jframe顶级父类
 * 实现ActionListener监听接口
 * @author ...
 *
 */
public class StudentView extends JFrame implements ActionListener {
    
	private JPanel pan = new JPanel();           //设置画板
	private JButton add = new JButton("添加");    //设置添加按钮
	private JButton del = new JButton("删除");    //设置删除按钮
	private JButton update = new JButton("修改"); //设置修改按钮
	private JButton back=new JButton("注销");
	private JTextField text1 = new JTextField(); //设置文本框
	private JTextField text2 = new JTextField(); //设置文本框
	private JTextField text3 = new JTextField(); //设置文本框
	private JTable table = new JTable();         //设置表格
	private String head[] = null;                //设置表格标题
	private Object[][] data = null;              //二维数组设置数据和标题
	DefaultTableModel tableModel = null;         //将数据绑定在table表格中
	private JLabel label1 = new JLabel("用户名：");//设置提示字
	private JLabel label2 = new JLabel("密    码：");//设置提示字
	private JLabel label3 = new JLabel("班    级：");//设置提示字
	private JLabel label4 = new JLabel("学生信息查阅");//设置提示字
    //在构造方法中实现各种初始化操作
	public StudentView() {
		super.add(pan);            //向父类添加画板
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 300);   //设置主窗体在显示器的位置
		super.setSize(650, 500);         //设置主窗体大小
		super.setResizable(false);
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));//画板边框
		pan.setLayout(null);                       //画板使用默认布局
		setVisible(true);                          //进行窗体初始化(没有这行代码，窗体出不来)
        /**
         * 将之前初始化的按钮，表格，文本框一一设置方位，然后进行添加画板的方法pan.add()
         */
		add.setBounds(517, 27, 67, 30);
		pan.add(add);
		update.setBounds(123, 357, 70, 30);
		pan.add(update);
		del.setBounds(293, 357, 70, 30);
		pan.add(del);
		text1.setBounds(72, 30, 90, 25);
		text2.setBounds(245, 30, 90, 25);
		text3.setBounds(417, 30, 90, 25);
		back.setBounds(463, 357, 70, 30);
		pan.add(back);
		pan.add(text1);
		pan.add(text2);
		pan.add(text3);
		label1.setBounds(10, 30, 55, 25);
		label2.setBounds(172, 30, 63, 25);
		label3.setBounds(345, 30, 63, 25);
		label4.setBounds(250, 80, 110, 25);
		pan.add(label1);
		pan.add(label2);
		pan.add(label3);
		pan.add(label4);
		//JScrollPane scrollPane = new JScrollPane(table);
		table.setBounds(62, 118, 500, 203);
		
		head = new String[] { "id", "姓名", "密码", "班级" };
		//将绑定的数据放进DefaultTableModel   query()为下面自己创建方法，head为标题
		tableModel = new DefaultTableModel(query(), head);
		table.setModel(tableModel);
		pan.add(table);
		
        //最好在这里重新进行画板部署，先关闭再开启，否则会查不到数据
		super.setVisible(false);
		super.setVisible(true);
		/**
		 * 对按钮添加监听事件
		 */
		add.addActionListener(this);
		del.addActionListener(this);
		back.addActionListener(this);
		update.addActionListener(this);
	}
    
	
    //自己创建修改方法，其后台与前台的融合！！此方法还未实现
	
	public void update() {
		UserDao ud = new UserDaoImpl();
		User updateTempUser;
		// 修改
		int selectedRow = table.getSelectedRow();
		String sid = (String) tableModel.getValueAt(selectedRow, 0).toString();
		int uid = Integer.parseInt(sid);
		updateTempUser=ud.getid(uid);
		if(updateTempUser!=null){
		
			new Update(updateTempUser);
		}else{
			JOptionPane.showMessageDialog(null, "获取失败！");
		}
	}
	//自己创建添加方法，其后台与前台的融合！！
	public void add() {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		//将uid设置为系统当前时间，精确到秒
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		Date d = new Date();
		String id = sdf.format(d);
		int uid = Integer.parseInt(id);
		String stuname = text1.getText();
		String stupassword = text2.getText();
		String stuclass = text3.getText();
		user.setStuId(uid);
		user.setStuName(stuname);
		user.setStuPassword(stupassword);
		user.setStuClass(stuclass);
		boolean isflag = ud.add(user);
		if (isflag) {
			JOptionPane.showMessageDialog(null, "添加成功！");
			new StudentView();
		} else {
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
	}
    //自己创建查询方法，其后台与前台的融合！！
	public Object[][] query() {
		UserDao pd = new UserDaoImpl();  //调用后台接口
		List<User> list = pd.get();      //查询方法返回list集合
		data = new Object[list.size()][head.length];  //将数据放入二维数组
		for (int i = 0; i < list.size(); i++) {       //遍历二维数组
			for (int j = 0; j < head.length; j++) {
				data[i][0] = list.get(i).getStuId();
				data[i][1] = list.get(i).getStuName();
				data[i][2] = list.get(i).getStuPassword();
				data[i][3] = list.get(i).getStuClass();
				
			}
		}

		return data;

	}
    //main方法 本窗体实例化入口
	public static void main(String[] args) {
		new StudentView();
	}
    //实现了ActionListener接口后的方法
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {  //通过参数e判定add按钮是否有方法
			add(); //调用我们自己的创建的add()方法
			super.setVisible(false);
		}
		if (e.getSource() == del) {  
			new Del(table,tableModel);
		}if(e.getSource() == update){ //未实现
			update();
		}if(e.getSource()==back) {
			super.setVisible(false);
			new Login();
		}
	}
}
