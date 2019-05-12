package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.CacheNamespaceRef;

import tk.mybatis.simple.model.SysRole;

@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {
	
	SysRole selectById(Long id);

}
