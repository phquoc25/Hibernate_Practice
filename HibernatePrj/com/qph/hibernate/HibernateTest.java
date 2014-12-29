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

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory buildSessionFactory = new Configuration().configure("config//hibernate.cfg.xml").buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "User9"));
		
		List<UserDetails> userNames = criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u : userNames){
			System.out.println(u.getUserName());
		}
	}

}
