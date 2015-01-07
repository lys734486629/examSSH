package com.seviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.StuDao;
import com.model.users.StuInfo;

public class StuDaoImpl implements StuDao{
private HibernateTemplate ht=null;
private SessionFactory sessionFactory=null;
public void setSessionFactory(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
private HibernateTemplate getHibernateTemplate(){
	if(ht==null){
		ht=new HibernateTemplate(sessionFactory);
	}
	return ht;
}
public StuInfo get(Long id){
	return getHibernateTemplate().get(StuInfo.class, id);
}
public Long save(StuInfo stu){
	return (Long)getHibernateTemplate().save(stu);
}
@SuppressWarnings("unchecked")
public List<StuInfo>findByID(Long id){
	try {
		return (List<StuInfo>)getHibernateTemplate().find("from StuInfo s where s.stuid=?", id);
	} catch (DataAccessException e) {
		// TODO: handle exception
		System.out.print(e.toString());
		return null;
	}
}
}
