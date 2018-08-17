package com.ares.exam.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.ares.exam.dto.PoliceSelectCondition;
import com.ares.exam.dto.Result;
import com.ares.exam.entity.LzPoliceInfo;
import com.ares.exam.entity.PoliceSelect;
import com.ares.exam.util.Constants;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ares.exam.dao.ExamPoliceInfoDao;
import com.ares.exam.dao.PoliceInfoDao;
import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.entity.PoliceInfo;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.PoliceInfoService;
import com.ares.exam.util.StringUtil;

import javax.servlet.http.HttpSession;

@Service
public class PoliceInfoServiceImpl implements PoliceInfoService{
	@Autowired
	private PoliceInfoDao policeInfoDao;
	@Autowired
	private ExamPoliceInfoDao examPoliceInfoDao;


	@Override
	public Result queryLzPoliceInfo(HttpSession session) {
		Long userId= (Long)session.getAttribute(Constants.USERID_KEY);
		if(userId != null) {
			//Long userId=Long.valueOf(userIdStr.toString());
			LzPoliceInfo lzPoliceInfo = policeInfoDao.queryLzPoliceInfo(userId);
			return new Result<LzPoliceInfo>(true,"查询成功",lzPoliceInfo);
		}else {
			return new Result<>(false,"你需要重新登陆!");
		}
	}

	@Override
	public PoliceInfo getByUserAndPwd(PoliceInfo policeInfo) throws ParameterNullException {
		if(policeInfo==null||policeInfo.getJh()==null||policeInfo.getPwd()==null) {
			throw new ParameterNullException("参数为空");
		}else {
			return policeInfoDao.queryPoliceInfoByUserAndPwd(policeInfo);
		}
		
	}
	
	@Override
	public List<PoliceInfo> getListByReadExcel(Workbook hwb) {
		HSSFSheet sheet=(HSSFSheet) hwb.getSheet("data");
		List<Long> ids=new ArrayList<>();
		if(sheet != null) {
			int fi=sheet.getFirstRowNum();
			int li=sheet.getLastRowNum();
			for(int i=fi;i<=li;i++) {
				HSSFRow hr=sheet.getRow(i);
				if(hr.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.println(i+"行是数字列");
					long x = Math.round(hr.getCell(0).getNumericCellValue());
					ids.add(x);
				}else if(hr.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
					String v=hr.getCell(0).getStringCellValue();
					if(StringUtil.isNumeric(v)) {
						Long x=Long.valueOf(v);
						ids.add(x);
					}	
				}
			}
			return policeInfoDao.queryPoliceInfoListByExcel(ids);
		}
		return null;
	}
	
	@Override
	public List<PoliceInfoDto> getListByExamID(Long examID) throws ParameterNullException {
		// TODO Auto-generated method stub
		if(examID == null) {
			throw new ParameterNullException("参数为空");
		}else {
			return examPoliceInfoDao.getPoliceInfoDtoByExamID(examID);
		}
	}

	@Override
	public List<PoliceInfo> getList(PoliceInfo policeInfo) throws ParameterNullException {
		if(policeInfo == null) {
			throw new ParameterNullException("参数为空");
		}else {
			return policeInfoDao.queryPoliceInfoList(policeInfo);
		}
	}

	@Override
	public List<PoliceSelect> getPoliceSelectList(PoliceSelectCondition condition) throws ParameterNullException {
		if(condition == null) {
			throw new ParameterNullException("参数为空");
		}else {
			return policeInfoDao.getPoliceSelectList(condition);
		}
	}

}
