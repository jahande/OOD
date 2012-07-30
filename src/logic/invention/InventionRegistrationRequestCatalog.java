package logic.invention;

import java.util.ArrayList;
import java.util.List;

import db.InventionRegistrationRequestDao;

import logic.RequestCatalog;
import logic.member.User;

public class InventionRegistrationRequestCatalog extends RequestCatalog {
	private static InventionRegistrationRequestCatalog instance;

	private InventionCatalog inventionCatalog;
	private InventionRegistrationRequestDao invRegReqDao;

	private InventionRegistrationRequestCatalog() {
		super();
		inventionCatalog = InventionCatalog.getInstance();
		invRegReqDao = InventionRegistrationRequestDao.getInstance();
		// inventionCatalog = (InventionCatalog) ApplicationContext
		// .getCatalog(InventionCatalog.class);
		// userCatalog = (UserCatalog) ApplicationContext
		// .getCatalog(UserCatalog.class);
		// Invention invention = (Invention)
		// inventionCatalog.getAllItems().get(0);
		// InventionRegistrationRequest req = new InventionRegistrationRequest(
		// new Date(), invention);
		// req.setAssignedExpert(userCatalog.getUserByParamater("expert"));
		// requestList.add(req);
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

	public List<InventionRegistrationRequest> getInvRegReqsByExpert(User expert) {
		List<InventionRegistrationRequest> list = invRegReqDao.findByParameter("assignedExpert", expert);
		return list;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByInventor(User inventor) {
		List<Invention> inventions = inventionCatalog.getInventionsByInventor(inventor);
		List<InventionRegistrationRequest> requests = new ArrayList<InventionRegistrationRequest>();
		for (Invention inv : inventions) {
			requests.add(inv.getInventionRegistrationRequest());
		}
		return requests;
	}

}
