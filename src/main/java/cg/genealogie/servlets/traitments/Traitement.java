package cg.genealogie.servlets.traitments;

import javax.servlet.http.HttpServletRequest;

public interface Traitement {

	public Boolean traiter(HttpServletRequest request) ;
}
