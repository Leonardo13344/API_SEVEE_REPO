package com.example.demo.controller;

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


@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class VotoRestFulControllerTest {


    volatile ApiSeveeRepoApplication app;

    volatile ConfigurableApplicationContext context;

    private VotoRestFulController votoController;

    @Test
    public void contextLoads() throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(VotoRestFulControllerTest.class.getSimpleName())
            .forks(1)
            .build();
        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        this.context = new SpringApplication(ApiSeveeRepoApplication.class).run();
        Object o = this.context.getBean(VotoRestFulController.class);
        votoController = (VotoRestFulController)o;
    }

    @TearDown
    public void tearDown(){
        this.context.close();
    }

    @Benchmark
    public void testMuestraListaVotosCandidatoGeneral() {
        this.votoController.muestraListaVotosCandidatoGeneral(false);
    }

    @Benchmark
    public void testVotoValidoSum() {
        this.votoController.votoValidoSum("false");
    }

    @Benchmark
    public void testVotosTotalGenero() {
        this.votoController.votosTotalGenero("false", "F");
    }
}
