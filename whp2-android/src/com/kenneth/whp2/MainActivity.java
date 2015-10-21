package com.kenneth.whp2;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useWakelock = true;
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        cfg.useImmersiveMode = true;
        
        initialize(new Starter(), cfg);

 
    }
}