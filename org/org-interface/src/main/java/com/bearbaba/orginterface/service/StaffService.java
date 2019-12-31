package com.bearbaba.orginterface.service;

import com.bearbaba.orginterface.bean.Staff;

import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
public interface StaffService {
	/**
	 * 添加员工
	 * @param staff
	 * @return 员工id
	 */
	public int addStaff(Staff staff);

	/**
	 * 修改员工信息(不用于赋权)
	 * @param staff
	 * @return
	 */
	public boolean updateStaffInfo(Staff staff);

	/**
	 * 给员工授权
	 * @param roleList
	 * @param staffId
	 * @return
	 */
	public boolean authorizeStaff(List<Long> roleList, Long staffId);

	/**
	 * 查询员工信息
	 * @param staffId
	 * @return
	 */
	public Staff getStaffInfo(Long staffId);

	/**
	 * 冻结员工
	 * @param staffId
	 * @return
	 */
	public boolean freeStaff(Long staffId);

	/**
	 * 解冻员工
	 * @param id
	 * @return
	 */
	public boolean unfreezeStaff(Long id);

	/**
	 * 删除员工
	 * @param id
	 * @return
	 */
	public boolean deleteStaff(Long id);

	/**
	 * 批量删除员工
	 * @param id
	 * @return
	 */
	public boolean batchDeleteStaff(List<Long> id);
}
