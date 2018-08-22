package com.ares.exam.service;

import java.util.List;
import java.util.Map;

import com.ares.exam.dto.ExamDto;
import com.ares.exam.dto.ExamErrorInfo;
import com.ares.exam.dto.ExamInfoDto;
import com.ares.exam.dto.ExamInfoPara;
import com.ares.exam.dto.ExamQuestionBankDto;
import com.ares.exam.dto.ExamQuestionInfoDto;
import com.ares.exam.dto.TrainParaDto;
import com.ares.exam.entity.Answer;
import com.ares.exam.entity.Exam;
import com.ares.exam.entity.ExamPoliceInfo;
import com.ares.exam.entity.ExamQuestionBank;
import com.ares.exam.entity.PoliceInfo;
import com.ares.exam.exception.ExamNotStartException;
import com.ares.exam.exception.NotExistException;
import com.ares.exam.exception.ParameterNullException;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpSession;

/**
 * 考试业务接口
 * @author szares02
 *
 */
public interface ExamService {
	/**
	 * 查询考试
	 * @param examDto
	 * @return
	 */
	List<ExamDto> queryExamDto(ExamDto examDto);

	/**
	 * 开始考试
	 * @param examPoliceInfo 
	 * @return 生成的考题信息
	 * @throws ParameterNullException  
	 * @throws ExamNotStartException 
	 */
	int startExam(ExamPoliceInfo examPoliceInfo,String ip) throws ParameterNullException, ExamNotStartException;
	
	
	/**
	 * 撤销对应答卷的开始考试
	 * @param answerSheetID
	 * @return
	 * @throws ParameterNullException 
	 * @throws NotExistException 
	 */
	int revokeExam(Long answerSheetID) throws ParameterNullException, NotExistException;
	
	
	/**
	 * 获取考试试题等信息
	 * @param examID
	 * @return
	 */
	ExamQuestionInfoDto getExamQestionInfoDto(Long examID);
	
	/**
	 * 练习模式获取试题信息
	 * @param trainParaDto 
	 * @return
	 * @throws ParameterNullException 
	 * @throws NotExistException 
	 */
	ExamQuestionInfoDto trian(TrainParaDto trainParaDto) throws ParameterNullException, NotExistException;
	
	/**
	 * 检查考试信息
	 * @param eip
	 * @return
	 * @throws ParameterNullException 
	 */
	ExamErrorInfo checkExam(ExamInfoPara eip) throws ParameterNullException;
	
	/**
	 * 提交试卷
	 * @param answers  答题
	 * @return
	 */
	int submitExam(Map<Long, List<Answer>> answers);
	
	/**
	 * 删除考试,包括下面的信息
	 * @param examID
	 * @return
	 */
	int delExam(Long examID);
	
	/**
	 * 添加考试（确保已经检查无误后）
	 * @param eip 考试参数信息
	 * @return 1 成功 0 失败
	 * @throws ParameterNullException 
	 */
	ExamErrorInfo addExam(ExamInfoPara eip, HttpSession session) throws ParameterNullException;
	
	/**
	 * 获取考试信息
	 * @param examID 考试ID
	 * @return
	 */
	ExamInfoDto getExamInfo(Long examID);
	
	
	
	ExamErrorInfo update(ExamInfoPara eip) throws ParameterNullException;
	
	
	/**
	 * 查询用户的考试
	 * @param pi
	 * @return
	 */
	Map<Integer, List<ExamDto>> queryUserExam(PoliceInfo pi);
	
	/**
	 * 考试DTO转PO
	 * @param ed
	 * @return
	 */
	Exam examDtoTopo(ExamDto ed);
	
	
	ExamQuestionBank examQuestionBankDtoTopo(ExamQuestionBankDto examQuestionBankDto);

	List<Exam> getExamsByXls(Workbook wb,Long userId);

	int insertBatchExam(List list);
	
}
