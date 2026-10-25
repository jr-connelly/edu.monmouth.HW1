package edu.monmouth.hw1;

import edu.monmouth.vehicle.Vehicle;

public class VehicleList {
	private VehicleNode head;

	public VehicleList() {
		head = null;
	}

	public void insert(Vehicle vehicle) {
		VehicleNode node = new VehicleNode(vehicle);
		node.setNext(head);
		head = node;
	}

	public void insertEnd(Vehicle vehicle) {
		VehicleNode node = new VehicleNode(vehicle);
		if (head == null) {
			head = node;
			return;
		}
		VehicleNode current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(node);
	}

	public Vehicle first() {
		return (head == null) ? null : head.getVehicle();
	}

	public Vehicle last() {
		if (head == null) {
			return null;
		}
		VehicleNode current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		return current.getVehicle();
	}

	public Vehicle removeFirst() {
		if (head == null) {
			return null;
		}
		Vehicle removed = head.getVehicle();
		head = head.getNext();
		return removed;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		int count = 0;
		for (VehicleNode current = head; current != null; current = current.getNext()) {
			count++;
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("VehicleList (" + size() + " vehicles):\n");
		int i = 1;
		for (VehicleNode current = head; current != null; current = current.getNext()) {
			sb.append("  ").append(i++).append(". ").append(current).append('\n');
		}
		return sb.toString();
	}
}
