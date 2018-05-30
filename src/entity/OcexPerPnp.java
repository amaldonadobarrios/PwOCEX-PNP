package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OCEX_PER_PNP database table.
 * 
 */
@Entity
@Table(name="OCEX_PER_PNP")
@NamedQuery(name="OcexPerPnp.findAll", query="SELECT o FROM OcexPerPnp o")
public class OcexPerPnp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OCEX_PER_PNP_IDPER_GENERATOR", sequenceName="SECPER",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_PER_PNP_IDPER_GENERATOR")
	@Column(name="ID_PER")
	private long idPer;

	@Column(name="APE_MAT_PER")
	private String apeMatPer;

	@Column(name="APE_PAT_PER")
	private String apePatPer;

	@Column(name="CIP_PER")
	private String cipPer;

	@Column(name="CORREO_PNP")
	private String correoPnp;

	@Column(name="CTA_AHOR_PER")
	private String ctaAhorPer;

	@Column(name="DNI_PER")
	private String dniPer;

	@Column(name="DOM_PER")
	private String domPer;

	@Column(name="FEC_NAC")
	private String fecNac;

	@Column(name="FLAG_PER_PNP")
	private String flagPerPnp;

	@Column(name="GEN_PER")
	private String genPer;

	@Column(name="GRADO_PER")
	private String gradoPer;

	@Column(name="NOM_PER")
	private String nomPer;

	@Column(name="NOM_UNI_PER")
	private String nomUniPer;

	@Column(name="TEL_CEL_PER")
	private String telCelPer;

	@Column(name="USU_REG")
	private String usuReg;

	public OcexPerPnp() {
	}

	public long getIdPer() {
		return this.idPer;
	}

	public void setIdPer(long idPer) {
		this.idPer = idPer;
	}

	public String getApeMatPer() {
		return this.apeMatPer;
	}

	public void setApeMatPer(String apeMatPer) {
		this.apeMatPer = apeMatPer;
	}

	public String getApePatPer() {
		return this.apePatPer;
	}

	public void setApePatPer(String apePatPer) {
		this.apePatPer = apePatPer;
	}

	public String getCipPer() {
		return this.cipPer;
	}

	public void setCipPer(String cipPer) {
		this.cipPer = cipPer;
	}

	public String getCorreoPnp() {
		return this.correoPnp;
	}

	public void setCorreoPnp(String correoPnp) {
		this.correoPnp = correoPnp;
	}

	public String getCtaAhorPer() {
		return this.ctaAhorPer;
	}

	public void setCtaAhorPer(String ctaAhorPer) {
		this.ctaAhorPer = ctaAhorPer;
	}

	public String getDniPer() {
		return this.dniPer;
	}

	public void setDniPer(String dniPer) {
		this.dniPer = dniPer;
	}

	public String getDomPer() {
		return this.domPer;
	}

	public void setDomPer(String domPer) {
		this.domPer = domPer;
	}

	public String getFecNac() {
		return this.fecNac;
	}

	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}

	public String getFlagPerPnp() {
		return this.flagPerPnp;
	}

	public void setFlagPerPnp(String flagPerPnp) {
		this.flagPerPnp = flagPerPnp;
	}

	public String getGenPer() {
		return this.genPer;
	}

	public void setGenPer(String genPer) {
		this.genPer = genPer;
	}

	public String getGradoPer() {
		return this.gradoPer;
	}

	public void setGradoPer(String gradoPer) {
		this.gradoPer = gradoPer;
	}

	public String getNomPer() {
		return this.nomPer;
	}

	public void setNomPer(String nomPer) {
		this.nomPer = nomPer;
	}

	public String getNomUniPer() {
		return this.nomUniPer;
	}

	public void setNomUniPer(String nomUniPer) {
		this.nomUniPer = nomUniPer;
	}

	public String getTelCelPer() {
		return this.telCelPer;
	}

	public void setTelCelPer(String telCelPer) {
		this.telCelPer = telCelPer;
	}

	public String getUsuReg() {
		return this.usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

	@Override
	public String toString() {
		return "OcexPerPnp [idPer=" + idPer + ", apeMatPer=" + apeMatPer + ", apePatPer=" + apePatPer + ", cipPer="
				+ cipPer + ", correoPnp=" + correoPnp + ", ctaAhorPer=" + ctaAhorPer + ", dniPer=" + dniPer
				+ ", domPer=" + domPer + ", fecNac=" + fecNac + ", flagPerPnp=" + flagPerPnp + ", genPer=" + genPer
				+ ", gradoPer=" + gradoPer + ", nomPer=" + nomPer + ", nomUniPer=" + nomUniPer + ", telCelPer="
				+ telCelPer + ", usuReg=" + usuReg + "]";
	}

}