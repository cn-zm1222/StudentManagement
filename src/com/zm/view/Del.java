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
	private JButton lab1=new JButton("ȷ��");
	private JButton lab2=new JButton("ȡ��");
	private JLabel lab3=new JLabel("�Ƿ�ɾ��");
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
		lab3.setFont(new Font("����", Font.BOLD, 25));
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
		UserDao ud = new UserDaoImpl();   //��̬����̨����
		int selectedRow = table1.getSelectedRow(); //��ȡ���ѡ��ı����
		//��ȡ������еĵ�0�С�ҲΪuid
		String sid = (String) tableModel.getValueAt(selectedRow, 0).toString();
		//uid��int���ͣ�����Ҫת����ʽString-->int
		int uid = Integer.parseInt(sid);
		boolean isflag = ud.del(uid);  //���ú�̨д�õ�ɾ������
		if (isflag) {     //����ɹ�
			//�˷������û���ʾȷ��ɾ��
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			new StudentView();    //ɾ�������²�ѯ
		} else {         //����ɾ��ʧ��
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");//���û���ʾ��Ϣ
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
