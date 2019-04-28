package tk.mybatis.simple.model;

import java.io.Serializable;

public class SysPrivilege implements Serializable {

	private static final long serialVersionUID = -3636573921270458179L;
	
	/**
	 * 权限ID
	 */
	private Long id;
	/**
	 * 权限名称
	 */
	private String privilegeName;
	/**
	 * 权限URL
	 */
	private String privilegeUrl;
	
	
	public SysPrivilege() {
	}
	public SysPrivilege(Long id, String privilegeName, String privilegeUrl) {
		this.id = id;
		this.privilegeName = privilegeName;
		this.privilegeUrl = privilegeUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getPrivilegeUrl() {
		return privilegeUrl;
	}
	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SysPrivilege [id=" + id + ", privilegeName=" + privilegeName + ", privilegeUrl=" + privilegeUrl + "]";
	}	
	
}
