package cg.genealogie.orm;

import cg.genealogie.orm.base.BasePersonne;

/**
 * This is the object class that relates to the personne table.
 * Any customizations belong here.
 */
public class Personne extends BasePersonne {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Personne () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Personne (java.lang.Integer _idPersonne) {
		super(_idPersonne);
	}

	/**
	 * Constructor for required fields
	 */
	public Personne (
		java.lang.Integer _idPersonne,
		cg.genealogie.orm.Personne _idpersonne2,
		cg.genealogie.orm.Personne _idpersonne1,
		java.util.Date _naissance) {

		super (
			_idPersonne,
			_idpersonne2,
			_idpersonne1,
			_naissance);
	}

/*[CONSTRUCTOR MARKER END]*/
}