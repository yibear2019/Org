package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class OrganizationNode implements Serializable {
	private static final long serialVersionUID = -2992235709534647738L;

	/**
	 * organization id
	 */
	Long id;

	/**
	 * organization name
	 */
	String name;

	/**
	 * tree structure
	 * children node
	 */
	List<OrganizationNode> childrenList;
}
