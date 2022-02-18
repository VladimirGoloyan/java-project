public class SalesPerson extends Employee {

    public String[] CustomerAccounts;
    private int addIndex = 0;
    private int customerCap = 50;

    //Complexity O(1) as constructor of parent is also O(1)
    public SalesPerson(String name, String surname, int ssn) {
        super(name, surname, ssn);
        CustomerAccounts = new String[customerCap];
    }

    //Complexity O(1)
    @Override
    void doWork() {
        System.out.println("Doing sales");
    }

    //Complexity O(1)
    public String[] getCustomers() {
        return this.CustomerAccounts;
    }

    //Complexity O(1)
    public void addCustomer(String customer) {
        if (addIndex == customerCap) {
            System.out.println("Sorry we are not large enough to accept you as customer");
            return;
        }
        CustomerAccounts[addIndex] = customer;
        addIndex++;
    }

}
