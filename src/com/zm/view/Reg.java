package com.zm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.zm.dao.UserDao;
import com.zm.daoimpl.UserDaoImpl;
import com.zm.entity.User;

public class Reg extends JFrame implements ActionListener {

	private JPanel pan = new JPanel();
	private JLabel zhuti = new JLabel("��ӭ����ע��ҳ��");
	private JLabel namelab = new JLabel("�û���");
	private JLabel passlab = new JLabel("����");
	private JTextField nametext = new JTextField();
	private JTextField passtext = new JTextField();

	public JButton zhuce = new JButton("ע��");
	public JButton fanhui = new JButton("������ҳ");

	public Reg() {
		super.add(pan);
		super.setBounds(450,160,450, 350);
		super.setVisible(true);
		super.setResizable(false);
		super.setTitle("ע��");
		pan.setLayout(null);
		zhuti.setBounds(160, 30, 150, 30);
		namelab.setBounds(85, 80, 60, 30);
		passlab.setBounds(85, 130, 60, 30);
		nametext.setBounds(150, 80, 150, 30);
		passtext.setBounds(150, 130, 150, 30);
		zhuce.setBounds(75, 200, 90, 30);
		fanhui.setBounds(250, 200, 90, 30);
		pan.add(namelab);
		pan.add(zhuti);
		pan.add(passlab);
		pan.add(nametext);
		pan.add(passtext);
		pan.add(zhuce);
		pan.add(fanhui);
		zhuce.addActionListener(this);
		fanhui.addActionListener(this);
	}

	public void fanhui() {
		super.setVisible(false);
		new Login();
	}

	public void zhuce() {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		Date d = new Date();
		String id = sdf.format(d);
		int uid = Integer.parseInt(id);

		String uname = nametext.getText();
		String upassword = passtext.getText();
		user.setStuId(uid);
		user.setStuName(uname);
		user.setStuPassword(upassword);
	    if(!"".equals(uname) && !"".equals(upassword)){
	    	boolean isflag = ud.regUser(user);
			if (isflag) {
					JOptionPane.showMessageDialog(null, "ע��ɹ�����ת����¼����...");
					super.setVisible(false);
					new Login();
			} else {
				JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�δ֪����");
			}
	    }else{
	    	JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ��û��������벻��Ϊ��");
	    }
		
	}

	public static void main(String[] args) {
		new Reg();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zhuce) {
			zhuce();
		}
		if (e.getSource() == fanhui) {
			fanhui();
		}
	}

}
