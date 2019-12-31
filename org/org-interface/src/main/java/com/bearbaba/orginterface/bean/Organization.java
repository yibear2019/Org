package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Organization implements Serializable {
	private static final long serialVersionUID = -2597193874686253778L;

	/**
	 * 组织 id
	 */
	Long id;

	/**
	 * 父组织 id
	 */
	Long pid;

	/**
	 * 节点名
	 */
	String name;

	/**
	 * 组织节点所属级别
	 */
	String level;
}
