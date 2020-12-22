package app;

import app.estudante.Estudante;
import app.linkedList.DoubleLinkedList;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            Estudante student = new Estudante();
            linkedList.put(student.getMatricula(), student);
        }
        long endTime = System.nanoTime();
        
        long startTimeShow = System.nanoTime();
        System.out.println(linkedList.toString());
        System.out.println("Tempo de inicio: "+startTime);
        System.out.println("Tempo ao finalizar: "+endTime);
        System.out.println("Subtração: " + (endTime - startTime));
        System.out.println("Tempo em segundos: " + (endTime - startTime) / 1_000_000_000f);
        long endTimeShow = System.nanoTime();
        System.out.println("\nTempo show: "+ startTimeShow);
        System.out.println("Tempo ao finalizar show: "+endTimeShow);
        System.out.println("Subtração: " + (endTimeShow - startTimeShow));
        System.out.println("Tempo em segundos: " + (endTimeShow - startTimeShow) / 1_000_000_000f);
    }
}
