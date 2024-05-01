package br.unipar.apivenda.repository;

import br.unipar.apivenda.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listar() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente buscaPorID(Integer id) {
        return em.find(Cliente.class, id);
    }

    public void cadastrar(Cliente cliente) throws Exception {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            throw new Exception("O cliente não pôde ser cadastrado");
        }
    }

    public void editar(Cliente cliente) throws Exception {
        try {
            em.merge(cliente);
        } catch (Exception ex) {
            throw new Exception("O cliente não pôde ser editado");
        }
    }

    public void excluir(Cliente cliente) throws Exception {
        try {
            em.remove(cliente);
        } catch (Exception ex) {
            throw new Exception("O cliente não pôde ser excluído");
        }
    }

}
