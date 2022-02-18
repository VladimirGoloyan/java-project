package CompanyRoles;
public class Accountant extends Employee{

    //Complexity O(1) as constructor of parent is also O(1)
    public Accountant(String name, String surname, int ssn) {
        super(name, surname, ssn);
    }
    //Complexity O(1)
    public void releaseSalary(){
        System.out.println("Releasing salaries");
    }

    //Complexity O(1)
    @Override
    void doWork() {
        System.out.println("Doing some accounting work");
    }
    
}
