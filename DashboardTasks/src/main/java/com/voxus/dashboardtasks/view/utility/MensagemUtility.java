/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voxus.dashboardtasks.view.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Evandro
 */
public class MensagemUtility {

    public static void adicionarMensagemDeErro(String idDoComponente, String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(idDoComponente, facesMessage);
    }

}
