package de.bonprix.dselect.modules.select;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import de.bonprix.dselect.dao.SeFieldDao;
import de.bonprix.dselect.model.SeField;
import de.bonprix.vaadin.UiEnvironment;
import de.bonprix.vaadin.mvp.AbstractMvpPresenter;
import de.bonprix.vaadin.spring.SpringPresenter;

@SpringPresenter
public class SelectPresenter extends AbstractMvpPresenter<SelectView> implements SelectView.Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private SelectView view;

	@Resource
	private UiEnvironment uiEnvironment;

	// @Resource
	// private EventBus eventBus;

	@Resource
	private SeFieldDao fieldDao;

	private SeField seField;

	private List<SeField> fetchField;

	@PostConstruct
	public void postConstruct() {
		this.getView()
			.setObserver(this);

	}

	@Override
	public SelectView getView() {
		return this.view;
	}

	@Override
	protected void onViewInitialized() {
		List<SeField> seFields = this.fieldDao.fetchField();
		getView().setSeField(seFields);

		// seFields.add(new SeFieldBuilder().withAddress("aff").build());

	}

}
