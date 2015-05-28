package Control;


import java.util.List;

import org.hibernate.Session;

import Dao.ReservationDAO;
import Factory.HibernateSessionFactory;
import Model.Reservation;



public class ReservationControl {
		public static ReservationControl control = null;
		public static ReservationControl getcontrol()
		{
			if(control  ==null)
				control  = new ReservationControl();
			return control;
		}
		
		private Session session;
		private ReservationDAO reservationDao;
		
		public ReservationControl()
		{
			session = HibernateSessionFactory.getSession();
			reservationDao = new ReservationDAO();
		}
		public List findByName(String name)
		{
			try{
				return reservationDao.findByName(name);
			}
			catch(Exception e)
			{
				return null;
			}
		}
		
		
		public List findByTablenum(String num)
		{
			try{
				return reservationDao.findByTablenum(num);
			}
			catch(Exception e)
			{
				return null;
			}
		}
		public List findByTelnum(String tel)
		{
			try{
				return reservationDao.findByTelnumber(tel);
			}
			catch(Exception e)
			{
				return null;
			}
		}
		public Boolean save(Reservation temp)
	    {
	    	try{
	    		reservationDao.save(temp);
	    		session.beginTransaction().commit();
	    		session.flush();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		return false;
	    	}
	    }
		
		public List findAll()
	    {
	    	try
	    	{
	    		return reservationDao.findAll();
	    	}
	    	catch(Exception e)
	    	{
	    		return null;
	    	}
	    }  
		public Boolean delete(Reservation consume) {
			try {

				reservationDao.delete(consume);
				session.beginTransaction().commit();
				session.flush();
				return true;

			} catch (Exception e) {
				return false;
			}
		}
		
		public Boolean update(Reservation reservation)
		{
			try
			{
				reservationDao.merge(reservation);
				session.beginTransaction().commit();
				session.flush();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		
	}
