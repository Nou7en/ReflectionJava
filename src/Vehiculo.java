import java.sql.SQLOutput;

public abstract class Vehiculo {
    public void arrancar(){
        System.out.println("Arrancar el Vehiculo");
    }
    public abstract void frenar();
}
