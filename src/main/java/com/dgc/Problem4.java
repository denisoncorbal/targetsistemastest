package com.dgc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    private static final Problem4 problem = new Problem4();

    public static void solveProblem() {
        System.out.println(
                "Para descobrir qual interruptor controla qual lâmpada é necessário ligar um interruptor, aguardar um tempo para que a lâmpada que foi acesa por ele possa aquecer, então desligar esse interruptor e ligar um segundo interruptor. Dessa forma, ao visitar as salas com as lâmpadas aquela que estiver com a lâmpada acesa é controlada pelo segundo interruptor que foi deixado ligado. A sala que estiver com a lâmpada apagada e quente é a que o interruptor foi ligado e depois desligado e por isso ela está quente ainda. A que estiver com a lâmpada apagada e fria é controlada pelo interruptor que nunca foi ligado.");

        System.out.println("");
        System.out.println("Prova");
        System.out.println("Gerando uma conexão aleatória entre três interruptores e três lâmpadas");
        int interrupt1 = 0, interrupt2 = 0, interrupt3 = 0;
        List<Lamp> rooms = new ArrayList<>();
        rooms.add(problem.new Lamp("Lâmpada 1"));
        rooms.add(problem.new Lamp("Lâmpada 2"));
        rooms.add(problem.new Lamp("Lâmpada 3"));
        do {
            interrupt1 = (int) (Math.random() * 10);
        } while (interrupt1 < 1 || interrupt1 > 3);
        do {
            interrupt2 = (int) (Math.random() * 10);
        } while (interrupt2 < 1 || interrupt2 > 3 || interrupt2 == interrupt1);
        do {
            interrupt3 = (int) (Math.random() * 10);
        } while (interrupt3 < 1 || interrupt3 > 3 || interrupt3 == interrupt1 || interrupt3 == interrupt2);
        System.out.println("Inicialmente todos os interruptores estão apagados");
        System.out.println("Ligando um dos interruptores (1)");
        rooms.get(interrupt1 - 1).turnOnOff();
        System.out.println("Aguardando esquentar");
        System.out.println("Desligando o mesmo interruptor (1)");
        rooms.get(interrupt1 - 1).turnOnOff();
        System.out.println("Ligando um outro interruptor (2)");
        rooms.get(interrupt2 - 1).turnOnOff();
        System.out.println("Agora vamos visitar os quartos com as lâmpadas 1 e 2");
        System.out.println("O quarto com a lâmpada acesa é do interruptor ligado (2)");
        System.out.println("O quarto com a lâmpada apagada e fria é do interruptor que nunca foi ligado (3)");
        System.out.println(
                "O quarto com a lâmpada apagada e quente é do primeiro interruptor que foi ligado e depois desligado (1)");
        List<Boolean> status = new ArrayList<>();
        System.out.println("Visitando o quarto com a lâmpada 1");
        status = visitRoom(rooms, 0);
        System.out.println("O quarto com a lâmpada 1 está com a lâmpada " + (status.get(0) ? "ligada" : "desligada"));
        System.out.println("O quarto com a lâmpada 1 está com a lâmpada " + (status.get(1) ? "quente" : "fria"));
        System.out.println("Logo, o quarto com a lâmpada 1 está conectado ao interruptor " + findInterrupt(status));
        System.out.println("Visitando o quarto com a lâmpada 2");
        status = visitRoom(rooms, 1);
        System.out.println("O quarto com a lâmpada 2 está com a lâmpada " + (status.get(0) ? "ligada" : "desligada"));
        System.out.println("O quarto com a lâmpada 2 está com a lâmpada " + (status.get(1) ? "quente" : "fria"));
        System.out.println("Logo, o quarto com a lâmpada 2 está conectado ao interruptor " + findInterrupt(status));
        System.out.println("");
        System.out.println("Gabarito");
        System.out.println("Interruptor 1 é da lâmpada " + rooms.get(interrupt1 - 1).name);
        System.out.println("Interruptor 2 é da lâmpada " + rooms.get(interrupt2 - 1).name);
        System.out.println("Interruptor 3 é da lâmpada " + rooms.get(interrupt3 - 1).name);
    }

    private static List<Boolean> visitRoom(List<Lamp> rooms, int room) {
        return List.of(rooms.get(room).isOn, rooms.get(room).isHot);
    }

    private static int findInterrupt(List<Boolean> status) {
        if (status.get(0))
            return 2;
        if (status.get(1))
            return 1;
        return 3;
    }

    private class Lamp {
        String name;
        boolean isOn;
        boolean isHot;

        @Override
        public String toString() {
            return "Lamp [name=" + name + ", isOn=" + isOn + ", isHot=" + isHot + "]";
        }

        public Lamp(String name) {
            this.name = name;
            this.isOn = false;
        }

        public void turnOnOff() {
            this.isOn = !this.isOn;
            if (!this.isOn) {
                this.isHot = true;
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            sleep(Duration.ofMinutes(1));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        isHot = false;
                    }
                }.start();
            }
        }
    }
}
