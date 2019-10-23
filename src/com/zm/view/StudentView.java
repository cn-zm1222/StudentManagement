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
 * ��Ŀ������
 * �̳���jframe��������
 * ʵ��ActionListener�����ӿ�
 * @author ...
 *
 */
public class StudentView extends JFrame implements ActionListener {
    
	private JPanel pan = new JPanel();           //���û���
	private JButton add = new JButton("���");    //������Ӱ�ť
	private JButton del = new JButton("ɾ��");    //����ɾ����ť
	private JButton update = new JButton("�޸�"); //�����޸İ�ť
	private JButton back=new JButton("ע��");
	private JTextField text1 = new JTextField(); //�����ı���
	private JTextField text2 = new JTextField(); //�����ı���
	private JTextField text3 = new JTextField(); //�����ı���
	private JTable table = new JTable();         //���ñ��
	private String head[] = null;                //���ñ�����
	private Object[][] data = null;              //��ά�����������ݺͱ���
	DefaultTableModel tableModel = null;         //�����ݰ���table�����
	private JLabel label1 = new JLabel("�û�����");//������ʾ��
	private JLabel label2 = new JLabel("��    �룺");//������ʾ��
	private JLabel label3 = new JLabel("��    ����");//������ʾ��
	private JLabel label4 = new JLabel("ѧ����Ϣ����");//������ʾ��
    //�ڹ��췽����ʵ�ָ��ֳ�ʼ������
	public StudentView() {
		super.add(pan);            //������ӻ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 300);   //��������������ʾ����λ��
		super.setSize(650, 500);         //�����������С
		super.setResizable(false);
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));//����߿�
		pan.setLayout(null);                       //����ʹ��Ĭ�ϲ���
		setVisible(true);                          //���д����ʼ��(û�����д��룬���������)
        /**
         * ��֮ǰ��ʼ���İ�ť������ı���һһ���÷�λ��Ȼ�������ӻ���ķ���pan.add()
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
		
		head = new String[] { "id", "����", "����", "�༶" };
		//���󶨵����ݷŽ�DefaultTableModel   query()Ϊ�����Լ�����������headΪ����
		tableModel = new DefaultTableModel(query(), head);
		table.setModel(tableModel);
		pan.add(table);
		
        //������������½��л��岿���ȹر��ٿ����������鲻������
		super.setVisible(false);
		super.setVisible(true);
		/**
		 * �԰�ť��Ӽ����¼�
		 */
		add.addActionListener(this);
		del.addActionListener(this);
		back.addActionListener(this);
		update.addActionListener(this);
	}
    
	
    //�Լ������޸ķ��������̨��ǰ̨���ںϣ����˷�����δʵ��
	
	public void update() {
		UserDao ud = new UserDaoImpl();
		User updateTempUser;
		// �޸�
		int selectedRow = table.getSelectedRow();
		String sid = (String) tableModel.getValueAt(selectedRow, 0).toString();
		int uid = Integer.parseInt(sid);
		updateTempUser=ud.getid(uid);
		if(updateTempUser!=null){
		
			new Update(updateTempUser);
		}else{
			JOptionPane.showMessageDialog(null, "��ȡʧ�ܣ�");
		}
	}
	//�Լ�������ӷ��������̨��ǰ̨���ںϣ���
	public void add() {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		//��uid����Ϊϵͳ��ǰʱ�䣬��ȷ����
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
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
			new StudentView();
		} else {
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
		}
	}
    //�Լ�������ѯ���������̨��ǰ̨���ںϣ���
	public Object[][] query() {
		UserDao pd = new UserDaoImpl();  //���ú�̨�ӿ�
		List<User> list = pd.get();      //��ѯ��������list����
		data = new Object[list.size()][head.length];  //�����ݷ����ά����
		for (int i = 0; i < list.size(); i++) {       //������ά����
			for (int j = 0; j < head.length; j++) {
				data[i][0] = list.get(i).getStuId();
				data[i][1] = list.get(i).getStuName();
				data[i][2] = list.get(i).getStuPassword();
				data[i][3] = list.get(i).getStuClass();
				
			}
		}

		return data;

	}
    //main���� ������ʵ�������
	public static void main(String[] args) {
		new StudentView();
	}
    //ʵ����ActionListener�ӿں�ķ���
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {  //ͨ������e�ж�add��ť�Ƿ��з���
			add(); //���������Լ��Ĵ�����add()����
			super.setVisible(false);
		}
		if (e.getSource() == del) {  
			new Del(table,tableModel);
		}if(e.getSource() == update){ //δʵ��
			update();
		}if(e.getSource()==back) {
			super.setVisible(false);
			new Login();
		}
	}
}
