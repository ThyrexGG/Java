package Model;

public class Staff {
    private String staffId;
    private String name;
    private String role;
    private double salary;
    private String shift;
    private String PhoneNumber;
    private String email;
    private String address;
    private String StartDate;

    // Constructor
    public Staff(String staffId, String name, String startDate) {
        setStaffId(staffId);
        setName(name);
        setStartDate(startDate);
    }

    public String getStaffId() {
        return staffId;
    }

    private void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return StartDate;
    }

    private void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }
}
