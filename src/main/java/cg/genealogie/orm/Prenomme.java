package cg.genealogie.orm;

import cg.genealogie.orm.base.BasePrenomme;

/**
 * This is the object class that relates to the prenomme table.
 * Any customizations belong here.
 */
public class Prenomme extends BasePrenomme {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Prenomme () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Prenomme (
		cg.genealogie.orm.Prenom _prenom,
		cg.genealogie.orm.Personne _idPersonne) {

		super (
			_prenom,
			_idPersonne);
	}

/*[CONSTRUCTOR MARKER END]*/
}