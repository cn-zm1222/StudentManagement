package com.zm.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.zm.dao.UserDao;
import com.zm.daoimpl.UserDaoImpl;
import com.zm.entity.User;

//��һ����
public class Login extends JFrame implements ActionListener {
	// ��һ���� ���û���
	private JPanel pan = new JPanel();
	// ���Ĳ���д����Ԫ�أ�����
	private JLabel label1=new JLabel();
	private JLabel namelab = new JLabel("�û���");
	private JLabel passlab = new JLabel("����");
	private JTextField nametext = new JTextField();// JTextField swing�ı���
	private JPasswordField passtext = new JPasswordField();// JPasswordField()
	private JCheckBox jCheckBox=new JCheckBox("��ס����");
	private JComboBox<String> jComboBox=new JComboBox<String>();
															// swing�����

	public JButton denglu = new JButton("��¼");// JButton("��¼") swing��ť
	public JButton zhuce = new JButton("ע��");
	


	// �ڶ��������췽�� ���ø��࣬ʵ�����
	public Login() {
		
		super.setTitle("��¼����");// .setTitle("��¼����") ���ñ���
		pan.setLayout(null);// .setLayout(null) Ĭ�ϲ���
		// ��������
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
		String name[]= {"ѧ������","��ʦ����","����Ա����"};
		for(int j=0;j<name.length;j++) {
			jComboBox.addItem(name[j]);
			
		}
		
		
		// �򻭰����Ԫ��
	
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
		super.setBounds(430,160,450, 400); // .setSize()���û���ߴ�
		super.setVisible(true);// .setVisible() ��ʼ������
	}
	//ע�ᰴť�ķ���
	public void zhuce(){
		super.setVisible(false);
		new Reg();
	}
	
	public void denglu() {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		String uname = nametext.getText(); // ��ȡ�û�������Ϣ
		String upass = passtext.getText();
		user = ud.Login(uname, upass);
		if (user != null) {
			JOptionPane.showMessageDialog(null, "��¼�ɹ���");
			super.setVisible(false);
			new StudentView();
		} else {
			JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ������û���������");
			JOptionPane.showMessageDialog(null, "�����˺ţ���ע�ᣡ");
			int a = JOptionPane.showConfirmDialog(null, "�Ƿ�ע�����˻�");
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

	// ��������ʵ����
	public static void main(String[] args) {
		new Login();
	}

}
