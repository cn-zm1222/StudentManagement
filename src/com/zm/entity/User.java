package com.zm.entity;
/**
 * 实体类，用来映射数据库表。
 * @author kou
 *
 */
public class User {
	private int stuId;			//用户ID
	private String stuName;		//用户姓名
	private String stuPassword;	//用户密码
	private String stuClass;	//用户班级

	

    //toString方法，便于测试输出
	public String toString() {
		return "User [stuId=" + stuId + ", stuName=" + stuName + ", stuPassword="
				+ stuPassword + ", stuClass=" + stuClass + "]";
	}
    //有参的构造方法
	public User(int stuId, String stuName, String stuPassword, String stuClass,char stuSex, int stuAge) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.stuClass=stuClass;

	}
    //无参的构造方法
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


	

