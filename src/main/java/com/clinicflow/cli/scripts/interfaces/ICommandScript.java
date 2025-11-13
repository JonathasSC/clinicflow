package com.clinicflow.cli.scripts.interfaces;

public interface ICommandScript {
    String getName();
    void run(String... args); 
}
