package interview;

public class CarFormap {
    String name;
    String color;

    public CarFormap(String name, String color) {
        this.name = name;
        this.color = color;
    }

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

    @Override
    public boolean equals(Object obj)
    {

        // if both the object references are
        // referring to the same object.
        if(this == obj)
            return true;

        // it checks if the argument is of the
        // type Geek by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        CarFormap geek = (CarFormap) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (geek.name.equals(this.name)  && geek.color.equals(this.color));
    }

    //@Override
    /*public int hashCode()
    {

        // We are returning the Geek_id
        // as a hashcode value.
        // we can also return some
        // other calculated value or may
        // be memory address of the
        // Object on which it is invoked.
        // it depends on how you implement
        // hashCode() method.
        return (this.getName().hashCode()+this.getColor().hashCode())*(-1);
    }*/

    @Override
    public final int hashCode() {
        int result = 17;
        if (this.getName() != null) {
            result = 31 * result + this.getName().hashCode();
        }
        if (this.getColor() != null) {
            result = 31 * result + this.getColor().hashCode();
        }
        return result;
    }
}
