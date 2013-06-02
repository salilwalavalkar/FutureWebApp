package com.tech.future.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tech.future.base.exception.BaseException;
import com.tech.future.dao.entity.StudentEVO;
import com.tech.future.dao.intf.IStudentDao;
import com.tech.future.model.StudentDetails;
import com.tech.future.service.intf.IStudentService;
import com.tech.future.util.FutureUtil;

/**
 * This is an Autowired student service class implementation example.
 * 
 * @author salil
 * @version 1.0.0
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true, rollbackFor = BaseException.class)
	public List<StudentDetails> getStudentList(final String sid)
			throws BaseException {
		return convertToModel(studentDao.getStudentList(sid));
	}

	private List<StudentDetails> convertToModel(List<StudentEVO> studList) {
		List<StudentDetails> studDetails = null;
		if (!FutureUtil.isListEmptyOrBlank(studList)) {
			studDetails = new ArrayList<StudentDetails>();
			for (StudentEVO evo : studList) {
				StudentDetails model = new StudentDetails();
				model.setStudId(String.valueOf(evo.getStudId()));
				model.setFirstName(evo.getFirstName());
				model.setLastName(evo.getLastName());
				model.setAge(evo.getAge());
				model.setDateCreated(evo.getDateCreated());
				model.setDateModified(evo.getDateModified());
				studDetails.add(model);
			}
		}
		return studDetails;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = BaseException.class)
	public void addStudentDetails(StudentDetails studentDetails)
			throws BaseException {
		StudentEVO evo = convertToEVO(new StudentEVO(), studentDetails);
		studentDao.addStudent(evo);
	}

	private StudentEVO convertToEVO(StudentEVO evo, StudentDetails model) {
		evo.setFirstName(model.getFirstName());
		evo.setLastName(model.getLastName());
		evo.setAge(model.getAge());
		return evo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = BaseException.class)
	public void deleteStudent(final String sid) throws BaseException {
		studentDao.deleteStudent(sid);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = BaseException.class)
	public void saveStudentDetails(StudentDetails studentDetails)
			throws BaseException {
		StudentEVO evo = studentDao.loadStudent(studentDetails.getStudId());
		evo = convertToEVO(evo, studentDetails);
		studentDao.saveStudent(evo);
	}
}
