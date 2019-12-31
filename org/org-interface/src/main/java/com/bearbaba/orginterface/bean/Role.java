package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;

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
	 * 角色作用域
	 */
	Scope scope;
}
