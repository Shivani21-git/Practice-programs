package interview;

public class CarForMap1 {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String name;
    String color;

    public CarForMap1(String name, String color) {
        this.name = name;
        this.color = color;
    }
    @Override
    public boolean equals(Object obj)
    {
       if(this==obj )
       {
           return true;
       }
       if(obj==null || obj.getClass()!=this.getClass())
       {
           return false;

       }
       CarForMap1 ob = (CarForMap1) obj;

       return (ob.name.equals(this.name)&& ob.color.equals(this.color));
    }
// @Override likhna jaroori hota hai , if you are overriding
    @Override
    public int hashCode() {
        int result = 17;
        if(this.getName()!=null)
        {
            result= 31*result+this.getName().hashCode();
        }
        if(this.getColor()!=null)
        {
            result= 31*result+this.getColor().hashCode();
        }
        return result;
    }

}
