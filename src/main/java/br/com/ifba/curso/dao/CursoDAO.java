/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;
//importa as classes de outros pacotes que desejo usar aqui
import br.com.ifba.curso.util.JPAUtil;
import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author raiii
 */
//fiz o dao na atividade 12 pq o senhor permitiu, foi uma solução temporária
//o DAO é feito para armazenar a lógica e fazer essa conexão entre as classes
//é aqui onde eu vou criar os métodos salvar, editar, excluir e etc.
public class CursoDAO {
    public void salvarCurso(Curso curso){
        EntityManager em = JPAUtil.getEntityManager(); //cria a conexão com o banco de dados
        try{
            em.getTransaction().begin();
            em.persist(curso);//salva
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
            em.close();
        }
    }
    
    public void removerCurso(Curso curso){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        Curso c = em.find(Curso.class, curso.getId());//busca o curso e c vai apontar para o curso encontrado
        if(c != null){
            em.remove(c);//remove do banco
        }
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizarCurso(Curso curso){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(curso);//atualiza os dados
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        } finally{//bloco executado sempre
            em.close();
        }    
    }
    
    public List<Curso> buscarTodos(){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Curso> query = em.createQuery("SELECT c FROM Curso c WHERE c.ativo = true", Curso.class);//cria consulta JPQL (seleciona todos os objetos do tipo Curso que estão no banco
        List<Curso> cursos = query.getResultList();//armazena todos os obejtos em curso, criando uma lista
        em.close();
        return cursos;//retorna a lista
    }
    
    public Curso buscarCodigo(String nome, String codigo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT c FROM Curso c WHERE c.codigoCurso = :codigo", Curso.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null se não encontrar
        } finally {
            em.close(); // Fecha a sessão corretamente
        }
    }
}
