package com.las.summoner;

import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;

/**
 * Created by atlantis on 23/01/17.
 */
public interface SummonerInfo {

    Summoner getSummoner(Region region, String summonerName);
}
