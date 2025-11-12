/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;
//importa as classes de outros pacotes que desejo usar aqui
import br.com.ifba.curso.entity.Curso;
import static br.com.ifba.curso.util.JPAUtil.getEntityManager;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


/**
 *
 * @author raiii
 */
//o DAO é feito para armazenar a lógica e fazer essa conexão entre as classes
//é aqui onde eu vou criar os métodos salvar, editar, excluir e etc.
public class CursoDAO extends GenericDao<Curso>
                        implements CursoIDao{
    public Curso findCodigo(String codigo){
        EntityManager em = getEntityManager();
        Curso curso = null;
        try {
            // Cria a consulta JPQL para buscar pelo campo codigoCurso
            Query query = em.createQuery("SELECT c FROM Curso c WHERE c.codigoCurso = :codigo");
            query.setParameter("codigo", codigo);
            curso = (Curso) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return curso;
    }
}
