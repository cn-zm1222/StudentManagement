package com.zm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.zm.dao.UserDao;
import com.zm.daoimpl.UserDaoImpl;
import com.zm.entity.User;
public class Update extends JFrame implements ActionListener{

	private JPanel pan = new JPanel();
	private JButton update = new JButton("�޸�"); //�����޸İ�ť
	private JButton cencel=new JButton("ȡ��");
	private JTextField stuName = new JTextField(); //�����ı���
	private JTextField stuPassword = new JTextField(); //�����ı���
	private JTextField stuClass = new JTextField(); //�����ı���
	private JLabel label1 = new JLabel("�û�����");//������ʾ��
	private JLabel label2 = new JLabel("��    �룺");//������ʾ��
	private JLabel label3 = new JLabel("��    ����");//������ʾ��
	public  User updateTempUser=new User();
	
	
	public Update(User user) {
		
		updateTempUser.setStuId(user.getStuId());
		updateTempUser.setStuName(user.getStuName());
		updateTempUser.setStuPassword(user.getStuPassword());
		updateTempUser.setStuClass(user.getStuClass());
		setTitle("�޸Ľ���");
		super.add(pan);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 450, 270);
		pan.setLayout(null);
		super.setSize(400, 400);
		super.setResizable(false);
		super.setVisible(true);
		update.setBounds(86, 214, 70, 30);
		update.setForeground(Color.red);
		pan.add(update);
		cencel.setBounds(206, 214, 70, 30);
		cencel.setForeground(Color.RED);
		pan.add(cencel);
		stuName.setBounds(183, 30, 90, 25);
		stuPassword.setBounds(183, 86, 90, 25);
		stuClass.setBounds(183, 138, 90, 25);
		pan.add(stuName);
		pan.add(stuPassword);
		pan.add(stuClass);
		label1.setBounds(78, 30, 55, 25);
		label2.setBounds(78, 86, 63, 25);
		label3.setBounds(78, 138, 63, 25);
		pan.add(label1);
		pan.add(label2);
		pan.add(label3);
		update.addActionListener(this);
		cencel.addActionListener(this);
	}
	
    public void update(){
    	UserDao ud = new UserDaoImpl();
    	String stun = stuName.getText();
    	String stupd = stuPassword.getText();
    	String stuc = stuClass.getText();
    	
    	updateTempUser.setStuName(stun);
    	updateTempUser.setStuPassword(stupd);
    	updateTempUser.setStuClass(stuc);
    	boolean isflag = ud.update(updateTempUser);
   
    	if(isflag){
    		JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
    		super.setVisible(false);
    		super.setVisible(true);
    		new StudentView();
    	}else{
    		JOptionPane.showMessageDialog(null, "�޸�ʧ��");
    	}
    }
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
        	update();
        }if(e.getSource()==cencel) {
        	super.setVisible(false);
        	new StudentView();
        }
	}
	
}
