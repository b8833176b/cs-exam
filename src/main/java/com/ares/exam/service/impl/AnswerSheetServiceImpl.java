package com.ares.exam.service.impl;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ares.exam.dto.*;
import com.ares.exam.exception.ParmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ares.exam.dao.AnswerDao;
import com.ares.exam.dao.AnswerSheetDao;
import com.ares.exam.dao.ExamDao;
import com.ares.exam.dao.ExamPoliceInfoDao;
import com.ares.exam.dao.QuestionDao;
import com.ares.exam.entity.Answer;
import com.ares.exam.entity.AnswerSheet;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.entity.Question;
import com.ares.exam.entity.QuestionJudgment;
import com.ares.exam.entity.QuestionMultiple;
import com.ares.exam.entity.QuestionRadio;
import com.ares.exam.exception.NotExistException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.AnswerSheetService;
import com.ares.exam.util.Constants;
import com.ares.exam.util.ImportExcelUtil;
import com.ares.exam.util.StringUtil;

@Service
public class AnswerSheetServiceImpl implements AnswerSheetService{
	@Autowired
	private AnswerSheetDao answerSheetDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private ExamPoliceInfoDao examPoliceInfoDao;
	@Autowired
	private ExamDao examDao;
	@Autowired
	private AnswerDao answerDao;
	@Override
	public List<Answer> getMark(List<Answer> answers,Exam exam) throws ParameterNullException,NotExistException {
		// TODO Auto-generated method stub
		List<Answer> nas=new ArrayList<Answer>();
		if(answers!=null) {
			for(Answer key: answers) {
				Long qid=key.getQuestionID();
				Question q=questionDao.getQuestionById(qid);
				if(q==null) {
					throw new NotExistException("有考题不存在!"); 
				}
				else if(q.getQuestionType()==Constants.QuestionType.Radio.getValue()) { //单选题
					Answer a=getRadioMark(key,(QuestionRadio) q, exam.getRadioScore());
					nas.add(a);
				}else if(q.getQuestionType()==Constants.QuestionType.multiple.getValue()) {//多选题
					Answer a=getMultipleMark(key, (QuestionMultiple) q,exam.getMultipleScore());
					nas.add(a);
				}else if(q.getQuestionType()==Constants.QuestionType.Judgment.getValue()) { //判断题
					Answer a=getJudgmentMark(key, (QuestionJudgment) q,exam.getJudgmentScore());
					nas.add(a);
				}else {  //其它类型的题目，原样返回
					nas.add(key);
				}
				
			}
		
		}else {
			throw new ParameterNullException("参数为空!");
		}
		return nas;
	}

	@Override
	public int save(List<Answer> answers,Exam exam) throws ParameterNullException, NotExistException {
		try {
			List<Answer> ls= getMark(answers,exam);
			//打印出来
			/*for(Answer key:ls) {
				System.out.println(key);
			}*/
			return answerDao.inserAnswer(ls);
		} catch (ParameterNullException e) {
			e.printStackTrace();
			throw e;
		} catch (NotExistException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Transactional
	@Override
	public int submit(ExamPoliceInfo epi, List<Answer> answers) throws NotExistException, ParameterNullException {
		ExamPoliceInfo examPoliceInfo=examPoliceInfoDao.get(epi.getExamID(), epi.getUserID());
		if(examPoliceInfo!=null) {
			if(examPoliceInfo.getIsOver()==1) {
				AnswerSheet as=answerSheetDao.getAnswerSheet(epi.getUserID(), epi.getExamID());
				if(as==null) {
					throw new NotExistException("考试没有开始");
				}else {
					if(as.getAssignmentTime()==null){ 
						as.setAssignmentTime(new Date(System.currentTimeMillis()));
						answerSheetDao.update(as);
						examPoliceInfo.setIsOver(2);
						examPoliceInfoDao.updateState(examPoliceInfo);
						//set 用户和考试属性
						for(Answer key:answers) {
							key.setAnswerSheetID(as.getAnswerSheetID());
							key.setIsReview(0);
						}
						Exam e=examDao.getExam(epi.getExamID());
						int r=save(answers,e);//自动评分
						loadMark(as.getAnswerSheetID());
						return r;
					}else{
						throw new NotExistException("考试已经交卷");
					}
				}				
			}else {
				throw new NotExistException("考试已经开始或者已经结束！"); 
			}
		}else {
			throw new NotExistException("对应考试不存在");
		}
	}
	
	
	
	private Answer getRadioMark(Answer a,QuestionRadio qr,Float s) {
		String r=a.getRespondence();
		String bz=qr.getRightAnswer();
		if(StringUtil.isABCD(r)&&StringUtil.isABCD(bz)) {
			if(r.toUpperCase().equals(bz.toUpperCase())) {
				a.setScore(s);
				a.setCorrect(1);
			}else {
				a.setScore((float) 0);
				a.setCorrect(0);
			}
		
		}else {
			a.setScore((float) 0);
			a.setCorrect(0);
		}
		a.setIsReview(1);
		return a;
	}
	
	private Answer getMultipleMark(Answer a,QuestionMultiple qm,Float s){ 
		String r=a.getRespondence();
		String bz=qm.getRightAnswer();
		String[] rs=StringUtil.Mysplit(r);
		String[] bzs=StringUtil.Mysplit(bz);
		if(rs!=null&&bzs!=null) {
			if(rs.length==bzs.length) {
				boolean ok=true;
				Arrays.sort(rs);
				Arrays.sort(bzs);
				for(int i=0;i<rs.length;i++) {
					if(!rs[i].toUpperCase().equals(bzs[i].toUpperCase())) {
						
						ok=false;
						break;
					}
				}
				if(ok) {
					a.setScore(s);
					a.setCorrect(1);
				}else {
					a.setScore((float) 0);
					a.setCorrect(0);
				}
			}else {
				a.setScore((float) 0);
				a.setCorrect(0);
			}
		}else {
			a.setScore((float) 0);
			a.setCorrect(0);
		}
		a.setIsReview(1);
		return a;
	}
	
	private Answer getJudgmentMark(Answer a,QuestionJudgment qj,Float s) {
		String r=a.getRespondence();
		String bz=qj.getRightAnswer();
		if(r!=null&&bz!=null) {
			if(r.toUpperCase().equals(bz.toUpperCase())) {
				a.setScore(s);
				a.setCorrect(1);
			}else {
				a.setScore((float) 0);
				a.setCorrect(0);
			}
		}else {
			a.setScore((float) 0);
			a.setCorrect(0);
		}
		a.setIsReview(1);
		return a;
	}

	@Override
	public List<AnswerDto> queryAnswerDto(Long answerSheetID) throws ParameterNullException {
		if(answerSheetID!=null) {
			return answerDao.queryAnswerDto(answerSheetID);
		}else {
			throw new ParameterNullException("缺少参数");
		}
	}

	@Override
	public AnswerSheet getAnswerSheet(Long examID,Long userID) throws ParameterNullException {
		// TODO Auto-generated method stub
		if(examID!=null && userID!=null) {
			return answerSheetDao.getAnswerSheet(userID, examID);
		}else {
			throw new ParameterNullException("缺少参数");
		}
	
	}

	@Override
	public List<AnswerDto> queryAnswerDto(Long examID, Long userID) throws ParameterNullException, NotExistException {
		AnswerSheet as=getAnswerSheet(examID, userID);
		if(as != null) {
			return queryAnswerDto(as.getAnswerSheetID());
		}else {
			throw new NotExistException("答卷不存在!");
		}
	
	}

	@Override
	public int update(List<Answer> answers) throws ParameterNullException, NotExistException {
		if(answers==null||answers.size()==0) {
			return 0;
		}else {
			int r=answerDao.updateAnswer(answers);
			Answer a = answerDao.get(answers.get(0).getAnswerID());
			if(a!=null) {
				loadMark(a.getAnswerSheetID());
			}
			return r;
		}
		
	}
	
	/**
	 * 检查评分是否合理
	 * @param answers
	 * @return
	 */
	@SuppressWarnings("unused")
	private int checkAnsers(List<Answer> answers) {
		//检查评分是否超过范围
		if(answers!=null&&answers.size()>0) {
			Answer as=answers.get(0);
			
		}else{
			
		}
		return 0;
	}

	@Override
	public List<AnswerSheetDto> queryAnswerSheetDtosByExam(Exam exam) throws ParameterNullException {
		if(exam!=null) {
			if(!StringUtil.isEmpty(exam.getExamName())) {
				
				Exam e = examDao.getExamByName(exam.getExamName());
				if(e!=null) {
					return answerSheetDao.queryAnswerSheetDtoByID(exam.getExamID());
				}else {
					throw new ParameterNullException("考试不存在！");
				}
			}else if(exam.getExamID()!=null) {
				return answerSheetDao.queryAnswerSheetDtoByID(exam.getExamID());
			}else {
				throw new ParameterNullException("参数为空！");
			}
		}else {
			throw new ParameterNullException("参数为空！");
		}
	}

	@Override
	public List<AnswerSheetDto> queryManualMark(ManualMarkCondition condition){
		if(condition.getExamID()==null)
			throw new ParmException("考试ID，参数为空！");
		return answerSheetDao.queryManualMark(condition);
	}


	@Override
	public void loadMark(Long answerSheetID) {
		int r=answerDao.getNoMarkCount(answerSheetID);//获得答卷中未打分的试题数量
		if(r>0) { //当试卷还有未评分的题目，什么也不做
		}else {//当该试卷全部都已经评分了
			AnswerSheet as=answerSheetDao.get(answerSheetID);
			if(as!=null) {
				Float s=answerSheetDao.markSum(answerSheetID);//根据试卷id，计算该试卷已经评分的分数
				if(s!=null) {
					as.setScore(s);//设置总分
					as.setIsMarking(1);//设置已阅
					answerSheetDao.update(as);//更新该试卷的总分和状态
				
				}else {
					System.out.println("????????");
				}
			}else {
				System.out.println("??????"+answerSheetID);
			}
		}
	}


	@Override
	public List<ExamResultDto> queryExamResultDtos(QueryAnswerSheetDto qasd) throws ParameterNullException {
		if(qasd!=null&&qasd.getExamID()!=null) {
			return answerSheetDao.queryExamResultDtos(qasd);
		}else {
			if(qasd==null)
				throw new ParameterNullException("参数为空!");
			if(qasd.getExamID()==null)
				throw new ParameterNullException("考试ID为空!");
		}
		return null;
	}

	@Override
	public void exportExcelByQuery(QueryAnswerSheetDto qasd, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ParameterNullException {
		try {
			List<ExamResultDto>  erds=queryExamResultDtos(qasd);
			exportExcel(erds, session, request, response);
		} catch (ParameterNullException e) {
			throw e;
		}	
	}
	
	private void exportExcel(List<ExamResultDto> erds,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String [] excelHeader = {"记录号","警号","姓名","IP地址","得分","状态"};
		String [] ds_titles = {"answerSheetID","jh","xm","addressIP","score","isMiss"};
		int [] ds_format = {2,2,2,2,2,2,2};
		List<Map<String, Object>> data =new ArrayList<>();
		if(erds!=null&&!erds.isEmpty()) {
			for(ExamResultDto key:erds) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("answerSheetID", key.getAnswerSheetID());
				map.put("jh", key.getJh());
				map.put("xm", key.getXm());
				map.put("score", key.getScore());
				map.put("addressIP", key.getAddressIP());
				map.put("isMiss", key.getIsMissStr());
				map.put("isPass", key.getIsPass());
				data.add(map);
			}
		}
		try {
			ImportExcelUtil.export("成绩表", "数据", excelHeader, ds_titles, ds_format, null, data, request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
