package web.module.auth.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class MemberVO implements UserDetails {
	private long 	userSeq;
	private long	connSeq;
	private String 	userId;
	private String 	userNm;
	private String	 userPwd;
	private String 	role;
	private int		auth;
	private String 	roleNm;
	private String 	email;
	private String 	thumb;
	private boolean enabled;
	private String	ipAddr;
	private String	blockYn;
	private String	blockInfo;

	private String regDate;
	private List<AuthVO> authList;

	private List<GrantedAuthority> authorities;

	@JsonSerialize(using = ToStringSerializer.class)
	public long getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(long userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return userPwd;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public List<AuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
		authorities = new ArrayList<GrantedAuthority>();
		String[] roles = role.split(", ");
		for(String userRole : roles) {
			authorities.add(new SimpleGrantedAuthority(userRole));
		}
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public long getConnSeq() {
		return connSeq;
	}

	public void setConnSeq(long connSeq) {
		this.connSeq = connSeq;
	}

	public String getBlockYn() {
		return blockYn;
	}

	public void setBlockYn(String blockYn) {
		this.blockYn = blockYn;
	}

	public String getBlockInfo() {
		return blockInfo;
	}

	public void setBlockInfo(String blockInfo) {
		this.blockInfo = blockInfo;
	}
}
