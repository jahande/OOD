package interfaces;

import java.util.Set;

import logic.invention.InventionField;
import db.BaseEntity;

public abstract class AbstractUser extends AbstractMember{
	public abstract boolean isExpert() ;
	public abstract void setExpert(boolean expert) ;
	public abstract Set<InventionField> getInventionFields() ;
	public abstract void setInventionFields(Set<InventionField> inventionFields) ;
}
