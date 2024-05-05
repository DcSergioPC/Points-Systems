package pointsystem.ejb;

// import org.hibernate.Criteria;
import org.hibernate.Session;
// import org.hibernate.criterion.MatchMode;
// import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import pointsystem.model.Concepto;

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
public class ConceptoDAO {
    @PersistenceContext(unitName = "point.systemPersistenceUnit")
    private EntityManager entityManager;

    protected Session getSession(){
        return (SessionImpl)entityManager.getDelegate();
    }

    public void agregar(Concepto p) {
        this.entityManager.persist(p);
    }

    public List<Concepto> obtenerConceptos() {
        return this.entityManager.createQuery("select p from concepto p",Concepto.class).getResultList();
    }

    public void eliminar (Integer idConcepto) {
        Concepto p=this.entityManager.find(Concepto.class,idConcepto);
        this.entityManager.remove(p);
    }

    public Concepto modificar (Concepto p) {
        return this.entityManager.merge(p);
    }


    public List<Concepto> obtenerConceptos(String nombre, String apellido) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Concepto> criteriaQuery = criteriaBuilder.createQuery(Concepto.class);
        Root<Concepto> root = criteriaQuery.from(Concepto.class);

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
