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
	@SequenceGenerator(name="OCEX_PER_PNP_IDPNP_GENERATOR", sequenceName="SECPER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OCEX_PER_PNP_IDPNP_GENERATOR")
	@Column(name="ID_PNP")
	private long idPnp;

	@Column(name="APE_MAT_PER")
	private String apeMatPer;

	@Column(name="APE_PAT_PER")
	private String apePatPer;

	@Column(name="APT_PER")
	private String aptPer;

	@Column(name="CANT_VAC_PER")
	private String cantVacPer;

	@Column(name="CIP_PER")
	private String cipPer;

	@Column(name="CORREO_PNP")
	private String correoPnp;

	@Column(name="CTA_AHOR_PER")
	private String ctaAhorPer;

	@Column(name="DNI_PER")
	private String dniPer;

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

	public OcexPerPnp() {
	}

	public long getIdPnp() {
		return this.idPnp;
	}

	public void setIdPnp(long idPnp) {
		this.idPnp = idPnp;
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

	public String getAptPer() {
		return this.aptPer;
	}

	public void setAptPer(String aptPer) {
		this.aptPer = aptPer;
	}

	public String getCantVacPer() {
		return this.cantVacPer;
	}

	public void setCantVacPer(String cantVacPer) {
		this.cantVacPer = cantVacPer;
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

	@Override
	public String toString() {
		return "OcexPerPnp [idPnp=" + idPnp + ", apeMatPer=" + apeMatPer + ", apePatPer=" + apePatPer + ", aptPer="
				+ aptPer + ", cantVacPer=" + cantVacPer + ", cipPer=" + cipPer + ", correoPnp=" + correoPnp
				+ ", ctaAhorPer=" + ctaAhorPer + ", dniPer=" + dniPer + ", fecNac=" + fecNac + ", flagPerPnp="
				+ flagPerPnp + ", genPer=" + genPer + ", gradoPer=" + gradoPer + ", nomPer=" + nomPer + ", nomUniPer="
				+ nomUniPer + ", telCelPer=" + telCelPer + "]";
	}

}