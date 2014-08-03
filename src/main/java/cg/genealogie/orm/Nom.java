package cg.genealogie.orm;

import cg.genealogie.orm.base.BaseNom;

/**
 * This is the object class that relates to the nom table.
 * Any customizations belong here.
 */
public class Nom extends BaseNom {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Nom () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Nom (java.lang.String _nom) {
		super(_nom);
	}

/*[CONSTRUCTOR MARKER END]*/
}