/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voxus.dashboardtasks.dao;

import com.voxus.dashboardtasks.model.Task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Evandro
 */
@Stateless
public class TaskDAO {

    @PersistenceContext
    private EntityManager em;

    public void alterar(Task task) {
        em.merge(task);
    }

    public void excluir(Task task) {
        Task taskASerExcluida = em.merge(task);
        em.remove(taskASerExcluida);
    }

    public void inserir(Task task) {
        em.persist(task);
    }

    public Task recuperarPorId(Long id) {
        return em.find(Task.class, id);
    }

    public List<Task> recuperarTodos() {
        return em.createQuery("select tas from Task as tas order by tas.titulo").getResultList();
    }
}
