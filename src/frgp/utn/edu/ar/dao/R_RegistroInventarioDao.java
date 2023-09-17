package frgp.utn.edu.ar.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.entidad.R_RegistroInventario;
import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.daoInt.R_RegistroInventarioDaoInt;

@Repository("R_RegistroInventarioDao")
public class R_RegistroInventarioDao implements R_RegistroInventarioDaoInt {

	private ConfigHibernate config;
	
	public R_RegistroInventarioDao()
	{
		this.config = new ConfigHibernate();
	}
	
	public ConfigHibernate getConfig() {
		return config;
	}

	public void setConfig(ConfigHibernate config) {
		this.config = config;
	}

	
	
	@Override
	@Transactional()
	public List<R_RegistroInventario> readAll() {
	    Session session = config.abrirConexion();
	    session.beginTransaction();
	    List<R_RegistroInventario> registroinventario = new ArrayList<>();

	    try
	    {
	        String hql = "FROM R_RegistroInventario a WHERE a.delet <> '*' ORDER BY id DESC";
	        Query query = session.createQuery(hql);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof R_RegistroInventario) {
	            	registroinventario.add((R_RegistroInventario) obj);
	            }
	        }

	        session.getTransaction().commit();
	    }
	    catch (Exception e)
	    {
	        session.getTransaction().rollback();
	        e.printStackTrace();
	    }

	    config.cerrarSession();
	    
	    return registroinventario;
	}
	
	
	@Override
	@Transactional()
	public List<R_RegistroInventario> readAllUser(String user) {
	    Session session = config.abrirConexion();
	    session.beginTransaction();
	    List<R_RegistroInventario> registroinventario = new ArrayList<>();
	    try
	    {
	        String hql = "FROM R_RegistroInventario a WHERE a.usuario='" + user + "' and a.delet <> '*' ORDER BY id DESC";
	        Query query = session.createQuery(hql);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof R_RegistroInventario) {
	            	registroinventario.add((R_RegistroInventario) obj);
	            }
	        }

	        session.getTransaction().commit();
	    }
	    catch (Exception e)
	    {
	        session.getTransaction().rollback();
	        e.printStackTrace();
	    }
	    finally
	    {
			config.cerrarSession();
	    }

	    return registroinventario;
	}


	@Override
	@Transactional()
	public List<R_RegistroInventario> readAllWithFilter(String filtro) {
	    Session session = config.abrirConexion();
	    session.beginTransaction();
	    List<R_RegistroInventario> registroinventario = new ArrayList<>();

	    try
	    {
	        String hql = "FROM R_RegistroInventario a WHERE a.nombre like '%" + filtro + "%' or a.descripcion like '%" + filtro + "%'";
	        Query query = session.createQuery(hql);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof R_RegistroInventario) {
	            	registroinventario.add((R_RegistroInventario) obj);
	            }
	        }

	        session.getTransaction().commit();
	    }
	    catch (Exception e)
	    {
	        session.getTransaction().rollback();
	        e.printStackTrace();
	    }
	    finally
	    {
			config.cerrarSession();
	    }

	    return registroinventario;
	}

	@Transactional()
	public boolean agregarR_RegistroInventarioDao(R_RegistroInventario r_registroinventario) {
		
		Session session = config.abrirConexion();

		//session.beginTransaction();
		//session.save(r_registroinventario);
		//session.getTransaction().commit();
		
		    String sql = "INSERT INTO R_RegistroInventario (codigo, descripcion, cantidad, filial, ubicacion, usuario, fecha, delet) " +
	                "VALUES (:codigo, :descripcion, :cantidad, :filial, :ubicacion, :usuario, :fecha, :delet)";
	
		   SQLQuery query = session.createSQLQuery(sql);
		   
		   // Asigna los valores de los campos de r_registroinventario a los parámetros de la consulta
		   query.setParameter("codigo", r_registroinventario.getCodigo());
		   query.setParameter("descripcion", r_registroinventario.getDescripcion());
		   query.setParameter("cantidad", r_registroinventario.getCantidad());
		   query.setParameter("filial", r_registroinventario.getFilial());
		   query.setParameter("ubicacion", r_registroinventario.getUbicacion());
		   query.setParameter("usuario", r_registroinventario.getUsuario());
		   query.setParameter("fecha", r_registroinventario.getFecha());
		   query.setParameter("delet", "");
		
		   // Ejecuta la consulta SQL
		    query.executeUpdate();
		
		
			config.cerrarSession();
		
		return true;
	}
	
	@Transactional()
	public R_RegistroInventario Get(Integer idR_RegistroInventario)
	{
		Session session = config.abrirConexion();
		
		try {
		    session.beginTransaction();
		    String hql = "FROM R_RegistroInventario a WHERE a.id = :idArticulo and delet=''";
		    Query query = session.createQuery(hql);
		    query.setParameter("idArticulo", idR_RegistroInventario);
		    R_RegistroInventario r_registroinventario = (R_RegistroInventario) query.uniqueResult();
		    session.getTransaction().commit();
		    return r_registroinventario;
		}
		catch (Exception e)
		{
		    session.getTransaction().rollback();
		    e.printStackTrace();
		    return null;
		}
		finally
		{
			config.cerrarSession();
		}
	}
	
	@Override
	@Transactional()
	public void Update(R_RegistroInventario articulo)
	{
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(articulo);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}


	@Override
	public boolean Delete(Integer id) {
	    Session session = config.abrirConexion();
	    session.beginTransaction();
	    R_RegistroInventario articulo = (R_RegistroInventario) session.get(R_RegistroInventario.class , id);
	    
	    if (articulo != null) {
	        articulo.setDelet("*");
	        session.update(articulo);
	    }
	    
	    session.getTransaction().commit();
	    config.cerrarSession();
	    
	    return true;
	}

	@Override
	public boolean agregarR_RegistroInventario(R_RegistroInventario a) {
		// TODO Auto-generated method stub
		return false;
	}


}
