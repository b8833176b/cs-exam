package com.ares.exam.web;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ares.exam.dto.ExamDto;
import com.ares.exam.dto.ExamErrorInfo;
import com.ares.exam.dto.ExamInfoDto;
import com.ares.exam.dto.ExamInfoPara;
import com.ares.exam.dto.ExamQuestionInfoDto;
import com.ares.exam.dto.Result;
import com.ares.exam.dto.TrainParaDto;
import com.ares.exam.entity.Answer;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.entity.PoliceInfo;
import com.ares.exam.entity.Question;
import com.ares.exam.exception.ExamNotStartException;
import com.ares.exam.exception.NotExistException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.AnswerSheetService;
import com.ares.exam.service.ExamService;
import com.ares.exam.util.Constants;

@Controller
@RequestMapping("/Exam")
public class ExamController extends BaseController{
	@Autowired
	private ExamService examService;
	@Autowired
	private AnswerSheetService answerSheetService;
	@RequestMapping(value="/getList",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<List<ExamDto>> getExamDto(@RequestBody ExamDto examDto){
		List<ExamDto> ls=null;
		try {
			ls=examService.queryExamDto(examDto);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<List<ExamDto>>(false,"错误!");
		}
		return new Result<List<ExamDto>>(true,"查询成功!",ls);
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<ExamErrorInfo> add(@RequestBody ExamInfoPara eip,HttpSession session){
		ExamErrorInfo eei;
		try {
			eei = examService.addExam(eip,session);
			if(eei.isHasError()) {
				return new Result<>(false,"参数有错误！",eei);
			}else {
				return new Result<>(true,"添加成功!");
			}
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"缺少参数");
		}
	}
	
	@RequestMapping(value="/update",method= {RequestMethod.GET,RequestMethod.POST},consumes = "application/json;charset=utf-8")
	public @ResponseBody Result<ExamErrorInfo> updateExam(@RequestBody ExamInfoPara eip){
		ExamErrorInfo eei;
		try {
			eei = examService.update(eip);
			if(eei.isHasError()) {
				return new Result<>(false,"参数有错误！",eei);
			}else {
				return new Result<>(true,"修改成功!");
			}
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"缺少参数");
		}	
	}
	
	@RequestMapping(value="/del",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> delExam(ExamDto examDto){
		Long examID=examDto.getExamID();
		if(examID==null) {
			return new Result<>(false,"参数为空");
		}else {
			try {
				int r=examService.delExam(examID);
				if(r>0) {
					return new Result<>(true,"删除成功!");
				}else {
					return new Result<>(false,"参数为空");
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new Result<>(false,"有其它关联的成绩信息,无法删除！");
			}
		}
	}
	
	@RequestMapping(value="/getExamInfo",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<ExamInfoDto> getExamInfo(ExamDto examDto){
		if(examDto!=null&&examDto.getExamID()!=null) {
			ExamInfoDto eid=examService.getExamInfo(examDto.getExamID());
			return new Result<>(true,"查询成功!",eid);
		}else {
			return new Result<>(false,"参数为空");
		}
	}
	
	@RequestMapping(value="/start",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<Map<Long, List<Question>>> startExam(ExamPoliceInfo epi){
		try {
			HttpSession session=getSession();
			Long userID=(Long) session.getAttribute(Constants.USERID_KEY);
			String ip=getIpAddr(getRequest());
			epi.setUserID(userID); 
			examService.startExam(epi,ip);
			session.setAttribute(Constants.NOWEXAMID_KEY, epi.getExamID());
			return new Result<>(true,"考试已经开始");
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			return new Result<>(false,e.getMessage());
		} catch (ExamNotStartException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,e.getMessage());
		}catch(Exception e) {
			return new Result<>(false,"IP获取异常");
		}
	}
	
	
	@RequestMapping(value="/revoke",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> revokeExam(Long answerSheetID){
		try {
			examService.revokeExam(answerSheetID);
			return new Result<>(true,"试卷记录已经重置");
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			
			return new Result<>(false,e.getMessage());
		} catch (NotExistException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,e.getMessage());
		}
	}
	
	
	
	@RequestMapping(value="/submit",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> submit(@RequestBody List<Answer> ls){
		try {
			HttpSession session=getSession();
			Long examID=(Long) session.getAttribute(Constants.NOWEXAMID_KEY);
			Long userID=(Long) session.getAttribute(Constants.USERID_KEY);
			ExamPoliceInfo epi=new ExamPoliceInfo();
			epi.setExamID(examID);
			epi.setUserID(userID);
			answerSheetService.submit(epi, ls);
			return new Result<>(true,"成功！");
		} catch (ParameterNullException e) {
			return new Result<>(false,e.getMessage());
		} catch (NotExistException e) {
	
			return new Result<>(false,e.getMessage());
		}
	}
	
	@RequestMapping(value="/getExamQuestionInfo",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<ExamQuestionInfoDto> getExamQuestionInfo(){
		HttpSession session=getSession();
		Long examID=(Long) session.getAttribute(Constants.NOWEXAMID_KEY);
		if(examID!=null) {
			ExamQuestionInfoDto eqid=examService.getExamQestionInfoDto(examID);
			return new Result<>(true,"查询成功",eqid);
		}else {
			return new Result<>(false,"没有开始考试!");
		}
	}

	//gyw add,判断考试是否超时，防止用户关闭，或者后退页面后再次考试。
	/*@RequestMapping(value="/isExamOverTime",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result isExamOverTime(){
		HttpSession session=getSession();
		Long examID=(Long) session.getAttribute(Constants.NOWEXAMID_KEY);//获取考试ID
		Long userID=(Long) session.getAttribute(Constants.USERID_KEY);//获取当前考生id
		if(examID!=null) {
			ExamQuestionInfoDto eqid=examService.getExamQestionInfoDto(examID);
			//获取考试交卷时间（先获取用户在该考试开始答题的时间，再加上该考试设置的时长）
			//判断交卷时间是否超过当前系统时间，超过则直接提交试卷。

			return new Result<>(true,"考试时到!自动交卷！");
		}
		return new Result<>(false,"未超时!");

	}*/
	
	@RequestMapping(value="/train",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<ExamQuestionInfoDto> getTrain(@RequestBody TrainParaDto trainParaDto){
		try {
			ExamQuestionInfoDto eqid=examService.trian(trainParaDto);
			return new Result<>(true,"查询成功",eqid);
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"请填写完整！");
		} catch (NotExistException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"对应题库不存在!");
		}	
	}
	
	@RequestMapping(value="/queryUserExam",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<Map<Integer, List<ExamDto>>> queryUserExam(){
		HttpSession session=getSession();
		Long userID=(Long) session.getAttribute(Constants.USERID_KEY);
		if(userID!=null) {
			PoliceInfo pi=new PoliceInfo();
			pi.setUserID(userID);
			Map<Integer, List<ExamDto>> map=examService.queryUserExam(pi);
			return new Result<Map<Integer,List<ExamDto>>>(true, "查询结果!", map);
		}else {
			return new Result<>(false,"你需要登陆！");
		}
	}
	
	
	
}
