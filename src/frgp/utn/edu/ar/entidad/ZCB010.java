package frgp.utn.edu.ar.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ZCB010")
public class ZCB010 {
	

	@Column(name="ZCB_CODBAR")
	private String zcb_codbar;
	
	@Column(name="ZCB_COD")	
	private	String zcb_cod;
	
	@Column(name="ZCB_QUANT")	
	private Float zcb_quant;
	

	@Column(name="D_E_L_E_T_")	
	private String d_e_l_e_t_;
	
	@Id
	@Column(name="R_E_C_N_O_")	
	private Integer r_e_c_n_o_;
	
	public ZCB010()
	{
		
	}

	public String getZcb_codbar() {
		return zcb_codbar;
	}

	public void setZcb_codbar(String zcb_codbar) {
		this.zcb_codbar = zcb_codbar;
	}

	public String getZcb_cod() {
		return zcb_cod;
	}

	public void setZcb_cod(String zcb_cod) {
		this.zcb_cod = zcb_cod;
	}

	public Float getZcb_quant() {
		return zcb_quant;
	}

	public void setZcb_quant(Float zcb_quant) {
		this.zcb_quant = zcb_quant;
	}

	public String getD_e_l_e_t_() {
		return d_e_l_e_t_;
	}

	public void setD_e_l_e_t_(String d_e_l_e_t_) {
		this.d_e_l_e_t_ = d_e_l_e_t_;
	}

	public Integer getR_e_c_n_o_() {
		return r_e_c_n_o_;
	}

	public void setR_e_c_n_o_(Integer r_e_c_n_o_) {
		this.r_e_c_n_o_ = r_e_c_n_o_;
	}

	@Override
	public String toString() {
		return "ZCB010 [zcb_codbar=" + zcb_codbar + ", zcb_cod=" + zcb_cod + ", zcb_quant=" + zcb_quant
				+ ", d_e_l_e_t_=" + d_e_l_e_t_ + ", r_e_c_n_o_=" + r_e_c_n_o_ + "]";
	}


}
