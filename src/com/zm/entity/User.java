package com.zm.entity;
/**
 * ʵ���࣬����ӳ�����ݿ��
 * @author kou
 *
 */
public class User {
	private int stuId;			//�û�ID
	private String stuName;		//�û�����
	private String stuPassword;	//�û�����
	private String stuClass;	//�û��༶

	

    //toString���������ڲ������
	public String toString() {
		return "User [stuId=" + stuId + ", stuName=" + stuName + ", stuPassword="
				+ stuPassword + ", stuClass=" + stuClass + "]";
	}
    //�вεĹ��췽��
	public User(int stuId, String stuName, String stuPassword, String stuClass,char stuSex, int stuAge) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.stuClass=stuClass;

	}
    //�޲εĹ��췽��
	public User() {}
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	

	

}


	

