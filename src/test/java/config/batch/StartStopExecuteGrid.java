package config.batch;


import config.ConfigSettings;

import java.io.IOException;
import java.util.Properties;

public class StartStopExecuteGrid {
    //
    public static void main(String[] args) throws IOException, InterruptedException {
        Properties properties = ConfigSettings.getInstance();

        if(properties.getProperty("DefaultGridBatch").equalsIgnoreCase("false")){
            GridBatch.startGridBatch(properties.getProperty("GridBatchURL"));
            properties.setProperty("DefaultGridBatch","true");
        }else{
            GridBatch.endGridBatch();
            properties.setProperty("DefaultGridBatch","false");
        }
        ConfigSettings.saveProperty(properties);
        }

}


