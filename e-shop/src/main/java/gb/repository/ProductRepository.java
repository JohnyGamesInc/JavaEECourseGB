package gb.repository;


import gb.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    EntityManager em;

    @Inject
    private UserTransaction userTransaction;

//    @PostConstruct
//    @Transactional
//    public void init() {
//        if (this.findAll().isEmpty()) {
//            this.insert(new Product(null, "Cola", 50, 20, "Sweet cola", true));
//            this.insert(new Product(null, "Milk", 75.5, 10, "Fresh milk from black cow", true));
//            this.insert(new Product(null, "Pistol", 500, 5, "Good friend in difficult cases", true));
//        }
//    }

    @Transactional
    public void insert(Product product) {
        em.persist(product);
    }

    @Transactional
    public List<Product> findAll() {
        Query findAllQuery = em.createQuery("from products", Product.class);
        return (List<Product>) findAllQuery.getResultList();
    }

    @Transactional
    public void update(Product product) {
        em.merge(product);
    }

    @Transactional
    public void delete(Product product) {
        em.remove(em.contains(product) ? product : em.merge(product));
    }

    @Transactional
    public Product findById(long id) {
        return em.find(Product.class, id);
    }
}
