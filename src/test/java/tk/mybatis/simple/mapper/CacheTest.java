package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysUser;

public class CacheTest extends BaseMapperTest {
	
	@Test
	public void testL1Cache() {
		// get sqlSession
		SqlSession sqlSession = getSqlSession();
		SysUser user1 = null;
		try {
			// get mapper object
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			// get user1
			user1 = userMapper.selectById(1l);
			// assgin a new value 
			user1.setUserName("New Name");
			System.out.println(user1.toString());
			
			// search the same user and assign to another user
			SysUser user2 = userMapper.selectById(1l);
			// though it haven't updated the DB, user2 have the new userName we assigned
			// with user1.
			Assert.assertEquals("New Name", user2.getUserName());
			// user1 and user2 should be the same object
			Assert.assertEquals(user1, user2);

		} finally {
			sqlSession.close();
		}
		
		// open another new sqlSession
		System.out.println("Open another new SqlSession");
		sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// L1 cache only exist in the same sqlSession,
			SysUser user2 = userMapper.selectById(1l);
			// so user2 will not the same object as in the first sqlSession
			Assert.assertNotEquals("New Name", user2.getUserName());
			Assert.assertNotEquals(user1, user2);
			// any insert, delete or update action will flush L1 cache 
			userMapper.deleteById(2L);
			// get the same user again and assigned to user3
			SysUser user3 = userMapper.selectById(1l);
			// user3 and user2 will be not the same object as cache is flushed.
			Assert.assertNotEquals(user2, user3);
		} finally {
			sqlSession.close();
		}
	}
}
