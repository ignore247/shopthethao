package com.shopthethao.DAO;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopthethao.Entity.test_thongtinEntity;

@Repository
public class testDAO {
	
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public List<test_thongtinEntity> laytt(){
		
		Session session = factory.getCurrentSession();
		String hql = "from test_thongtinEntity";
		Query query = session.createQuery(hql);
		List<test_thongtinEntity> list = query.getResultList();
		System.out.println(list);
		return list;
		
	}

}
