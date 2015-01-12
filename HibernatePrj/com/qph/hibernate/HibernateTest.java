package com.qph.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.qph.dto.Address;
import com.qph.dto.FourWheeler;
import com.qph.dto.TwoWheeler;
import com.qph.dto.UserDetails;
import com.qph.dto.Vehicle;
import com.qph.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.between("userId", 10, 12), 
									 Restrictions.between("userId", 15, 20)));
		
		List<UserDetails> userNames = criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u : userNames){
			System.out.println(u.getUserName());
		}
	}

}
