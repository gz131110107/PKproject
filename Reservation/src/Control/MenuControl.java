package Control;

import java.util.List;

import org.hibernate.Session;

import Dao.MenuDAO;
import Factory.HibernateSessionFactory;
import Model.Menu;



public class MenuControl {
	public static MenuControl control = null;
	public static MenuControl getcontrol()
	{
		if(control  ==null)
			control  = new MenuControl();
		return control;
	}
	
	private Session session;
	private MenuDAO menuDao;
	
	public MenuControl()
	{
		session = HibernateSessionFactory.getSession();
		menuDao = new MenuDAO();
	}
	public List findByMName(String mname)
	{
		try{
			return menuDao.findByMname(mname);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	

	
	public Boolean save(Menu temp)
    {
    	try{
    		menuDao.save(temp);
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
    		return menuDao.findAll();
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    }  
	
	public Menu findById(int id)
	{
		try {
			 Menu menu= menuDao.findById(id);
			return menu;
		} catch (Exception e) {
			return null;
		}
	}
	public Boolean delete(Menu consume) {
		try {

			menuDao.delete(consume);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
}
