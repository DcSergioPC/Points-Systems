package pointsystem.ejb;

// import org.hibernate.Criteria;
import org.hibernate.Session;
// import org.hibernate.criterion.MatchMode;
// import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import pointsystem.model.UsoPuntosDetalle;

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
public class UsoPuntosDetalleDAO {
    @PersistenceContext(unitName = "point.systemPersistenceUnit")
    private EntityManager entityManager;

    protected Session getSession(){
        return (SessionImpl)entityManager.getDelegate();
    }

    public void agregar(UsoPuntosDetalle p) {
        this.entityManager.persist(p);
    }

    public List<UsoPuntosDetalle> obtenerUsoPuntosDetalles() {
        return this.entityManager.createQuery("select p from UsoPuntosDetalle p",UsoPuntosDetalle.class).getResultList();
    }

    public void eliminar (Integer idUsoPuntosDetalle) {
        UsoPuntosDetalle p=this.entityManager.find(UsoPuntosDetalle.class,idUsoPuntosDetalle);
        this.entityManager.remove(p);
    }

    public UsoPuntosDetalle modificar (UsoPuntosDetalle p) {
        return this.entityManager.merge(p);
    }


    public List<UsoPuntosDetalle> obtenerUsoPuntosDetalles(String nombre, String apellido) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsoPuntosDetalle> criteriaQuery = criteriaBuilder.createQuery(UsoPuntosDetalle.class);
        Root<UsoPuntosDetalle> root = criteriaQuery.from(UsoPuntosDetalle.class);

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
