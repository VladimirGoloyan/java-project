public class Executive extends Employee implements Manager {

    public Manager[] directReports;
    private int teamCap = 10;
    private int addIndex = 0;

    //Complexity O(1) as constructor of parent is also O(1)
    public Executive(String name, String surname, int ssn) {
        super(name, surname, ssn);
        directReports = new Manager[teamCap];
    }

    //Complexity O(1)
    public boolean confirmHiring(){
        System.out.println("We will hire everybody now !!!!");
        return true;
    }

    //Complexity O(1)
    public boolean confirmFiring(){
        System.out.println("We cant fire anybody ..... yet");
        return false;
    }

    //Complexity O(1)
    public boolean confirmCompanyBudget(){
        System.out.println("Forward that request to the head accountant yourself please, I should be busy.");
        return false;
    }

    //Complexity O(n) where n is equal to teamCap
    public void enlargeTeam(int i) {
        if (i < teamCap) {
            System.out.println("Number must be bigger than previous capacity");
        } else if (directReports[0] == null) {
            directReports = new Manager[i];
        }

        Manager[] temp = new Manager[i];

        for (int j = 0; j < teamCap; j++) {
            temp[i] = directReports[i];
        }

        teamCap = i;
        directReports = temp;
    }

    //Complexity O(n) as enlargeTeam is O(n)
    public void addDirectReport(Employee e) {
        if (addIndex == teamCap) {
            enlargeTeam(teamCap * 2);
        }

        directReports[addIndex] = (Manager) e;
        addIndex++;
    }

    //Complexity O(1)
    public void evaluateEmployee(Employee e) {
        System.out.println("Evaluating Employee : " + e.getFullName());
    }

    //Complexity O(1)
    @Override
    public void reviewSalary(Employee e) {
        System.out.println("Reviewing salary of Employee : " + e.getFullName());
    }

    //Complexity O(1)
    @Override
    public Employee[] getDirectReports() {
        return (Employee[]) directReports;
    }

    //Complexity O(1)
    @Override
    void doWork() {
        // TODO Auto-generated method stub
        System.out.println("Being caring and awesome about what you do.");
    }

}
