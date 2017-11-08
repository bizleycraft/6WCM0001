public class Test
{
    public static void main(String[] args)
    {
        System.out.println("Booting up CCS");
        CCSImplementation ccs = new CCSImplementation();
        System.out.println("Creating new customer (should be assigned id 1)");
        ccs.addCustomer(ccs.getNewCustomerId(),"Joshua Bizley","St Aldridge, London","joshua@gmail.com","07979797979");
        System.out.println("Printing toString() of customer with id 1:");
        System.out.println(ccs.getCustomer(1).toString());
        System.out.println("Creating general complaint (should be assigned id 1)");
        ccs.addGeneralComplaint(ccs.getNewSubmissionId(),1,"Room smells.",new Date(3,3,2017));
        System.out.println("Printing toString() of submission with id 1:");
        System.out.println(ccs.getSubmission(1).toString());
    }
}