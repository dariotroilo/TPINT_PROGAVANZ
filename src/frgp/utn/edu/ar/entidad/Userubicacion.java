package frgp.utn.edu.ar.entidad;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Userubicacion")
public class Userubicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "filial")
	private String filial;

	@Column(name = "local")
	private String local;

	@Column(name = "localizacion")
	private String localizacion;

	public Userubicacion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@Override
	public String toString() {
		return "Userubicacion [id=" + id + ", usuario=" + usuario + ", filial=" + filial + ", local=" + local
				+ ", localizacion=" + localizacion + "]";
	}




}
