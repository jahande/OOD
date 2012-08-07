package interfaces;

import invregsystem.db.BaseEntity;
import invregsystem.logic.invention.InventionField;

import java.util.Set;


public abstract class AbstractUser extends AbstractMember{
	public abstract boolean isExpert() ;
	public abstract void setExpert(boolean expert) ;
	public abstract Set<InventionField> getInventionFields() ;
	public abstract void setInventionFields(Set<InventionField> inventionFields) ;
}