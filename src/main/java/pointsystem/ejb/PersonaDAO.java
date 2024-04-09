package pointsystem.ejb;

// import org.hibernate.Criteria;
import org.hibernate.Session;
// import org.hibernate.criterion.MatchMode;
// import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import pointsystem.model.Persona;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonaDAO {
    @PersistenceContext(unitName = "point.systemPersistenceUnit")
    private EntityManager entityManager;

    protected Session getSession(){
        return (SessionImpl)entityManager.getDelegate();
    }

    public void agregar(Persona p) {
        this.entityManager.persist(p);
    }

    public List<Persona> obtenerPersonas() {
        return this.entityManager.createQuery("select p from Persona p",Persona.class).getResultList();
    }

    public void eliminar (Integer idPersona) {
        Persona p=this.entityManager.find(Persona.class,idPersona);
        this.entityManager.remove(p);
    }

    public Persona modificar (Persona p) {
        return this.entityManager.merge(p);
    }


    public List<Persona> obtenerPersonas(String nombre, String apellido) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root = criteriaQuery.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        if (nombre != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
        }
        if (apellido != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("apellido")), "%" + apellido.toLowerCase() + "%"));
        }

        criteriaQuery.select(root).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
