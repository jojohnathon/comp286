//Johnathon Zheng
//9/21/23

public class ProductDisplay<K,V,P> {
    K item1;
    V item2;
    P item3;

    public ProductDisplay(K product) {
        item1 = product;
    }

    public ProductDisplay(K product1, V product2, P product3) {
        item1 = product1;
        item2 = product2;
        item3 = product3;
    }

    public static void main(String args[]) {
        ProductDisplay<AudioFile,VideoFile,VideoFile> testDisplay = new ProductDisplay<>(
            new AudioFile("audio1"), 
            new VideoFile("video1"), 
            new VideoFile("video2"));
    }
    
    /*(f) TODO Contemplate: 

    */
}
