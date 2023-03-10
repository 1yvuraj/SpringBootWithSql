package com.API.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
     private int id;
     private String name;
     private String Address;
		public Author() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Author(int id, String name, String Address) {
			super();
			this.id = id;
			this.name = name;
			this.Address = Address;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
}
