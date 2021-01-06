class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (this.firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (this.lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if (firstName.length() == 0 && lastName.length()==0) {
            return "Unknown";
        } else if (this.lastName.isEmpty()) {
            return firstName;
        } else if (this.firstName.isEmpty()){
            return lastName;
        } else {
            return firstName + " " + lastName;
        }
    }
}