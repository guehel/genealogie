package cg.genealogie.orm.base;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import cg.genealogie.orm.dao.PrenommeDAO;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BasePrenommeDAO extends cg.genealogie.orm.dao._RootDAO {

	public static PrenommeDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static PrenommeDAO getInstance () {
		if (null == instance) instance = new PrenommeDAO();
		return instance;
	}

	/**
	 * cg.genealogie.orm.dao._RootDAO _RootDAO.getReferenceClass()
	 */
	public Class getReferenceClass () {
		return cg.genealogie.orm.Prenomme.class;
	}
	
	public cg.genealogie.orm.Prenomme load(cg.genealogie.orm.Prenomme key)
		throws net.sf.hibernate.HibernateException {
		return (cg.genealogie.orm.Prenomme) load(getReferenceClass(), key);
	}

	public cg.genealogie.orm.Prenomme load(cg.genealogie.orm.Prenomme key, Session s)
		throws net.sf.hibernate.HibernateException {
		return (cg.genealogie.orm.Prenomme) load(getReferenceClass(), key, s);
	}

	public cg.genealogie.orm.Prenomme loadInitialize(cg.genealogie.orm.Prenomme key, Session s) 
			throws net.sf.hibernate.HibernateException { 
		cg.genealogie.orm.Prenomme obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param prenomme a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public cg.genealogie.orm.Prenomme save(cg.genealogie.orm.Prenomme prenomme)
		throws net.sf.hibernate.HibernateException {
		return (cg.genealogie.orm.Prenomme) super.save(prenomme);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param prenomme a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public cg.genealogie.orm.Prenomme save(cg.genealogie.orm.Prenomme prenomme, Session s)
		throws net.sf.hibernate.HibernateException {
		return (cg.genealogie.orm.Prenomme) super.save(prenomme, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param prenomme a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(cg.genealogie.orm.Prenomme prenomme)
		throws net.sf.hibernate.HibernateException {
		super.saveOrUpdate(prenomme);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param prenomme a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(cg.genealogie.orm.Prenomme prenomme, Session s)
		throws net.sf.hibernate.HibernateException {
		super.saveOrUpdate(prenomme, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param prenomme a transient instance containing updated state
	 */
	public void update(cg.genealogie.orm.Prenomme prenomme) 
		throws net.sf.hibernate.HibernateException {
		super.update(prenomme);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param prenomme a transient instance containing updated state
	 * @param the Session
	 */
	public void update(cg.genealogie.orm.Prenomme prenomme, Session s)
		throws net.sf.hibernate.HibernateException {
		super.update(prenomme, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param prenomme the instance to be removed
	 */
	public void delete(cg.genealogie.orm.Prenomme prenomme)
		throws net.sf.hibernate.HibernateException {
		super.delete(prenomme);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param prenomme the instance to be removed
	 * @param s the Session
	 */
	public void delete(cg.genealogie.orm.Prenomme prenomme, Session s)
		throws net.sf.hibernate.HibernateException {
		super.delete(prenomme, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (cg.genealogie.orm.Prenomme prenomme, Session s)
		throws net.sf.hibernate.HibernateException {
		super.refresh(prenomme, s);
	}

    public String getDefaultOrderProperty () {
		return null;
    }

}