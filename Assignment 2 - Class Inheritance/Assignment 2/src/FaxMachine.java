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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'communicate'");
    }
    
}
