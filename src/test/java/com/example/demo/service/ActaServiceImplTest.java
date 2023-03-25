package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.ApiSeveeRepoApplication;

/**
 * BENCHMARKING CON JMH
 * Las anotaciones de aqui abajo definen iteraciones que se desea realizar, dejar por defecto en lo posible
 * Cambiar unicamente entre las clases el metodo benchmark(), los demas metodos hacen que funcione el programa
 * https://stackoverflow.com/questions/41438519/benchmarking-spring-boot-application-with-jmh, se baso de aqui
 * 
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class ActaServiceImplTest {

    volatile ApiSeveeRepoApplication app;

    volatile ConfigurableApplicationContext context;

    private IActaService actaService;

    @Test
    public void contextLoads() throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(ActaServiceImplTest.class.getSimpleName())
            .forks(1)
            .build();
        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        this.context = new SpringApplication(ApiSeveeRepoApplication.class).run();
        Object o = this.context.getBean(IActaService.class);
        actaService = (IActaService)o;
    }

    @TearDown
    public void tearDown(){
        this.context.close();
    }

    @Benchmark
    public void benchmark(){
        this.actaService.sumaVotoAusente("C");
    }

   
}
