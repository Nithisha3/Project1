package com.cg.model;

public class Userrole {
		private String userName;
		private String password;
		private String roleCode;
		
		public Userrole(String username, String password, String rolecode) {
			super();
			this.userName = username;
			this.password = password;
			this.roleCode = rolecode;
		}
		

		public Userrole(String username, String roleCode) {
			super();
			this.userName = username;
			this.roleCode=roleCode;
		}


		public Userrole() {
			super();
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String username) {
			this.userName = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRoleCode() {
			return roleCode;
		}

		public void setRoleCode(String rolecode) {
			this.roleCode = rolecode;
		}

		@Override
		public String toString() {
			return "Userrole: User name :"+ userName+" role: "+roleCode;
		}
		
		
		
	}

