package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the OCEX_CHARLA database table.
 * 
 */
@Entity
@Table(name="OCEX_CHARLA")
@NamedQuery(name="OcexCharla.findAll", query="SELECT o FROM OcexCharla o")
public class OcexCharla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_CHARLA_IDCHARLA_GENERATOR", sequenceName="SECCHAR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_CHARLA_IDCHARLA_GENERATOR")
	@Column(name="ID_CHARLA")
	private long idCharla;

	@Column(name="CIP_PER")
	private String cipPer;

	@Column(name="DNI_PER")
	private String dniPer;

	@Temporal(TemporalType.DATE)
	@Column(name="FEC_CHAR")
	private Date fecChar;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REG")
	private Date fechaReg;

	@Column(name="FLAG_CHARLA")
	private String flagCharla;

	@Column(name="NOMBRE_PER")
	private String nombrePer;

	private String unidad;

	@Column(name="USU_REG")
	private String usuReg;

	@Temporal(TemporalType.DATE)
	@Column(name="VIG_CHAR")
	private Date vigChar;

	public OcexCharla() {
	}

	public long getIdCharla() {
		return this.idCharla;
	}

	public void setIdCharla(long idCharla) {
		this.idCharla = idCharla;
	}

	public String getCipPer() {
		return this.cipPer;
	}

	public void setCipPer(String cipPer) {
		this.cipPer = cipPer;
	}

	public String getDniPer() {
		return this.dniPer;
	}

	public void setDniPer(String dniPer) {
		this.dniPer = dniPer;
	}

	public Date getFecChar() {
		return this.fecChar;
	}

	public void setFecChar(Date fecChar) {
		this.fecChar = fecChar;
	}

	public Date getFechaReg() {
		return this.fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getFlagCharla() {
		return this.flagCharla;
	}

	public void setFlagCharla(String flagCharla) {
		this.flagCharla = flagCharla;
	}

	public String getNombrePer() {
		return this.nombrePer;
	}

	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

	public Date getVigChar() {
		return this.vigChar;
	}

	public void setVigChar(Date vigChar) {
		this.vigChar = vigChar;
	}

	@Override
	public String toString() {
		return "OcexCharla [idCharla=" + idCharla + ", cipPer=" + cipPer + ", dniPer=" + dniPer + ", fecChar=" + fecChar
				+ ", fechaReg=" + fechaReg + ", flagCharla=" + flagCharla + ", nombrePer=" + nombrePer + ", unidad="
				+ unidad + ", usuReg=" + usuReg + ", vigChar=" + vigChar + "]";
	}

}