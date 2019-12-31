package com.bearbaba.orginterface.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 5816014942664655984L;

	/**
	 * 用户 id
	 */
	Long id;

	/**
	 * 用户名
	 * 不可登陆用,无唯一性,仅做展示
	 */
	String userName;

	/**
	 * 用户电话
	 * 登陆用,有唯一性,非空
	 */
	Long telephoneNumber;

	/**
	 * 用户邮箱
	 * 可登陆用
	 */
	String mail;

	/**
	 * 用户密码
	 */
	String password;

	/**
	 * 对应账号所对应的员工 id list
	 */
	List<Integer> staffList;
}
