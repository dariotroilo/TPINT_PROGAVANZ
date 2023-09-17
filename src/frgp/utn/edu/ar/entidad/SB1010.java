package frgp.utn.edu.ar.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SB1010")
public class SB1010 {

	@Column(name = "B1_COD")
	private String b1_cod;

	@Column(name = "B1_DESC")
	private String b1_desc;

	@Column(name = "D_E_L_E_T_")
	private String d_e_l_e_t_;

	@Id
	@Column(name = "R_E_C_N_O_")
	private Integer r_e_c_n_o_;


	public SB1010() {

	}


	public String getB1_cod() {
		return b1_cod;
	}

	public void setB1_cod(String b1_cod) {
		this.b1_cod = b1_cod;
	}

	public String getB1_desc() {
		return b1_desc;
	}

	public void setB1_desc(String b1_desc) {
		this.b1_desc = b1_desc;
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
		return "SB1010 [b1_cod=" + b1_cod + ", b1_desc=" + b1_desc + ", d_e_l_e_t_=" + d_e_l_e_t_ + ", r_e_c_n_o_="
				+ r_e_c_n_o_ + "]";
	}

	
}