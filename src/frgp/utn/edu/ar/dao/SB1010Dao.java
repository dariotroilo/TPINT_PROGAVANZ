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
	@Transactional()
	public SB1010 readWithCod(String cod) {
	    Session session = config.abrirConexion();
	    session.beginTransaction();
	    /*SB1010 producto = new SB1010();*/

	    try
	    {
	        //String hql = "SELECT R_E_C_N_O_,BE_FILIAL,LEFT(BE_LOCALIZ,5) as BE_LOCAL, BE_LOCALIZ, BE_DESCRIC, BE_PRIOR FROM SBE010 a WHERE a.D_E_L_E_T_= '' and a.BE_FILIAL='" + filial; // +"' group by LEFT(BE_FILIAL,5) desc";
	    	String hql = "FROM SB1010 a WHERE a.b1_cod='" + cod + "' AND a.d_e_l_e_t_= ''";
			Query query = session.createQuery(hql);
			SB1010 producto = (SB1010) query.uniqueResult();
			session.getTransaction().commit();
			return producto;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			config.cerrarSession();
		}	
	}

	@Override
	@Transactional()
	public List<SB1010> readAll() {
	    Session session = config.abrirConexion();
	    session.beginTransaction();
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

	        session.getTransaction().commit();
	    }
	    catch (Exception e)
	    {
	        session.getTransaction().rollback();
	        e.printStackTrace();
	    }

	    config.cerrarSession();
	    
	    return codigos;
	}


	
	
	
}
