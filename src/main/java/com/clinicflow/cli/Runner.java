package com.clinicflow.cli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.clinicflow.cli.scripts.seed.SeedClinics;

@Component
public class Runner implements CommandLineRunner {

    private final SeedClinics seedScript;

    public Runner(SeedClinics seedScript) {
        this.seedScript = seedScript;
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) return;

        switch (args[0]) {
            case "seed" -> seedScript.run();
            default -> System.out.println("⚠️ Comando desconhecido: " + args[0]);
        }
    }
}
