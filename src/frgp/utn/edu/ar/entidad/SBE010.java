package frgp.utn.edu.ar.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="SBE010")
public class SBE010 {

	@Column(name="BE_FILIAL")
	private String be_filial;

	@Column(name="BE_LOCAL")
	private String be_local;
	
	@Column(name="BE_LOCALIZ")
	private String be_localiz;
	
	@Column(name="BE_DESCRIC")
	private String be_descric;

	@Column(name="BE_CAPACID")
	private Float be_capacid;
	
	@Column(name="BE_PRIOR")
	private String be_prior;
	
	@Column(name="BE_ALTURLC")
	private Float be_alturlc;
	
	@Column(name="BE_LARGLC")
	private Float be_larglc;
	
	@Column(name="BE_COMPRLC")
	private Float be_comprlc;
	
	@Column(name="BE_PERDA")
	private Float be_perda;
	
	@Column(name="BE_CODZON")
	private String be_codzon;
	
	@Column(name="BE_STATUS")
	private String be_status;
	
	@Column(name="BE_ESTFIS")
	private String be_estfis;
	
	@Column(name="BE_CODCFG")
	private String be_codcfg;
	
	@Column(name="BE_CODPRO")
	private String be_codpro;
	
	@Column(name="BE_HORA")
	private String be_hora;
	
	@Column(name="BE_OK")
	private String be_ok;
	
	@Column(name="BE_XCECAO")
	private String be_xcecao;
	
	@Column(name="BE_DATGER")
	private String be_datger;
	
	@Column(name="BE_HORGER")
	private String be_horger;
	
	@Column(name="BE_DTINV")
	private String be_dtinv;
	
	@Column(name="BE_IDETIQ")
	private String be_idetiq;
	
	@Column(name="D_E_L_E_T_")
	private String D_E_L_E_T_;
	
	@Id
	@Column(name="R_E_C_N_O_")
	private Integer R_E_C_N_O_;
	
	@Column(name="R_E_C_D_E_L_")
	private Integer R_E_C_D_E_L_;
	
	@Column(name="BE_VALNV1")
	private Float be_valnv1;
	
	@Column(name="BE_VALNV2")
	private Float be_valnv2;
	
	@Column(name="BE_VALNV3")
	private Float be_valnv3;
	
	@Column(name="BE_VALNV4")
	private Float be_valnv4;
	
	@Column(name="BE_VALNV5")
	private Float be_valnv5;
	
	@Column(name="BE_VALNV6")
	private Float be_valnv6;
	
	@Column(name="BE_NRUNIT")
	private Float be_nrunit;
	
	public SBE010()
	{
		
	}

	public String getBe_filial() {
		return be_filial;
	}

	public void setBe_filial(String be_filial) {
		this.be_filial = be_filial;
	}

	public String getBe_local() {
		return be_local;
	}

	public void setBe_local(String be_local) {
		this.be_local = be_local;
	}

	public String getBe_localiz() {
		return be_localiz;
	}

	public void setBe_localiz(String be_localiz) {
		this.be_localiz = be_localiz;
	}

	public String getBe_descric() {
		return be_descric;
	}

	public void setBe_descric(String be_descric) {
		this.be_descric = be_descric;
	}

	public Float getBe_capacid() {
		return be_capacid;
	}

	public void setBe_capacid(Float be_capacid) {
		this.be_capacid = be_capacid;
	}

	public String getBe_prior() {
		return be_prior;
	}

	public void setBe_prior(String be_prior) {
		this.be_prior = be_prior;
	}

	public Float getBe_alturlc() {
		return be_alturlc;
	}

	public void setBe_alturlc(Float be_alturlc) {
		this.be_alturlc = be_alturlc;
	}

	public Float getBe_larglc() {
		return be_larglc;
	}

	public void setBe_larglc(Float be_larglc) {
		this.be_larglc = be_larglc;
	}

	public Float getBe_comprlc() {
		return be_comprlc;
	}

	public void setBe_comprlc(Float be_comprlc) {
		this.be_comprlc = be_comprlc;
	}

	public Float getBe_perda() {
		return be_perda;
	}

	public void setBe_perda(Float be_perda) {
		this.be_perda = be_perda;
	}

	public String getBe_codzon() {
		return be_codzon;
	}

	public void setBe_codzon(String be_codzon) {
		this.be_codzon = be_codzon;
	}

	public String getBe_status() {
		return be_status;
	}

	public void setBe_status(String be_status) {
		this.be_status = be_status;
	}

	public String getBe_estfis() {
		return be_estfis;
	}

	public void setBe_estfis(String be_estfis) {
		this.be_estfis = be_estfis;
	}

	public String getBe_codcfg() {
		return be_codcfg;
	}

	public void setBe_codcfg(String be_codcfg) {
		this.be_codcfg = be_codcfg;
	}

	public String getBe_codpro() {
		return be_codpro;
	}

	public void setBe_codpro(String be_codpro) {
		this.be_codpro = be_codpro;
	}

	public String getBe_hora() {
		return be_hora;
	}

	public void setBe_hora(String be_hora) {
		this.be_hora = be_hora;
	}

	public String getBe_ok() {
		return be_ok;
	}

	public void setBe_ok(String be_ok) {
		this.be_ok = be_ok;
	}

	public String getBe_xcecao() {
		return be_xcecao;
	}

	public void setBe_xcecao(String be_xcecao) {
		this.be_xcecao = be_xcecao;
	}

	public String getBe_datger() {
		return be_datger;
	}

	public void setBe_datger(String be_datger) {
		this.be_datger = be_datger;
	}

	public String getBe_horger() {
		return be_horger;
	}

	public void setBe_horger(String be_horger) {
		this.be_horger = be_horger;
	}

	public String getBe_dtinv() {
		return be_dtinv;
	}

	public void setBe_dtinv(String be_dtinv) {
		this.be_dtinv = be_dtinv;
	}

	public String getBe_idetiq() {
		return be_idetiq;
	}

	public void setBe_idetiq(String be_idetiq) {
		this.be_idetiq = be_idetiq;
	}

	public String getD_E_L_E_T_() {
		return D_E_L_E_T_;
	}

	public void setD_E_L_E_T_(String d_E_L_E_T_) {
		D_E_L_E_T_ = d_E_L_E_T_;
	}

	public Integer getR_E_C_N_O_() {
		return R_E_C_N_O_;
	}

	public void setR_E_C_N_O_(Integer r_E_C_N_O_) {
		R_E_C_N_O_ = r_E_C_N_O_;
	}

	public Integer getR_E_C_D_E_L_() {
		return R_E_C_D_E_L_;
	}

	public void setR_E_C_D_E_L_(Integer r_E_C_D_E_L_) {
		R_E_C_D_E_L_ = r_E_C_D_E_L_;
	}

	public Float getBe_valnv1() {
		return be_valnv1;
	}

	public void setBe_valnv1(Float be_valnv1) {
		this.be_valnv1 = be_valnv1;
	}

	public Float getBe_valnv2() {
		return be_valnv2;
	}

	public void setBe_valnv2(Float be_valnv2) {
		this.be_valnv2 = be_valnv2;
	}

	public Float getBe_valnv3() {
		return be_valnv3;
	}

	public void setBe_valnv3(Float be_valnv3) {
		this.be_valnv3 = be_valnv3;
	}

	public Float getBe_valnv4() {
		return be_valnv4;
	}

	public void setBe_valnv4(Float be_valnv4) {
		this.be_valnv4 = be_valnv4;
	}

	public Float getBe_valnv5() {
		return be_valnv5;
	}

	public void setBe_valnv5(Float be_valnv5) {
		this.be_valnv5 = be_valnv5;
	}

	public Float getBe_valnv6() {
		return be_valnv6;
	}

	public void setBe_valnv6(Float be_valnv6) {
		this.be_valnv6 = be_valnv6;
	}

	public Float getBe_nrunit() {
		return be_nrunit;
	}

	public void setBe_nrunit(Float be_nrunit) {
		this.be_nrunit = be_nrunit;
	}

	@Override
	public String toString() {
		return "SBE010 [be_filial=" + be_filial + ", be_local=" + be_local + ", be_localiz=" + be_localiz
				+ ", be_descric=" + be_descric + ", be_capacid=" + be_capacid + ", be_prior=" + be_prior
				+ ", be_alturlc=" + be_alturlc + ", be_larglc=" + be_larglc + ", be_comprlc=" + be_comprlc
				+ ", be_perda=" + be_perda + ", be_codzon=" + be_codzon + ", be_status=" + be_status + ", be_estfis="
				+ be_estfis + ", be_codcfg=" + be_codcfg + ", be_codpro=" + be_codpro + ", be_hora=" + be_hora
				+ ", be_ok=" + be_ok + ", be_xcecao=" + be_xcecao + ", be_datger=" + be_datger + ", be_horger="
				+ be_horger + ", be_dtinv=" + be_dtinv + ", be_idetiq=" + be_idetiq + ", D_E_L_E_T_=" + D_E_L_E_T_
				+ ", R_E_C_N_O_=" + R_E_C_N_O_ + ", R_E_C_D_E_L_=" + R_E_C_D_E_L_ + ", be_valnv1=" + be_valnv1
				+ ", be_valnv2=" + be_valnv2 + ", be_valnv3=" + be_valnv3 + ", be_valnv4=" + be_valnv4 + ", be_valnv5="
				+ be_valnv5 + ", be_valnv6=" + be_valnv6 + ", be_nrunit=" + be_nrunit + "]";
	}

	
}
