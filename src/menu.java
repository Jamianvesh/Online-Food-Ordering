public class menu {
    private String item;
    private String price;
    public menu(String item,String price){
        this.item=item;
        this.price=price;
    }
    public String getItem(){
        return item;
    }
    public String getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return "Item:"+item+" , Price: ₹"+price;
    }
}
