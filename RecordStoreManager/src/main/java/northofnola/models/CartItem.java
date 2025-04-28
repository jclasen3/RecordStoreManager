package northofnola.models;

import northofnola.models.Media;


public class CartItem {
    private Media media;
    private int quantity;
    
// Getters and Setters for CartItems
    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


