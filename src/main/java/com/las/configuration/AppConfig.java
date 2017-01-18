package com.las.configuration;

import com.las.summoner.SummonerInfo;
import com.las.summoner.SummonerInfoImpl;
import net.rithms.riot.api.RiotApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * Created by atlantis on 23/01/17.
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:riot-api.properties")
@ComponentScan(basePackages = "com.las.*")
public class AppConfig {


    @Value("${riot.api.key}")
    private String apiKey;

    @Value("${riot.api.url}")
    private String apiUrl;

    @Bean
    public RiotApi riotApi() {
        return new RiotApi(apiKey);
    }

    @Bean
    public SummonerInfo summonerInfo() {
        return new SummonerInfoImpl(riotApi());
    }
//
//    @Bean
//    public RiotApiAspect riotApiAspect() { return new RiotApiAspect(); }
}
