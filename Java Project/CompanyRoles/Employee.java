package CompanyRoles;
abstract class Employee {
    public String name;
    public String surname;
    public int ssn;

    abstract void doWork();

    //Complexity O(1)
    public void takeVacation() {
        System.out.println(this.name + ' ' + this.surname + " is going on a vacation.");
    }

    //Complexity O(1)
    public Employee(String name, String surname, int ssn) {
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
    }

    //Complexity O(1)
    public String getName() {
        return this.name;
    }

    //Complexity O(1)
    public String getSurname() {
        return this.surname;
    }

    //Complexity O(1)
    public String getFullName() {
        return this.name + ' ' + this.surname;
    }

    //Complexity O(1)
    public int getSSN() {
        return this.ssn;
    }

    //Complexity O(1)
    public void setName(String n) {
        this.name = n;
    }

    //Complexity O(1)
    public void setSurname(String s) {
        this.surname = s;
    }

    // no setter for ssn as I think it cannot be changed
}
