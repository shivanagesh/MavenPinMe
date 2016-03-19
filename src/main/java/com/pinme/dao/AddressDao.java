package com.pinme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Address;
import com.pinme.model.Event;

/**
 *
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
        List<Address> addressList = new ArrayList<Address>();

            String sql = "Select * from address where id=?";
            PreparedStatement addressQueryStmt = null;
            try{
                addressQueryStmt = dbConnection.prepareStatement(sql);
                addressQueryStmt.setInt(1, addressId);
                ResultSet rs = addressQueryStmt.executeQuery();
                while (rs.next()) {
                   Address address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setStreet(rs.getString("street"));
                    address.setCity(rs.getString("city"));
                    address.setState(rs.getString("state"));
                    address.setZipcode(rs.getString("zipcoe"));
                    address.setCountry(rs.getString("country"));
                    address.setLatitude(rs.getString("latitude"));
                    address.setLongitude(rs.getString("longitude"));
                    addressList.add(address)  ;
                }
            } catch (Exception e){
                e.printStackTrace();
            }


        return addressList.get(0);

	}

	public void updateAddress(int AddressId, Address updateAddress) {

		for (Address address : addresses) {
			if (address.getId() == AddressId) {
				address = updateAddress;

			}
		}

	}

}
