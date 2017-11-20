/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voxus.dashboardtasks.view;

import com.voxus.dashboardtasks.facade.TaskFacade;
import com.voxus.dashboardtasks.model.Task;
import com.voxus.dashboardtasks.view.utility.MensagemUtility;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Evandro
 */
@SessionScoped
@ManagedBean(name = "taskManagedBean")
public class TaskManagedBean {

    private Task task;
    private List<Task> tasks = new ArrayList<>();

    @EJB
    private TaskFacade taskFacade;

    public TaskManagedBean() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskFacade getTaskFacade() {
        return taskFacade;
    }

    public void setTaskFacade(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    

    public List<Task> getTasks() {
        return tasks;
    }

    public String alterar() {
        try {
            taskFacade.alterar(this.getTask());
            this.recuperarTasks();
            return "/task/ListarTasks";
        } catch (Exception e) {
            MensagemUtility.adicionarMensagemDeErro("formTask", e.getMessage());
            return "/task/AlterarTask";
        }
    }

    public String excluir() {
        try {
            taskFacade.excluir(this.getTask());
            this.recuperarTasks();
            return "/task/ListarTasks";
        } catch (Exception e) {
            return "/task/ExcluirTask";
        }
    }

    public String inserir() {
        try {
            taskFacade.inserir(this.getTask());
            this.recuperarTasks();
            return "/task/ListarTasks";
        } catch (Exception e) {
            MensagemUtility.adicionarMensagemDeErro("formTask", e.getMessage());
            return "/task/InserirTask";
        }
    }

    public String listar() {
        this.recuperarTasks();
        return "/task/ListarTasks";
    }

    public String montarPaginaParaAlteracao() {
        return "/task/AlterarTask";
    }

    public String montarPaginaParaExclusao() {
        return "/task/ExcluirTask";
    }

    public String montarPaginaParaInsercao() {
        this.task = new Task();
        return "/task/InserirTask";
    }

    private void recuperarTasks() {
        this.tasks = taskFacade.listar();
    }
    
    public String logout() {
      HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
      sessao.invalidate();
      return "index"; 
    }

}
