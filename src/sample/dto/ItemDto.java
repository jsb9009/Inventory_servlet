package sample.dto;

/**
 * Created by jaliya on 7/13/17.
 */

/**
 * encapsulation of item data
 */
public class ItemDto {

    private String itemNumber;
    private String itemName;
    private String itemType;


    public ItemDto(String itemNumber, String itemName, String itemType) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemType = itemType;
    }


    public String getItemNumber() {

        return this.itemNumber;
    }

    public String getItemName() {

        return this.itemName;
    }

    public String getItemType() {

        return this.itemType;
    }

}
