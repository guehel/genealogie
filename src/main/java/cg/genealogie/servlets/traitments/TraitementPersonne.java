package cg.genealogie.servlets.traitments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import cg.genealogie.orm.Personne;
import cg.genealogie.orm.dao.HibernateSessionFactory;

public class TraitementPersonne implements Traitement {

	public Boolean traiter(HttpServletRequest request) {
		String idPersonne  = request.getParameter("idPersonne");
		String idPere  = request.getParameter("idPere");
		String idMere  = request.getParameter("idMere");
		String dateNaissance  = request.getParameter("naissance");
		Personne personne = new Personne();
		try{
			personne.setIdPersonne(Integer.parseInt(idPersonne));
			personne.setIdpersonne1(new Personne(Integer.parseInt(idPere)));
			personne.setIdpersonne2(new Personne(Integer.parseInt(idMere)));
			Date naissance = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance);
			personne.setNaissance(naissance);
			Session session = HibernateSessionFactory.currentSession();
			Transaction transaction = session.beginTransaction();
			session.save(personne);
			transaction.commit();
			return true;
		}
		catch(NumberFormatException e){
			e.printStackTrace();
		} 
		catch (HibernateException e) {
				e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
