package com.zm.dao;

import java.util.List;

import com.zm.entity.User;
/**
 * ����ӿڣ����ܣ�
 * @author kou
 *
 */
public interface UserDao {
	/**
	 * ��ѯ����������List����
	 * @return
	 */
	public List<User> get();
	/**
	 * ��ӷ��������ز������ͣ������������
	 * @param user(����)
	 * @return
	 */
	public boolean add(User user);
	/**
	 * �޸ķ��������ز������ͣ������������
	 * @param user(����)
	 * @return
	 */
	public boolean update(User user);
	/**
	 * ɾ�����������ز������ͣ�����uid����ɾ������
	 * @param user(����)
	 * @return
	 */
	public boolean del(int uid);
	/**
	 * ��ȡID���������ض������ͣ�����uid���л�ȡid����
	 * @param user(����)
	 * @return
	 */
	public User getid(int uid);
	/**
	 * ��½���������ض������ͣ������������л�ȡ�ԱȲ���
	 * @param user(����)
	 * @return
	 */
	public User Login(String uname, String upassword);
	/**
	 * ע�᷽�������ز������ͣ���������������
	 * @param user(����)
	 * @return
	 */
	 public boolean regUser(User user);
}
