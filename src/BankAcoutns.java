import java.util.Scanner;
import java.util.Vector;

class BankCustomerData{
    public String AcountNumber;
    private String Name;
    private String Address;
    public String userId;
    private String passWord;
    private String mobileNum;
    int cnt=0;
    class balance{

        private int bal;
        private int withdraw;
        private int deposit;
        public String history[][] = new String[5][2];

        balance(){
            bal=0;
        }
        public int getbal(){
            return bal;
        }
        public void setBal(int dep){
            this.bal = dep;
        }
        public void withdraw(int with){
            if(with>bal){
                System.out.println("No have any balance");
                return;
            }
            bal -=with;
            System.out.println("Withdraw Successfully");
            history[cnt][0] = String.valueOf(with);
            history[cnt][1] = "Withdraw";
            cnt++;
        }
        public void transfer(int amt,String accuntNum){
            bal-=amt;
            history[cnt][1] = "Transfer to "+accuntNum;
        }
    }



    BankCustomerData(long accountNum,String name,String Addr,String Mno,String userId,String passWord){

        this.AcountNumber = String.valueOf(accountNum);
        this.Name = name;
        this.Address = Addr;
        this.mobileNum = Mno;
        this.userId = userId;
        this.passWord = passWord;
        Display();


    }
    public void Display(){

        System.out.println("Account Number : "+AcountNumber);
        System.out.println("Account Holder Name : "+Name);
        System.out.println("Account UserId : "+userId);

    }
    public boolean checkLogin(String user,String pass){

        if(userId.equals(user)||AcountNumber.equals(user)){
            if(passWord.equals(pass)){
                return true;
            }
        }
        return false;
    }
}
public class BankAcoutns {

    public Vector<BankCustomerData> custData = new Vector<>();
    public Vector<BankCustomerData.balance> balData = new Vector<>();
    int accountNum=1234;
    int index;
    boolean acntNumValid(int acnt){

        for(int i=0;i<custData.size();i++){

            if(custData.get(i).AcountNumber.equals(String.valueOf(acnt))){
                index=i;
                return true;
            }

        }

        return false;
    }
    int getAcntNumIdex(){
        return index;
    }

    public boolean insertnewData(String name,String userId,String password,String Address,String Mno){

        BankCustomerData obj = new BankCustomerData(accountNum,name,Address,Mno,userId,password);
        BankCustomerData.balance bal = obj.new balance();
        custData.add(obj);
        balData.add(bal);

        accountNum*=2;

        return true;

    }
    public void checkLoginCustomer(String ID,String Pass){
        for(int i=0;i<custData.size();i++){
            if(custData.get(i).checkLogin(ID,Pass)){
                LoginCustomer(custData.get(i),i);
                return;
            }
        }

    }

    public void LoginCustomer(BankCustomerData obj,int index){
        Scanner sc = new Scanner(System.in);



        int choice;
        do {
            System.out.println("1.Account Balance");
            System.out.println("2.Deposit");
            System.out.println("3.WithDraw");
            System.out.println("4.Money Transfer");
            System.out.println("5.History");
            System.out.println("6.Exit");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Your Account Balance : " + balData.get(index).getbal());
            } else if (choice == 2) {
                System.out.println("Amount ?");
                int dep = sc.nextInt();
                balData.get(index).setBal(dep);
                System.out.println("Deposit Successfully");
                System.out.println("Your Account Balance : " + balData.get(index).getbal());
                balData.get(index).history[obj.cnt][0] = String.valueOf(dep);
                balData.get(index).history[obj.cnt][1] = "Deposit";
                obj.cnt++;


            } else if (choice == 3) {
                System.out.println("Withdraw Amount : ");
                int withdraw = sc.nextInt();
                balData.get(index).withdraw(withdraw);
                System.out.println("Your Account Balance : " + balData.get(index).getbal());

            }
            else if(choice==4){

                System.out.print("Account Number to transfer : ");
                int acnt = sc.nextInt();

                if(acntNumValid(acnt)){
                    System.out.print("Amount to transfer : ");
                    int amt = sc.nextInt();
                    if(balData.get(index).getbal()>=amt){
                        balData.get(getAcntNumIdex()).setBal(amt);
                        balData.get(index).transfer(amt, custData.get(getAcntNumIdex()).toString());
                        System.out.println("Transfer successfully");
                        System.out.println("Your Account Balance : " + balData.get(index).getbal());
                    }

                }
                else {
                    System.out.print("Invalid Account Number..");
                }


            }
            else if (choice == 5) {
                for (int i = 0; i < balData.get(index).history.length; i++) {
                    System.out.println(balData.get(index).history[i][0] + " " + balData.get(index).history[i][1]);
                }
            }
        }while (choice!=6);


    }
    public void adminLogin(){
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1.View all customers");
            System.out.println("2.View customers Data");
            System.out.println("3.?");
            System.out.println("4.Exit");
            ch = sc.nextInt();

            if(ch==1){
                System.out.println("   Customer Acnt Num      UserIds");
                for(int i=0;i<custData.size();i++){
                    System.out.println(i+1+ custData.get(i).AcountNumber+" "+custData.get(i).userId);
                }
            }
        }while (ch!=4);


    }




}
