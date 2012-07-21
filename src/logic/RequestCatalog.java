package logic;

import java.util.ArrayList;
import java.util.List;


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

	public void updateItem(Object item) {
		// TODO Auto-generated method stub
	}

//	public static void addRequest(Request request) {
//		requestList.add(request);
//	}
//
//	public static List<Request> getRequestList() {
//		return requestList;
//	}
}
