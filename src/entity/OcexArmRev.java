package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OCEX_ARM_REV database table.
 * 
 */
@Entity
@Table(name="OCEX_ARM_REV")
@NamedQuery(name="OcexArmRev.findAll", query="SELECT o FROM OcexArmRev o")
public class OcexArmRev implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_ARM_REV_IDPAPARM_GENERATOR", sequenceName="SECARM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_ARM_REV_IDPAPARM_GENERATOR")
	@Column(name="ID_PAP_ARM")
	private long idPapArm;

	@Column(name="ACCES_ARM")
	private String accesArm;

	@Column(name="CAF_ARM")
	private String cafArm;

	@Column(name="CAL_ARM")
	private String calArm;

	@Column(name="CANT_MUN")
	private String cantMun;

	@Column(name="CLAS_ARM")
	private String clasArm;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REG")
	private Date fechaReg;

	@Column(name="FLAG_REV_ARM")
	private String flagRevArm;

	@Column(name="ID_FICHER")
	private BigDecimal idFicher;

	@Column(name="ID_PER")
	private BigDecimal idPer;

	@Column(name="MARC_ARM")
	private String marcArm;

	@Column(name="NRO_REV_ARM")
	private String nroRevArm;

	@Column(name="NRO_SER_ARM")
	private String nroSerArm;

	@Column(name="UNID_EMITE")
	private String unidEmite;

	@Column(name="USU_REG")
	private String usuReg;

	public OcexArmRev() {
	}

	public long getIdPapArm() {
		return this.idPapArm;
	}

	public void setIdPapArm(long idPapArm) {
		this.idPapArm = idPapArm;
	}

	public String getAccesArm() {
		return this.accesArm;
	}

	public void setAccesArm(String accesArm) {
		this.accesArm = accesArm;
	}

	public String getCafArm() {
		return this.cafArm;
	}

	public void setCafArm(String cafArm) {
		this.cafArm = cafArm;
	}

	public String getCalArm() {
		return this.calArm;
	}

	public void setCalArm(String calArm) {
		this.calArm = calArm;
	}

	public String getCantMun() {
		return this.cantMun;
	}

	public void setCantMun(String cantMun) {
		this.cantMun = cantMun;
	}

	public String getClasArm() {
		return this.clasArm;
	}

	public void setClasArm(String clasArm) {
		this.clasArm = clasArm;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getFlagRevArm() {
		return this.flagRevArm;
	}

	public void setFlagRevArm(String flagRevArm) {
		this.flagRevArm = flagRevArm;
	}

	public BigDecimal getIdFicher() {
		return this.idFicher;
	}

	public void setIdFicher(BigDecimal idFicher) {
		this.idFicher = idFicher;
	}

	public BigDecimal getIdPer() {
		return this.idPer;
	}

	public void setIdPer(BigDecimal idPer) {
		this.idPer = idPer;
	}

	public String getMarcArm() {
		return this.marcArm;
	}

	public void setMarcArm(String marcArm) {
		this.marcArm = marcArm;
	}

	public String getNroRevArm() {
		return this.nroRevArm;
	}

	public void setNroRevArm(String nroRevArm) {
		this.nroRevArm = nroRevArm;
	}

	public String getNroSerArm() {
		return this.nroSerArm;
	}

	public void setNroSerArm(String nroSerArm) {
		this.nroSerArm = nroSerArm;
	}

	public String getUnidEmite() {
		return this.unidEmite;
	}

	public void setUnidEmite(String unidEmite) {
		this.unidEmite = unidEmite;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

}