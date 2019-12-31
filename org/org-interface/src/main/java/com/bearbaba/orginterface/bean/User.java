package com.bearbaba.orginterface.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author YangXiong
 * @date 2019/12/22
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 3024380882742116946L;

	int id;
}
