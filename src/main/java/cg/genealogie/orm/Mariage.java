package cg.genealogie.orm;

import cg.genealogie.orm.base.BaseMariage;

/**
 * This is the object class that relates to the mariage table.
 * Any customizations belong here.
 */
public class Mariage extends BaseMariage {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Mariage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Mariage (cg.genealogie.orm.MariagePK _id) {
		super(_id);
	}

/*[CONSTRUCTOR MARKER END]*/
}