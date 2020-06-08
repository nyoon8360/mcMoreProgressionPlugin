package user.nyoon.helperclasses;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class Upgrader {
	private ItemStack result;
	private ItemStack mold;
	private ItemStack catalyst;
	private ArrayList<ItemStack> materials;
	
	public Upgrader(ItemStack result, ItemStack mold, ItemStack catalyst, ArrayList<ItemStack> materials) {
		this.mold = mold;
		this.result = result;
		this.materials = materials;
		this.catalyst = catalyst;
	}
	
	public ItemStack getResult() {
		return result;
	}
	
	public ArrayList<ItemStack> getMaterials() {
		return materials;
	}
	
	public ItemStack getCatalyst() {
		return catalyst;
	}
	
	public ItemStack getMold() {
		return mold;
	}
	
	public String getRecipeString() {
		
		return mold.getType().toString() + catalyst.getType().toString();
	}
}
