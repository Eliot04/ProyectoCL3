package Dao;

import java.util.List;

//ClassUsuarioImp.java
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Interfaces.IUsuario;

import java.util.List;
import model.TblUsuariocl3;

public class ClassUsuarioImp implements IUsuario {

 private EntityManagerFactory emf;
 private EntityManager em;

 public ClassUsuarioImp() {
     emf = Persistence.createEntityManagerFactory("ProyectoCL3");
     em = emf.createEntityManager();
 }

 @Override
 public boolean validarUsuario(String usuario, String password) {
     try {
         String jpql = "SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :usuario AND u.passwordcl3 = :password";
         Query query = em.createQuery(jpql);
         query.setParameter("usuario", usuario);
         query.setParameter("password", password);
         List results = query.getResultList();
         return !results.isEmpty();
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         em.close();
     }
     return false;
 }

@Override
public void RegistrarUsuario(TblUsuariocl3 usuario) {
	//cadena de conexion con la unidad de persistencia
	EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoCL3");
	//gestion de entidades
	EntityManager em=fabr.createEntityManager();
	//inicio de transaccion
	em.getTransaction().begin();
	//registramos
	em.persist(usuario);
	//mensaje de consola
	System.out.println("Usuario Registrado en la BD");
	//confirmamos
	em.getTransaction().commit();
	//cerramos
	em.close();
}//fin del registro
}