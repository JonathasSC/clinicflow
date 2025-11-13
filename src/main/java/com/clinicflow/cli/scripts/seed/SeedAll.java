package com.clinicflow.cli.scripts.seed;
import java.util.List;

import org.springframework.stereotype.Component;
import com.clinicflow.cli.scripts.interfaces.ICommandScript;

@Component
public class SeedAll implements ICommandScript {
    private final List<ICommandScript> allScripts;

    public SeedAll(List<ICommandScript> allScripts) {
        this.allScripts = allScripts;
    }

    @Override
    public String getName() {
        return "all";
    }

    @Override
    public void run(String... args) {
        allScripts.forEach(ICommandScript::run);
    }
}
