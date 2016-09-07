/**
 * Copyright (C) 2016 Premium Minds.
 *
 * This file is part of pm-wicket-utils.
 *
 * pm-wicket-utils is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * pm-wicket-utils is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with pm-wicket-utils. If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.webapp.wicket.bootstrap;
import java.io.Serializable;
import java.util.Date;

public final class SpecialDate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date dt;
	private String cssClass, tooltip;

	public SpecialDate(Date dt, String cssClass, String tooltip) {
		this.dt = dt;
		this.cssClass = cssClass;
		this.tooltip = tooltip;
	}
	public Date getDt() {
		return dt;
	}
	public String getCssClass() {
		return cssClass;
	}
	public String getTooltip() {
		return tooltip;
	}
}