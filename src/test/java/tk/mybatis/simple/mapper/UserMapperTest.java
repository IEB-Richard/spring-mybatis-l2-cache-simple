package tk.mybatis.simple.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysRoleExtend;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest {

	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		try {
			// get the UserMapper interface
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// call the method selectById, get the User with id '1L'
			SysUser user = userMapper.selectById(1l);
			// check user is not null
			assertNotNull(user);
			// check user name = 'admin'
			assertEquals("admin", user.getUserName());
			
		}finally {
			// Important: Please don't forget to close the SqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// call method selectAll() to get all users
			List<SysUser> userList = userMapper.selectAll();
			// check the userList is not null
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserId(1l);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size() > 0);
		}finally {
			sqlSession.close();
		}		
	}
	
	@Test
	public void testSelectRoleExtendsByUserId() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRoleExtend> roleList = userMapper.selectRoleExtendsByUserId(1l);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size() > 0);
		}finally {
			sqlSession.close();
		}		
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// Create one User Object
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test user Info");
			user.setHeadImg(new byte[] {1, 2, 3});
			user.setCreateTime(new Date());
			
			int result = userMapper.insert(user);
			Assert.assertEquals(1, result);
			Assert.assertNull(user.getId());
		}finally {
			/**
			 * In order not to affect other testings, here we roll back the 
			 * changes.
			 */
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// Create one User Object
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test user Info");
			user.setHeadImg(new byte[] {1, 2, 3});
			user.setCreateTime(new Date());
			
			int result = userMapper.insert2(user);
			Assert.assertEquals(1, result);
			Assert.assertNotNull(user.getId());
		}finally {
			/**
			 * In order not to affect other testings, here we roll back the 
			 * changes.
			 */
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// Create one User Object
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test user Info");
			user.setHeadImg(new byte[] {1, 2, 3});
			user.setCreateTime(new Date());
			
			int result = userMapper.insert3(user);
			Assert.assertEquals(1, result);
			Assert.assertNotNull(user.getId());
		}finally {
			/**
			 * In order not to affect other testings, here we roll back the 
			 * changes.
			 */
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// get one user object from database
			SysUser user = userMapper.selectById(1l);
			// test: if the current userName is 'admin'
			Assert.assertEquals("admin", user.getUserName());
			
			// change user name
			user.setUserName("admin_test");
			// change user email
			user.setUserEmail("test@mybatis.tk");
			
			// update the data, please play attention here: the return result here means number 
			// of records changed
			int result = userMapper.updateById(user);
			
			// test: make sure only one
			Assert.assertEquals(1, result);
			// get the user from Database again
			user = userMapper.selectById(1l);
			// test: the userName after change is 'admin_test' 
			Assert.assertEquals("admin_test", user.getUserName());
		}finally {
			
			// in order not affect other tests, here we rollback the changes
			sqlSession.rollback();
			// close sqlSession
			sqlSession.close();
			
		}
	}
	
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// get one user object from database
			SysUser user1 = userMapper.selectById(1l);
			// test: now we could get data from DB
			Assert.assertNotNull(user1);
			// call method to delete
			Assert.assertEquals(1, userMapper.deleteById(1l));
			// search again, it should be null
			Assert.assertNull(userMapper.selectById(1l));
			
			// Search again to get another user with id 1001
			SysUser user2 = userMapper.selectById(1001l);
			Assert.assertNotNull(user2);
		}finally {
			// in order not affect other tests, here we rollback the changes
			sqlSession.rollback();
			// close sqlSession
			sqlSession.close();
		}
	}
}
