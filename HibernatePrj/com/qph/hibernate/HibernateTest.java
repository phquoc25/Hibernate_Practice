package com.qph.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<String> userNames = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(String u : userNames){
			System.out.println(u);
		}
	}

}
