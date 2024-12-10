package com.example.awslambda;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;

public class LambdaHandler {
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(Application.class);
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }

    public AwsProxyResponse handleRequest(AwsProxyRequest request, Context context) {
        return handler.proxy(request, context);
    }
}
