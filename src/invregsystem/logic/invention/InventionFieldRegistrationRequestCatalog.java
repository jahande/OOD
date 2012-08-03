package invregsystem.logic.invention;

import invregsystem.db.InventionFieldRegistrationRequestDao;
import invregsystem.logic.RequestCatalog;

import java.util.List;

public class InventionFieldRegistrationRequestCatalog extends RequestCatalog {
	private static InventionFieldRegistrationRequestCatalog instance;

	private InventionFieldRegistrationRequestDao invRegReqDao;

	private InventionFieldRegistrationRequestCatalog() {
		super();
		invRegReqDao = InventionFieldRegistrationRequestDao.getInstance();
	}

	public static InventionFieldRegistrationRequestCatalog getInstance() {
		if (instance == null) {
			instance = new InventionFieldRegistrationRequestCatalog();
		}
		return instance;
	}

	@Override
	public List<?> getAllItems() {
		return invRegReqDao.fetchAll();
	}

	@Override
	public void addItem(Object item) {
		invRegReqDao.save((InventionFieldRegistrationRequest) item);

	}

	@Override
	public void removeItem(Object item) {
		invRegReqDao.delete((InventionFieldRegistrationRequest) item);
	}

	@Override
	public void updateItem(Object item) {
		invRegReqDao.update((InventionFieldRegistrationRequest) item);
	}

}
