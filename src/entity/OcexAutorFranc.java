package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OCEX_AUTOR_FRANC database table.
 * 
 */
@Entity
@Table(name="OCEX_AUTOR_FRANC")
@NamedQuery(name="OcexAutorFranc.findAll", query="SELECT o FROM OcexAutorFranc o")
public class OcexAutorFranc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_AUTOR_FRANC_IDAUT_GENERATOR", sequenceName="SECAUTORFRANC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_AUTOR_FRANC_IDAUT_GENERATOR")
	@Column(name="ID_AUT")
	private long idAut;

	private String anio;

	@Column(name="DIAS_FRANCO")
	private String diasFranco;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_REG")
	private Date fechReg;

	@Column(name="FLAG_AUT")
	private String flagAut;

	@Column(name="ID_FICHER")
	private BigDecimal idFicher;

	@Column(name="ID_PER")
	private BigDecimal idPer;

	private String mes;

	@Column(name="USU_REG")
	private String usuReg;

	public OcexAutorFranc() {
	}

	public long getIdAut() {
		return this.idAut;
	}

	public void setIdAut(long idAut) {
		this.idAut = idAut;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getDiasFranco() {
		return this.diasFranco;
	}

	public void setDiasFranco(String diasFranco) {
		this.diasFranco = diasFranco;
	}

	public Date getFechReg() {
		return this.fechReg;
	}

	public void setFechReg(Date fechReg) {
		this.fechReg = fechReg;
	}

	public String getFlagAut() {
		return this.flagAut;
	}

	public void setFlagAut(String flagAut) {
		this.flagAut = flagAut;
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

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

}