package pointsystem.ejb;

// import org.hibernate.Criteria;
import org.hibernate.Session;
// import org.hibernate.criterion.MatchMode;
// import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import pointsystem.model.UsoPuntos;

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
public class UsoPuntosDAO {
    @PersistenceContext(unitName = "point.systemPersistenceUnit")
    private EntityManager entityManager;

    protected Session getSession(){
        return (SessionImpl)entityManager.getDelegate();
    }

    public void agregar(UsoPuntos p) {
        this.entityManager.persist(p);
    }

    public List<UsoPuntos> obtenerUsoPuntoss() {
        return this.entityManager.createQuery("select p from UsoPuntos p",UsoPuntos.class).getResultList();
    }

    public void eliminar (Integer idUsoPuntos) {
        UsoPuntos p=this.entityManager.find(UsoPuntos.class,idUsoPuntos);
        this.entityManager.remove(p);
    }

    public UsoPuntos modificar (UsoPuntos p) {
        return this.entityManager.merge(p);
    }


    public List<UsoPuntos> obtenerUsoPuntoss(String nombre, String apellido) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsoPuntos> criteriaQuery = criteriaBuilder.createQuery(UsoPuntos.class);
        Root<UsoPuntos> root = criteriaQuery.from(UsoPuntos.class);

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
