import java.util.Iterator;

public class Company {
    public String name;
    // Fixed after HW1 feedback
    private Executive ceo;
    private LinkedList<Employee> employeeList;
    private ArrayDeque<Employee> top10performers = new ArrayDeque<>(10);

    // Complexity O(1)
    public Company(String n, int cap, Executive e) {
        this.name = n;
        this.ceo = e;

        employeeList = new LinkedList<Employee>();
        employeeList.addFirst(this.ceo);
    }

    // Complexity O(1)
    public String getName() {
        return this.name;
    }

    // Complexity O(1)
    public int getEmployeeCapacity() {
        return employeeList.size();
    }

    // Complexity O(1)
    public Employee getCEO() {
        return this.ceo;
    }

    // Complexity O(1)
    public void setName(String n) {
        this.name = n;
    }

    // Complexity O(n) where n is equal to employeeCapacity
    // Fixed after HW1 feedback
    // public void enlargeCapacity(int i) {
    // if (i < employeeCapacity) {
    // System.out.println("Number must be bigger than previous capacity");
    // }

    // Employee[] temp = new Employee[i];

    // for (int j = 0; j < employeeCapacity; j++) {
    // temp[i] = employeeList[i];
    // }

    // employeeCapacity = i;
    // employeeList = temp;
    // }

    // Complexity O(n) as enlargeCapacity method is O(n)
    public boolean hireEmployee(Employee e, Manager m) {
        if (!ceo.confirmHiring()) {
            return false;
        }
        employeeList.addLast(e);
        m.addDirectReport(e);
        return true;
    }

    // Complexity O(n) where n is equal to addIndex => number of employees in
    // company
    public void printAllEmployeeNames() {
        System.out.println("Printing all employee names");

        Iterator<Employee> it = employeeList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public boolean addTopPerformer(Employee e) {
        if (top10performers.isEmpty()) {
            top10performers.pushFront(e);
            return true;
        }

        if (top10performers.size() == 10) {
            top10performers.popBack();
        }

        Iterator<Employee> it = top10performers.iterator();

        while (it.hasNext()) {
            if (it.next().getPerformanceScore() < e.getPerformanceScore()) {
                top10performers.pushFront(e);
                return true;
            }
        }
        return false;
    }

    public boolean addTopPerformerUpdated(Employee e) {
        if (top10performers.isEmpty()) {
            top10performers.pushFront(e);
            return true;
        }

        if (top10performers.size() == 10) {

            Iterator<Employee> it = top10performers.iterator();

            Employee lowest = top10performers.front();
            while (it.hasNext()) {
                Employee walk = it.next();
                if (walk.getPerformanceScore() < lowest.getPerformanceScore()) {
                    lowest = walk;
                }
            }
            top10performers.swap(lowest, top10performers.back());
            top10performers.popBack();
        }

        top10performers.pushFront(e);
        return false;
    }

    // Fixed after HW1 feedback
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
