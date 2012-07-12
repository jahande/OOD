package logic.invention;

import com.sun.org.apache.bcel.internal.generic.IINC;

public class InventionField {
	private String name;
	private int id;

	private static int idCounter =0;
	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public InventionField(String name) {
		super();
		this.name = name;
		InventionField.idCounter++;
		this.id = InventionField.idCounter;
	}

	public String getName() {
		return name;
	}
}
