package com.bearbaba.orgprovider.serviceImpl;

import com.bearbaba.orginterface.service.StaffService;
import com.bearbaba.orgprovider.mapper.RoleMapper;
import com.bearbaba.orgprovider.mapper.StaffRoleRelMapper;
import com.bearbaba.orgprovider.model.Role;
import com.bearbaba.orgprovider.model.Staff;
import com.bearbaba.orgprovider.mapper.StaffMapper;
import com.bearbaba.orgprovider.model.StaffRoleRel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author YangXiong
 * @date 2019/12/30
 */
public class StaffServiceImpl implements StaffService {
	Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

	@Autowired
	StaffMapper staffMapper;

	@Autowired
	RoleMapper roleMapper;

	@Autowired
	StaffRoleRelMapper staffRoleRelMapper;

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
			logger.info("转换Model失败,员工属性不完善");
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
			logger.info("更新员工信息失败,员工信息为空");
			return false;
		}

		Staff validation = staffMapper.selectByPrimaryKey(staff.getId());
		if(validation == null){
			logger.info("更新员工信息失败,对应员工不存在");
			return false;
		}
		if(!validation.getEnterpriseId().equals(staff.getEnterpriseId()) &&
		!validation.getOrgId().equals(staff.getOrgId())){
			logger.info("更新员工信息失败,员工信息不匹配");
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
		for (Long curRoleId : roleList) {
			Role curRole = roleMapper.selectByPrimaryKey(curRoleId);
			if(curRole == null){
				logger.warn("当前赋权角色不存在,对应角色ID:" + curRoleId);
				continue;
			}
			List<StaffRoleRel> staffIdList = staffRoleRelMapper.selectByRoleId(curRoleId);
			/**
			 * todo
			 * 可 sql 查这条数据有无,
			 * 若无则插入
			 */
			boolean flag = true;
			for (StaffRoleRel rel : staffIdList) {
				if(rel.getStaffId().equals(staffId)){
					flag = false;
				}
			}
			if(flag){
				StaffRoleRel modelRel = new StaffRoleRel();
				modelRel.setRoleId(curRoleId);
				modelRel.setStaffId(staffId);
				staffRoleRelMapper.insert(modelRel);
			}
		}
		return true;
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
			logger.info("获取员工信息失败,对应员工不存在");
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
			logger.info("冻结员工失败,对应员工不存在");
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
			logger.info("解冻员工失败,对应员工不存在");
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
			logger.info("删除员工失败,对应员工不存在");
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
				 * 考虑加上失败回滚逻辑
				 */
				logger.warn("删除员工失败,对应员工ID:" + curId);
				return false;
			}
		}
		return true;
	}
}
