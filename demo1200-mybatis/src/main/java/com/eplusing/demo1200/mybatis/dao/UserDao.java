/**
 * 
 */
package com.eplusing.demo1200.mybatis.dao;

import java.util.List;

import com.eplusing.demo1200.mybatis.po.User;

/**
 * @author admin
 *
 */
public interface UserDao {
	//����id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	//����username��ѯ�û���Ϣ
	public List<User> findUserByName(String username) throws Exception;
	//�����û�
	public int insertUser(User user) throws Exception;
	//����username��ѯ�û���Ϣ
	public int deleteUser(int id) throws Exception;
	//����username��ѯ�û���Ϣ
	public int updateUser(User user) throws Exception;
}
