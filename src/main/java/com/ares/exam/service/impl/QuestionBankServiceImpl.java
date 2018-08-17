package com.ares.exam.service.impl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ares.exam.dao.QuestionBankDao;
import com.ares.exam.dto.QueryQuestionBankDto;
import com.ares.exam.dto.QuestionBankDto;
import com.ares.exam.entity.QuestionBank;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService{
	@Autowired
	private QuestionBankDao questionBankDao;

	@Override
	public List<QuestionBank> getList() {
		// TODO Auto-generated method stub
		return questionBankDao.queryQuestionBank();
	}
	
	@Override
	public List<QuestionBank> getIsDisplayList() {
		// TODO Auto-generated method stub
		QuestionBank qb=new QuestionBank();
		qb.setIsDisplay(1);
		return questionBankDao.queryQuestionBank(qb);
	}

	@Override
	public List<QuestionBankDto> getQuestionBankDtoList(QueryQuestionBankDto queryQuestionBankDto) {
		// TODO Auto-generated method stub
		return questionBankDao.queryQuestionBankDto(queryQuestionBankDto);
	}

	@Override
	public int delQuestionBank(QuestionBank questionBank) throws ParameterNullException {
		// TODO Auto-generated method stub
	//	return questionBankDao.;
		if(questionBank!=null&&questionBank.getQuestionBankID()!=null) {
			questionBankDao.clean(questionBank.getQuestionBankID());
			return questionBankDao.delQuestionBank(questionBank);
		}else {
			throw new ParameterNullException("缺少参数!");
		}
	}

	@Override
	public int addQuestionBank(QuestionBankDto questionBankDto) {
		// TODO Auto-generated method stub
		//设置创建时间
		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		questionBankDto.setCreationTime(date);
		questionBankDto.setUpdateTime(date);
		return questionBankDao.addQuestionBank(questionBankDto);
	}

	@Override
	public int addQuestionBank(QuestionBank questionBank) {
		// TODO Auto-generated method stub
		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		questionBank.setCreationTime(date);
		questionBank.setUpdateTime(date);
		return questionBankDao.addQuestionBank(questionBank);
	}

	@Override
	public int clean(Long questionBankID) {
		// TODO Auto-generated method stub
		return questionBankDao.clean(questionBankID);
	}

	@Override
	public int updateQuestionBank(QuestionBank questionBank) throws ParameterNullException {
		// TODO Auto-generated method stub
		if(questionBank == null) {
			throw new ParameterNullException("参数为空");
		}else {
			return questionBankDao.updateQuestionBank(questionBank);
		}
	}

	@Override
	public int updateMan(Long QuestionBankID, String name)  {
		// TODO Auto-generated method stub
		QuestionBank qb=questionBankDao.get(QuestionBankID);
		if(qb != null) {
			qb.setUpdateMan(name);
			qb.setUpdateTime(new Date(System.currentTimeMillis()));
			try {
				return updateQuestionBank(qb);
			} catch (ParameterNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
		
		
	}

	
	
}
