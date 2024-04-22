import java.lang.reflect.Method;
public class Main {
    public static void main(String[] args){
        Vehiculo[] vehiculos = new Vehiculo[] { new Carro(), new Moto()};

        for(Vehiculo vehiculo: vehiculos){
            try {
                Method metodoArrancar = vehiculo.getClass().getMethod("arrancar");
                Method metodoFrenar = vehiculo.getClass().getMethod("frenar");
                metodoArrancar.invoke(vehiculo);
                metodoFrenar.invoke(vehiculo);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
