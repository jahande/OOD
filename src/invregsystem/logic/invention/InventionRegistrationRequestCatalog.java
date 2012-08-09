package invregsystem.logic.invention;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
import invregsystem.db.InventionRegistrationRequestDao;
import invregsystem.logic.RequestCatalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

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
		List<AbstractInvention> inventions = inventionCatalog.getInventionsByInventor(inventor);
		List<InventionRegistrationRequest> requests = new ArrayList<InventionRegistrationRequest>();
		for (AbstractInvention inv : inventions) {
			requests.add(inv.getInventionRegistrationRequest());
		}
		return requests;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByInventorAndState(AbstractUser inventor, int state) {
		List<AbstractInvention> inventions = inventionCatalog.getInventionsByInventor(inventor);
		List<InventionRegistrationRequest> requests = new ArrayList<InventionRegistrationRequest>();
		for (AbstractInvention inv : inventions) {
			InventionRegistrationRequest request = inv.getInventionRegistrationRequest();
			if (request.getState() == state) {
				requests.add(inv.getInventionRegistrationRequest());
			}
		}
		return requests;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByPermitted(boolean permitted) {
		List<InventionRegistrationRequest> list = invRegReqDao.findByParameter("permitted", permitted);
		return list;
	}

	public List<InventionRegistrationRequest> getExpiredInvRegReqs() {
		List<InventionRegistrationRequest> list = invRegReqDao.fetchAll();
		List<InventionRegistrationRequest> result = new ArrayList<InventionRegistrationRequest>();
		for (InventionRegistrationRequest request : list) {
			if (request.getSendDate() != null && request.getState() == InventionRegistrationRequest.NOT_INVESTIGATED) {
				DateTime sendDate = new DateTime(request.getSendDate().getTime());
				DateTime now = new DateTime(new Date().getTime());
				// if more than 3 weeks is passed from send date
				if (Days.daysBetween(sendDate, now).getDays() > 21) {
					result.add(request);
				}
			}
		}
		return result;
	}

	public List<InventionRegistrationRequest> getNotInvestigatedInvRegReqsByInventor(AbstractUser inventor) {
		List<InventionRegistrationRequest> requests = getInvRegReqsByInventorAndState(inventor, InventionRegistrationRequest.NOT_INVESTIGATED);
		List<InventionRegistrationRequest> result = new ArrayList<InventionRegistrationRequest>();
		for (InventionRegistrationRequest request : requests) {
			if (request.getSendDate() != null) {
				result.add(request);
			}
		}
		return result;
	}

}
