package com.hust.kstn;

public class Cart {
	 public static final int MAX_NUMBERS_ORDERED = 20;
	 private DigitalVideoDisc[] itemsInCart = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	 private int qtyOrdered = 0;
	 public void addDVD(DigitalVideoDisc disc) {
	        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
	            System.out.println("The cart is almost full.");
	            return;
	        }
	        itemsInCart[qtyOrdered] = disc;
	        qtyOrdered++;
	        System.out.println("The disc has been added successfully.");
	    }
	 public void removeDVD(DigitalVideoDisc disc) {
	        if (qtyOrdered == 0) {
	            System.out.println("The cart is empty.");
	            return;
	        }

	        boolean found = false;
	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemsInCart[i] == disc) {
	                found = true;
	                // shift left
	                for (int j = i; j < qtyOrdered - 1; j++) {
	                    itemsInCart[j] = itemsInCart[j + 1];
	                }
	                itemsInCart[qtyOrdered - 1] = null;
	                qtyOrdered--;
	                System.out.println("The disc has been removed successfully.");
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("The disc does not exist.");
	        }
	    }
	 public float calculateTotalCost() {
	        float total = 0f;
	        for (int i = 0; i < qtyOrdered; i++) {
	            total += itemsInCart[i].getCost();
	        }
	        return total;
	    }
	  public void print() {
        System.out.println("=========================THE CURRENT CART ====================");
        if (qtyOrdered != 0)
		{
			System.out.println("Total items: " + qtyOrdered);
            for (DigitalVideoDisc item : itemsInCart)
                if (item != null)
                    System.out.println("- " + item.toString());
            System.out.println("Subtotal: " + calculateTotalCost() + "$");
        System.out.println("==============================================================");
		}
        else 
		{
		System.out.println("The cart is empty");
		}
    }
}
