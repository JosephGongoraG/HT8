import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void testAdd() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "Dolor", "C"));
        heap.add(new Paciente("Maria", "Apendicitis", "A"));

        assertEquals(2, heap.size());
    }

    @Test
    public void testRemove() {

        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "Dolor", "C"));
        heap.add(new Paciente("Maria", "Apendicitis", "A"));
        heap.add(new Paciente("Pedro", "Fiebre", "B"));

        Paciente primero = heap.remove();

        assertEquals("Maria", primero.getNombre());
    }
}