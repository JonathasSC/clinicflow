package com.clinicflow.cli.scripts.seed;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.clinicflow.repositories.ClinicRepository;
import com.clinicflow.models.business.Clinic;
import com.clinicflow.cli.scripts.interfaces.ICommandScript;
import com.clinicflow.models.Address;

@Component
public class SeedPatients implements ICommandScript {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public String getName() {
        return "patients";
    }

    public void run(String... args){
        try { 
            System.out.println("🌱 Populando o banco com dados iniciais...");
    
            if (clinicRepository.count() > 0) {
                System.out.println("⚠️ Já existem clínicas cadastradas. Ignorando seed.");
                return;
            }
    
            List<Clinic> clinics = List.of(
                Clinic.builder()
                    .name("Clínica Vida Saudável")
                    .tenantId(UUID.randomUUID())
                    .address(Address.builder()
                        .street("Rua das Flores")
                        .number("123")
                        .neighborhood("Centro")
                        .city("São Paulo")
                        .state("SP")
                        .zipCode("12348")
                        .build())
                    .build(),
    
                Clinic.builder()
                    .name("Clínica Bem Estar")
                    .tenantId(UUID.randomUUID())
                    .address(Address.builder()
                        .street("Avenida Brasil")
                        .number("456")
                        .neighborhood("Jardins")
                        .city("Rio de Janeiro")
                        .state("RJ")
                        .zipCode("45612")
                        .build())
                    .build(),
    
                Clinic.builder()
                    .name("Clínica Saúde Total")
                    .tenantId(UUID.randomUUID())
                    .address(Address.builder()
                        .street("Rua da Paz")
                        .number("789")
                        .neighborhood("Boa Vista")
                        .city("Belo Horizonte")
                        .state("MG")
                        .zipCode("78945")
                        .build())
                    .build()
            );
    
            clinicRepository.saveAll(clinics);
            System.out.println("✅ Clínicas iniciais inseridas com sucesso!");
            
        } catch (Exception e) {
            System.err.println("❌ Erro ao executar seed do banco:");
            e.printStackTrace();
            
        } finally {
            System.out.println("🏁 Seed finalizado.");
        }
    };
}
