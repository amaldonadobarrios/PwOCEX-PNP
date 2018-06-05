package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OCEX_PRE_INSC database table.
 * 
 */
@Entity
@Table(name="OCEX_PRE_INSC")
@NamedQuery(name="OcexPreInsc.findAll", query="SELECT o FROM OcexPreInsc o")
public class OcexPreInsc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_PRE_INSC_IDPRE_GENERATOR", sequenceName="SECPRE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_PRE_INSC_IDPRE_GENERATOR")
	@Column(name="ID_PRE")
	private long idPre;

	@Column(name="F_ANIO")
	private String fAnio;

	@Column(name="F_DIAS_FRANCO")
	private String fDiasFranco;

	@Column(name="F_MES")
	private String fMes;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REG")
	private Date fechaReg;

	@Column(name="FLAG_PRE")
	private String flagPre;

	@Column(name="ID_PER")
	private int idPer;

	@Column(name="MOD_PRE")
	private String modPre;

	@Column(name="USU_REG")
	private String usuReg;

	@Column(name="V_CANT_CUS")
	private String vCantCus;

	@Temporal(TemporalType.DATE)
	@Column(name="V_FIN_CUS")
	private Date vFinCus;

	@Temporal(TemporalType.DATE)
	@Column(name="V_INI_CUS")
	private Date vIniCus;

	public OcexPreInsc() {
	}

	public long getIdPre() {
		return this.idPre;
	}

	public void setIdPre(long idPre) {
		this.idPre = idPre;
	}

	public String getFAnio() {
		return this.fAnio;
	}

	public void setFAnio(String fAnio) {
		this.fAnio = fAnio;
	}

	public String getFDiasFranco() {
		return this.fDiasFranco;
	}

	public void setFDiasFranco(String fDiasFranco) {
		this.fDiasFranco = fDiasFranco;
	}

	public String getFMes() {
		return this.fMes;
	}

	public void setFMes(String fMes) {
		this.fMes = fMes;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getFlagPre() {
		return this.flagPre;
	}

	public void setFlagPre(String flagPre) {
		this.flagPre = flagPre;
	}

	public int getIdPer() {
		return this.idPer;
	}

	public void setIdPer(int idPer) {
		this.idPer = idPer;
	}

	public String getModPre() {
		return this.modPre;
	}

	public void setModPre(String modPre) {
		this.modPre = modPre;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

	public String getVCantCus() {
		return this.vCantCus;
	}

	public void setVCantCus(String vCantCus) {
		this.vCantCus = vCantCus;
	}

	public Date getVFinCus() {
		return this.vFinCus;
	}

	public void setVFinCus(Date vFinCus) {
		this.vFinCus = vFinCus;
	}

	public Date getVIniCus() {
		return this.vIniCus;
	}

	public void setVIniCus(Date vIniCus) {
		this.vIniCus = vIniCus;
	}

}