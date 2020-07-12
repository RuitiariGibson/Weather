package network;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        Request request1=request.newBuilder().build();
        return chain.proceed(request1);
    }
}
