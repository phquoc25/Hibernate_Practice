package com.qph.hibernate;

import java.util.Date;

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
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 10);
		
		session.getTransaction().commit();
		session.close();

		//user.setUserName("Username updated after session closed");
		
		session = buildSessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		//user.setUserName("Username updated after updated");
		session.getTransaction().commit();
		session.close();
		
	}

}
