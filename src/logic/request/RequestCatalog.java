package logic.request;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;

public abstract class RequestCatalog implements Catalog {
	protected static List<Request> requestList = new ArrayList<Request>();

	public void addItem(Object item) {
		requestList.add((Request) item);
	}

	public List<?> getAllItems() {
		return requestList;
	}

	public void removeItem(Object removedItem) {
		requestList.remove(removedItem);
	}

//	public static void addRequest(Request request) {
//		requestList.add(request);
//	}
//
//	public static List<Request> getRequestList() {
//		return requestList;
//	}
}
