
import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        BankAcoutns obj = new BankAcoutns();
        do{
            System.out.println("*-----Apna-Spana New Bank-----*");
            System.out.println("Welcome to Apna spana New bank... :)");
            System.out.println("1.Are u New Customer ? ");
            System.out.println("2.Our Customer ? ");
            System.out.println("3. Admin Login ? ");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            if(choice==1){
                //New Customer
                System.out.print("Your name : ");
                String Name = sc.next();

                System.out.print("Your City u Live : ");
                String Address = sc.next();
                String Mno;
                do {
                    System.out.print("Your Mobile Number : ");
                    Mno = sc.next();
                    if(Mno.length()!=10){
                        System.out.println("Please re-enter the 10dit Mobile No.");
                    }
                }while (10!=Mno.length());
                System.out.print("Create userId : ");
                String userId = sc.next();
                System.out.print("Create Password : ");
                String password = sc.next();

                if(obj.insertnewData(Name,userId,password,Address,Mno)){
                    System.out.println("Data Added Successfully..");
                }


            }
            else if(choice==2){
                //Old
                System.out.print("your Account num or userID : ");
                String id = sc.next();
                System.out.println("Your Password : ");
                String pass = sc.next();
                obj.checkLoginCustomer(id,pass);
                    //obj.LoginCustomer();

            }
            else if(choice==3){
                System.out.print("Enter username : ");
                String user = sc.next();
                System.out.print("Enter Password : ");
                String pass = sc.next();
                if(user.equals("admin")&&pass.equals("admin")){
                    obj.adminLogin();
                }
                else {
                    System.out.println("Wrong Password");
                }



            }



        }while (choice!=4);
        System.out.println("Thank You");

    }
}
