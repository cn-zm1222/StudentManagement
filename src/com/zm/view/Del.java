package com.zm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zm.dao.UserDao;
import com.zm.daoimpl.UserDaoImpl;

public class Del extends JFrame implements ActionListener {
	private JPanel jPanel=new JPanel();
	private JButton lab1=new JButton("确认");
	private JButton lab2=new JButton("取消");
	private JLabel lab3=new JLabel("是否删除");
	private JTable table1;
	DefaultTableModel tableModel = null;  
	public Del(JTable table,DefaultTableModel tableModel1) {
		tableModel=tableModel1;
		table1=table;
		super.add(jPanel);
		super.setBounds(550, 210, 280, 240);
		super.setResizable(false);
		super.setVisible(true);
		jPanel.setLayout(null);
		
		lab1.setBounds(35, 105, 70, 30);
		lab2.setBounds(145, 105, 70, 30);
		lab3.setBounds(70, 45, 140, 30);
		lab3.setFont(new Font("宋体", Font.BOLD, 25));
		lab3.setForeground(Color.RED);
		lab2.setForeground(Color.BLUE);
		lab1.setForeground(Color.BLUE);
		lab1.addActionListener(this);
		lab2.addActionListener(this);
		
		jPanel.add(lab1);
		jPanel.add(lab2);
		jPanel.add(lab3);
		
		
	}
	
	public void del() {
		UserDao ud = new UserDaoImpl();   //多态出后台方法
		int selectedRow = table1.getSelectedRow(); //获取鼠标选择的表格行
		//获取表格行中的第0列。也为uid
		String sid = (String) tableModel.getValueAt(selectedRow, 0).toString();
		//uid是int类型，所以要转换格式String-->int
		int uid = Integer.parseInt(sid);
		boolean isflag = ud.del(uid);  //调用后台写好的删除方法
		if (isflag) {     //代表成功
			//此方法向用户提示确认删除
			JOptionPane.showMessageDialog(null, "删除成功");
			new StudentView();    //删除后重新查询
		} else {         //代表删除失败
			JOptionPane.showMessageDialog(null, "删除失败！");//向用户提示信息
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==lab1) {
			del();
			
		}if (e.getSource()==lab2) {
			super.setVisible(false);
			new StudentView();
		}
	}
}
