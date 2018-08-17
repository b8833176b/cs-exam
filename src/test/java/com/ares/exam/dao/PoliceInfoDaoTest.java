package com.ares.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.exam.BaseTest;
import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.entity.PoliceInfo;

public class PoliceInfoDaoTest extends BaseTest{
	@Autowired
	private PoliceInfoDao policeInfoDao;
	@Test
	public void testQueryPoliceInfo() {
		PoliceInfo pi=policeInfoDao.queryPoliceInfo(450200000053L);
		System.out.println(pi.getXm());
	}
	
	@Test
	public void testqueryPoliceInfoByUserAndPwd() {
		PoliceInfo police =new PoliceInfo();
		police.setJh("204236");
		police.setPwd("111111");
		PoliceInfo p2=policeInfoDao.queryPoliceInfoByUserAndPwd(police);
		System.out.println(p2);
	}
	
	@Test
	public void testQueryList() {
		List<PoliceInfo> ls=policeInfoDao.queryPoliceInfoList(new PoliceInfo());
		System.out.println(ls.get(0).getPwd());
	}
	
	@Test
	public void testQueryListDto() {
		
		List<PoliceInfoDto> ls=policeInfoDao.queryPoliceInfoDtoList(new PoliceInfo());
		System.err.println(ls.size()+"###########");
		System.out.println(ls.get(0).toString()+"!!!!!!!!!!!");
	}
	
	@Test
	public void testQueryPoliceInfoList() {
		List<Long> ids=new ArrayList<>();
		ids.add(450200000053L);
		ids.add(450200000055L);
		List<PoliceInfo> ls=policeInfoDao.queryPoliceInfoListByExcel(ids);
		System.out.println(ls.size());
	}

}
