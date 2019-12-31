package com.bearbaba.orgprovider.serviceImpl;

import com.bearbaba.orginterface.bean.Staff;
import com.bearbaba.orginterface.service.StaffService;
import com.bearbaba.orgprovider.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffMapper staffMapper;
	/**
	 * 添加员工
	 *
	 * @param staff
	 * @return 员工id
	 */
	@Override
	public int addStaff(Staff staff) {
		return 0;
	}

	/**
	 * 修改员工信息(不用于赋权)
	 *
	 * @param staff
	 * @return
	 */
	@Override
	public boolean updateStaffInfo(Staff staff) {
		return false;
	}

	/**
	 * 给员工授权
	 *
	 * @param roleList
	 * @param staffId
	 * @return
	 */
	@Override
	public boolean authorizeStaff(List<Long> roleList, Long staffId) {
		return false;
	}

	/**
	 * 查询员工信息
	 *
	 * @param staffId
	 * @return
	 */
	@Override
	public Staff getStaffInfo(Long staffId) {
		Staff staff = staffMapper.selectByPrimaryKey(staffId);
		System.out.println("根据 id " + staffId + " 获取成功,对应员工姓名: " + staff.getName());
		return staff;
	}

	/**
	 * 冻结员工
	 *
	 * @param staffId
	 * @return
	 */
	@Override
	public boolean freeStaff(Long staffId) {
		return false;
	}

	/**
	 * 解冻员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean unfreezeStaff(Long id) {
		return false;
	}

	/**
	 * 删除员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteStaff(Long id) {
		return false;
	}

	/**
	 * 批量删除员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean batchDeleteStaff(List<Long> id) {
		return false;
	}
}
