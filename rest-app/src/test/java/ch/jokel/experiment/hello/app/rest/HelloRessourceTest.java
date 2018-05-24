package ch.jokel.experiment.hello.app.rest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class HelloRessourceTest {

    @Test
    void test() {
        assertThat(1 + 1, is(2));
    }

//    @Test
//    void hello_validResponse() {
//        HelloResource resource = new HelloResource();
//        assertThat(resource.hello(), notNullValue());
//    }
}
