package com.eplusing.demo1200.mybatis.dao;

import java.util.List;

import com.eplusing.demo1200.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImp implements UserDao {
	private SqlSessionFactory sqlSessionFactory;

	// ��sqlsessionFactoryע��
	public UserDaoImp() {
	}

	public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// ����sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int parameter = id;
		try {
			User user = sqlSession.selectOne("test.findUserById", parameter);
			System.out.println(user);

			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public List<User> findUserByName(String username) throws Exception {
		// ����sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<User> userList = sqlSession.selectList("test.findUserByName", username);
			System.out.println(userList);

			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public int insertUser(User user) throws Exception {
		// ����sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int num = sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
			System.out.println(num);

			return num;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int deleteUser(int id) throws Exception {
		// ����sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int num = sqlSession.delete("test.deleteUser", id);
			sqlSession.commit();
			System.out.println(num);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return 0;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// ����sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int num = sqlSession.update("test.updateUser", user);
			sqlSession.commit();
			System.out.println(num);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return 0;
	}

}
