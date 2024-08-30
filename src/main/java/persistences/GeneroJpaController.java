package persistences;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import models.Genero;

public class GeneroJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public GeneroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("grupo6_Spotify");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Genero genero) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(genero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Genero genero) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            genero = em.merge(genero);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String nombre = genero.getNombre();
            if (findGenero(nombre) == null) {
                throw new EntityNotFoundException("El género con nombre " + nombre + " no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String nombre) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Genero genero;
            try {
                genero = em.getReference(Genero.class, nombre);
                genero.getNombre(); // Verificar si la entidad existe
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("El género con nombre " + nombre + " no existe.");
            }
            em.remove(genero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Genero> findGeneroEntities() {
        return findGeneroEntities(true, -1, -1);
    }

    public List<Genero> findGeneroEntities(int maxResults, int firstResult) {
        return findGeneroEntities(false, maxResults, firstResult);
    }

    private List<Genero> findGeneroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            var query = em.createQuery("SELECT g FROM Genero g", Genero.class);
            if (!all) {
                query.setMaxResults(maxResults);
                query.setFirstResult(firstResult);
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Genero findGenero(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Genero.class, nombre);
        } finally {
            em.close();
        }
    }

    public int getGeneroCount() {
        EntityManager em = getEntityManager();
        try {
            var query = em.createQuery("SELECT COUNT(g) FROM Genero g", Long.class);
            return ((Long) query.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}