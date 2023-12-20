import java.util.*;
interface Bank {
    void balance();
    void transfer();
}

class ICICIBank implements Bank {

    @Override
    public void balance() {
        
        System.out.println("Check Balance of ICICI Bank");
    }

    @Override
    public void transfer() {
    
        System.out.println("Transfer Balance from ICICI Bank ");
    }
}

class SBIBank implements Bank {
    @Override
    public void balance() {
        
        System.out.println("Check Balance of SBI Bank");
    }
    @Override
    public void transfer() {
        
        System.out.println("Transfer Balance of SBI Bank");
    }
}
class HDFCBank implements Bank {
    @Override
    public void balance() {
        
        System.out.println("Check Balance of HDFC Bank");
    }
    @Override
    public void transfer() {
        
        System.out.println("Transfer Balance from HDFC Bank");
    }
}
class PNB implements Bank {
    @Override
    public void balance() {
        
        System.out.println("Check Balance of PNB Bank");
    }
    @Override
    public void transfer() {
        
        System.out.println("Transfer Balance from PNB Bank");
    }
}
class UserDetails{
    private String phoneNumber;
    private String name;
    private String bank;
  
       public void setName(String name){
           this.name=name;
       }
       public void setPhoneNumber(String phoneNumber){
           this.phoneNumber=phoneNumber;
       }
       public String getName(){
           return name;
       }
       public String getPhoneNumber(){
           return phoneNumber;
       }
        public void setBank(String bank){
           this.bank=bank;
       }
        public String getBank(){
           return bank;
       }
      
    }  

class UPIValidation {
     static UPIValidation instance;
     private UPIValidation(){
     }
    public static UPIValidation getInstance() {
        if (instance == null) {
            instance = new UPIValidation();
        }
        return instance;
    }
    public boolean isValidUPI(String upi) {
        boolean b=false;
        if(upi.length()==6){
            for(int i=0;i<upi.length();i++){
                if(upi.charAt(i)<'0' || upi.charAt(i)>'9'){
                 b=false;
                 break;
            }
            else{
                b=true;
            }
        }
        }
        return b;
        
    }
    
}
class BankFactory {
    public static boolean validPhoneNumber(String phone){
        boolean b=true;
        if(phone!=null && phone.length()==10){
            for(int i=0;i<phone.length();i++){
            if((phone.charAt(0)!='6'&&phone.charAt(0)!='9'&&phone.charAt(0)!='7'&&phone.charAt(0)!='8') || phone.charAt(i)<'0' || phone.charAt(i)>'9'){
                b=false;
                break;
            }
        }
    }
   if(phone.length()!=10){
       b=false;
   }
    
    return b;
    }
    public static String phoneNumber(){
       boolean b=false;
       String z="";
       while(!b){
           Scanner sc=new Scanner(System.in);
           System.out.print("Enter Phone Number: ");
           String phoneNo=sc.next();
           b=validPhoneNumber(phoneNo);
           if(!b)
           System.out.println("Invalid Phone Number. Try Again");
          else
          z=phoneNo;
       }
       return z; 
    }
    public static Bank createBank() {
        Scanner sc=new Scanner(System.in);
        System.out.println("=======Enter Your Details=======");
        System.out.print("Enter your Name:");
        String name=sc.nextLine();
        // System.out.print("Enter phone Number:");
        // String phoneNo=sc.next();
       String k= phoneNumber();
        System.out.print("Enter Bank Name:");
        String bankName=sc.next();
        System.out.print("Enter UPI PIN:");
        String upiPin=sc.next();
        UserDetails e1=new UserDetails();
         e1.setName(name);
        e1.setPhoneNumber(k);
        e1.setBank(bankName);
        System.out.println("======User Details======");
        System.out.println("Name of User is: "+e1.getName());
        System.out.println("Phone Number of User is: "+e1.getPhoneNumber());
        System.out.println("Bank Name is: "+e1.getBank());
        Bank bank = null;
        UPIValidation valid = UPIValidation.getInstance();
        if (valid.isValidUPI(upiPin)) {
            if (bankName.equals("ICICI")) {
                bank = new ICICIBank();
            } else if (bankName.equals("SBI")) {
                bank = new SBIBank();
            } else if (bankName.equals("HDFC")) {
                bank = new HDFCBank();
            }
            else if(bankName.equals("PNB")){
                bank=new PNB();
            }
            else {
                System.out.println("Invalid bank name");
            }
        } else {
            System.out.println("Invalid UPI pin");
        }
        
        return bank;
    }
}

public class Project {
    public static void main(String[] args) {
        Bank ref1 =BankFactory.createBank();
        if(ref1!=null){
        ref1.balance();
        ref1.transfer();
        
        }
    }
}