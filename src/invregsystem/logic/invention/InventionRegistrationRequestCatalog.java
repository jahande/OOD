package invregsystem.logic.invention;

import interfaces.AbstractUser;
import invregsystem.db.InventionRegistrationRequestDao;
import invregsystem.logic.RequestCatalog;

import java.util.ArrayList;
import java.util.List;

public class InventionRegistrationRequestCatalog extends RequestCatalog {
	private static InventionRegistrationRequestCatalog instance;

	private InventionCatalog inventionCatalog;
	private InventionRegistrationRequestDao invRegReqDao;

	private InventionRegistrationRequestCatalog() {
		super();
		inventionCatalog = InventionCatalog.getInstance();
		invRegReqDao = InventionRegistrationRequestDao.getInstance();
	}

	public static InventionRegistrationRequestCatalog getInstance() {
		if (instance == null) {
			instance = new InventionRegistrationRequestCatalog();
		}
		return instance;
	}

	@Override
	public List<?> getAllItems() {
		return invRegReqDao.fetchAll();
	}

	@Override
	public void addItem(Object item) {
		invRegReqDao.save((InventionRegistrationRequest) item);

	}

	@Override
	public void removeItem(Object item) {
		invRegReqDao.delete((InventionRegistrationRequest) item);
	}

	@Override
	public void updateItem(Object item) {
		invRegReqDao.update((InventionRegistrationRequest) item);
	}

	public InventionRegistrationRequest getInvRegReqByInvention(Invention invention) {
		List<InventionRegistrationRequest> list = invRegReqDao.findByParameter("invention", invention);
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<InventionRegistrationRequest> getInvRegReqsByExpert(AbstractUser expert) {
		List<InventionRegistrationRequest> list = invRegReqDao.findByParameter("assignedExpert", expert);
		return list;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByInventor(AbstractUser inventor) {
		List<Invention> inventions = inventionCatalog.getInventionsByInventor(inventor);
		List<InventionRegistrationRequest> requests = new ArrayList<InventionRegistrationRequest>();
		for (Invention inv : inventions) {
			requests.add(inv.getInventionRegistrationRequest());
		}
		return requests;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByInventorAndState(AbstractUser inventor, int state) {
		List<Invention> inventions = inventionCatalog.getInventionsByInventor(inventor);
		List<InventionRegistrationRequest> requests = new ArrayList<InventionRegistrationRequest>();
		for (Invention inv : inventions) {
			InventionRegistrationRequest request = inv.getInventionRegistrationRequest();
			if (request.getState() == state) {
				requests.add(inv.getInventionRegistrationRequest());
			}
		}
		return requests;
	}

}
