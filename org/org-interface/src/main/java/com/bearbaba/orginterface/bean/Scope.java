package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Scope implements Serializable {
	private static final long serialVersionUID = 6975837102051803665L;
	/**
	 * 作用组织 id
	 */
	Long organizationId;

	/**
	 * 权限码
	 */
	String permissionCode;
}
