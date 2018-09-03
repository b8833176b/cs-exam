package com.ares.exam.service.impl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DecimalFormat;
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
		//设置试题集合的题库ID
		for(Question key:list) {
			key.setQuestionBankID(questionBankID);
		}
		return 	questionDao.insertQuestion(list);
	}
	
	@Override
	public Map<Integer, List<Question>> ReadXls(Workbook hwb) throws FileNotFoundException, IOException  {
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
				setQuestionRadioValue(hc4,qr,"A");
				//选项B
				HSSFCell hc5=hr.getCell(4);
				setQuestionRadioValue(hc5,qr,"B");
				//选项C
				HSSFCell hc6=hr.getCell(5);
				setQuestionRadioValue(hc6,qr,"C");
				//选项D
				HSSFCell hc7=hr.getCell(6);
				setQuestionRadioValue(hc7,qr,"D");
				//选项E
				HSSFCell hc8=hr.getCell(7);
				setQuestionRadioValue(hc8,qr,"E");
				//选项F
				HSSFCell hc9=hr.getCell(8);
				setQuestionRadioValue(hc9,qr,"F");
				//qr.setQuestionBankID(6L);
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
				seQuestionMultipleValue(hm4,qm,"A");
				//选项B
				HSSFCell hm5=hr.getCell(4);
				seQuestionMultipleValue(hm5,qm,"B");
				//选项C
				HSSFCell hm6=hr.getCell(5);
				seQuestionMultipleValue(hm6,qm,"C");
				//选项D
				HSSFCell hm7=hr.getCell(6);
				seQuestionMultipleValue(hm7,qm,"D");
				//选项E
				HSSFCell hm8=hr.getCell(7);
				seQuestionMultipleValue(hm8,qm,"E");
				//选项F
				HSSFCell hm9=hr.getCell(8);
				seQuestionMultipleValue(hm9,qm,"F");
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
					//double d=hcl3.getNumericCellValue();
					//qc.setRightAnswer(String.valueOf(d));
					Double q=hcl3.getNumericCellValue();
					Long longVal = Math.round(hcl3.getNumericCellValue());
					if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
						qc.setRightAnswer(longVal+"");
					}else{
						qc.setRightAnswer(String.valueOf(q));
					}
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
					//double d=ha3.getNumericCellValue();
					//qa.setRightAnswer(String.valueOf(d));
					Double q=ha3.getNumericCellValue();
					Long longVal = Math.round(ha3.getNumericCellValue());
					if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
						qa.setRightAnswer(longVal+"");
					}else{
						qa.setRightAnswer(String.valueOf(q));
					}
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
					//double d=ht3.getNumericCellValue();
					//qt.setRightAnswer(String.valueOf(d));
					Double q=ht3.getNumericCellValue();
					Long longVal = Math.round(ht3.getNumericCellValue());
					if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
						qt.setRightAnswer(longVal+"");
					}else{
						qt.setRightAnswer(String.valueOf(q));
					}
				}
				return qt;
			default:
				break;
		}
		return null;
		
	}

	private void setQuestionRadioValue(HSSFCell hc,QuestionRadio qr,String type){
		if(hc.getCellType()==HSSFCell.CELL_TYPE_STRING) {
			setStringQuestionRadioByType(hc,qr,type);//设置字符串格式选项内容
		}else if(hc.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
			setNumericQuestionRadioByType(hc,qr,type);
		}
	}

	//设置 单选题 字符串格式选项内容
	private void setStringQuestionRadioByType(HSSFCell hc,QuestionRadio qr,String type){
		if("A".equals(type))
			qr.setOptionA(hc.getStringCellValue().trim());
		else if("B".equals(type))
			qr.setOptionB(hc.getStringCellValue().trim());
		else if("C".equals(type))
			qr.setOptionC(hc.getStringCellValue().trim());
		else if("D".equals(type))
			qr.setOptionD(hc.getStringCellValue().trim());
		else if("E".equals(type))
			qr.setOptionE(hc.getStringCellValue().trim());
		else if("F".equals(type))
			qr.setOptionF(hc.getStringCellValue().trim());
	}

	//设置 单选题 数字格式选项内容
	private void setNumericQuestionRadioByType(HSSFCell hc,QuestionRadio qr,String type){
		Double q=hc.getNumericCellValue();
		Long longVal = Math.round(hc.getNumericCellValue());
        if("A".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qr.setOptionA(longVal+"");
			}else{
				qr.setOptionA(String.valueOf(q));
			}
		}else if("B".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qr.setOptionB(longVal+"");
			}else{
				qr.setOptionB(String.valueOf(q));
			}
		}else if("C".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qr.setOptionC(longVal+"");
			}else{
				qr.setOptionC(String.valueOf(q));
			}
		}else if("D".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qr.setOptionD(longVal+"");
			}else{
				qr.setOptionD(String.valueOf(q));
			}
		}else if("E".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qr.setOptionE(longVal+"");
			}else{
				qr.setOptionE(String.valueOf(q));
			}
		}else if("F".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qr.setOptionF(longVal+"");
			}else{
				qr.setOptionF(String.valueOf(q));
			}
		}
	}

	private void seQuestionMultipleValue(HSSFCell hc,QuestionMultiple qm,String type){
		if(hc.getCellType()==HSSFCell.CELL_TYPE_STRING) {
			setStringQuestionMultipleByType(hc,qm,type);//设置字符串格式选项内容
		}else if(hc.getCellType()==HSSFCell.CELL_TYPE_NUMERIC) {
			setNumericQuestionMultipleByType(hc,qm,type);
		}
	}

	//设置 多选题 字符串格式选项内容
	private void setStringQuestionMultipleByType(HSSFCell hc,QuestionMultiple qm,String type){
		if("A".equals(type))
			qm.setOptionA(hc.getStringCellValue().trim());
		else if("B".equals(type))
			qm.setOptionB(hc.getStringCellValue().trim());
		else if("C".equals(type))
			qm.setOptionC(hc.getStringCellValue().trim());
		else if("D".equals(type))
			qm.setOptionD(hc.getStringCellValue().trim());
		else if("E".equals(type))
			qm.setOptionE(hc.getStringCellValue().trim());
		else if("F".equals(type))
			qm.setOptionF(hc.getStringCellValue().trim());
	}

	//设置 多选题 数字格式选项内容
	private void setNumericQuestionMultipleByType(HSSFCell hc,QuestionMultiple qm,String type){
		Double q=hc.getNumericCellValue();
		Long longVal = Math.round(hc.getNumericCellValue());
		if("A".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qm.setOptionA(longVal+"");
			}else{
				qm.setOptionA(String.valueOf(q));
			}
		}else if("B".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qm.setOptionB(longVal+"");
			}else{
				qm.setOptionB(String.valueOf(q));
			}
		}else if("C".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qm.setOptionC(longVal+"");
			}else{
				qm.setOptionC(String.valueOf(q));
			}
		}else if("D".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qm.setOptionD(longVal+"");
			}else{
				qm.setOptionD(String.valueOf(q));
			}
		}else if("E".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qm.setOptionE(longVal+"");
			}else{
				qm.setOptionE(String.valueOf(q));
			}
		}else if("F".equals(type)){
			if(Double.parseDouble(longVal + ".0") == q){   //判断是否含有小数位.0
				qm.setOptionF(longVal+"");
			}else{
				qm.setOptionF(String.valueOf(q));
			}
		}
	}

	private void setOptionBValue(){

	}

	private void setOptionCValue(){

	}

	private void setOptionDValue(){

	}
	
	@Override
	public List<Question> getQuestionsByBankID(long questionBankID) {
		return questionDao.queryQuestionByBankID(questionBankID);
	}
	
	
	
	
	

}
