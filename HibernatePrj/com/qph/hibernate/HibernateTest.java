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
		String userName = "User6";
		
		Query query = session.createQuery("from UserDetails where userName=:userName");
		query.setString("userName", userName);
		
		List<UserDetails> userNames = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u : userNames){
			System.out.println(u.getUserName());
		}
	}

}
