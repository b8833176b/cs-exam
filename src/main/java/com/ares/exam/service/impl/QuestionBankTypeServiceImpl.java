package com.ares.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ares.exam.dao.QuestionBankTypeDao;
import com.ares.exam.entity.QuestionBankType;
import com.ares.exam.exception.NameRepeatException;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionBankTypeService;
import com.ares.exam.util.StringUtil;
@Service
public class QuestionBankTypeServiceImpl implements QuestionBankTypeService{
	@Autowired
	private QuestionBankTypeDao questionBankTypeDao;
	
	
	@Override
	public int addQuestionBankType(String questBankTypeName) {
		// TODO Auto-generated method stub
		return questionBankTypeDao.addQuestionBankType(questBankTypeName);
	}

	@Override
	public List<QuestionBankType> queryQuestionBankType() {
		// TODO Auto-generated method stub
		return questionBankTypeDao.queryQuestionBankType();
	}

	@Override
	public int delQuestionBankType(QuestionBankType questionBankType) {
		// TODO Auto-generated method stub
		return questionBankTypeDao.delQuestionBankType(questionBankType);
	}

	@Override
	public int addQuestionBankType(QuestionBankType questionBankType) throws NameRepeatException, ParameterNullException {
		// TODO Auto-generated method stub
		//检查是否类型名称重复
		List<QuestionBankType> qbt=questionBankTypeDao.queryQuestionBankType(questionBankType);
		if(StringUtil.isEmpty(questionBankType.getQuestionBankTypeName())) {
			throw new ParameterNullException("参数为空！");
		}
		if(qbt!=null&qbt.size()>0) {
			System.out.println(qbt.size());
			throw new NameRepeatException();
		}
		return questionBankTypeDao.addQuestionBankType(questionBankType);
	}

	@Override
	public QuestionBankType getQuestionBankType(QuestionBankType questionBankType) {
		// TODO Auto-generated method stub
		return questionBankTypeDao.getQuestionBankType(questionBankType.getQuestionBankTypeID());
	}

	@Override
	public int updateQuestionBankType(QuestionBankType questionBankType) throws ParameterNullException, NameRepeatException {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(questionBankType.getQuestionBankTypeName())) {
			throw new ParameterNullException("参数为空");
		}
		int r=questionBankTypeDao.getConutByName(questionBankType.getQuestionBankTypeName());
		if(r>0) {
			throw new NameRepeatException("此名称已经存在");
		}
		return questionBankTypeDao.updateQuestionBankType(questionBankType);
	}

}
