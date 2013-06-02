package com.tech.future.dao.intf;

import java.util.List;

import com.tech.future.base.exception.BaseException;
import com.tech.future.dao.base.IDao;
import com.tech.future.dao.entity.StudentEVO;

/**
 * Student Dao Interface
 * 
 * @author salil
 * @version 1.0
 */
public interface IStudentDao extends IDao {

	List<StudentEVO> getStudentList(final String sid) throws BaseException;
	
	void addStudent(final StudentEVO evo) throws BaseException;
	
	void deleteStudent(final String sid) throws BaseException;
	
	void saveStudent(final StudentEVO evo) throws BaseException;
	
	StudentEVO loadStudent(final String sid) throws BaseException;
}
