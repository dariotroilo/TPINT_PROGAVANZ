package frgp.utn.edu.ar.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.entidad.Userubicacion;
import frgp.utn.edu.ar.dao.ConfigHibernate;
import frgp.utn.edu.ar.daoInt.UserubicacionDaoInt;

@Repository("UserubicacionDao")
public class UserubicacionDao implements UserubicacionDaoInt {

	private ConfigHibernate config;

	public UserubicacionDao() 
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
	public List<Userubicacion> readAll() {
		Session session = config.abrirConexion();
		session.beginTransaction();
		List<Userubicacion> userubicaciones = new ArrayList<>();

		try {
			String hql = "FROM Userubicacion";
			Query query = session.createQuery(hql);
			Object[] result = query.list().toArray();

			for (Object obj : result) {
				if (obj instanceof Userubicacion) {
					userubicaciones.add((Userubicacion) obj);
				}
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			config.cerrarSession();
			return null;
		}

		config.cerrarSession();

		return userubicaciones;
	}

	@Override
	@Transactional()
	public Userubicacion Get(Long Id) {
		Session session = config.abrirConexion();

		try {
			session.beginTransaction();
			String hql = "FROM Userubicacion a WHERE a.id = :Id";
			Query query = session.createQuery(hql);
			query.setParameter("id", Id);
			Userubicacion userubicacion = (Userubicacion) query.uniqueResult();
			session.getTransaction().commit();
			return userubicacion;
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
	public Userubicacion Getuser(String usuario) {
		Session session = config.abrirConexion();

		try {
			session.beginTransaction();
			String hql = "FROM Userubicacion a WHERE a.usuario = :usuario";
			Query query = session.createQuery(hql);
			query.setParameter("usuario", usuario);
			Userubicacion userubicacion = (Userubicacion) query.uniqueResult();
			session.getTransaction().commit();
			return userubicacion;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			config.cerrarSession();
		}
	}

	@Override
	public void Update(Userubicacion userubicacion) {
		Session session = config.abrirConexion();

		session.beginTransaction();
		session.update(userubicacion);
		session.getTransaction().commit();

		config.cerrarSession();

	}

}
