package hello.advanced.trace.hellorace;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import org.junit.jupiter.api.Test;


public class HelloTraceV1Test {


    @Test
    void begin_end() {
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus status = traceV1.begin("hello");
        traceV1.end(status);
    }


    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        trace.exception(status, new IllegalStateException());
    }


}
