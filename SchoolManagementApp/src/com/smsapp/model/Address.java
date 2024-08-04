package com.smsapp.model;

/**
 * Represents an address in the School Management System.
 * <p>
 * This class provides the necessary fields and methods to manage address
 * information. The Address class supports both a parameterized constructor and
 * a builder pattern for object creation.
 * </p>
 * 
 * @author MonigaBalasubramanians
 */
public class Address {

	private int addressId;
	private String doorNo;
	private String street;
	private String city;
	private String district;
	private int pincode;
	private String state;
	private String country;

	/**
	 * Constructor for the Address class using the Builder pattern.
	 * 
	 * @param builder the Builder object to construct the Address object
	 */
	private Address(Builder builder) {
		this.doorNo = builder.doorNo;
		this.street = builder.street;
		this.city = builder.city;
		this.district = builder.district;
		this.pincode = builder.pincode;
		this.state = builder.state;
		this.country = builder.country;
	}

	/**
	 * Builder class for constructing Address objects.
	 */
	public static class Builder {
		private String doorNo;
		private String street;
		private String city;
		private String district;
		private int pincode;
		private String state;
		private String country;

		/**
		 * Sets the door number.
		 * 
		 * @param doorNo the door number
		 * @return the Builder object
		 */
		public Builder doorNo(String doorNo) {
			this.doorNo = doorNo;
			return this;
		}

		/**
		 * Sets the street.
		 * 
		 * @param street the street
		 * @return the Builder object
		 */
		public Builder street(String street) {
			this.street = street;
			return this;
		}

		/**
		 * Sets the city.
		 * 
		 * @param city the city
		 * @return the Builder object
		 */
		public Builder city(String city) {
			this.city = city;
			return this;
		}

		/**
		 * Sets the district.
		 * 
		 * @param district the district
		 * @return the Builder object
		 */
		public Builder district(String district) {
			this.district = district;
			return this;
		}

		/**
		 * Sets the pincode.
		 * 
		 * @param pincode the pincode
		 * @return the Builder object
		 */
		public Builder pincode(int pincode) {
			this.pincode = pincode;
			return this;
		}

		/**
		 * Sets the state.
		 * 
		 * @param state the state
		 * @return the Builder object
		 */
		public Builder state(String state) {
			this.state = state;
			return this;
		}

		/**
		 * Sets the country.
		 * 
		 * @param country the country
		 * @return the Builder object
		 */
		public Builder country(String country) {
			this.country = country;
			return this;
		}

		/**
		 * Builds and returns an Address object.
		 * 
		 * @return the constructed Address object
		 */
		public Address build() {
			return new Address(this);
		}
	}

	/**
	 * Default constructor.
	 */
	public Address() {
		super();
	}

	/**
	 * Parameterized constructor to initialize an Address object with the provided
	 * values.
	 * 
	 * @param addressId the unique ID of the address
	 * @param doorNo    the door number
	 * @param street    the street
	 * @param city      the city
	 * @param district  the district
	 * @param pincode   the pincode
	 * @param state     the state
	 * @param country   the country
	 */
	public Address(int addressId, String doorNo, String street, String city, String district, int pincode, String state,
			String country) {
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.city = city;
		this.district = district;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}

	/**
	 * Gets the address ID.
	 * 
	 * @return the address ID
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * Sets the address ID.
	 * 
	 * @param addressId the new address ID
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * Gets the door number.
	 * 
	 * @return the door number
	 */
	public String getDoorNo() {
		return doorNo;
	}

	/**
	 * Sets the door number.
	 * 
	 * @param doorNo the new door number
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street.
	 * 
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 * 
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the district.
	 * 
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 * 
	 * @param district the new district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * Gets the pincode.
	 * 
	 * @return the pincode
	 */
	public int getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 * 
	 * @param pincode the new pincode
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * Gets the state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Returns a string representation of the address object.
	 * 
	 * @return a string representation of the address object
	 */
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", district=" + district
				+ ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}
}
