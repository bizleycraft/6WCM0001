public interface CCS
{
    public abstract void addComment(int submissionId, int customerId, java.lang.String comment, Date date);
    public abstract void addCustomer(int customerId, java.lang.String name, java.lang.String address, java.lang.String email, java.lang.String phone);
    public abstract void addGeneralComplaint(int submissionId, int customerId, java.lang.String description, Date date);
    public abstract void addLiftComplaint(int submissionId, int customerId, java.lang.String description, java.lang.String lift, int floor, Date date);
    public abstract void addStaff(int staffId, java.lang.String name, java.lang.String role, java.lang.String department);
    public abstract void addStaffComplaint(int submissionId, int customerId, java.lang.String description, int staffId, Date date);
    public abstract void archiveSubmissions();
    public abstract void assignResolver(int complaintId, int staffId, Date deadLine);
    public abstract java.util.List<Action> getActionsForComplaint(int complaintId);
    public abstract Customer getCustomer(int customerId);
    public abstract java.util.List<Customer> getCustomerList();
    public abstract int getNewCustomerId();
    public abstract int getNewStaffId();
    public abstract int getNewSubmissionId();
    public abstract Staff getStaff(int staffId);
    public abstract java.util.List<Staff> getStaffList();
    public abstract Submission getSubmission(int submissionId);
    public abstract java.util.List<Submission> getSubmissionList();
    public abstract void recordAction(int complaintId, java.lang.String actionTaken, Date date);
    public abstract void recordComplaintResolved(int complaintId);
    public abstract void removeCustomer(int customerId);
}