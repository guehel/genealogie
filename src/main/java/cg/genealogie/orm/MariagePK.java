package cg.genealogie.orm;

import cg.genealogie.orm.base.BaseMariagePK;

public class MariagePK extends BaseMariagePK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MariagePK () {}
	
	public MariagePK (
		cg.genealogie.orm.Personne _idPersonne,
		cg.genealogie.orm.Personne _idpersonne1) {

		super (
		_idPersonne,
		_idpersonne1);
	}
/*[CONSTRUCTOR MARKER END]*/
}