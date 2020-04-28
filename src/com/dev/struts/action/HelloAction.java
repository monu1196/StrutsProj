package com.dev.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.dev.struts.form.HelloForm;

public class HelloAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HelloForm helloForm = (HelloForm) form;
		ActionForward forward = mapping.getInputForward();
		
		if(helloForm!=null && helloForm.getName().equalsIgnoreCase("Monu"))
		{
			forward = mapping.findForward("success");
		}else
		{
			ActionErrors errors = new ActionErrors();
			errors.add("",new ActionMessage("key.error"));
			saveErrors(request,errors);
		}
		return forward;
	}
}
