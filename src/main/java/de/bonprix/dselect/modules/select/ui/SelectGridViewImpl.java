package de.bonprix.dselect.modules.select.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.vaadin.teemusa.gridextensions.client.tableselection.TableSelectionState;
import org.vaadin.teemusa.gridextensions.client.tableselection.TableSelectionState.TableSelectionMode;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

import de.bonprix.dselect.model.Country;
import de.bonprix.dselect.model.SeField;
import de.bonprix.dselect.modules.select.SelectView;
import de.bonprix.vaadin.builder.FluentUI;
import de.bonprix.vaadin.mvp.AbstractMvpModuleView;
import de.bonprix.vaadin.spring.SpringView;
import de.bonprix.vaadin.theme.BonprixTheme;
import de.bonprix.vaadin.ui.RatingBar;
import de.bonprix.vaadin.ui.form.BeanItemComboBox;
import de.bonprix.vaadin.ui.grid.BeanItemGrid;

@SpringView
public class SelectGridViewImpl extends AbstractMvpModuleView<SelectView.Observer, Component> implements SelectView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BeanItemGrid<SeField> grid;

	private RatingBar ratingBar;

	private BeanItemComboBox<Country> comboBox;

	@Override
	protected void initializeUI() {

		this.setCompositionRoot(genGrid());
		this.setCompositionRoot(genComboBox());
		setSizeFull();
	}

	private Component genComboBox() {

		BeanItemComboBox<Country> comboBox = new BeanItemComboBox<>(Country.class, "country");
		this.comboBox.setItemCaptionPropertyId("Country");
		this.comboBox.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				Map<Integer, String> map = new HashMap<Integer, String>();
				Set<Entry<Integer, String>> set = map.entrySet();
				map.put(1, "India");
				map.put(2, "Peris");
				map.put(3, "London");
				set.iterator()
					.next();

			}
		});

		this.comboBox.replaceAllBeans(createItem());
		return FluentUI.vertical()
			.add(comboBox)
			.get();
	}

	private Collection<Country> createItem() {
		return null;
	}

	private Component genGrid() {

		Button highlightdEdtClmBtn = new Button("toggle highlighted editable columns");

		highlightdEdtClmBtn.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				if (BonprixTheme.GRID_HIGHLIGHT_EDITABLE_COLUMNS.equals(SelectGridViewImpl.this.grid.getStyleName())) {
					SelectGridViewImpl.this.grid.removeStyleName(BonprixTheme.GRID_HIGHLIGHT_EDITABLE_COLUMNS);

				} else {
					SelectGridViewImpl.this.grid.addStyleName(BonprixTheme.GRID_HIGHLIGHT_EDITABLE_COLUMNS);
				}

			}

		});

		HorizontalLayout selectionLayout = FluentUI.horizontal()
			.spacing()
			.captionKey("Table Selcetion Controls -" + TableSelectionMode.NONE.toString())
			.get();

		for (final TableSelectionState.TableSelectionMode t : TableSelectionState.TableSelectionMode.values()) {

			selectionLayout.addComponent(new Button(t.toString(), new ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {

					SelectGridViewImpl.this.grid.setSelectionMode(t);
					selectionLayout.setCaption("Table Selcetion Controls -" + t.toString());
				}
			}));
			this.grid = new BeanItemGrid<>(SeField.class);

			this.grid.setCaption("BeanItemGrid with Editable Columns");

			this.grid.setTextFieldRenderer("name");
			this.grid.setTextFieldRenderer("address");
			this.grid.setDateFieldRenderer("dob");
			this.grid.setCheckBoxRenderer("onFacebook");
			this.grid.setCheckBoxRenderer("country");

			setStringToBooleanColumnConverter("onFacebook");
			setStringToBooleanColumnConverter("country");
			this.grid.setColumnOrder("id", "name", "address", "dob", "onFacebook", "country");
			this.grid.setSizeFull();

		}

		return FluentUI.vertical()
			.add(highlightdEdtClmBtn, Alignment.TOP_CENTER)
			.add(this.grid)
			.add(selectionLayout, Alignment.BOTTOM_CENTER)
			.spacing()
			.margin()
			.get();

	}

	private void setStringToBooleanColumnConverter(String columnName) {
		this.grid.getColumn(columnName)
			.setConverter(new Converter<Boolean, String>() {
				private static final long serialVersionUID = -217722226979094995L;

				@Override
				public Boolean convertToPresentation(String value, Class<? extends Boolean> targetType, Locale locale)
						throws ConversionException {
					return value.equals("yes") ? true : false;
				}

				@Override
				public String convertToModel(Boolean value, Class<? extends String> targetType, Locale locale)
						throws ConversionException {
					return value.equals(Boolean.TRUE) ? "yes" : "no";
				}

				@Override
				public Class<Boolean> getPresentationType() {
					return Boolean.class;
				}

				@Override
				public Class<String> getModelType() {
					return String.class;
				}
			});
	}

	@Override
	public void setSeField(List<SeField> list) {

		this.grid.replaceAllBeans(list);

	}

}
