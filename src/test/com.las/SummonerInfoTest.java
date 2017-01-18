import com.las.configuration.AppConfig;
import com.las.summoner.SummonerInfo;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by atlantis on 24/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SummonerInfoTest {

    @Autowired
    SummonerInfo summonerInfo;

    @Test
    public void should_return_summoner_if_called_with_name_Atlantis_Phantom_and_region_is_euw() {
        Summoner summoner = summonerInfo.getSummoner(Region.EUW, "Atlantis Phantom");

        Assert.assertNotNull("Summoner 'Atlantis Phantom' in EUW region should not be null", summoner);
    }
}
