public abstract class Communicator {
    private String model;
   
    public String getModel() {
        return model;
    }

    public void setsModel(String newModel) {
        model = newModel;
    }

    public abstract void communicate();
}
