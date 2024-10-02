import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        BankAcoutns obj = new BankAcoutns();

        do {
            System.out.println("========================================");
            System.out.println("      WELCOME TO APNA BANK MANAGEMENT    ");
            System.out.println("========================================");
            System.out.println("1. Create New Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Close Account");
            System.out.println("7. Exit");
            System.out.println("========================================");
            System.out.print("Please select an option [1-7]: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // New Customer
                    System.out.print("Your Name: ");
                    String Name = sc.next();

                    System.out.print("Your City: ");
                    String Address = sc.next();

                    String Mno;
                    do {
                        System.out.print("Your Mobile Number: ");
                        Mno = sc.next();
                        if (Mno.length() != 10) {
                            System.out.println("Please re-enter a 10-digit Mobile Number.");
                        }
                    } while (Mno.length() != 10);

                    System.out.print("Create User ID: ");
                    String userId = sc.next();
                    System.out.print("Create Password: ");
                    String password = sc.next();

                    if (obj.insertnewData(Name, userId, password, Address, Mno)) {
                        System.out.println("Account Created Successfully!");
                    }
                    break;

                case 2:
                    // Old Customer Login
                    System.out.print("Enter Your Account Number or User ID: ");
                    String id = sc.next();
                    System.out.print("Enter Your Password: ");
                    String pass = sc.next();
                    obj.checkLoginCustomer(id, pass);
                    break;

                case 3:
                    // Deposit Money
                    System.out.print("Enter Your Account Number or User ID: ");
                    String depositId = sc.next();
                    System.out.print("Enter Your Password: ");
                    String depositPass = sc.next();
                    obj.checkLoginCustomer(depositId, depositPass);
                    // Deposit logic would be in `LoginCustomer`
                    break;

                case 4:
                    // Withdraw Money
                    System.out.print("Enter Your Account Number or User ID: ");
                    String withdrawId = sc.next();
                    System.out.print("Enter Your Password: ");
                    String withdrawPass = sc.next();
                    obj.checkLoginCustomer(withdrawId, withdrawPass);
                    // Withdraw logic would be in `LoginCustomer`
                    break;

                case 5:
                    // Transfer Funds
                    System.out.print("Enter Your Account Number or User ID: ");
                    String transferId = sc.next();
                    System.out.print("Enter Your Password: ");
                    String transferPass = sc.next();
                    obj.checkLoginCustomer(transferId, transferPass);
                    // Transfer logic would be in `LoginCustomer`
                    break;

                case 6:
                    // Admin Login
                    System.out.print("Enter Admin Username: ");
                    String adminUser = sc.next();
                    System.out.print("Enter Admin Password: ");
                    String adminPass = sc.next();
                    if (adminUser.equals("admin") && adminPass.equals("admin")) {
                        obj.adminLogin();
                    } else {
                        System.out.println("Invalid Admin Credentials.");
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Thank you for using XYZ Bank. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
