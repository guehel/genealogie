package cg.genealogie.orm;

import cg.genealogie.orm.base.BaseNomme;

/**
 * This is the object class that relates to the nomme table.
 * Any customizations belong here.
 */
public class Nomme extends BaseNomme {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Nomme () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Nomme (
		cg.genealogie.orm.Nom _nom,
		cg.genealogie.orm.Personne _idPersonne) {

		super (
			_nom,
			_idPersonne);
	}

/*[CONSTRUCTOR MARKER END]*/
}