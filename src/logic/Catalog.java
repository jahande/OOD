package logic;

import java.util.List;

public interface Catalog {

	public List<?> getAllItems();

	public void addItem(Object item);

	public void removeItem(Object removedItem);
}
