package CompanyRoles;
public class Company {
    public String name;
    public int employeeCapacity;
    //Fixed after HW1 feedback
    private Executive ceo;
    private Employee[] employeeList;
    private int addIndex = 1;

    //Complexity O(1)
    public Company(String n, int cap, Executive e) {
        this.name = n;

        if (cap <= 20) {
            this.employeeCapacity = 20;
        } else {
            this.employeeCapacity = cap;
        }

        this.ceo = e;
        employeeList = new Employee[cap];
        employeeList[0] = this.ceo;
    }

    //Complexity O(1)
    public String getName() {
        return this.name;
    }

    //Complexity O(1)
    public int getEmployeeCapacity() {
        return this.employeeCapacity;
    }

    //Complexity O(1)
    public Employee getCEO() {
        return this.ceo;
    }

    //Complexity O(1)
    public void setName(String n) {
        this.name = n;
    }

    //Complexity O(n) where n is equal to employeeCapacity 
    //Fixed after HW1 feedback
    public void enlargeCapacity(int i) {
        if (i < employeeCapacity) {
            System.out.println("Number must be bigger than previous capacity");
        } 
        
        Employee[] temp = new Employee[i];
        
        for (int j = 0; j < employeeCapacity; j++) {
            temp[i] = employeeList[i];
        }

        employeeCapacity = i;
        employeeList = temp;
    }

    //Complexity O(n) as enlargeCapacity method is O(n)
    public boolean hireEmployee(Employee e, Manager m){
        if(!ceo.confirmHiring()){
            return false;
        }
        if(addIndex == employeeCapacity){
            enlargeCapacity(employeeCapacity * 2);
        }

        employeeList[addIndex] = e;
        addIndex++;
        m.addDirectReport(e);
        return true;
    }

    //Complexity O(n) where n is equal to addIndex => number of employees in company
    public void printAllEmployeeNames(){
        System.out.println("Printing all employee names");

        for(int i = 0; i < addIndex;i++){
            System.out.println(employeeList[i].getFullName());
        }
    }

    //Fixed after HW1 feedback
    public static void main(String[] args) {

        System.out.println("Main started.");

        Executive ceo = new Executive("Abigail", "James", 1);

        SWManager sen1 = new SWManager("John", "Green", 2, "Senior software engineer");
        SWManager sen2 = new SWManager("John", "Brown", 3, "Senior software engineer");

        SWEngineer jun1 = new SWEngineer("Hilary", "Something", 4, "Junior software engineer");
        SWEngineer jun2 = new SWEngineer("Debbie", "Anniston", 5, "Junior software engineer");
        SWEngineer jun3 = new SWEngineer("Adam", "Levine", 6, "Junior software engineer");
        SWEngineer jun4 = new SWEngineer("Leo", "Bonucci", 7, "Junior software engineer");

        SWEngineer mid1 = new SWEngineer("Ricardo", "Miller", 8, "Middle software engineer");
        SWEngineer mid2 = new SWEngineer("Tessa", "Davidson", 9, "Middle software engineer");

        FinanceManager fin = new FinanceManager("Rob", "Robson", 0004);

        Accountant acc1 = new Accountant("Evan", "Valet", 10);
        Accountant acc2 = new Accountant("Georgio", "Tuz", 11);

        Company comp = new Company("AUA", 20, ceo);

        comp.hireEmployee(sen1, ceo);
        comp.hireEmployee(sen2, ceo);

        comp.hireEmployee(mid1, sen1);
        comp.hireEmployee(jun1, sen1);
        comp.hireEmployee(jun2, sen1);

        comp.hireEmployee(mid2, sen2);
        comp.hireEmployee(jun3, sen2);
        comp.hireEmployee(jun4, sen2);

        comp.hireEmployee(fin, ceo);

        comp.hireEmployee(acc1, fin);
        comp.hireEmployee(acc2, fin);

        comp.printAllEmployeeNames();
    }
}


