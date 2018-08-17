package com.ares.exam.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ares.exam.dto.Result;
import com.ares.exam.entity.ExamType;
import com.ares.exam.exception.NameRepeatException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.ExamTypeService;

@Controller
@RequestMapping("/ExamType")
public class ExamTypeController {
	@Autowired
	private ExamTypeService examTypeService;
	@RequestMapping(value="/getList",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<ExamType>> list(){
		List<ExamType> ls=null;
		try {
			ls=examTypeService.queryExamTypeList();
		} catch (Exception e) {
			// TODO: handle exception
			return new Result<List<ExamType>>(false,"错误!");
		}
	
		return new Result<List<ExamType>>(true,"查询成功",ls);
	}
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> add(ExamType examType){
		try {
			examTypeService.addExamType(examType);
		} catch (NameRepeatException | ParameterNullException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			return new Result<>(false,"错误！");
		}
		return new Result<>(false,"添加成功");
	}
	@RequestMapping(value="/del",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> delExamType(ExamType examType){
		try {
			int r=examTypeService.delExamType(examType);
			if(r>0) {
				return new Result<>(true,"删除成功!");
			}else {
				return new Result<>(true,"对应条目不存在");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new Result<>(false,"有该类型的考试存在，无法删除!");
		}
	}
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody Result<String> updateExamType(ExamType examType){
			try {
				examTypeService.updateExamType(examType);
			} catch (ParameterNullException e) {
				// TODO Auto-generated catch block
				return new Result<>(false,"参数为空!");
			} catch (NameRepeatException e) {
				// TODO Auto-generated catch block
				return new Result<>(false,"名称重复!");
			}
			return new Result<>(true,"修改成功!");
	}
}
