package invregsystem.ui.models;

import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RequestExpirationTimer {
	private static RequestExpirationTimer instance;

	private RequestExpirationTimer() {
	}

	public static RequestExpirationTimer getInstance() {
		if (instance == null) {
			instance = new RequestExpirationTimer();
		}
		return instance;
	}

	public void start() {
		Timer timer = new Timer();
		timer.schedule(new RequestExpirationTask(), 0, 3600000); // period = 1
																	// hour
	}

	private static class RequestExpirationTask extends TimerTask {
		@Override
		public void run() {
			InventionRegistrationRequestCatalog invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
			List<InventionRegistrationRequest> expiredList = invRegReqCatalog.getExpiredInvRegReqs();
			for (InventionRegistrationRequest request : expiredList) {
				request.setAsExpired();
				request.referToAnotherExpert(request.getAssignedExpert());
			}
		}
	}

}
