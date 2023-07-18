package hello.pratice.v1;

import hello.pratice.trace.HelloTraceV1;
import hello.pratice.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;

    private final HelloTraceV1 trace;



    @GetMapping("/p/v1/request")
    public String request(String itemId) {


        TraceStatus status = null;
        try {

            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        }

        catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
