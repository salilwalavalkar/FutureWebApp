package com.tech.future.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.tech.future.base.exception.BaseException;
import com.tech.future.dao.base.AbstractDaoImpl;
import com.tech.future.dao.entity.StudentEVO;
import com.tech.future.dao.intf.IStudentDao;

/**
 * #HIBERNATE
 * @author salil
 *
 */
public class StudentDao extends AbstractDaoImpl implements IStudentDao {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(StudentDao.class);
    
	@Override
	public List<StudentEVO> getStudentList(final String sid) throws BaseException {

		List<StudentEVO> finalReturnList = null;
		finalReturnList = hibernateTemplate
				.execute(new HibernateCallback<List<StudentEVO>>() {
					/**
					 * Execute defined query in Hibernate.
					 * 
					 * @throws HibernateException
					 *             - in case of Hibernate errors .
					 * @throws SQLException
					 *             - in case of errors on direct JDBC access.
					 */
					public List<StudentEVO> doInHibernate(final Session session)
							throws HibernateException, SQLException {

						Query query = null;
						if(sid == null)
						{
							query = session.getNamedQuery("getAllStudentList");
						}
						else
						{
							query = session.getNamedQuery("getStudentList");
							query.setLong("sid", Long.valueOf(sid));
						}
						@SuppressWarnings("unchecked")
						List<StudentEVO> list = query.list();
						LOGGER.debug("Student List Count: " + list.size());
						return list;
					}
				});
		return finalReturnList;
	}

	private Timestamp getCurrentTimestamp()
	{
		Calendar calendar = Calendar.getInstance();
		return new java.sql.Timestamp(calendar.getTime().getTime());
	}
	
	@Override
	public void addStudent(final StudentEVO evo) throws BaseException {
		evo.setDateCreated(getCurrentTimestamp());
		evo.setDateModified(getCurrentTimestamp());
		long newId = (Long) hibernateTemplate.save(evo);
		LOGGER.debug("Student Added with Id: " + newId);
	}

	@Override
	public void deleteStudent(final String sid) throws BaseException {
		StudentEVO evo = new StudentEVO();
		evo.setStudId(Long.valueOf(sid));
		hibernateTemplate.delete(evo);
		LOGGER.debug("Student Deleted with Id: " + sid);
	}

	@Override
	public void saveStudent(StudentEVO evo) throws BaseException {
		evo.setDateModified(getCurrentTimestamp());
		hibernateTemplate.update(evo);
		LOGGER.debug("Student Edited with Id: " + evo.getStudId());
	}

	@Override
	public StudentEVO loadStudent(String sid) throws BaseException {
		return hibernateTemplate.get(StudentEVO.class, Long.valueOf(sid));
	}
}