package org.example;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO implements DAO<Cliente>{
    @Override
    public Cliente insertarCliente(Cliente cliente) {
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return cliente;
    }
@Override
    public Cliente getCliente(Long id) {
        EntityManager entityManager = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        Cliente cliente;
        try {
            cliente = entityManager.find(Cliente.class, id);
        } finally {
            entityManager.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> listarMejoresClientes(Long cantidad) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Cliente> query = em.createQuery(
                "SELECT cliente FROM Cliente cliente WHERE cliente.estado = :estado AND cliente.totalVentas > :cantidad", Cliente.class);
        query.setParameter("estado", "Activo");
        query.setParameter("cantidad", cantidad);
        return query.getResultList();
    }

    @Override
    public String estadisticas() {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Long> consultaTotalVentas = em.createQuery("SELECT SUM(c.totalVentas) FROM Cliente c", Long.class);
        TypedQuery<Double> consutaPromedioVentas = em.createQuery("SELECT AVG(c.totalVentas) FROM Cliente c WHERE c.estado = 'Activo'", Double.class);
        TypedQuery<Long> cantidadInactivos = em.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'Inactivo' AND c.totalVentas > 0", Long.class);

        Long totalVentas = consultaTotalVentas.getSingleResult();
        Double promedioVentas = consutaPromedioVentas.getSingleResult();
        Long inactivos = cantidadInactivos.getSingleResult();

        return ("Total de ventas entre todos los clientes: " + totalVentas + "\n" + "Promedio de ventas de los clientes activos:" + promedioVentas + "\n" + "Cantidad de clientes inactivos que tienen total de ventas mayor a 0: " + inactivos);
    }
}
