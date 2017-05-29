package de.bonprix.dselect.modules.select;

import java.util.List;

import com.vaadin.ui.Component;

import de.bonprix.dselect.model.SeField;
import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.mvp.MvpModuleViewObserver;
import de.bonprix.vaadin.spring.SpringView;

public interface SelectView  extends MvpModuleView<SelectView.Observer>{

	public interface Observer extends MvpModuleViewObserver{

		
	}

 public void setSeField(List<SeField>list);


}
