package com.clinicflow.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.clinicflow.cli.scripts.interfaces.ICommandScript;
import java.util.*;

@Component
public class Runner implements CommandLineRunner {

    private final Map<String, ICommandScript> commandMap = new HashMap<>();

    public Runner(List<ICommandScript> scripts) {
        for (ICommandScript script : scripts) {
            commandMap.put(script.getName(), script);
        }
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            printAvailableCommands();
            return;
        }

        String command = args[0];
        ICommandScript script = commandMap.get(command);

        if ("all".equals(command)) {
            System.out.println("🚀 Executando todos os scripts...");
            commandMap.values().forEach(commandScript -> commandScript.run());
            return;
        }

        if (script != null) {
            System.out.println("⚙️ Executando script: " + command);
            script.run(Arrays.copyOfRange(args, 1, args.length));
        } else {
            System.out.println("❌ Comando desconhecido: " + command);
            printAvailableCommands();
        }
    }

    private void printAvailableCommands() {
        System.out.println("📜 Comandos disponíveis:");
        commandMap.keySet().forEach(cmd -> System.out.println("  - " + cmd));
    }
}
