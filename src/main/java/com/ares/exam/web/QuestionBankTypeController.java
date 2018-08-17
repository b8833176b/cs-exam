package com.ares.exam.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ares.exam.dto.Result;
import com.ares.exam.entity.QuestionBankType;
import com.ares.exam.exception.NameRepeatException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionBankTypeService;

@Controller
@RequestMapping("/QuestionBankType")
public class QuestionBankTypeController {
	@Autowired
	private QuestionBankTypeService questionBankTypeService;
	@RequestMapping(value="/getList",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<QuestionBankType>> list() {
		List<QuestionBankType> ls=null;
		try {
			ls=questionBankTypeService.queryQuestionBankType();
		} catch (Exception e) {
			// TODO: handle exception
			return new Result<List<QuestionBankType>>(false,"错误!");
		}
		return new Result<List<QuestionBankType>>(true,"成功",ls);
	}
	
	@RequestMapping(value="/get",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<QuestionBankType> getQuestionBankType(QuestionBankType questionBankType){
		QuestionBankType questionBankTypeR=null;
		try {
			questionBankTypeR=questionBankTypeService.getQuestionBankType(questionBankType);
			if(questionBankTypeR == null) {
				return new Result<>(false,"对应题库类型不存在");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new Result<>(false,"出现错误！");
		}
		return new Result<>(true,"查询成功",questionBankTypeR);
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> add(QuestionBankType questionBankType){
			try {
				questionBankTypeService.addQuestionBankType(questionBankType);
			} catch (NameRepeatException e) {
				// TODO Auto-generated catch block
	//			e.printStackTrace();
				return new Result<>(false,"名称已经存在");
			} catch (ParameterNullException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
				return new Result<>(false,"参数为空");
			}
			return new Result<>(false,"添加成功");
	}
	
	@RequestMapping(value="/del",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> delQuestionBankType(QuestionBankType questionBankType){
		try {
			int r=questionBankTypeService.delQuestionBankType(questionBankType);
			if(r>0) {
				return new Result<>(true,"删除成功!");
			}else {
				return new Result<>(true,"对应条目不存在");
			}
		} catch (Exception e) {
			// TODO: handle exception
	//		e.printStackTrace();
			return new Result<>(false,"有该类型的题库存在，无法删除!");
		}
	}
	
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> updateQuestionBankType(QuestionBankType questionBankType){
		try {
			questionBankTypeService.updateQuestionBankType(questionBankType);
		} catch (ParameterNullException e) {
			return new Result<>(false,"参数为空!");
		} catch (NameRepeatException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"名称重复!");
		}
		return new Result<>(true,"修改成功!");
	}
}
