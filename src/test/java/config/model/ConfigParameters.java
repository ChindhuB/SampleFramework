/*Can design as model  / dto (Data Transfer Objective) package */
package config.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
/**
 * Class that encapsulates config parameters
 *
 * @author Chindhu Babu
 */
public class ConfigParameters {
    private String relativePath;
    private static final ConfigParameters CONFIG_PARAMETERS = new ConfigParameters();
    /**
     * Function to return the instance of the
     * {@link ConfigParameters} object
     *
     * @return Instance of the {@link ConfigParameters} object
     */

    public static ConfigParameters getInstance() {
        return CONFIG_PARAMETERS;
    }

}
