package Control;

import java.util.List;

import org.hibernate.Session;

import Dao.ConsumeDAO;
import Factory.HibernateSessionFactory;
import Model.Consume;
import Model.Table;


public class ConsumeControl {
	public static ConsumeControl control = null;
	public static ConsumeControl getcontrol()
	{
		if(control  ==null)
			control  = new ConsumeControl();
		return control;
	}
	
	private Session session;
	private ConsumeDAO consumeDao;
	
	public ConsumeControl()
	{
		session = HibernateSessionFactory.getSession();
		consumeDao = new ConsumeDAO();
	}
	public List findByCName(String cname)
	{
		try{
			return consumeDao.findByCname(cname);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public List findByMName(String mname)
	{
		try{
			return consumeDao.findByMname(mname);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public Boolean save(Consume temp)
    {
    	try{
    		consumeDao.save(temp);
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
    		return consumeDao.findAll();
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    }  
	public Boolean delete(Consume consume) {
		try {

			consumeDao.delete(consume);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean update(Consume consume)
	{
		try
		{
			consumeDao.merge(consume);
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
