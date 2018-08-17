package com.ares.exam.service;
/**
 * 题库业务接口
 * @author szares02
 *
 */
import java.util.List;
import com.ares.exam.dto.QueryQuestionBankDto;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.entity.QuestionBank;
import com.ares.exam.exception.ParameterNullException;

public interface QuestionBankService {
	/**
	 * 查询所有题库
	 * @return
	 */
	List<QuestionBank> getList();
	
	/**
	 * 获得可以显示的题库（可供考生练习）
	 * @return
	 */
	List<QuestionBank> getIsDisplayList();
	
	/**
	 * 查看题库Dto用于前端显示
	 * @param questionBankDto
	 * @return
	 */
	List<QuestionBankDto> getQuestionBankDtoList(QueryQuestionBankDto queryQuestionBankDto);
	
	/**
	 * 删除题库
	 * @param questionBank
	 * @return
	 * @throws ParameterNullException 
	 */
	int delQuestionBank(QuestionBank questionBank) throws ParameterNullException;
	
	/**
	 * 添加题库
	 * @param QuestionBankDto 题库类
	 * @return
	 */
	int addQuestionBank(QuestionBankDto questionBankDto);
	
	/**
	 * 添加题库
	 * @param questionBank
	 * @return 影响行数
	 */
	int addQuestionBank(QuestionBank questionBank);
	
	/**
	 * 更新题库
	 * @param questionBank
	 * @return
	 * @throws ParameterNullException 
	 */
	int updateQuestionBank(QuestionBank questionBank) throws ParameterNullException;
	
	/**
	 * 更新题库更新人
	 * @param QuestionBankID
	 * @param name 
	 * @return
	 */
	int updateMan(Long QuestionBankID,String name);
	
	/**
	 * 清空题库下的试题
	 * @param questionBankID 题库ID
	 * @return
	 */
	int clean(Long questionBankID);
}
