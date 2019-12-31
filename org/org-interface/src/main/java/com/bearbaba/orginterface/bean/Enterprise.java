package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Enterprise implements Serializable {

	private static final long serialVersionUID = -2796604956282250301L;

	/**
	 * 企业 id
	 */
	Long id;

	/**
	 * 企业名
	 */
	String name;
}
