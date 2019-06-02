package com.cars.model;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@NotNull(message="Editable field cannot be null")
	private boolean isEditable;

	@NotNull(message="Deletable field cannot be null")
	private boolean isDeletable;

	public Cars(String carName,boolean isEditable,boolean isDeletable){
		this.isEditable=isEditable;
		this.isDeletable=isDeletable;
	}
	public Cars(){}



	@OneToOne(mappedBy = "CarDetails")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean editable) {
		isEditable = editable;
	}

	public boolean isDeletable() {
		return isDeletable;
	}

	public void setDeletable(boolean deletable) {
		isDeletable = deletable;
	}
}
