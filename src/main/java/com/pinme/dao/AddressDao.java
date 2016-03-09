package com.pinme.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Address;

/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 */
public class AddressDao {
	public static List<Address> addresses = new ArrayList<Address>();
	private static AtomicInteger uniqueId = new AtomicInteger();

	/**
	 * 
	 */
	public AddressDao() {
		
	}

	public int addAddress(Address Address) {
		Address.setId(uniqueId.incrementAndGet());
		addresses.add(Address);
		return Address.getId();
	}

	public void removeAddress(int id) {
		for (Address Address : addresses) {
			if (Address.getId() == (id)) {
				addresses.remove(Address);
				return;
			}

		}

	}

	public Address getAddress(int addressId) {
		for (Address address : addresses) {
			if (address.getId() == addressId) {
				return address;
			}
		}
		return null;
	}

	public void updateAddress(int AddressId, Address updateAddress) {

		for (Address address : addresses) {
			if (address.getId() == AddressId) {
				address = updateAddress;

			}
		}

	}

}
