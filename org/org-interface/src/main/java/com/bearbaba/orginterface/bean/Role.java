package com.bearbaba.orginterface.bean;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Role implements Serializable {
	private static final long serialVersionUID = -8466777140015108019L;

	/**
	 * 角色 id
	 */
	Long id;

	/**
	 * 角色名
	 */
	String name;

	/**
	 * 组织 id
	 */
	Long organizationId;

	/**
	 * 角色作用域
	 */
	List<Scope> scopes;


}
