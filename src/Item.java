public class Item {
private ItemType type;
private int value = 0;

private Item(ItemType itemType,int value)
{
    this.type = itemType;
    this.value=value;
}

public static Item Add()
{
    return new Item(ItemType.ADD,0);
}

public static Item Sub()
{
    return new Item(ItemType.SUB,0);
}
public static Item Mul()
{
    return new Item(ItemType.MUL,0);
}

public static Item Div()
{
    return new Item(ItemType.DIV,0);
}

public static Item Value(int value)
{
    return new Item(ItemType.VALUE,value);
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