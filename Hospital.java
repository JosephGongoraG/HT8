import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Hospital {

    public static void main(String[] args) {

        VectorHeap<Paciente> cola = new VectorHeap<>();

        try {

            BufferedReader br =
                    new BufferedReader(new FileReader("pacientes.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(",");

                String nombre = partes[0].trim();
                String sintoma = partes[1].trim();
                String codigo = partes[2].trim();

                Paciente paciente =
                        new Paciente(nombre, sintoma, codigo);

                cola.add(paciente);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Orden de atención:");

        while (!cola.isEmpty()) {

            System.out.println(cola.remove());
        }
    }
}