package com.drifter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/costumers")
public class Main {

    private final CostumerRepository costumerRepository;

    public Main(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Costumer> getCostumers() {
        return costumerRepository.findAll();
    }

    public record NewCostumerRequest(
            String name,
            String email,
            Integer age
    ) {
    }

    @PostMapping
    public void addCostumer(@RequestBody NewCostumerRequest request) {
        Costumer costumer = new Costumer();
        costumer.setAge(request.age());
        costumer.setName(request.name());
        costumer.setEmail(request.email());
        costumerRepository.save(costumer);
    }

    @DeleteMapping("{costumerId}")
    public void deleteCostumer(@PathVariable("costumerId") Integer id){
        costumerRepository.deleteById(id);
    }

    @PutMapping("{costumerId}")
    public void putCostumer(@RequestBody NewCostumerRequest request, @PathVariable("costumerId") Integer id){
        costumerRepository.deleteById(id);
        Costumer costumer = new Costumer();
        costumer.setAge(request.age());
        costumer.setName(request.name());
        costumer.setEmail(request.email());
        costumerRepository.save(costumer);
    }

/*@GetMapping("/hello")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "Python", "C#"),
                new Person("Don", 23, 10000)
        );
        return response;
    }

    public record Person (String name, int age, double savings) {

    }

    public record GreetResponse (
            String greet,
            List<String> favoriteProgrammingLanguages,
            Person person
    ) {

    }
 */
}
