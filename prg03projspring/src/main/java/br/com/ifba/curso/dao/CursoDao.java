package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDao extends GenericDao<Curso> implements CursoIDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Curso findByCodigo(String codigo) {

        try {
            Query query = em.createQuery(
                "SELECT c FROM Curso c WHERE c.codigoCurso = :codigo"
            );

            query.setParameter("codigo", codigo);

            return (Curso) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("Nenhum curso encontrado para o código: " + codigo);
            return null;
        }
    }
}
