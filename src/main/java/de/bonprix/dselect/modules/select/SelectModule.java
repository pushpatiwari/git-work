package de.bonprix.dselect.modules.select;

import javax.annotation.Resource;

import de.bonprix.vaadin.mvp.MvpModuleView;
import de.bonprix.vaadin.navigation.AbstractModule;
import de.bonprix.vaadin.spring.SpringModule;

@SpringModule(captionKey = "selectModule", id = "selectModule", sorting = 30, tags = { "selectModule" }, roles = {})
public class SelectModule extends AbstractModule {

	@Resource
	private SelectPresenter presenter;
	
	@Override
	public MvpModuleView<?> getUIView() {

		return this.presenter.getView();
	}

}
