package hello.advanced.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;

    private final TraceTemplate template;

    @Autowired
    public OrderControllerV5(OrderServiceV5 orderServiceV5, LogTrace trace) {
        this.orderServiceV5 = orderServiceV5;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {

        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderServiceV5.orderItem(itemId);
                return "ok";
            }
        });


    }
}
