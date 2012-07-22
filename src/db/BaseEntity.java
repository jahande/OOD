package db;

import java.io.Serializable;

public abstract class BaseEntity<T extends Serializable> {
	public abstract T getId();

	public abstract void setId(T id);

	@Override
	public String toString() {
		return "Entity:" + this.getClass().getSimpleName() + "[" + getId() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!this.getClass().isInstance(obj)) {
			return false;
		}
		BaseEntity<?> entity = (BaseEntity<?>) obj;
		return getId().equals(entity.getId());
	}

}
