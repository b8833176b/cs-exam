package com.ares.exam.service.impl;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ares.exam.entity.*;
import com.ares.exam.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ares.exam.dao.AnswerDao;
import com.ares.exam.dao.AnswerSheetDao;
import com.ares.exam.dao.ExamDao;
import com.ares.exam.dao.ExamPoliceInfoDao;
import com.ares.exam.dao.ExamQuestionBankDao;
import com.ares.exam.dao.QuestionBankDao;
import com.ares.exam.dao.QuestionDao;
import com.ares.exam.dto.ExamDto;
import com.ares.exam.dto.ExamErrorInfo;
import com.ares.exam.dto.ExamInfoDto;
import com.ares.exam.dto.ExamInfoPara;
import com.ares.exam.dto.ExamQuestionBankDto;
import com.ares.exam.dto.ExamQuestionInfoDto;
import com.ares.exam.dto.PoliceInfoDto;
import com.ares.exam.dto.TrainParaDto;
import com.ares.exam.exception.ExamNotStartException;
import com.ares.exam.exception.NotExistException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.ExamService;

import javax.servlet.http.HttpSession;

@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	private ExamDao examDao;
	@Autowired
	private ExamPoliceInfoDao examPoliceInfoDao; 
	@Autowired
	private ExamQuestionBankDao examQuestionBankDao;
	@Autowired
	private QuestionBankDao questionBankDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private AnswerSheetDao answerSheetDao;
	@Autowired
	private AnswerDao answerDao;
	@Override
	public List<ExamDto> queryExamDto(ExamDto examDto) {
		// TODO Auto-generated method stub
		return examDao.queryExamDto(examDto);
	}
	@Transactional
	@Override
	public int startExam(ExamPoliceInfo examPoliceInfo,String ip) throws ParameterNullException, ExamNotStartException {

		if(examPoliceInfo == null || examPoliceInfo.getUserID()==null || examPoliceInfo.getExamID() == null) {
			throw new ParameterNullException("参数为空!");
		}else {
			ExamPoliceInfo epi=examPoliceInfoDao.get(examPoliceInfo.getExamID(), examPoliceInfo.getUserID());
			if(epi==null) {
				throw new ParameterNullException("对应考试不存在！");
			}else {
				if(epi.getIsOver()==0) {  
					Exam exam=examDao.getExam(epi.getExamID());
					//检查时间
					Date sd=exam.getStartTime();
					Date ed=exam.getEndTime();
					Date xd=new Date(System.currentTimeMillis());
					System.out.println(xd.after(sd));
					if(!(xd.after(ed)||xd.before(sd))) {  //这里为了效率，跳过检查。
						//获取关联类，把考试状态修改为已经开始，但是未完成
						AnswerSheet as=answerSheetDao.getAnswerSheet(epi.getUserID(), epi.getExamID());
						if(as==null) {
							as=new AnswerSheet();
							as.setExamID(epi.getExamID());
							as.setIsMarking(0);
							as.setUserID(epi.getUserID());
							as.setStartTime(new Date(System.currentTimeMillis()));
							as.setAddressIP(ip);
							answerSheetDao.add(as);
							epi.setIsOver(1);
							examPoliceInfoDao.updateState(epi);
							return 1;
						}else {
							if(as.getStartTime()!=null) {
								throw new ExamNotStartException("考试已经开始过!");
							}else {
								as.setStartTime(new Date(System.currentTimeMillis()));
								answerSheetDao.update(as);
								return 1;
							}
						}
					}else {
						throw new ExamNotStartException("不在考试时间段内！");
					}
				}else {
					throw new ExamNotStartException("考试已经开始过!");
				}
			}
		}
	}
	@Transactional
	@Override
	public int revokeExam(Long answerSheetID) throws ParameterNullException, NotExistException {
		// TODO Auto-generated method stub
		if(answerSheetID==null) throw new ParameterNullException("参数为空");
		AnswerSheet as=answerSheetDao.get(answerSheetID);
		if(as!=null) {
			//先清空答题信息
			answerDao.clean(answerSheetID);
			//在删除答卷
			answerSheetDao.del(answerSheetID);
			//在把考试开始标志设置为零
			ExamPoliceInfo epi=examPoliceInfoDao.get(as.getExamID(), as.getUserID());
			epi.setIsOver(0);
			examPoliceInfoDao.updateState(epi);
			return 1;
		}else {
			throw new NotExistException("对应答题信息不存在！");
		}
	}

	
	@Override
	public ExamErrorInfo checkExam(ExamInfoPara eip) throws ParameterNullException {
		List<ExamQuestionBank> eqbs=eip.getEqbs();
		ExamErrorInfo eei=new ExamErrorInfo();
		//基本信息检查
		Exam e = eip.getExam();
		if(e.getExamName()==null||"".equals(e.getExamName().trim())) {
			eei.addExamInfoError("缺少考试名称");
		}else{
			checkExamNameRepeat(e,eei);
		}
		if(e.getStartTime()==null||e.getEndTime()==null) {
			eei.addExamInfoError("缺少考试时间段");
		}
		if(e.getWhenLong()==null) {
			eei.addExamInfoError("缺少考试时长参数");
		}
		if(eqbs==null|| eqbs.size()==0) {
			eei.addNotHasQuestionBankError();	
		}else {
			for(ExamQuestionBank key:eqbs) { 
				Long type=key.getUseQuestionType();
				//先检查是否有设置分数
				if(type==null) {
					throw new ParameterNullException("缺少参数");
				}
				if(type==1) {
					if(e.getRadioScore()==null) {
						eei.addExamInfoError("未指定单选题分数");
					}
				}
				if(type==2) {
					if(e.getMultipleScore()==null) {
						eei.addExamInfoError("未指定多选题分数");
					}
				}
				if(type==3) {
					if(e.getJudgmentScore()==null) {
						eei.addExamInfoError("未指定判断题分数");
					}
				}
				if(type==4) {
					if(e.getClozeScore()==null) {
						eei.addExamInfoError("未指定填空题分数");
					}
				}
				if(type==5) {
					if(e.getAnswerScore()==null) {
						eei.addExamInfoError("未指定问答题分数");
					}
				}
				if(type==6) {
					if(e.getTypingScore()==null) {
						eei.addExamInfoError("未指定打字题分数");
					}
				}
				if(key.getQuestionCount()==null) {
					eei.addExamInfoError("有题库未指定题库数目");
				}else {
					int c=questionBankDao.queryCountByType(key.getUseQuestionBankID(), type);
					if(c<key.getQuestionCount()) { //题目不足
						eei.addQuestionBankNotEnoughError(key.getUseQuestionBankID(), key.getUseQuestionType(), c);
					}
				}
				
			}
		}
		List<ExamPoliceInfo> epis=eip.getEpis();
		if(epis == null||epis.size() == 0) {
			eei.setUserError("没有添加任何考生！");
		}
		return eei;
	}

    private void checkExamNameRepeat(Exam exam,ExamErrorInfo eei){
		if(exam.getExamID()!=null){//修改
			if(isExamNameRepeatWhenUpdate(exam))
				eei.addExamInfoError("考试名称已存在，请重命名。");
		}else{//增加
			if(isExamNameRepeatWhenAdd(exam.getExamName()))
				eei.addExamInfoError("考试名称已存在，请重命名。");
		}
	}

	private boolean isExamNameRepeatWhenAdd(String name){
		try {
			if(examDao.countExamByNameWhenAdd(name)>0)
                return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean isExamNameRepeatWhenUpdate(Exam exam){
		try {
			if(examDao.countExamByNameWhenUpdate(exam)>0)
                return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public int submitExam(Map<Long, List<Answer>> answers) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delExam(Long examID) {
	
		Exam e=examDao.getExam(examID);
		if(e!=null) {
			int c=0;
			c+=examPoliceInfoDao.clean(e.getExamID());  //清空
			c+=examQuestionBankDao.clean(e.getExamID()); //清空
			c+=examDao.delExam(e);  //删除考试
			return c;
		}
		return 0;
	}
	@Transactional
	@Override
	public ExamErrorInfo addExam(ExamInfoPara eip, HttpSession session) throws ParameterNullException {
		ExamErrorInfo eid = checkExam(eip);
		if(eid.isHasError()) {
			return eid;
		}else { //添加考试
			Long userId=(Long) session.getAttribute(Constants.USERID_KEY);
			eip.getExam().setFounderID(userId);//插入创建人信息
			examDao.addExam(eip.getExam());  //先添加考试
			Long id=eip.getExam().getExamID();
			List<ExamPoliceInfo> epis=eip.getEpis();
			List<ExamQuestionBank> eqbs=eip.getEqbs();
			//设入刚才添加的考试id
			for(ExamPoliceInfo epi:epis) {
				epi.setExamID(id);
				epi.setIsOver(0);
			}
			
			for(ExamQuestionBank eqb:eqbs) {
				eqb.setUseExamID(id);
			}
			
			//保存
			examPoliceInfoDao.addExamPoliceInfo(epis);
			examQuestionBankDao.addExamQuestionBank(eqbs);
		}
		return eid;
	}
	
	@Override
	public ExamErrorInfo update(ExamInfoPara eip) throws ParameterNullException {
		// TODO Auto-generated method stub
		ExamErrorInfo eid=checkExam(eip);
		if(eid.isHasError()) {
			return eid;
		}else { //添加考试
			Exam e=eip.getExam();
			Long id=e.getExamID();
			List<ExamPoliceInfo> epis=eip.getEpis();
			List<ExamQuestionBank> eqbs=eip.getEqbs();
			//设入刚才添加的考试id
			for(ExamPoliceInfo epi:epis) {
				epi.setExamID(id);
				epi.setIsOver(0);
			}
			for(ExamQuestionBank eqb:eqbs) {
				eqb.setUseExamID(id);
			}
			//保存
			examDao.updateExam(e);
			//先清空，后添加
			examPoliceInfoDao.clean(id);
			examQuestionBankDao.clean(id);
			examPoliceInfoDao.addExamPoliceInfo(epis);
			examQuestionBankDao.addExamQuestionBank(eqbs);
		}
		return eid;
	}
	
	@Override
	public ExamInfoDto getExamInfo(Long examID) {
		ExamDto ed=examDao.getExamDto(examID);
		if(ed!=null) {
			ExamInfoDto eid=new ExamInfoDto();
			eid.setExamDto(ed);
			//List<PoliceInfoDto> pis=examPoliceInfoDao.getPoliceInfoDtoByExamID(ed.getExamID());
			List<PoliceSelect> pss = examPoliceInfoDao.getPoliceSelectByExamID(ed.getExamID());
			List<ExamQuestionBankDto> eqbs=examQuestionBankDao.queryExamQuestionBankDtoByExamID(ed.getExamID());
			//eid.setPis(pis);
			eid.setPss(pss);
			eid.setQbs(eqbs);
			return eid;
		}
		return null;
	}
	
	
	

	@Override
	public Map<Integer, List<ExamDto>> queryUserExam(PoliceInfo pi) {
		// TODO Auto-generated method stub
		if(pi!=null) {
			Map<Integer, List<ExamDto>> map=new HashMap<>();
			List<ExamDto> l1=examDao.queryExamDtoByUser(pi);
			List<ExamDto> l2=examDao.queryBeforeExamDtoByUser(pi);
			List<ExamDto> l3=examDao.queryMissExamDtoByUser(pi);
			map.put(1, l1);
			map.put(2, l2);
			map.put(3, l3);
			return map;
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		ExamInfoDto  eid = new ExamServiceImpl().getExamInfo(2L);
		System.out.println(eid.getExamDto().toString());
	}*/
	@Override   
	public Exam examDtoTopo(ExamDto ed) {
		// TODO Auto-generated method stub
		if(ed!=null) {
			Exam e=new Exam();
			e.setAnswerScore(ed.getAnswerScore());
			e.setClozeScore(ed.getClozeScore());
			e.setDescription(ed.getDescription());
			e.setDisplay(ed.getDisplay());
			e.setEndTime(ed.getEndTime());
			e.setExamID(ed.getExamID());
			e.setExamName(ed.getExamName());
		//	e.setFounderID(null);
			e.setJudgmentScore(ed.getJudgmentScore());
			e.setMultipleScore(ed.getMultipleScore());
			e.setRadioScore(ed.getRadioScore());
			e.setStartTime(ed.getStartTime());
			e.setTypingScore(ed.getTypingScore());
			e.setWhenLong(ed.getWhenLong());
			e.setFounderID(ed.getFounderID());
			e.setExamTypeID(ed.getExamTypeID());
			
			return e;
		}
		return null;
	}
	@Override
	public ExamQuestionBank examQuestionBankDtoTopo(ExamQuestionBankDto examQuestionBankDto) {
		// TODO Auto-generated method stub
		ExamQuestionBank eqb=new ExamQuestionBank();
		eqb.setExamQuestionBankID(examQuestionBankDto.getExamQuestionBankID());
		eqb.setQuestionCount(examQuestionBankDto.getQuestionCount());
		eqb.setUseExamID(examQuestionBankDto.getUseExamID());
		eqb.setUseQuestionType(examQuestionBankDto.getUseQuestionType());
		eqb.setUseQuestionBankID(examQuestionBankDto.getUseQuestionBankID());
		return eqb;
	}

	@Override
	public ExamQuestionInfoDto getExamQestionInfoDto(Long examID) {
		if(examID!=null) {
			ExamDto ed=examDao.getExamDto(examID);
			if(ed!=null) {
				ExamQuestionInfoDto eqid=new ExamQuestionInfoDto();
				eqid.setEd(ed);
				List<ExamQuestionBank> eqbs=examQuestionBankDao.queryByExamID(examID);
				for(ExamQuestionBank key:eqbs) {
					Integer c=key.getQuestionCount();
					Long qbi=key.getUseQuestionBankID();
					Long qt=key.getUseQuestionType();
					//这里直接跳过验证
					List<Question> ls=questionDao.randomQueryQuestion(qbi,c,qt);
					eqid.addQuestions(ls);	
				}
				return eqid;
			}
		}
		return null;
	}
	@Override
	public ExamQuestionInfoDto trian(TrainParaDto trainParaDto) throws ParameterNullException, NotExistException {
		// TODO Auto-generated method stub
		if(trainParaDto != null&&(trainParaDto.getQuestionBankID()!=null || trainParaDto.getQuestionBankName()!=null)&& trainParaDto.getQuestionType()!=null && trainParaDto.getQuestionCount()!=null) {
			//先查询出题库,并等到其ID
			QuestionBank qb=new QuestionBank();
			qb.setQuestionBankID(trainParaDto.getQuestionBankID());
			if(trainParaDto.getQuestionBankName()!=null&&!"".equals(trainParaDto.getQuestionBankName())) {
				qb.setQuestionBankName(trainParaDto.getQuestionBankName());
			}
			List<QuestionBank> qbs=questionBankDao.queryQuestionBank(qb);
			if(qbs==null||qbs.size()==0) {
				throw new NotExistException("对应题库不存在");
			}else {
				 int c=trainParaDto.getQuestionCount();
				 if(c<0) c=0;
					List<Question> qs=questionDao.randomQueryQuestion(qbs.get(0).getQuestionBankID(), c,(Long) trainParaDto.getQuestionType());
					ExamQuestionInfoDto eqid=new ExamQuestionInfoDto();
					eqid.setQuestions(qs);
					return eqid;
			}
		}else {
			throw new ParameterNullException("请求参数为空或不完整");
		}
	}
	

}
