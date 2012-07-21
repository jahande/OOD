package logic.invention;

import java.util.ArrayList;
import java.util.List;

import logic.Request;
import logic.RequestCatalog;
import logic.member.User;

public class InventionRegistrationRequestCatalog extends RequestCatalog {
	private static InventionRegistrationRequestCatalog instance;

	// private InventionCatalog inventionCatalog;
	// private UserCatalog userCatalog;

	private InventionRegistrationRequestCatalog() {
		super();
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

	public InventionRegistrationRequest getInvRegReqByParamater(
			Invention invention) {
		for (Request request : requestList) {
			if (((InventionRegistrationRequest) request).getInvention().equals(
					invention)) {
				return (InventionRegistrationRequest) request;
			}
		}
		return null;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByExpert(
			User expert) {
		List<InventionRegistrationRequest> results = new ArrayList<InventionRegistrationRequest>();
		for (Request request : requestList) {
			InventionRegistrationRequest invRegReq = (InventionRegistrationRequest) request;
			if (invRegReq.hasAssignedExpert()
					&& invRegReq.getAssignedExpert().equals(expert)) {
				results.add(invRegReq);
			}
		}
		return results;
	}

	public List<InventionRegistrationRequest> getInvRegReqsByInventor(
			User inventor) {
		List<InventionRegistrationRequest> results = new ArrayList<InventionRegistrationRequest>();
		for (Request request : requestList) {
			InventionRegistrationRequest invRegReq = (InventionRegistrationRequest) request;
			if (invRegReq.getInvention().getInventors().contains(inventor)) {
				results.add(invRegReq);
			}
		}
		return results;
	}

}
