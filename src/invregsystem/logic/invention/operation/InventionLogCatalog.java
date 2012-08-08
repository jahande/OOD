package invregsystem.logic.invention.operation;

import interfaces.AbstractInvention;
import invregsystem.db.ChangeDao;
import invregsystem.db.InventionLogDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.invention.Invention;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventionLogCatalog implements Catalog {
	private static InventionLogCatalog instance;
	private InventionLogDao inventionLogDao;
	private ChangeDao changeDao;

	private InventionLogCatalog() {
		inventionLogDao = InventionLogDao.getInstance();
		changeDao = ChangeDao.getInstance();
	}

	public static InventionLogCatalog getInstance() {
		if (instance == null) {
			instance = new InventionLogCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		inventionLogDao.save((InventionLog) item);
	}

	public List<?> getAllItems() {
		return inventionLogDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		inventionLogDao.delete((InventionLog) removedItem);
	}

	public void updateItem(Object item) {
		inventionLogDao.update((InventionLog) item);
	}

	public List<InventionLog> getItemsByInvention(Invention invention) {
		return inventionLogDao.findByParameter("invention", invention);
	}

	public void addChange(Change change) {
		changeDao.save(change);
	}

	public List<Change> getChangesByInventionLog(InventionLog inventionLog) {
		return changeDao.findByParameter("inventionLog", inventionLog);
	}

	public List<InventionLog> getlogsOfInventionBeforeDate(AbstractInvention invention, Date date) {
		List<InventionLog> logs = inventionLogDao.findLessEqualThanParameter("changeDate", date);
		List<InventionLog> result = new ArrayList<InventionLog>();
		for (InventionLog log : logs) {
			if (log.getInvention().equals(invention)) {
				result.add(log);
			}
		}
		return result;
	}

	public void addInitialLog(AbstractInvention invention) {
		InventionLog log = new InventionLog(invention, null, new Date(), "");
		inventionLogDao.save(log);
		changeDao.save(new Change("totalSpec", null, invention.getTotalSpec(), log));
		changeDao.save(new Change("summary", null, invention.getSummary(), log));
		changeDao.save(new Change("ideaDescription", null, invention.getIdeaDescription(), log));
		changeDao.save(new Change("ideaHistory", null, invention.getIdeaHistory(), log));
		changeDao.save(new Change("claim", null, invention.getClaim(), log));
		changeDao.save(new Change("explanation", null, invention.getExplanation(), log));
		changeDao.save(new Change("file1", null, invention.getFile1(), log));
		changeDao.save(new Change("file2", null, invention.getFile2(), log));
		changeDao.save(new Change("file3", null, invention.getFile3(), log));
	}
}
