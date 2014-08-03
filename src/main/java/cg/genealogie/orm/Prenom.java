package cg.genealogie.orm;

import cg.genealogie.orm.base.BasePrenom;

/**
 * This is the object class that relates to the prenom table.
 * Any customizations belong here.
 */
public class Prenom extends BasePrenom {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Prenom () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Prenom (java.lang.String _prenom) {
		super(_prenom);
	}

/*[CONSTRUCTOR MARKER END]*/
}