package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Permission implements Serializable {

	private static final long serialVersionUID = -9020232321419850473L;

	/**
	 * 权限 id
	 */
	Integer id ;

	/**
	 * 权限码
	 * 唯一标识一条权限
	 */
	String permissionCode;

	/**
	 * 权限所属业务线
	 */
	String type;
}
