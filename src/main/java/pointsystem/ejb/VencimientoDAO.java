package pointsystem.ejb;

// import org.hibernate.Criteria;
import org.hibernate.Session;
// import org.hibernate.criterion.MatchMode;
// import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import pointsystem.model.Vencimiento;

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
public class VencimientoDAO {
    @PersistenceContext(unitName = "point.systemPersistenceUnit")
    private EntityManager entityManager;

    protected Session getSession(){
        return (SessionImpl)entityManager.getDelegate();
    }

    public void agregar(Vencimiento p) {
        this.entityManager.persist(p);
    }

    public List<Vencimiento> obtenerVencimientos() {
        return this.entityManager.createQuery("select p from vencimiento p",Vencimiento.class).getResultList();
    }

    public void eliminar (Integer idVencimiento) {
        Vencimiento p=this.entityManager.find(Vencimiento.class,idVencimiento);
        this.entityManager.remove(p);
    }

    public Vencimiento modificar (Vencimiento p) {
        return this.entityManager.merge(p);
    }


    public List<Vencimiento> obtenerVencimientos(String nombre, String apellido) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vencimiento> criteriaQuery = criteriaBuilder.createQuery(Vencimiento.class);
        Root<Vencimiento> root = criteriaQuery.from(Vencimiento.class);

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
