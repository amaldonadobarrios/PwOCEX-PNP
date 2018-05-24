package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OCEX_FICHER database table.
 * 
 */
@Entity
@Table(name="OCEX_FICHER")
@NamedQuery(name="OcexFicher.findAll", query="SELECT o FROM OcexFicher o")
public class OcexFicher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_FICHER_IDFICHER_GENERATOR", sequenceName="SECFIC",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_FICHER_IDFICHER_GENERATOR")
	@Column(name="ID_FICHER")
	private long idFicher;

	@Column(name="CIP_PER")
	private String cipPer;


	@Column(name="ID_SESION")
	private String idSesion;

	@Lob
	@Column(name="IMAGE_FICHER")
	private byte[] imageFicher;

	@Column(name="NOMB_FICHER")
	private String nombFicher;

	@Column(name="TAM_FICHER")
	private String tamFicher;

	@Column(name="TIP_FICHER")
	private String tipFicher;

	public OcexFicher() {
	}

	public long getIdFicher() {
		return this.idFicher;
	}

	public void setIdFicher(long idFicher) {
		this.idFicher = idFicher;
	}

	public String getCipPer() {
		return this.cipPer;
	}

	public void setCipPer(String cipPer) {
		this.cipPer = cipPer;
	}
	public String getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public byte[] getImageFicher() {
		return this.imageFicher;
	}

	public void setImageFicher(byte[] imageFicher) {
		this.imageFicher = imageFicher;
	}

	public String getNombFicher() {
		return this.nombFicher;
	}

	public void setNombFicher(String nombFicher) {
		this.nombFicher = nombFicher;
	}

	public String getTamFicher() {
		return this.tamFicher;
	}

	public void setTamFicher(String tamFicher) {
		this.tamFicher = tamFicher;
	}

	public String getTipFicher() {
		return this.tipFicher;
	}

	public void setTipFicher(String tipFicher) {
		this.tipFicher = tipFicher;
	}

}