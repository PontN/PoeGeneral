package fr.epsi.petstore;

/**
 * Created by yannis on 13/07/16.
 */
public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("pending");


    private String statusName;
    PetStatus(String statusName) {
        this.statusName = statusName;
    }
}
