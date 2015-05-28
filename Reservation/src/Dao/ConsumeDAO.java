package Dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.Consume;

/**
 * A data access object (DAO) providing persistence and search support for
 * Consume entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Dao.Consume
 * @author MyEclipse Persistence Tools
 */
public class ConsumeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ConsumeDAO.class);
	// property constants
	public static final String CNAME = "cname";
	public static final String MNAME = "mname";
	public static final String MPRICE = "mprice";

	public void save(Consume transientInstance) {
		log.debug("saving Consume instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Consume persistentInstance) {
		log.debug("deleting Consume instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Consume findById(java.lang.Integer id) {
		log.debug("getting Consume instance with id: " + id);
		try {
			Consume instance = (Consume) getSession().get("Model.Consume", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Consume instance) {
		log.debug("finding Consume instance by example");
		try {
			List results = getSession().createCriteria("Model.Consume")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Consume instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Consume as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findByMname(Object mname) {
		return findByProperty(MNAME, mname);
	}

	public List findByMprice(Object mprice) {
		return findByProperty(MPRICE, mprice);
	}

	public List findAll() {
		log.debug("finding all Consume instances");
		try {
			String queryString = "from Consume";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Consume merge(Consume detachedInstance) {
		log.debug("merging Consume instance");
		try {
			Consume result = (Consume) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Consume instance) {
		log.debug("attaching dirty Consume instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Consume instance) {
		log.debug("attaching clean Consume instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}