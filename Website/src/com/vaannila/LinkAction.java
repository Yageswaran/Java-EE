/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vaannila;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author eswar@vaannila.com
 */
public class LinkAction extends DispatchAction {
    
   
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1,
     * where "method" is the value specified in <action> element : 
     * ( <action parameter="method" .../> )
     */
    public ActionForward friends(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("friends");
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2,
     * where "method" is the value specified in <action> element : 
     * ( <action parameter="method" .../> )
     */
    public ActionForward office(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("office");
    }
}