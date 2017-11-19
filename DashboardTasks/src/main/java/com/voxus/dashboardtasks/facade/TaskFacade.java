/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voxus.dashboardtasks.facade;

import com.voxus.dashboardtasks.dao.TaskDAO;
import com.voxus.dashboardtasks.model.Task;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Evandro
 */
@Stateless
public class TaskFacade {

    @EJB
    private TaskDAO taskDAO;

    public void alterar(Task task) {
        taskDAO.alterar(task);
    }

    public void excluir(Task task) {
        taskDAO.excluir(task);
    }

    public void inserir(Task task) {
        taskDAO.inserir(task);
    }

    public List<Task> listar() {
        return taskDAO.recuperarTodos();
    }
}
