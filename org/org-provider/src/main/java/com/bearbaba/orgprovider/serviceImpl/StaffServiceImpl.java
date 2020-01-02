package com.bearbaba.orgprovider.serviceImpl;

import com.bearbaba.orginterface.service.StaffService;
import com.bearbaba.orgprovider.model.Staff;
import com.bearbaba.orgprovider.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Iterator;
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
	public int addStaff(com.bearbaba.orginterface.bean.Staff staff) {
		Staff curStaff = new Staff();
		convertToModel(staff,curStaff);
		/**
		 * todo
		 * long 型主键插入,Mybatis返回 int
		 */
		int staffId = staffMapper.insert(curStaff);
		return staffId;
	}

	private void convertToModel(com.bearbaba.orginterface.bean.Staff staff, Staff curStaff) {
		if(staff == null || staff.getOrgId() == null ||
		staff.getEnterpriseId() == null || staff.getName() == null ||
		staff.getSex() == null || staff.getTelephoneNumber() == null){
			return;
		}

		curStaff.setEnterpriseId(staff.getEnterpriseId());
		curStaff.setOrgId(staff.getOrgId());
		curStaff.setFreeze(false);
		curStaff.setCreateTime(new Date());
		curStaff.setName(staff.getName());
		curStaff.setSex(staff.getSex());
		curStaff.setTelephoneNumber(staff.getTelephoneNumber());
	}

	/**
	 * 修改员工信息(不用于赋权)
	 *
	 * @param staff
	 * @return
	 */
	@Override
	public boolean updateStaffInfo(com.bearbaba.orginterface.bean.Staff staff) {
		/**
		 * todo
		 * 参数校验考虑拆分为一个 before 模块来做
		 */
		if(staff == null){
			return false;
		}

		Staff validation = staffMapper.selectByPrimaryKey(staff.getId());
		if(validation == null){
			return false;
		}
		if(!validation.getEnterpriseId().equals(staff.getEnterpriseId()) &&
		!validation.getOrgId().equals(staff.getOrgId())){
			return false;
		}
		Staff curStaff = staffMapper.selectByPrimaryKey(staff.getId());
		convertToModel(staff,curStaff);
		staffMapper.updateByPrimaryKey(curStaff);
		return true;
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
	public com.bearbaba.orginterface.bean.Staff getStaffInfo(Long staffId) {
		Staff staff = staffMapper.selectByPrimaryKey(staffId);
		com.bearbaba.orginterface.bean.Staff dtoStaff = new com.bearbaba.orginterface.bean.Staff();
		convertToDto(staff,dtoStaff);
		return dtoStaff;
	}

	private void convertToDto(Staff staff, com.bearbaba.orginterface.bean.Staff dtoStaff) {
		if(staff == null){
			return;
		}

		dtoStaff.setEnterpriseId(staff.getEnterpriseId());
		dtoStaff.setOrgId(staff.getOrgId());
		dtoStaff.setFreeze(staff.getFreeze());
		dtoStaff.setId(staff.getId());
		dtoStaff.setIdCard(staff.getIdCard());
		dtoStaff.setName(staff.getName());
		dtoStaff.setSex(staff.getSex());
		dtoStaff.setTelephoneNumber(staff.getTelephoneNumber());
	}

	/**
	 * 冻结员工
	 *
	 * @param staffId
	 * @return
	 */
	@Override
	public boolean freeStaff(Long staffId) {
		Staff staff = staffMapper.selectByPrimaryKey(staffId);
		if(staff == null){
			return false;
		}
		staff.setFreeze(true);
		staffMapper.insert(staff);
		return true;
	}

	/**
	 * 解冻员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean unfreezeStaff(Long id) {
		Staff staff = staffMapper.selectByPrimaryKey(id);
		if(staff == null){
			return false;
		}
		staff.setFreeze(false);
		staffMapper.updateByPrimaryKey(staff);
		return true;
	}

	/**
	 * 删除员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteStaff(Long id) {
		Staff staff = staffMapper.selectByPrimaryKey(id);
		if(staff == null){
			return false;
		}
		staffMapper.deleteByPrimaryKey(id);
		return true;
	}

	/**
	 * 批量删除员工
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean batchDeleteStaff(List<Long> id) {
		for (Long curId : id) {
			Boolean curFlag = deleteStaff(curId);
			if (!curFlag) {
				/**
				 * todo
				 * 此处应记录失败 ID 到日志中,并考虑是否采取回滚措施
				 */

				return false;
			}
		}
		return true;
	}
}
