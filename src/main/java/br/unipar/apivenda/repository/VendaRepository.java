package br.unipar.apivenda.repository;

import br.unipar.apivenda.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class VendaRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Venda> listar() {
        String jpql = "SELECT v FROM Venda v";
        return em.createQuery(jpql, Venda.class).getResultList();
    }

    public Venda buscaPorID(Integer id) {
        return em.find(Venda.class, id);
    }

    public void cadastrar(Venda venda) throws Exception {
        try {
            em.persist(venda);
        } catch (Exception ex) {
            throw new Exception("A venda não pôde ser cadastrada");
        }
    }

    public void editar(Venda venda) throws Exception {
        try {
            em.merge(venda);
        } catch (Exception ex) {
            throw new Exception("A venda não pôde ser editada");
        }
    }

    public void excluir(Venda venda) throws Exception {
        try {
            em.remove(venda);
        } catch (Exception ex) {
            throw new Exception("A venda não pôde ser excluída");
        }
    }

    public BigDecimal obterValorTotalVendaPorCliente(Integer idCliente) {
        String jpql = "SELECT SUM(v.total) FROM Venda v WHERE " +
                "v.cliente.id = :idCliente";
        return em.createQuery(jpql, BigDecimal.class).setParameter("idCliente", idCliente)
                .getSingleResult();
    }

    public int obterQuantidadeVendaPorCliente(Integer idCliente) {
        String jpql = "SELECT CONT(v) FROM Venda v WHERE " +
                "v.cliente.id = :idCliente";
        return em.createQuery(jpql, Long.class).setParameter("idCliente", idCliente)
                .getSingleResult().intValue();
    }

}
