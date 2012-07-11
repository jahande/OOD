package logic.actions.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.invention.Invention;
import logic.invention.InventionCatalog;
import logic.member.User;
import logic.member.UserCatalog;

public class InventionRegistrationRequestCatalog extends RequestCatalog {
	static {
		InventionRegistrationRequest req = new InventionRegistrationRequest(new Date(),
				InventionCatalog.getInventionList().get(0));
		req.setAssignedExpert(UserCatalog.getUserByParamater("expert"));
		requestList.add(req);
	}

	public static InventionRegistrationRequest getInvRegReqByParamater(
			Invention invention) {
		for (Request request : requestList) {
			if (((InventionRegistrationRequest) request).getInvention().equals(
					invention)) {
				return (InventionRegistrationRequest) request;
			}
		}
		return null;
	}

	public static List<InventionRegistrationRequest> getInvRegReqsByParamater(
			User expert) {
		List<InventionRegistrationRequest> results = new ArrayList<InventionRegistrationRequest>();
		for (Request request : requestList) {
			InventionRegistrationRequest invRegReq = (InventionRegistrationRequest) request;
			if (invRegReq.getAssignedExpert().equals(expert)) {
				results.add(invRegReq);
			}
		}
		return results;
	}

}
