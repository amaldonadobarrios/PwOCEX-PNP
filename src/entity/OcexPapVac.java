package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OCEX_PAP_VAC database table.
 * 
 */
@Entity
@Table(name="OCEX_PAP_VAC")
@NamedQuery(name="OcexPapVac.findAll", query="SELECT o FROM OcexPapVac o")
public class OcexPapVac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_PAP_VAC_IDPVAC_GENERATOR", sequenceName="SECVAC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_PAP_VAC_IDPVAC_GENERATOR")
	@Column(name="ID_P_VAC")
	private long idPVac;

	@Column(name="CANT_VAC")
	private String cantVac;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REG")
	private Date fechaReg;

	@Temporal(TemporalType.DATE)
	@Column(name="FFIN_CUS")
	private Date ffinCus;

	@Temporal(TemporalType.DATE)
	@Column(name="FIN_VAC")
	private Date finVac;

	@Temporal(TemporalType.DATE)
	@Column(name="FINI_CUS")
	private Date finiCus;

	@Column(name="FLAG_VAC")
	private String flagVac;

	@Column(name="ID_FICHER")
	private BigDecimal idFicher;

	@Column(name="ID_PER")
	private BigDecimal idPer;

	@Temporal(TemporalType.DATE)
	@Column(name="INI_VAC")
	private Date iniVac;

	@Column(name="USU_REG")
	private String usuReg;

	public OcexPapVac() {
	}

	public long getIdPVac() {
		return this.idPVac;
	}

	public void setIdPVac(long idPVac) {
		this.idPVac = idPVac;
	}

	public String getCantVac() {
		return this.cantVac;
	}

	public void setCantVac(String cantVac) {
		this.cantVac = cantVac;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Date getFfinCus() {
		return this.ffinCus;
	}

	public void setFfinCus(Date ffinCus) {
		this.ffinCus = ffinCus;
	}

	public Date getFinVac() {
		return this.finVac;
	}

	public void setFinVac(Date finVac) {
		this.finVac = finVac;
	}

	public Date getFiniCus() {
		return this.finiCus;
	}

	public void setFiniCus(Date finiCus) {
		this.finiCus = finiCus;
	}

	public String getFlagVac() {
		return this.flagVac;
	}

	public void setFlagVac(String flagVac) {
		this.flagVac = flagVac;
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

	public Date getIniVac() {
		return this.iniVac;
	}

	public void setIniVac(Date iniVac) {
		this.iniVac = iniVac;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

}