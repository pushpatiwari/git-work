package de.bonprix.dselect.dao;

import java.util.List;

import de.bonprix.dselect.model.SeField;
import de.bonprix.model.EntityFilter;
import de.bonprix.mybatis.database.dao.EntityDao;

public interface SeFieldDao extends EntityDao<SeField, EntityFilter> {
	
	public void insertSeField(List<SeField>list);
//	
//	public void updateSeField(SeField itemid);
//	
//	public int deleteSeField(Long id);
	
	public List<SeField> fetchField();

}
