package frgp.utn.edu.ar.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.entidad.SB1010;
import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.daoInt.SB1010DaoInt;

@Repository("SB1010Dao")
public class SB1010Dao implements SB1010DaoInt {

	private ConfigHibernate config;

	
	public SB1010Dao()
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
	@Transactional
	public SB1010 readWithCod(String cod) {
		Session session = config.abrirConexion();
		
	    try {
	        String hql = "FROM SB1010 a WHERE a.b1_cod = :cod AND a.d_e_l_e_t_ = ''";
	        Query query = session.createQuery(hql);
	        query.setParameter("cod", cod);
	        SB1010 producto = (SB1010) query.uniqueResult();
	        
	        if (producto == null) {
	            producto = new SB1010();
	            producto.setB1_desc("");
	            producto.setB1_cod("0000000");
	            producto.setD_e_l_e_t_("");
	            producto.setR_e_c_n_o_(0);
	        }

	        return producto;
	    } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud SB1010DAO readWithCod", e);
		} finally {
			session.close();
		}
	}


	@Override
	@Transactional()
	public List<SB1010> readAll() {
	    Session session = config.abrirConexion();
	    List<SB1010> codigos = new ArrayList<>();

	    try
	    {
	        String hql = "FROM SB1010 a WHERE a.D_E_L_E_T_= '' order by a.b1_cod";
	        Query query = session.createQuery(hql);
	        Object[] result = query.list().toArray();
	        
	        for (Object obj : result) {
	            if (obj instanceof SB1010) {
	            	codigos.add((SB1010) obj);
	            }
	        }
		    return codigos;

	    }
	    catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error procesando la solicitud SB1010DAO readAll", e);
		} finally {
			session.close();
		}	    

	}


	
	
	
}
