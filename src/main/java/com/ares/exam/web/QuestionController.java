package com.ares.exam.web;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ares.exam.dto.Result;
import com.ares.exam.entity.QuestionRadio;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionService;

@Controller
@RequestMapping("/Question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@RequestMapping(value="/del",method={RequestMethod.GET,RequestMethod.POST})
	public   @ResponseBody Result<String> del(Long questionID){
		try {
			questionService.delQuestion(questionID);
			return new Result<>(true,"删除成功！");
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			
			return new Result<>(false,"ID参数为空！");	
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"此试题被考试引用，无法删除！");
		}	
	}
	
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> update(QuestionRadio question){
		try {
			questionService.updateQuestion(question);
			return new Result<>(true,"更新成功！");	
		} catch (ParameterNullException e) {
			return new Result<>(false,"参数为空！");	
		}
	}
	
	
}
