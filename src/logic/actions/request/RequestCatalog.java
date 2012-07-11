package logic.actions.request;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;

public abstract class RequestCatalog implements Catalog {
	private static List<Request> requestList = new ArrayList<Request>();

	public static void addRequest(Request request) {
		requestList.add(request);
	}

	public static List<Request> getRequestList() {
		return requestList;
	}
}
