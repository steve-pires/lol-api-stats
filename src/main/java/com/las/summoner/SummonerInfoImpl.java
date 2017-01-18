package com.las.summoner;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by atlantis on 23/01/17.
 */
public class SummonerInfoImpl implements SummonerInfo {

    private final RiotApi api;

    private static final Logger LOGGER = Logger.getLogger( SummonerInfoImpl.class.getName() );

    @Autowired
    public SummonerInfoImpl(RiotApi api) {
        this.api = api;
    }

    public Summoner getSummoner(Region region, String summonerName) {

        Summoner summoner = null;
        try {
            summoner = api.getSummonerByName(region, summonerName);
        } catch (RiotApiException e) {
            LOGGER.log(Level.INFO, "Could not retrieve summoner with name '" + summonerName + "' in region " + region.getName());
        }
        
        return summoner;
    }
}
