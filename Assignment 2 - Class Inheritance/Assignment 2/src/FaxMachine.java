/* 
 * Johnathon Zheng
 * 8/31/23
 */
public class FaxMachine extends Communicator {
    private long FaxNumber;
    
    public long getFaxNumber() {
        return FaxNumber;
    }

    public void setFaxNumber(long faxNumber) {
        FaxNumber = faxNumber;
    }
    
    @Override
    public void communicate() {
        System.out.println("Sending data to " +  getModel());
    }

    //override setter method for model in Communicator
    @Override
    public void setsModel(String model) {
        super.setsModel("Fax:" + model);
    }

    public FaxMachine(long faxNumber) {
        super.setsModel("Fax Machine");
        this.FaxNumber = faxNumber;
    }
    
}
