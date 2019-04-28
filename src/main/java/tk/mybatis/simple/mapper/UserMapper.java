package tk.mybatis.simple.mapper;

import java.util.List;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysRoleExtend;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	/**
	 * Select user by user's id
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);
	List<SysUser> selectAll();
	/**
	 * select roles by user Id
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	/**
	 * select roles by user Id, but here the Roles was extended to have one field 'userName'
	 * @param userId
	 * @return
	 */
	List<SysRoleExtend> selectRoleExtendsByUserId(Long userId);
	
	/**
	 * Insert the new User to database
	 * @param sysUser
	 * @return return the number of records inserted
	 */
	int insert(SysUser sysUser);
	/**
	 * Insert new User - useGeneratedKeys
	 * @param sysUser
	 * @return
	 */
	int insert2(SysUser sysUser);
	
	/**
	 * Insert new User - selectKey
	 * @param sysUser
	 * @return
	 */
	int insert3(SysUser sysUser);
	/**
	 * Update User by id
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	/**
	 * Delete by user
	 * @param sysUser
	 * @return
	 */
	int deleteById(Long id);
}
