package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OCEX_FIC_MED database table.
 * 
 */
@Entity
@Table(name="OCEX_FIC_MED")
@NamedQuery(name="OcexFicMed.findAll", query="SELECT o FROM OcexFicMed o")
public class OcexFicMed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_FIC_MED_IDFICMED_GENERATOR", sequenceName="SECFIC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_FIC_MED_IDFICMED_GENERATOR")
	@Column(name="ID_FIC_MED")
	private long idFicMed;

	@Column(name="APT_PNP")
	private String aptPnp;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REG")
	private Date fechaReg;

	@Column(name="FLAG_FIC_MED")
	private String flagFicMed;

	@Column(name="ID_FICHER")
	private BigDecimal idFicher;

	@Column(name="ID_PER")
	private BigDecimal idPer;

	@Column(name="NRO_FIC_MED")
	private String nroFicMed;

	@Column(name="USU_REG")
	private String usuReg;

	public OcexFicMed() {
	}

	public long getIdFicMed() {
		return this.idFicMed;
	}

	public void setIdFicMed(long idFicMed) {
		this.idFicMed = idFicMed;
	}

	public String getAptPnp() {
		return this.aptPnp;
	}

	public void setAptPnp(String aptPnp) {
		this.aptPnp = aptPnp;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getFlagFicMed() {
		return this.flagFicMed;
	}

	public void setFlagFicMed(String flagFicMed) {
		this.flagFicMed = flagFicMed;
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

	public String getNroFicMed() {
		return this.nroFicMed;
	}

	public void setNroFicMed(String nroFicMed) {
		this.nroFicMed = nroFicMed;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

}