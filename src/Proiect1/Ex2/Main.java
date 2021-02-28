package Proiect1.Ex2;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount.Builder(23).build();
        BankAccount bankAccount2 = new BankAccount.Builder(23).setName("Ion").build();
        BankAccount bankAccount3 = new BankAccount.Builder(23).setName("Pop").setAge(43).build();


        bankAccount1.print();
        bankAccount2.print();
        bankAccount3.print();


    }
}
