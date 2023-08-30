public class Cars {
    int id;
    String name;
    String type;
    String fuel;
    String price;
    int seater;
    
    public Cars(int id) {
        this.id = id;
    }
    public Cars(int id, String name, String type, String fuel, String price, int seater) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.price = price;
        this.seater = seater;
    }
     public Cars( String name, String type, String fuel, String price, int seater) {
        
        this.name = name;
        this.type = type;
        this.fuel = fuel;
        this.price = price;
        this.seater = seater;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFuel() {
        return fuel;
    }
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getSeater() {
        return seater;
    }
    public void setSeater(int seater) {
        this.seater = seater;
    }
    
}
