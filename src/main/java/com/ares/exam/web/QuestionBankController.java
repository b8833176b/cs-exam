package com.ares.exam.web;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ares.exam.dto.QueryQuestionBankDto;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.dto.Result;
import com.ares.exam.entity.Question;
import com.ares.exam.entity.QuestionBank;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionBankService;
import com.ares.exam.service.QuestionService;
import com.ares.exam.util.Constants;
@Controller
@RequestMapping("/QuestionBank")
public class QuestionBankController extends BaseController{
	@Autowired
	private QuestionBankService questionBankService;
	@Autowired
	private QuestionService questionService;
	@RequestMapping(value="/getList",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<QuestionBank>> getQuestionBankList(){
		List<QuestionBank> ls;
		try {
			ls=questionBankService.getList();
		} catch (Exception e) {
			// TODO: handle exception
			return new Result<List<QuestionBank>>(false,"错误！");
		}
		return new Result<List<QuestionBank>>(true,"查询成功!",ls);
	}
	
	@RequestMapping(value="/getIsDisplayList",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<QuestionBank>> getIsDisplayQuestionBankList(QuestionBank questionBank){
		List<QuestionBank> ls;
		try {
			ls=questionBankService.getIsDisplayList();
		} catch (Exception e) {
			// TODO: handle exception
			return new Result<List<QuestionBank>>(false,"错误！");
		}
		return new Result<List<QuestionBank>>(true,"查询成功!",ls);
	}
	
	@RequestMapping(value="/getDtoList",method= {RequestMethod.GET,RequestMethod.POST}, consumes = "application/json")
	public  @ResponseBody Result<List<QuestionBankDto>> getQuestionBankDtoList(@RequestBody  QueryQuestionBankDto queryQuestionBankDto){
		List<QuestionBankDto> ls;
		try {
	
			ls=questionBankService.getQuestionBankDtoList(queryQuestionBankDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result<List<QuestionBankDto>>(false,"错误!");
		}
		return new Result<List<QuestionBankDto>>(true,"查询成功!",ls);
	}
	
	@RequestMapping(value="/getQuestions",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<Question>> getQuestionByBankID(Long questionBankID){
		List<Question> ls;
		try {
			ls=questionService.getQuestionsByBankID(questionBankID);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<List<Question>>(false,"错误!");
		}
		return new Result<List<Question>>(true,"查询成功!",ls);
	}
	
	@RequestMapping(value="/del",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> delQuestionBank(QuestionBank questionBank){
		try {
			int r = questionBankService.delQuestionBank(questionBank);
			if(r>0) {
				return new Result<>(true,"删除成功");
			}else {
				return new Result<>(true,"对应题库不存在");
			}
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			return  new Result<>(false,e.getMessage());
		}catch(Exception e) {
			return  new Result<>(false,"有考试引用此题库，无法删除！");
		}
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> addQuestionBank(QuestionBank questionBank){
		try {
			//获取添加人 录入其中
			HttpSession httpSession=getSession();
			String username=(String) httpSession.getAttribute(Constants.USERNAME_KEY);
			questionBank.setFounder(username);
			questionBank.setUpdateMan(username);
			questionBankService.addQuestionBank(questionBank);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false,"添加失败！");
		}
		return new Result<>(true,"添加成功");
	}
	
	@RequestMapping(value="/update",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> updateQuestionBank(QuestionBank questionBank){
		try {
			questionBankService.updateQuestionBank(questionBank);
			return new Result<>(true,"修改成功");
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			
			return new Result<>(false,"缺少参数！");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result<>(false,"修改失败！");
		}
	}
	
}
