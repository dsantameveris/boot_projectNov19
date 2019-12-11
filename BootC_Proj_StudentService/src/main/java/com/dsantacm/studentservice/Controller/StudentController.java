package com.dsantacm.studentservice.Controller;

import javax.validation.Valid;

import com.dsantacm.studentservice.Model.Student;
// import com.dsantacm.studentservice.Service.StudentService;
import com.dsantacm.studentservice.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
class StudentController {

    
    // Esta es un end point que jala el mensaje incluido en la configuracion del
    // Config Server, como prueba de que esta operando de manera adecuada.

    
    @GetMapping("/message")
    String getMessage() {
        return this.message;
    }

    // Este es la variable del mensaje a mostrar.
    @Value("${message: Hello default}")
    private String message;

    // Variable del repositorio. Tiene la anotacion Autowired para instanciarlo de
    // manera automatica.
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/hello")
     private Mono<String> helloMessage()
    {
        //This line creates a webclient(I think it is like a handler to retrieve info from another service) pointing to given URI
        WebClient client = WebClient.create("http://localhost:8012/hello");

        //.Get() method is declared to 'fetch' data from given URI.
        //.Retrieve() gets all data from ".get()"
        //.BodytoMono change data back to Mono<here your class>.
        return client.get()
                     .retrieve()
                     .bodyToMono(String.class);  
    }

    //Mapeo GET para jalar todos los studiantes. Usa flux para jalar multiple data.
    @GetMapping("/all")
    private Flux<Student> getAllStudent() {
        return studentRepository.findAll(); // Esta función es herencia de la extension de nuesto DAO con ReactiveMongo
    }

    // Mapeo Get que retorna un solo estudiante, por eso se usa MONO.
    @GetMapping("/id/{id}")
    private Mono<Student> getStudentById(@PathVariable("id") String studentID) {
        return studentRepository.findById(studentID);
    }

    // @GetMapping("/dni/{dni}")
    // private Mono<Student> getStudentByDNI(@PathVariable("dni") String studentDNI) {
    //     return studentRepository.findByDni(studentDNI);

    // }

    @PostMapping()
    public Mono<Student> addStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping()
    public Mono<Void> delAllStudent() {
        return studentRepository.deleteAll();
    }

    
}