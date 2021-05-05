package com.meicano.mybatis.mapper;

import java.util.List;

import com.meicano.mybatis.po.Orders;
import com.meicano.mybatis.po.User;
import com.meicano.mybatis.po.UserCustom;
import com.meicano.mybatis.po.UserQueryVo;

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
