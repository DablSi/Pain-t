package com.stars.paint;

import android.content.Context;
import android.os.PowerManager;

public class ProximityViaPowerManager {
    private Context context;
    private PowerManager.WakeLock proximityWakeLock;
    private String TAG = "PROXIMITY";

    public ProximityViaPowerManager(Context context) {
        this.context = context;
    }

    public boolean enableProximityWakeLock() {
        if (proximityWakeLock != null) {
            return true;
        }
        PowerManager powerManager =
                (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
        proximityWakeLock = powerManager.newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, TAG);
        proximityWakeLock.acquire(10*60*1000L /*10 minutes*/);
        return true;
    }

    public void disableProximityWakeLock() {
        if (proximityWakeLock != null) {
            proximityWakeLock.release();
            proximityWakeLock = null;
        }
    }
}
