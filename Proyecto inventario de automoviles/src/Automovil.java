public class Automovil {
    // Atributos de la clase Automovil
    String placa;
    String marca;
    String modelo;
    double precio;
    int caballosDeFuerza;

    // Constructor para inicializar los atributos de Automovil
    public Automovil(String placa, String marca, String modelo, double precio, int caballosDeFuerza) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.caballosDeFuerza = caballosDeFuerza;
    }

    // Método toString para representar el objeto Coche como una cadena de texto
    @Override
    public String toString() {
        return "Marca='" + marca + '\'' +
                    ", Modelo='" + modelo + '\'' +
                    ", Caballos de fuerza=" + caballosDeFuerza +
                    ", Precio=" + precio +
                    ", Placa='" + placa + '\'';
    }
}
