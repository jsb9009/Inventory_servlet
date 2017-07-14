package sample;

/**
 * Created by jaliya on 7/13/17.
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

    public void setItemNumber(String itemNo) {

        this.itemNumber = itemNo;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }


    public void setItemType(String itemType) {

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
