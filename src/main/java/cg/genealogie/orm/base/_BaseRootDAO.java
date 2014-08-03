package cg.genealogie.orm.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.SessionFactory;

import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import net.sf.hibernate.type.Type;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 */
public abstract class _BaseRootDAO {

	protected static Map sessionFactoryMap = new HashMap();
	protected static ThreadLocal threadedSessions = new ThreadLocal();

	/**
	 * Configure the session factory by reading hibernate config file
	 */
	public static void initialize () throws HibernateException {
		initialize((String) null);
	}
	
	/**
	 * Configure the session factory by reading hibernate config file
	 * @param configFileName the name of the configuration file
	 */
	public static void initialize (String configFileName) throws HibernateException {
		if (null == configFileName && sessionFactoryMap.size() > 0) return;
		else if (null != sessionFactoryMap.get(configFileName)) return;
		else {
			Configuration cfg = new Configuration();
			if (null == configFileName)
				cfg.configure();
			else
				cfg.configure(configFileName);
			setSessionFactory(configFileName, cfg.buildSessionFactory());
		}
	}

	/**
	 * Set the session factory
	 */
	protected static void setSessionFactory (SessionFactory sessionFactory) {
		setSessionFactory((String) null, sessionFactory);
	}

	/**
	 * Set the session factory
	 */
	protected static void setSessionFactory (String configFileName, SessionFactory sessionFactory) {
		sessionFactoryMap.put(configFileName, sessionFactory);
	}

	/**
	 * Return the SessionFactory that is to be used by these DAOs.  Change this
	 * and implement your own strategy if you, for example, want to pull the SessionFactory
	 * from the JNDI tree.
	 */
	protected SessionFactory getSessionFactory() throws HibernateException {
		return getSessionFactory (getConfigurationFileName());
	}

	private static SessionFactory getSessionFactory(String configFile) throws HibernateException {
		if (sessionFactoryMap.size() == 1) return (SessionFactory) sessionFactoryMap.values().toArray()[0];
		else {
    		SessionFactory sessionFactory = (SessionFactory) sessionFactoryMap.get(configFile);
    		if (null == sessionFactory)
    			if (null == configFile)
    				throw new RuntimeException("The session factory has not been initialized.");
    			else
    				throw new RuntimeException("The session factory for '" + configFile + "' has not been initialized.");
    		else
    			return sessionFactory;
		}
	}

	/**
	 * Return a new Session object that must be closed when the work has been completed.
	 * @return the active Session
	 */
	protected Session getSession() throws HibernateException {
		return createSession();
	}

	/**
	 * Return a new Session object that must be closed when the work has been completed.
	 * @return the active Session
	 */
	public static Session createSession() throws HibernateException {
		return createSession(null);
	}

	/**
	 * Return a new Session object that must be closed when the work has been completed.
	 * @param configFile the config file must match the meta attribute "config-file" in the hibernate mapping file
	 * @return the active Session
	 */
	public static Session createSession(String configFile) throws HibernateException {
		java.util.Stack sessionStack = (java.util.Stack) threadedSessions.get();
		Session session = null;
		if (null == sessionStack) {
			sessionStack = new java.util.Stack();
			threadedSessions.set(sessionStack);
		}
		if (sessionStack.size() > 0) {
			Object[] arr = (Object[]) sessionStack.peek();
			String cf = (String) arr[0];
			if (null == cf) {
				session = (Session) arr[1];
			}
			else if (null != cf && null != configFile) {
				if (cf.equals(configFile)) session = (Session) arr[1];
			}
			if (null == session) {
				session = getSessionFactory(configFile).openSession();
				arr = new Object[2];
				arr[0] = configFile;
				arr[1] = session;
				sessionStack.push(arr);
			}
		}
		else {
			session = getSessionFactory(configFile).openSession();
			Object[] arr = new Object[2];
			arr = new Object[2];
			arr[0] = configFile;
			arr[1] = session;
			sessionStack.push(arr);
		}
		return session;
	}
	
	/**
	 * Return the name of the configuration file to be used with this DAO or null if default
	 */
	public String getConfigurationFileName () {
		return null;
	}

	/**
	 * Return the specific Object class that will be used for class-specific
	 * implementation of this DAO.
	 * @return the reference Class
	 */
	protected abstract Class getReferenceClass();

	/**
	 * Close the session
	 */
	public void closeSession () throws HibernateException {
		java.util.Stack sessionStack = (java.util.Stack) threadedSessions.get();
		if (null != sessionStack) {
			Object[] arr = (Object[]) sessionStack.peek();
			String cf = (String) arr[0];
			if (null == cf) {
				Session session = (Session) arr[1];
				session.close();
				sessionStack.pop();
			}
			else {
				String configurationFile = getConfigurationFileName();
				if (null != configurationFile && configurationFile.equals(cf)) {
					Session session = (Session) arr[1];
					session.close();
					sessionStack.pop();
				}
			}
		}
	}

	/**
	 * Begin the transaction related to the session
	 */
	public Transaction beginTransaction(Session s) throws HibernateException {
		return s.beginTransaction();
	}

	/**
	 * Commit the given transaction
	 */
	public void commitTransaction(Transaction t) throws HibernateException {
		t.commit();
	}

	/**
	 * Execute a query. 
	 * @param query a query expressed in Hibernate's query language
	 * @return a distinct list of instances (or arrays of instances)
	 */
	public java.util.List find(String query) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return find(query, s);
		} finally {
			closeSession();
		}
	}

	/**
	 * Perform a find but use the session given instead of creating a new one.
	 * @param query a query expressed in Hibernate's query language
	 * @s the Session to use
	 */
	public java.util.List find(String query, Session s) throws HibernateException {
		return s.find(query);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List findAll () throws HibernateException {
		Session s = null;
		try {
			s = getSession();
    		return findAll(s);
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List findAll (Session s) throws HibernateException {
   		return findAll(s, getDefaultOrderProperty());
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List findAll (String orderProperty) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return findAll(s, orderProperty);
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List findAll (Session s, String orderProperty) throws HibernateException {
		Criteria crit = createCriteria(s);
		if (null != orderProperty) crit.addOrder(Order.asc(orderProperty));
		return crit.list();
	}

	/**
	 * Return all objects related to the implementation of this DAO with a filter.
	 * Use the session given.
	 * @param propName the name of the property to use for filtering
	 * @param filter the value of the filter
	 */
	protected java.util.List findFiltered (String propName, Object filter) throws HibernateException {
		return findFiltered(propName, filter, getDefaultOrderProperty());
	}

	/**
	 * Return all objects related to the implementation of this DAO with a filter.
	 * Use the session given.
	 * @param propName the name of the property to use for filtering
	 * @param filter the value of the filter
	 * @param orderProperty the name of the property used for ordering
	 */
	protected java.util.List findFiltered (String propName, Object filter, String orderProperty) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return findFiltered(s, propName, filter, getDefaultOrderProperty());
		}
		finally {
			closeSession();
		}
	}
	
	/**
	 * Return all objects related to the implementation of this DAO with a filter.
	 * Use the session given.
	 * @param s the Session
	 * @param propName the name of the property to use for filtering
	 * @param filter the value of the filter
	 * @param orderProperty the name of the property used for ordering
	 */
	protected java.util.List findFiltered (Session s, String propName, Object filter, String orderProperty) throws HibernateException {
		Criteria crit = createCriteria(s);
		crit.add(Expression.eq(propName, filter));
		if (null != orderProperty) crit.addOrder(Order.asc(orderProperty));
		return crit.list();
	}
	
	/**
	 * Obtain an instance of Query for a named query string defined in the mapping file.
	 * @param name the name of a query defined externally 
	 * @return Query
	 */
	public java.util.List getNamedQuery(String name) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return getNamedQuery(name, s);
		} finally {
			closeSession();
		}
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the mapping file.
	 * Use the session given.
	 * @param name the name of a query defined externally 
	 * @param s the Session
	 * @return Query
	 */
	public java.util.List getNamedQuery(String name, Session s) throws HibernateException {
		Query q = s.getNamedQuery(name);
		return q.list();
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the mapping file.
	 * Use the parameters given.
	 * @param name the name of a query defined externally 
	 * @param params the parameter array
	 * @return Query
	 */
	public java.util.List getNamedQuery(String name, Serializable[] params)
		throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return getNamedQuery(name, params, s);
		} finally {
			closeSession();
		}
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the mapping file.
	 * Use the parameters given and the Session given.
	 * @param name the name of a query defined externally 
	 * @param params the parameter array
	 * @s the Session
	 * @return Query
	 */
	public java.util.List getNamedQuery(String name, Serializable[] params, Session s)
		throws HibernateException {
		Query q = s.getNamedQuery(name);
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				setParameterValue(q, i, params[i]);
			}
		}
		return q.list();
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the mapping file.
	 * Use the parameters given.
	 * @param name the name of a query defined externally 
	 * @param params the parameter Map
	 * @return Query
	 */
	public java.util.List getNamedQuery(String name, Map params)
		throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return getNamedQuery(name, params, s);
		} finally {
			closeSession();
		}
	}

	/**
	 * Obtain an instance of Query for a named query string defined in the mapping file.
	 * Use the parameters given and the Session given.
	 * @param name the name of a query defined externally 
	 * @param params the parameter Map
	 * @s the Session
	 * @return Query
	 */
	public java.util.List getNamedQuery(String name, Map params, Session s)
		throws HibernateException {
		Query q = s.getNamedQuery(name);
		if (null != params) {
			for (Iterator i=params.entrySet().iterator(); i.hasNext(); ) {
				Map.Entry entry = (Map.Entry) i.next();
				setParameterValue(q, (String) entry.getKey(), entry.getValue());
			}
		}
		return q.list();
	}

	/**
	 * Execute a query.
	 * @param query a query expressed in Hibernate's query language
	 * @return a distinct list of instances (or arrays of instances)
	 */
	public java.util.List find(String query, Object obj, Type type) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return find(query, obj, type, s);
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Perform a find but use the session given instead of creating a new one.
	 * @param query a query expressed in Hibernate's query language
	 * @s the Session to use
	 */
	public java.util.List find(String query, Object obj, Type type, Session s) throws HibernateException {
		return s.find(query, obj, type);
	}

	/**
	 * Execute a query.
	 * @param query a query expressed in Hibernate's query language
	 * @return a distinct list of instances (or arrays of instances)
	 */
	public java.util.List find(String query, Object[] obj, Type[] type) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return find(query, obj, type, s);
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Perform a find but use the session given instead of creating a new one.
	 * @param query a query expressed in Hibernate's query language
	 * @s the Session to use
	 */
	public java.util.List find(String query, Object[] obj, Type[] type, Session s) throws HibernateException {
		return s.find(query, obj, type);
	}

	/**
	 * Return a Criteria object that relates to the DAO's table.
	 * A session will be created if an open one is not located.  This session must be closed!
	 */
	protected Criteria createCriteria () throws HibernateException {
		Session s = getSession();
		return createCriteria(s);
	}

	/**
	 * Return a Criteria object that relates to the DAO's table
	 */
	 protected Criteria createCriteria (Session s) throws HibernateException {
	 	return s.createCriteria(getReferenceClass());
	 }

	/**
	 * Return the property of the class you would like to use for default ordering
	 * @return the property name
	 */
	public String getDefaultOrderProperty () {
		return null;
	}

	/**
	 * Convenience method to set paramers in the query given based on the actual object type in passed in as the value.
	 * You may need to add more functionaly to this as desired (or not use this at all).
	 * @param query the Query to set
	 * @param position the ordinal position of the current parameter within the query
	 * @param value the object to set as the parameter
	 */
	protected void setParameterValue(Query query, int position, Object value) {
		if (null == value) {
			return;
		} else if (value instanceof Boolean) {
			query.setBoolean(position, ((Boolean) value).booleanValue());
		} else if (value instanceof String) {
			query.setString(position, (String) value);
		} else if (value instanceof Integer) {
			query.setInteger(position, ((Integer) value).intValue());
		} else if (value instanceof Long) {
			query.setLong(position, ((Long) value).longValue());
		} else if (value instanceof Float) {
			query.setFloat(position, ((Float) value).floatValue());
		} else if (value instanceof Double) {
			query.setDouble(position, ((Double) value).doubleValue());
		} else if (value instanceof BigDecimal) {
			query.setBigDecimal(position, (BigDecimal) value);
		} else if (value instanceof Byte) {
			query.setByte(position, ((Byte) value).byteValue());
		} else if (value instanceof Calendar) {
			query.setCalendar(position, (Calendar) value);
		} else if (value instanceof Character) {
			query.setCharacter(position, ((Character) value).charValue());
		} else if (value instanceof Timestamp) {
			query.setTimestamp(position, (Timestamp) value);
		} else if (value instanceof Date) {
			query.setDate(position, (Date) value);
		} else if (value instanceof Short) {
			query.setShort(position, ((Short) value).shortValue());
		}
	}

	/**
	 * Convenience method to set paramers in the query given based on the actual object type in passed in as the value.
	 * You may need to add more functionaly to this as desired (or not use this at all).
	 * @param query the Query to set
	 * @param key the key name
	 * @param value the object to set as the parameter
	 */
	protected void setParameterValue(Query query, String key, Object value) {
		if (null == key || null == value) {
			return;
		} else if (value instanceof Boolean) {
			query.setBoolean(key, ((Boolean) value).booleanValue());
		} else if (value instanceof String) {
			query.setString(key, (String) value);
		} else if (value instanceof Integer) {
			query.setInteger(key, ((Integer) value).intValue());
		} else if (value instanceof Long) {
			query.setLong(key, ((Long) value).longValue());
		} else if (value instanceof Float) {
			query.setFloat(key, ((Float) value).floatValue());
		} else if (value instanceof Double) {
			query.setDouble(key, ((Double) value).doubleValue());
		} else if (value instanceof BigDecimal) {
			query.setBigDecimal(key, (BigDecimal) value);
		} else if (value instanceof Byte) {
			query.setByte(key, ((Byte) value).byteValue());
		} else if (value instanceof Calendar) {
			query.setCalendar(key, (Calendar) value);
		} else if (value instanceof Character) {
			query.setCharacter(key, ((Character) value).charValue());
		} else if (value instanceof Timestamp) {
			query.setTimestamp(key, (Timestamp) value);
		} else if (value instanceof Date) {
			query.setDate(key, (Date) value);
		} else if (value instanceof Short) {
			query.setShort(key, ((Short) value).shortValue());
		}
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Load object matching the given key and return it.
	 */
	protected Object load(Class refClass, Serializable key) throws HibernateException {
		Session s = null;
		try {
			s = getSession();
			return load(refClass, key, s);
		} finally {
			closeSession();
		}
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Load object matching the given key and return it.
	 */
	protected Object load(Class refClass, Serializable key, Session s) throws HibernateException {
		return s.load(refClass, key);
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Persist the given transient instance, first assigning a generated identifier. 
	 * (Or using the current value of the identifier property if the assigned generator is used.) 
	 */
	protected Serializable save(Object obj) throws HibernateException {
		Transaction t = null;
		Session s = null;
		try {
			s = getSession();
			t = beginTransaction(s);
			Serializable rtn = save(obj, s);
			commitTransaction(t);
			return rtn;
		}
		catch (HibernateException e) {
			if (null != t) t.rollback();
            throw e;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Persist the given transient instance, first assigning a generated identifier. 
	 * (Or using the current value of the identifier property if the assigned generator is used.) 
	 */
	protected Serializable save(Object obj, Session s) throws HibernateException {
		return s.save(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Either save() or update() the given instance, depending upon the value of its
	 * identifier property.
	 */
	protected void saveOrUpdate(Object obj) throws HibernateException {
		Transaction t = null;
		Session s = null;
		try {
			s = getSession();
			t = beginTransaction(s);
			saveOrUpdate(obj, s);
			commitTransaction(t);
		}
		catch (HibernateException e) {
			if (null != t) t.rollback();
            throw e;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Either save() or update() the given instance, depending upon the value of its
	 * identifier property.
	 */
	protected void saveOrUpdate(Object obj, Session s) throws HibernateException {
		s.saveOrUpdate(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param obj a transient instance containing updated state
	 */
	protected void update(Object obj) throws HibernateException {
		Transaction t = null;
		Session s = null;
		try {
			s = getSession();
			t = beginTransaction(s);
			update(obj, s);
			commitTransaction(t);
		}
		catch (HibernateException e) {
			if (null != t) t.rollback();
            throw e;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param obj a transient instance containing updated state
	 * @param s the Session
	 */
	protected void update(Object obj, Session s) throws HibernateException {
		s.update(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 */
	protected void delete(Object obj) throws HibernateException {
		Transaction t = null;
		Session s = null;
		try {
			s = getSession();
			t = beginTransaction(s);
			delete(obj, s);
			commitTransaction(t);
		}
		catch (HibernateException e) {
			if (null != t) t.rollback();
            throw e;
		}
		finally {
			closeSession();
		}
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 */
	protected void delete(Object obj, Session s) throws HibernateException {
		s.delete(obj);
	}

	/**
	 * Used by the base DAO classes but here for your modification
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 */
	protected void refresh(Object obj, Session s) throws HibernateException {
		s.refresh(obj);
	}


}