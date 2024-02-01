package com.stingray.desinePattern.abstractFactory;

public class AbstractFactoryAPPS {
    public static void main(String[] args) {
        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
        Bank hdfc = bankFactory.getBank("HDFC");
        System.out.println(hdfc.getBankName());
    }
}
abstract class AbstractFactory{
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory {
    final static String icici ="ICICI";
    final static String sbi ="SBI";
    final static String hdfc ="HDFC";
    public Bank getBank(String bankName){
        if (bankName==null){
            return null;
        }

        switch (bankName){
            case hdfc: return new HDFC();
            case sbi: return new SBI();
            case icici: return new ICICI();
            default: return null;
        }
    }

    public  Loan getLoan(String loan){
        return null;
    };

}

class LoanFactory extends AbstractFactory {
    final static String educationLoan ="EDUCATION_LOAN";
    final static String businessLoan ="BUSINESS_LOAN";
    final static String houseLoan ="HOUSE_LOAN";
    public Loan getLoan(String loanType){
        if (loanType==null){
            return null;
        }

        switch (loanType){
            case educationLoan: return new EducationLoad();
            case businessLoan: return new BussinessLoan();
            case houseLoan: return new HomeLoan();
            default: return null;
        }
    }

    @Override
    public Bank getBank(String bank) {
        return null;
    }
}
interface  Bank{
    String getBankName();
}

class ICICI implements  Bank{
    @Override
    public String getBankName() {
        return getClass().getName();
    }
}

class HDFC implements  Bank{
    @Override
    public String getBankName() {
        return getClass().getName();
    }
}
class SBI implements  Bank{
    @Override
    public String getBankName() {
        return getClass().getName();
    }
}

abstract class Loan{
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanamount, int years){


        double EMI;
        int n;

        n=years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanamount+" you have borrowed");
    }
}

class HomeLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}//End of the HomeLoan class.

class BussinessLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }

}//End of the Busssiness Loan class.

class EducationLoad extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}//End of the Education loan class.

class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}//End of the FactoryCreator.