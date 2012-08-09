package invregsystem.logic.invention;

import invregsystem.AbstractUser;
import invregsystem.db.ExpertInventionFieldDao;
import invregsystem.db.InventionFieldDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.member.ExpertInventionField;
import invregsystem.logic.member.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventionFieldCatalog implements Catalog {
	private static InventionFieldCatalog instance;
	private InventionFieldDao inventionFieldDao;
	private ExpertInventionFieldDao expertInventionFieldDao;

	private InventionFieldCatalog() {
		super();
		inventionFieldDao = InventionFieldDao.getInstance();
		expertInventionFieldDao = ExpertInventionFieldDao.getInstance();
	}

	public static InventionFieldCatalog getInstance() {
		if (instance == null) {
			instance = new InventionFieldCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		inventionFieldDao.save((InventionField) item);
	}

	public List<?> getAllItems() {
		return inventionFieldDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		inventionFieldDao.delete((InventionField) removedItem);
	}

	public void updateItem(Object item) {
		inventionFieldDao.update((InventionField) item);
	}

	public InventionField getInventionFieldByName(String name) {
		List<InventionField> result = inventionFieldDao.findByParameter("name",
				name);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public List<InventionField> getInventionFieldsOfExpert(AbstractUser expert) {
		List<ExpertInventionField> expertInventionFields = expertInventionFieldDao
				.findByParameter("expert", expert);
		List<InventionField> fields = new ArrayList<InventionField>();
		for (ExpertInventionField expInvField : expertInventionFields) {
			fields.add(expInvField.getInventionField());
		}
		return fields;
	}

	public void addInventionFieldToExpert(AbstractUser expert,
			InventionField field) {
		expertInventionFieldDao.save(new ExpertInventionField((User) expert,
				field));
	}

	public void removeInventionFieldFromExpert(AbstractUser expert,
			InventionField field) {
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("expert", expert);
		parametersMap.put("inventionField", field);
		expertInventionFieldDao.delete(expertInventionFieldDao
				.findByParametersMap(parametersMap).get(0));
	}
}
