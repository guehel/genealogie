package cg.genealogie.orm.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 */
public class BaseMariagePK implements Serializable {

	private int hashCode = Integer.MIN_VALUE;

	private cg.genealogie.orm.Personne _idPersonne;
	private cg.genealogie.orm.Personne _idpersonne1;

	public BaseMariagePK () {}
	
	public BaseMariagePK (
		cg.genealogie.orm.Personne _idPersonne,
		cg.genealogie.orm.Personne _idpersonne1) {

		this.setIdPersonne(_idPersonne);
		this.setIdpersonne1(_idpersonne1);
	}


	public cg.genealogie.orm.Personne getIdPersonne () {
		return _idPersonne;
	}

	public void setIdPersonne (cg.genealogie.orm.Personne _idPersonne) {
		hashCode = Integer.MIN_VALUE;
		this._idPersonne = _idPersonne;
	}

	public cg.genealogie.orm.Personne getIdpersonne1 () {
		return _idpersonne1;
	}

	public void setIdpersonne1 (cg.genealogie.orm.Personne _idpersonne1) {
		hashCode = Integer.MIN_VALUE;
		this._idpersonne1 = _idpersonne1;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof cg.genealogie.orm.MariagePK)) return false;
		else {
			cg.genealogie.orm.MariagePK mObj = (cg.genealogie.orm.MariagePK) obj;
			if (null != this.getIdPersonne() && null != mObj.getIdPersonne()) {
				if (!this.getIdPersonne().equals(mObj.getIdPersonne())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getIdpersonne1() && null != mObj.getIdpersonne1()) {
				if (!this.getIdpersonne1().equals(mObj.getIdpersonne1())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getIdPersonne()) {
				sb.append(this.getIdPersonne().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getIdpersonne1()) {
				sb.append(this.getIdpersonne1().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}

}