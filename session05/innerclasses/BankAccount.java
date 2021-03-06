package innerclasses;

/**
 * Created by Sh-Java on 12/23/2016.
 */
public class BankAccount {
private  int x=0;
Acc acc;
    public class Money {

       private long dollars;
    private int cents;
         public Money(String stringAmount)
        {
           abortOnNull(stringAmount);
            int length = stringAmount.length();
            dollars = Long.parseLong(
                 stringAmount.substring(0, length - 3));
         cents = Integer.parseInt(
                 stringAmount.substring(length - 2, length));
             }
         public String getAmount()
    {
             if (cents > 9)
                 return (dollars + "." + cents);
                 else
         return (dollars + ".0" + cents);
        }
 public void addIn(Money secondAmount)
 {
     abortOnNull(secondAmount);
     int newCents = (cents + secondAmount.cents)%100;
      long carry = (cents + secondAmount.cents)/100;
     cents = newCents;
      dollars = dollars + secondAmount.dollars + carry;
      }
 private void abortOnNull(Object o)
 {
   if (o == null)
       {
          System.out.println("Unexpected null argument.");
          System.exit(0);
          }
      }
}





    private Money balance;
 public BankAccount()
 {
        balance = new Money("0.00");
    acc=new Acc();
acc.getX();
        }
 public String getBalance()
 {
         return balance.getAmount();
         }
 public void makeDeposit(String depositAmount)
 {
         balance.addIn( new Money(depositAmount));
         }
 public void closeAccount()
 {
         balance.dollars = 0;
         balance.cents = 0;
        }
}

 class Acc{
   private int x;

     public int getX() {
         return x;
     }

     public void setX(int x) {
         this.x = x;
     }
 }
