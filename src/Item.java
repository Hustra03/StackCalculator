public class Item {
private ItemType type;
private int value = 0;

public Item(ItemType itemType,int value)
{
    this.type = itemType;
    this.value=value;
}

public ItemType getItemType()
{
    return this.type;
}

public int getValue()
{
    return this.value;
}
}