package com.ares.exam.web;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.ares.exam.exception.ParmException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ares.exam.dto.Result;
import com.ares.exam.entity.Question;
import com.ares.exam.exception.FileFormatException;
import com.ares.exam.service.QuestionBankService;
import com.ares.exam.service.QuestionService;
import com.ares.exam.util.Constants;
import com.ares.exam.util.ImportExcelUtil;
import com.ares.exam.util.StringUtil;
@Controller
@RequestMapping("/uploadQuestionExcel")
public class UploadQuestionExcelController  extends BaseController{
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuestionBankService questionBankService;
	/** 题库管理-导入试题 */
	@Transactional
	@RequestMapping(value="/Upload",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody  Result<String> uploadExcel(@RequestParam("questionBankID") String questionBankID,@RequestParam(value = "file", required = false) MultipartFile file)  {
		InputStream in = null;
		if(file.isEmpty()) {
			return new Result<>(false,"文件不存在");
		}else if(questionBankID==null||!StringUtil.isNumeric(questionBankID)) {
			return new Result<>(false,"缺少题库参数!");
		}
		try {
			HttpSession httpSession=getSession();
			String name=(String) httpSession.getAttribute(Constants.USERNAME_KEY);
			in=file.getInputStream();
			Workbook wb=new ImportExcelUtil().getWorkbook(in, file.getOriginalFilename());
			Map<Integer, List<Question>> map=questionService.ReadXls(wb);
			Set<Integer> set=map.keySet();
			questionBankService.clean(Long.valueOf(questionBankID));
			questionBankService.updateMan(Long.valueOf(questionBankID), name);
			for(Integer key:set) {
				questionService.insertQuestion(key,Long.valueOf(questionBankID), map.get(key));
			}
			return new Result<>(true,"保存成功！");		
		}catch (ParmException e) {
			return new Result<>(false,e.getMessage());
		}catch (IOException e) {
			return new Result<>(false,"文件读取异常！");
		} catch (FileFormatException e) {
			return new Result<>(false,"文件格式错误！");
		}
	}
}
