package com.ares.exam.web;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.ares.exam.dto.PoliceSelectCondition;
import com.ares.exam.entity.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.dto.Result;
import com.ares.exam.exception.FileFormatException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.PoliceInfoService;
import com.ares.exam.service.TypeInfoService;
import com.ares.exam.util.ImportExcelUtil;

import javax.servlet.http.HttpSession;

/**
 * 考试信息控制器
 * @author szares02
 *
 */
@Controller
@RequestMapping("/PoliceInfo")
public class PoliceInfoController {
	@Autowired
	private PoliceInfoService policeInfoService;
	@Autowired
	private TypeInfoService typeInfoService;

	@RequestMapping(value="/queryLzPoliceInfo",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<PoliceInfo> queryLzPoliceInfo(HttpSession session){
		try {
			return policeInfoService.queryLzPoliceInfo(session);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false,"参数错误!");
		}
	}

	@RequestMapping(value="/getUserByExam",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<PoliceInfoDto>> getUserByExam(Exam exam){
		if(exam != null && exam.getExamID()!=null) {
			List<PoliceInfoDto> ls;
			try {
				ls = policeInfoService.getListByExamID(exam.getExamID());
				return new Result<>(true,"查询成功",ls);
			} catch (ParameterNullException e) {
				return new Result<>(false,"出现错误!");
			}
		}else {
			return new Result<>(false,"参数错误!");
		}
	}
	
	@RequestMapping(value="/queryUser",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<PoliceInfo>> queryUser(PoliceInfo policeinfo){
		List<PoliceInfo> ls;
		try {
			ls =policeInfoService.getList(policeinfo);
			return new Result<>(true,"查询成功",ls);
		} catch (ParameterNullException e) {
			
			return new Result<>(false,"参数错误!");
		}
	}

	@RequestMapping(value="/queryUserSelect",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<PoliceSelect>> queryUserSelect(PoliceSelectCondition condition){
		List<PoliceSelect> ls;
		try {
			ls =policeInfoService.getPoliceSelectList(condition);
			return new Result<>(true,"查询成功",ls);
		} catch (ParameterNullException e) {
			return new Result<>(false,"参数错误!");
		}
	}
	
	/**
	 * 通过上传excel查询用户ID列表
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/Upload",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<PoliceInfo>> uploadUserExcelQueryUserlist(@RequestParam(value = "file", required = false) MultipartFile file){
		InputStream in = null;
		if(file==null||file.isEmpty()) {
			return new Result<>(false,"文件不存在");
		}
		try {
			in=file.getInputStream();
			Workbook wb=new ImportExcelUtil().getWorkbook(in, file.getOriginalFilename());
			List<PoliceInfo> pis=policeInfoService.getListByReadExcel(wb);
			if(pis==null) {
				return new Result<>(true,"系统中没有匹配的考生");
			}
			return new Result<>(true,"查询成功",pis);
		} catch (IOException e) {
			
			return new Result<>(false,"文件读取失败");
		} catch (FileFormatException e) {
			// TODO Auto-generated catch block
		
			return new Result<>(false,"文件读取失败");
		}
	}
	
	@RequestMapping(value="/getDepartmentTypeList",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<DepartmentType>> getDepartmentTypeList() {
		try {
			List<DepartmentType> ls=typeInfoService.getDepartmentTypeList();
			return new Result<>(true,"查询成功",ls);
		} catch (Exception e) {
			return new Result<>(false,"错误!");
		}
	}
	
	@RequestMapping(value="/getPoliceRankTypeList",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<PoliceRankType>> getPoliceRankTypeList() {
		try {
			List<PoliceRankType> ls=typeInfoService.getPoliceRankTypeList();
			return new Result<>(true,"查询成功",ls);
		} catch (Exception e) {
			return new Result<>(false,"错误!");
		}
	}
	
	@RequestMapping(value="/getPostTypeList",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<PostType>> getPostTypeList() {
		try {
			List<PostType> ls=typeInfoService.getPostTypeList();
			return new Result<>(true,"查询成功",ls);
		} catch (Exception e) {
			return new Result<>(false,"错误!");
		}
	}
	
	@RequestMapping(value="/getUnitTypeList",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<UnitType>> getUnitTypeList() {
		try {
			List<UnitType> ls=typeInfoService.getUnitTypeList();
			return new Result<>(true,"查询成功",ls);
		} catch (Exception e) {
			return new Result<>(false,"错误!");
		}
	}
	
	
	
}
