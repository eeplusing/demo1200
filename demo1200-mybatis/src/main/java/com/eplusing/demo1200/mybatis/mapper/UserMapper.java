package com.eplusing.demo1200.mybatis.mapper;

import java.util.List;

import com.eplusing.demo1200.mybatis.po.User;
import com.eplusing.demo1200.mybatis.po.UserCustom;
import com.eplusing.demo1200.mybatis.po.UserQueryVo;
import com.eplusing.demo1200.mybatis.po.Orders;

public interface UserMapper {
		//����id��ѯ�û���Ϣ
		public User findUserByIdResultMap(int id) throws Exception;
		//����id��ѯ�û���Ϣ
		public User findUserById(int id) throws Exception;
		//����username��ѯ�û���Ϣ
		public List<User> findUserByName(String username) throws Exception;
		//�Զ����ѯ������ѯ�û���Ϣ
		public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
		//�Զ����ѯ������ѯ�û�����
		public int findUserCount(UserQueryVo userQueryVo) throws Exception;
		//�����û�
		public int insertUser(User user) throws Exception;
		//����username��ѯ�û���Ϣ
		public int deleteUser(int id) throws Exception;
		//����username��ѯ�û���Ϣ
		public int updateUser(User user) throws Exception;
		//��ѯ�û���������Ʒ��Ϣ
		public List<Orders> findUserAndDetailResultMap() throws Exception;
}
