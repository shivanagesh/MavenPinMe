package com.pinme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Address;

/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 *
 * @author Prathyusha Chintala, Implemented routine to persist address
 */
public class AddressDao extends DBConnect {
	public static List<Address> addresses = new ArrayList<Address>();
	private static AtomicInteger uniqueId = new AtomicInteger();
    Connection dbConnection = getDBConnection();

	/**
	 * 
	 */
	public AddressDao() {
		
	}

	public int addAddress(Address address) {
        String sql = "INSERT INTO address(street, city, state, zipcoe, country, latitude, longitude) VALUES (?, ?, ?, ?,?, ?, ?)";
        PreparedStatement addressInsertStmt = null;
        int id = -1;
        try {
            System.out.println(dbConnection);
            addressInsertStmt = dbConnection.prepareStatement(sql);
            addressInsertStmt.setString(1, address.getStreet());
            addressInsertStmt.setString(2, address.getCity());
            addressInsertStmt.setString(3, address.getState());
            addressInsertStmt.setString(4, address.getZipcode());
            addressInsertStmt.setString(5, address.getCountry());
            addressInsertStmt.setString(6, address.getLatitude());
            addressInsertStmt.setString(7, address.getLongitude());

            id = addressInsertStmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            id = -1;
        }
        return id;
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
