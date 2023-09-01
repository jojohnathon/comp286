public class CellPhone extends Communicator{
    private long phoneNumber;
    private String owner;
    private boolean isSmartPhone;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isSmartPhone() {
        return isSmartPhone;
    }

    public void setSmartPhone(boolean isSmartPhone) {
        this.isSmartPhone = isSmartPhone;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void communicate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'communicate'");
    }

    public CellPhone(String model, String owner, long phoneNumber, boolean isSmartPhone) {
        
    }
    
}
