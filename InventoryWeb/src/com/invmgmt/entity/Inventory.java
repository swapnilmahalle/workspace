package com.invmgmt.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {

	@EmbeddedId
	private InventorySpec inventorySpec;

	@Column(name="purchaseRate")
	private String purchaseRate;

	@Column(name="quantity")
	private int quantity;
	
	public Inventory() 
	{

	}

	public InventorySpec getInventorySpec() {
		return inventorySpec;
	}

	public void setInventorySpec(InventorySpec inventorySpec) {
		this.inventorySpec = inventorySpec;
	}

	public String getPurchaseRate()
	{
		return this.purchaseRate;
	}

	public void setPurchaseRate(String purchaseRate)
	{
		this.purchaseRate = purchaseRate;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
