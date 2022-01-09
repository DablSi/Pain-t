package com.stars.paint;

import android.media.MediaRecorder;
import android.graphics.Color;
import android.media.MediaRecorder;

public class MicrophoneAndColor{

    MediaRecorder mRecorder;
public void startRecorder(){
        if (mRecorder == null)
        {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile("/dev/null");
            try
            {
                mRecorder.prepare();
            }catch (java.io.IOException ioe) {
                android.util.Log.e("[Monkey]", "IOException: " + android.util.Log.getStackTraceString(ioe));

            }catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " + android.util.Log.getStackTraceString(e));
            }
            try
            {
                mRecorder.start();
            }catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " + android.util.Log.getStackTraceString(e));
            }
        }
    }
    public void stopRecorder() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

    public double soundDb(double ampl){
        return  20 * Math.log10(getAmplitude() / ampl);
    }
    public double getAmplitude() {
        if (mRecorder != null)
            return  (mRecorder.getMaxAmplitude());
        else
            return 0;

    }
    public int ChooseColor(double amplitude){
        if (amplitude >= 15 && amplitude <= 25){
            return Color.RED;
        } else if(amplitude >= 26 && amplitude <= 35){
            return Color.YELLOW;
        } else if(amplitude >= 36 && amplitude <= 45){
            return Color.GREEN;
        } else if(amplitude >= 46 && amplitude <= 55){
            return Color.BLUE;
        } else if(amplitude >= 56 && amplitude <= 65){
            return Color.MAGENTA;
        }
        return Color.WHITE;
    }
}