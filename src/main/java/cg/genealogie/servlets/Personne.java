package cg.genealogie.servlets;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cg.genealogie.servlets.traitments.Traitement;
import cg.genealogie.servlets.traitments.TraitementPersonne;

public class Personne extends HttpServlet {
	public static String urlPagePersonne ="";
public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException{
	
}
public void doPost(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException{
Traitement traitementPersonne = new TraitementPersonne();
Boolean reussite  = traitementPersonne.traiter(request);
request.setAttribute("reussite", reussite);
this.getServletContext().getRequestDispatcher(urlPagePersonne).forward(request, response);
}
}
