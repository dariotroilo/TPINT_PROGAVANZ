package frgp.utn.edu.ar.entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="R_RegistroInventario")
public class R_RegistroInventario{

    @Id
    @Column(name="id")
    private Integer id;

	@Column(name="codigo")
	private String codigo;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="filial")
	private String filial;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="fecha")
	private String fecha;

	@Column(name="delet")
	private String delet;
	
	//Constructor vacio
	public R_RegistroInventario()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDelet() {
		return delet;
	}

	public void setDelet(String delet) {
		this.delet = delet;
	}

	@Override
	public String toString() {
		return "R_RegistroInventario [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad="
				+ cantidad + ", filial=" + filial + ", ubicacion=" + ubicacion + ", usuario=" + usuario + ", fecha="
				+ fecha + ", delet=" + delet + "]";
	}

	
	
}
