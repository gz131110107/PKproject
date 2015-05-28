package Control;

import java.util.List;

import org.hibernate.Session;

import Dao.TableDAO;
import Factory.HibernateSessionFactory;
import Model.Reservation;
import Model.Table;

public class TableControl {

	public static TableControl control = null;
	public static TableControl getcontrol()
	{
		if(control  ==null)
			control  = new TableControl();
		return control;
	}
	
	private Session session;
	private TableDAO tableDao;
	
	public TableControl()
	{
		session = HibernateSessionFactory.getSession();
		tableDao = new TableDAO();
	}
	public Table findById(String id)
	{
		try {
			Table table= tableDao.findById(id);
			return table;
		} catch (Exception e) {
			return null;
		}
	}
	

	
	public Boolean save(Table temp)
    {
    	try{
    		tableDao.save(temp);
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
    		return tableDao.findAll();
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    } 
	public List fIndTableByType(int type)
	{
		return tableDao.findByType(type);
		
	}
	
	public List fIndTableByFlag(int flag)
	{
		return tableDao.findByReFlag(flag);
		
	}
	
	public Boolean delete(Table consume) {
		try {

			tableDao.delete(consume);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public Boolean update(Table table)
	{
		try
		{
			tableDao.merge(table);
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

