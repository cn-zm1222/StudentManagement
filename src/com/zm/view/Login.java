package com.zm.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.zm.dao.UserDao;
import com.zm.daoimpl.UserDaoImpl;
import com.zm.entity.User;

//第一步：
public class Login extends JFrame implements ActionListener {
	// 第一步： 设置画板
	private JPanel pan = new JPanel();
	// 第四步：写界面元素（对象）
	private JLabel label1=new JLabel();
	private JLabel namelab = new JLabel("用户名");
	private JLabel passlab = new JLabel("密码");
	private JTextField nametext = new JTextField();// JTextField swing文本框
	private JPasswordField passtext = new JPasswordField();// JPasswordField()
	private JCheckBox jCheckBox=new JCheckBox("记住密码");
	private JComboBox<String> jComboBox=new JComboBox<String>();
															// swing密码框

	public JButton denglu = new JButton("登录");// JButton("登录") swing按钮
	public JButton zhuce = new JButton("注册");
	


	// 第二步：构造方法 调用父类，实现添加
	public Login() {
		
		super.setTitle("登录界面");// .setTitle("登录界面") 设置标题
		pan.setLayout(null);// .setLayout(null) 默认布局
		// 设置坐标
		namelab.setBounds(60, 150, 60, 30);
		nametext.setBounds(125, 150, 150, 30);
		passlab.setBounds(60, 200, 60, 30);
		passtext.setBounds(125, 200, 150, 30);
		denglu.setBounds(90, 260, 85, 30);
		zhuce.setBounds(245,260, 85, 30);
		jCheckBox.setBounds(280, 200, 90, 30);
		jComboBox.setBounds(280, 150, 95, 28);
		
		label1.setIcon(new ImageIcon("src/text.jpg"));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setBounds(0, 0, 440, 130);
		label1.setOpaque(false);
		denglu.setForeground(Color.blue);
		zhuce.setForeground(Color.blue);
		String name[]= {"学生登入","教师登入","管理员登入"};
		for(int j=0;j<name.length;j++) {
			jComboBox.addItem(name[j]);
			
		}
		
		
		// 向画板添加元素
	
		pan.add(label1);
		pan.add(namelab);
		pan.add(nametext);
		pan.add(passlab);
		pan.add(passtext);
		pan.add(denglu);
		pan.add(zhuce);
		pan.add(jCheckBox);
		pan.add(jComboBox);
		
		
		denglu.addActionListener(this);
        zhuce.addActionListener(this);
        
		super.add(pan);
		super.setResizable(false);
		super.setBounds(430,160,450, 400); // .setSize()设置画板尺寸
		super.setVisible(true);// .setVisible() 初始化方法
	}
	//注册按钮的返回
	public void zhuce(){
		super.setVisible(false);
		new Reg();
	}
	
	public void denglu() {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		String uname = nametext.getText(); // 获取用户输入信息
		String upass = passtext.getText();
		user = ud.Login(uname, upass);
		if (user != null) {
			JOptionPane.showMessageDialog(null, "登录成功！");
			super.setVisible(false);
			new StudentView();
		} else {
			JOptionPane.showMessageDialog(null, "登录失败，请检查用户名或密码");
			JOptionPane.showMessageDialog(null, "如无账号，请注册！");
			int a = JOptionPane.showConfirmDialog(null, "是否注册新账户");
			if(a == JOptionPane.YES_OPTION){
				new Reg();
			}else{
				super.setVisible(false);
				new Login();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == denglu) {
			denglu();
		}
		if(e.getSource() == zhuce){
			zhuce();
		}
	}

	// 第三步：实例化
	public static void main(String[] args) {
		new Login();
	}

}
