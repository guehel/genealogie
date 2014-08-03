package cg.genealogie.orm.dao;
import net.sf.hibernate.*;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.*;
public class HibernateSessionFactory {
private static final SessionFactory sessionFactory;
static
{
try
{
// Crée l’objet SessionFactory à partir de hibernate.cfg.xml
sessionFactory = new Configuration().configure().buildSessionFactory();
}
catch (HibernateException  ex)
{
	  throw new RuntimeException("Initial SessionFactory creation failed." + ex);

}
}
public static SessionFactory getSessionFactory()
{
return sessionFactory;
}
public static final ThreadLocal session = new ThreadLocal();

public static Session currentSession()
               throws HibernateException {
  Session s = (Session) session.get();
  // Ouvre une nouvelle Session, si ce Thread n'en a aucune
  if (s == null) {
  s = sessionFactory.openSession();
  session.set(s);
  }
  return s;
  }

public static void closeSession()
               throws HibernateException {
  Session s = (Session) session.get();
  session.set(null);
  if (s != null)
  s.close();
  }

}