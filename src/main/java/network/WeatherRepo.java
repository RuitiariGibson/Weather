package network;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import model.WoeidResponse;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherRepo {
    private final ApiService apiService;
    @Inject
    public WeatherRepo(ApiService apiService){
        this.apiService=apiService;
    }

    /**
     * TODO: find a way to dynamically get the user's location
     * This method is responsible for fetching the data from the api
     * We use a scheduler to offload the work into an I/O thread. <p>
     * The executor service ensures we have fine grained control of when the background thread <br>
     * Will shut down. Since we are the work is done on the background thread we need to ensure the results are received on the main thread.
     * To do this we use {@code blockingSubscribe} which blocks the main thread until we get the results. This imitates kotlin coroutines {@code runBlocking}
     * </p>
     * @return ConcurrentHashMap
     */
    public ConcurrentHashMap<String,Object> fetchWeatherUpdates() {
    String location="nairobi";
    ExecutorService executorService= Executors.newSingleThreadExecutor();
    ConcurrentHashMap<String,Object>concurrentHashMap=new ConcurrentHashMap<>();
    try{
    Scheduler schedulers=Schedulers.from(executorService);
    apiService.getWoeid(location).subscribeOn(schedulers)
            .observeOn(schedulers)
            .doFinally(schedulers::shutdown)
            .doOnError(throwable -> schedulers.shutdown())
            .blockingSubscribe(new DisposableSingleObserver<List<WoeidResponse>>() {
                @Override
                public void onSuccess(@NonNull List<WoeidResponse> woeidResponses) {
                    apiService.getWeatherUpdates(woeidResponses.get(0).getWoeid()).subscribeOn(schedulers)
                            .observeOn(schedulers)
                            .doFinally(executorService::shutdown)
                            .blockingSubscribe(weatherResponse -> {
                                concurrentHashMap.put("success",true);
                                concurrentHashMap.put("today",weatherResponse.getWeatherUpdateClassList().get(0));
                                concurrentHashMap.put("tomorrow",weatherResponse.getWeatherUpdateClassList().get(1));
                                concurrentHashMap.put("dayAf",weatherResponse.getWeatherUpdateClassList().get(2));
                                executorService.shutdown();
                                schedulers.shutdown();
                            });
                }
                @Override
                public void onError(@NonNull Throwable e) {
                    schedulers.shutdown();
                    concurrentHashMap.put("success",false);
                    executorService.shutdown();
                }
            });
    }finally {
        executorService.shutdown();
    }
    return concurrentHashMap;
}

}



