package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Staff implements Serializable {

	private static final long serialVersionUID = -5178245177483591064L;

	/**
	 * 员工 Id
	 */
	Long id;

	/**
	 * 员工名
	 */
	String name;

	/**
	 * 电话号码
	 */
	Long telephoneNumber;

	/**
	 * 性别
	 */
	String sex;

	/**
	 * 身份证号
	 */
	String idCard;

	/**
	 * 员工被赋予角色列表
	 */
	List<Long> roleList;

	/**
	 * 隶属组织 id
	 */
	Long orgId;

	/**
	 * 隶属企业 id
	 */
	Long enterpriseId;

	/**
	 * 是否被冻结,默认 false
	 */
	boolean freeze;
}
