package Proiect1.Ex2;

public class BankAccount {
    private long accountNumber;
    private String name;
    private int age;
    private int pin;

    public BankAccount(Builder builder) {
       this.accountNumber=builder.accountNumber;
       this.age=builder.age;
       this.name=builder.name;
       this.pin=builder.pin;

    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public int getAge() {
        return age;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void print(){

        System.out.println("Account "+accountNumber+" Name :"+name+ " Age d"+ age+" Pin " +pin);
    }

    public static class Builder {

        private long accountNumber;
        private String name;
        private int age;
        private int pin;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAccountNumber(long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setPin(int pin) {
            this.pin = pin;
            return this;
        }

        public BankAccount build(){return new BankAccount(this);}

    }
}
