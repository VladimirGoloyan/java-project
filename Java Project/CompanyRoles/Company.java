package CompanyRoles;
public class Company {
    public String name;
    public int employeeCapacity;
    public Executive ceo;

    public Employee[] employeeList;
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
    public void enlargeCapacity(int i) {
        if (i < employeeCapacity) {
            System.out.println("Number must be bigger than previous capacity");
        } 
        else if (employeeList[1] == null) {
            employeeList = new Employee[i];
            employeeList[0] = this.ceo;
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
}


