package org.example;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxFallbackButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

import java.util.Locale;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private final Label result;
	private final TextField text;
	public HomePage(final PageParameters parameters) {
		Form form = new Form("form");
		text = new TextField("text", new Model(""));
		form.add(text);
		form.add(new AjaxFallbackButton("submit_upper_case", form){
			@Override
			protected void onSubmit(AjaxRequestTarget ajaxRequestTarget, Form form) {
				String value = (String) text.getModelObject();
				result.setModelObject(value.toUpperCase(Locale.ROOT));
				if(ajaxRequestTarget !=null)
					ajaxRequestTarget.addComponent(result);
			}
		});
		form.add(new AjaxFallbackButton("submit_lower_case", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget ajaxRequestTarget, Form form) {
				String value = (String) text.getModelObject();
				result.setModelObject(value.toLowerCase(Locale.ROOT));
				if(ajaxRequestTarget!=null)
					ajaxRequestTarget.addComponent(result);
			}
		});

		add(form);
		result = new Label("result", new Model(""));
		result.setOutputMarkupId(true);
		add(result);
	}
}
