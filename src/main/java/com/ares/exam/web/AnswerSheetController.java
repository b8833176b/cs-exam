package com.ares.exam.web;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ares.exam.dto.*;
import com.ares.exam.exception.ParmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ares.exam.entity.Answer;
import com.ares.exam.entity.Exam;
import com.ares.exam.exception.NotExistException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.AnswerSheetService;
@Controller
@RequestMapping("/AnswerSheet")
public class AnswerSheetController {
	@Autowired
	private AnswerSheetService answerSheetService;
	@RequestMapping(value="/getAnswerDtoList",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<AnswerDto>> queryAnswerDto(Long answerSheetID){
		try {
			List<AnswerDto> ls=answerSheetService.queryAnswerDto(answerSheetID);
			return new Result<>(true,"查询成功",ls);
		} catch (ParameterNullException e) {
			return new Result<>(false, "参数为空");
		} 
	}
	
	/**
	 * 根据考试查看考试考卷封装信息
	 * @param condition
	 * @return
	 */
	@RequestMapping(value="/getAnswerSheetDtosByExam",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<AnswerSheetDto>> getAnswerSheetDtosByExamID(ManualMarkCondition condition){
		try {
			//List<AnswerSheetDto> ls=answerSheetService.queryAnswerSheetDtosByExam(exam);
			List<AnswerSheetDto> ls=answerSheetService.queryManualMark(condition);
			return new Result<>(true,"查询成功",ls);
		} catch (ParmException e){
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, "查询失败");
		}
	}
	
	//保存或修改评分
	@RequestMapping(value="/submit",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody  Result<String> submitAnswer(@RequestBody List<Answer> answers){
		try {
			answerSheetService.update(answers);
			return new Result<>(true,"提交成功!");
		} catch (ParameterNullException e) {
			e.printStackTrace();
			return new Result<>(false,"参数为空!");
		} catch (NotExistException e) {
			e.printStackTrace();
			return new Result<>(false,"出现问题!");
		}
	}
		
	//查询成绩
	@RequestMapping(value="/queryExamResultDtos",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<ExamResultDto>> queryExamResultDtos(QueryAnswerSheetDto qasd){
		try {
			List<ExamResultDto> ls=answerSheetService.queryExamResultDtos(qasd);
			return new Result<>(true,"查询成功",ls);
		} catch (ParameterNullException e) {
		//	e.printStackTrace();
			return new Result<>(false,e.getMessage()); 
		}
	}
	
	//导出excel 成绩
	@RequestMapping(value="/exportExcel",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> exportExcel(QueryAnswerSheetDto qasd,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		try {
			answerSheetService.exportExcelByQuery(qasd, session, request, response);
			return new Result<>(true,"成功");
		} catch (ParameterNullException e) {
			e.printStackTrace();
			return new Result<>(false,e.getMessage());
		}
	}
}
