package com.ares.exam.service.impl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ares.exam.exception.ParmException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ares.exam.dao.QuestionDao;
import com.ares.exam.entity.Question;
import com.ares.exam.entity.QuestionAnswer;
import com.ares.exam.entity.QuestionCloze;
import com.ares.exam.entity.QuestionJudgment;
import com.ares.exam.entity.QuestionMultiple;
import com.ares.exam.entity.QuestionRadio;
import com.ares.exam.entity.QuestionTyping;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.QuestionService;
import com.ares.exam.util.Constants;
import com.ares.exam.util.StringUtil;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDao questionDao;

	@Override
	public int delQuestion(Long questionID) throws ParameterNullException, SQLIntegrityConstraintViolationException {
		// TODO Auto-generated method stub
		if(questionID == null) throw new ParameterNullException("参数为空!");
		return questionDao.delQuestion(questionID);
		
	}
	
	@Override
	public int updateQuestion(Question question) throws ParameterNullException {
		if(question == null) throw new ParameterNullException("参数为空!");
		return questionDao.updateQuestion(question);
	}
	
	@Override
	public int insertQuestion(int type,long questionBankID,List<Question> list) {
		// TODO Auto-generated method stub
		//设置试题集合的题库ID
		for(Question key:list) {
			key.setQuestionBankID(questionBankID);
		}
		return 	questionDao.insertQuestion(list);
	}
	
	@Override
	public Map<Integer, List<Question>> ReadXls(Workbook hwb) throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		
		/*HSSFWorkbook hwb=new HSSFWorkbook(new FileInputStream(file));*/
		HSSFSheet sheet=(HSSFSheet) hwb.getSheet("data");
		if(sheet==null)
			throw new ParmException("上传excel中没找到data表");
		Map<Integer, List<Question>> map=new HashMap<>();
		if(sheet!=null) {
			int fi=sheet.getFirstRowNum();
			int li=sheet.getLastRowNum();
			for(int i=fi;i<=li;i++) {
				HSSFRow hr=sheet.getRow(i);
				//第一列不是数字自己跳过
				Question q=ReadLine(hr);
				if(q!=null) { //放入集合
					if(map.get(q.getQuestionType())==null) {
						List<Question> ls=new ArrayList<>();
						ls.add(q);
						map.put(q.getQuestionType(),ls);
					}else {
						map.get(q.getQuestionType()).add(q);
					}
				}
			}
		}
		hwb.close();
		return map;
	}
	
	private  Question ReadLine(HSSFRow hr) {
		Integer x=0;
		if(hr.getCell(0).getCellType()==HSSFCell.CELL_TYPE_STRING) {
			String v=hr.getCell(0).getStringCellValue().trim();
			if(StringUtil.isNumeric(v)) {
				x=Integer.valueOf(v);
			}else {
				return null;
			}
		} else if(hr.getCell(0).getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
			HSSFCell hc=hr.getCell(0);
			double v=hc.getNumericCellValue();
			x=(int) v;
		}
		
		switch (Constants.QuestionType.getType(x)) { 
			case Radio://单选题
				QuestionRadio qr=new QuestionRadio();
				//问题内容
				HSSFCell hc2=hr.getCell(1);  
				if(hc2.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qr.setQuestionContent(hc2.getStringCellValue().trim());
				//问题答案
				HSSFCell hc3=hr.getCell(2);  
				if(hc3.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qr.setRightAnswer(hc3.getStringCellValue().trim());
				//选项A
				HSSFCell hc4=hr.getCell(3);
				if(hc4.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qr.setOptionA(hc4.getStringCellValue().trim());
				}else if(hc4.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hc4.getNumericCellValue();
					qr.setOptionA(String.valueOf(q));
				}
				//选项B
				HSSFCell hc5=hr.getCell(4);
				if(hc5.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qr.setOptionB(hc5.getStringCellValue().trim());
				}else if(hc5.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hc5.getNumericCellValue();
					qr.setOptionB(String.valueOf(q));
				}
				//选项C
				HSSFCell hc6=hr.getCell(5);
				if(hc6.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qr.setOptionC(hc6.getStringCellValue().trim());
				}else if(hc6.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hc6.getNumericCellValue();
					qr.setOptionC(String.valueOf(q));
				}
				//选项D
				HSSFCell hc7=hr.getCell(6);
				if(hc7.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qr.setOptionD(hc7.getStringCellValue().trim());
				}else if(hc7.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hc7.getNumericCellValue();
					qr.setOptionD(String.valueOf(q));
				}
				qr.setQuestionBankID(6L);
				return qr;
			case multiple:  //多选题
				QuestionMultiple qm=new QuestionMultiple();
				HSSFCell hm2=hr.getCell(1);
				//问题内容
				if(hm2.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qm.setQuestionContent(hm2.getStringCellValue().trim());
				//问题答案
				HSSFCell hm3=hr.getCell(2);  
				if(hm3.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qm.setRightAnswer(hm3.getStringCellValue().trim());
				//选项A
				HSSFCell hm4=hr.getCell(3);
				if(hm4.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qm.setOptionA(hm4.getStringCellValue().trim());
				}else if(hm4.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hm4.getNumericCellValue();
					qm.setOptionA(String.valueOf(q));
				}
				//选项B
				HSSFCell hm5=hr.getCell(4);
				if(hm5.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qm.setOptionB(hm5.getStringCellValue().trim());
				}else if(hm5.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hm5.getNumericCellValue();
					qm.setOptionB(String.valueOf(q));
				}
				//选项C
				HSSFCell hm6=hr.getCell(5);
				if(hm6.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qm.setOptionC(hm6.getStringCellValue().trim());
				}else if(hm6.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hm6.getNumericCellValue();
					qm.setOptionC(String.valueOf(q));
				}
				//选项D
				HSSFCell hm7=hr.getCell(6);
				if(hm7.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qm.setOptionD(hm7.getStringCellValue().trim());
				}else if(hm7.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double q=hm7.getNumericCellValue();
					qm.setOptionD(String.valueOf(q));
				}
				return qm;
			case Judgment: //判断题
				QuestionJudgment qj=new QuestionJudgment();
				HSSFCell hj2=hr.getCell(1);
				//问题内容
				if(hj2.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qj.setQuestionContent(hj2.getStringCellValue().trim());
				//问题答案
				HSSFCell hj3=hr.getCell(2);  
				if(hj3.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qj.setRightAnswer(hj3.getStringCellValue().trim());
				return qj;
			case Cloze:  //填空题
				QuestionCloze qc=new QuestionCloze();
				HSSFCell hcl2=hr.getCell(1);
				//问题内容
				if(hcl2.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qc.setQuestionContent(hcl2.getStringCellValue().trim());
				//问题答案
				HSSFCell hcl3=hr.getCell(2);  
				if(hcl3.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qc.setRightAnswer(hcl3.getStringCellValue().trim());
				}else if(hcl3.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double d=hcl3.getNumericCellValue();
					qc.setRightAnswer(String.valueOf(d));
				}
				
				return qc;
			case Answer:  //问答题
				QuestionAnswer qa = new QuestionAnswer();
				HSSFCell ha2=hr.getCell(1);
				//问题内容
				if(ha2.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qa.setQuestionContent(ha2.getStringCellValue().trim());
				//问题答案
				HSSFCell ha3=hr.getCell(2);  
				if(ha3.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qa.setRightAnswer(ha3.getStringCellValue().trim());
				}else if(ha3.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double d=ha3.getNumericCellValue();
					qa.setRightAnswer(String.valueOf(d));
				}
				
				return qa;
			case typing: //打字题
				QuestionTyping qt = new QuestionTyping();
				HSSFCell ht2=hr.getCell(2);
				//问题内容
				if(ht2.getCellType()!=HSSFCell.CELL_TYPE_STRING) return null;
				qt.setQuestionContent(ht2.getStringCellValue().trim());
				//问题答案
				HSSFCell ht3=hr.getCell(2);  
				if(ht3.getCellType()==HSSFCell.CELL_TYPE_STRING) {
					qt.setRightAnswer(ht3.getStringCellValue().trim());
				}else if(ht3.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
					double d=ht3.getNumericCellValue();
					qt.setRightAnswer(String.valueOf(d));
				}
				
				return qt;
			default:
				break;
		}
		return null;
		
	}
	
	@Override
	public List<Question> getQuestionsByBankID(long questionBankID) {
		// TODO Auto-generated method stub
		return questionDao.queryQuestionByBankID(questionBankID);
	}
	
	
	
	
	

}
