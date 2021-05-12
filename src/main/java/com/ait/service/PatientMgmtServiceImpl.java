package com.ait.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ait.bo.PatientBO;
import com.ait.dao.PatientDAO;
import com.ait.dto.PatientDTO;

@Service
public class PatientMgmtServiceImpl implements PatientMgmtService {
	@Autowired
	private PatientDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(PatientDTO dto) {
		int count=0;
		PatientBO bo=null;
		//convert dto to bo
		bo=new PatientBO();
        //count=dao.insert(bo); if i use First DAO Class ..The DataBase WHAT EVER I ENTER GOING AND STORE Null value so you have alreday used after convert dto to bo 
		/*BeanUtils.copyProperties(dto,bo);*/ //if your are not converting dto to do...output become sucess but when its store in data base store null value so mandtrory to convert dto to bo
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
				return count==0?"Patient Registration Failed":"Patient Registration succeded";
	}


}
