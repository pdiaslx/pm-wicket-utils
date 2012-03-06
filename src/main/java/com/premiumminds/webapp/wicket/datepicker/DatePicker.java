package com.premiumminds.webapp.wicket.datepicker;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class DatePicker extends Behavior {
	private static final long serialVersionUID = -2779776745316284795L;
	
	private static final ResourceReference DATE_PICKER_JS = new JavaScriptResourceReference(DatePicker.class, "Picker.js");
	private static final ResourceReference DATE_PICKER_ATTACH_JS = new JavaScriptResourceReference(DatePicker.class, "Picker.Attach.js");
	private static final ResourceReference DATE_PICKER_DATE_JS = new JavaScriptResourceReference(DatePicker.class, "Picker.Date.js");
	
	private static final ResourceReference DATE_PICKER_DATE_CSS = new CssResourceReference(DatePicker.class, "datepicker.css");

	private Component container;
	
	public DatePicker(Component container){
		this.container = container;
	}
	
	@Override
	public void bind(Component component) {
		component.setOutputMarkupId(true);
		getDatePattern();
	}
	
	protected String getDatePattern()
	{
//		String format = null;
//		if (dateField instanceof ITextFormatProvider)
//		{
//			format = ((ITextFormatProvider)dateField).getTextFormat();
//			// it is possible that components implement ITextFormatProvider but
//			// don't provide a format
//		} else {
//			throw new WicketRuntimeException("cant get date pattern of parent component");
//		}
		return "%d-%m-%Y";
	}
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		response.renderCSSReference(DATE_PICKER_DATE_CSS, "screen");
		response.renderJavaScriptReference(DATE_PICKER_JS);
		response.renderJavaScriptReference(DATE_PICKER_ATTACH_JS);
		response.renderJavaScriptReference(DATE_PICKER_DATE_JS);
		
		if(component.isEnabledInHierarchy()){
			
			StringBuilder sb = new StringBuilder();
			sb.append("Date.defineParser(\"").append(getDatePattern()).append("\");");
			response.renderJavaScript(sb.toString(), "pickerDatePattern");
			
			sb = new StringBuilder();
			
			sb.append("new Picker.Date($(\"").append(component.getMarkupId()).append("\"), {");
			
			sb.append("format : \"").append(getDatePattern()).append("\",");
			sb.append("inject : $(\"").append(container.getMarkupId()).append("\"),");
	
			sb.append("months_abr : [");
			sb.append("\"Jan\",");
			sb.append("\"Fev\",");
			sb.append("\"Mar\",");
			sb.append("\"Abr\",");
			sb.append("\"Mai\",");
			sb.append("\"Jun\",");
			sb.append("\"Jul\",");
			sb.append("\"Ago\",");
			sb.append("\"Set\",");
			sb.append("\"Out\",");
			sb.append("\"Nov\",");
			sb.append("\"Dez\",");
			sb.append("],");
	
			sb.append("days_abr : [");
			sb.append("\"Seg\",");
			sb.append("\"Ter\",");
			sb.append("\"Qua\",");
			sb.append("\"Qui\",");
			sb.append("\"Sex\",");
			sb.append("\"Sab\",");
			sb.append("\"Dom\",");
			sb.append("],");
			
			sb.append("})");
			
			response.renderOnLoadJavaScript(sb.toString());
		}
	}

	
}
