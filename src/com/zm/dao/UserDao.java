package com.zm.dao;

import java.util.List;

import com.zm.entity.User;
/**
 * 定义接口（功能）
 * @author kou
 *
 */
public interface UserDao {
	/**
	 * 查询方法，返回List集合
	 * @return
	 */
	public List<User> get();
	/**
	 * 添加方法，返回布尔类型，并传对象参数
	 * @param user(参数)
	 * @return
	 */
	public boolean add(User user);
	/**
	 * 修改方法，返回布尔类型，并传对象参数
	 * @param user(参数)
	 * @return
	 */
	public boolean update(User user);
	/**
	 * 删除方法，返回布尔类型，并传uid进行删除操作
	 * @param user(参数)
	 * @return
	 */
	public boolean del(int uid);
	/**
	 * 获取ID方法，返回对象类型，并传uid进行获取id操作
	 * @param user(参数)
	 * @return
	 */
	public User getid(int uid);
	/**
	 * 登陆方法，返回对象类型，并传参数进行获取对比操作
	 * @param user(参数)
	 * @return
	 */
	public User Login(String uname, String upassword);
	/**
	 * 注册方法，返回布尔类型，并传对象进行添加
	 * @param user(参数)
	 * @return
	 */
	 public boolean regUser(User user);
}
