package com.stars.paint;

import android.content.Intent;
import android.media.MediaRecorder;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;

import java.io.File;
import java.io.IOException;

import static androidx.core.content.ContextCompat.startActivity;

public class MicrophoneAndColor {

    public static MediaRecorder mRecorder;
    public static final int RECORD_AUDIO = 0;


    public static void startRecorder() {
        if (mRecorder == null) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            File outputFile = null;
            try {
                outputFile = File.createTempFile("sound", ".3gp", Environment.getExternalStorageDirectory());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mRecorder.setOutputFile(outputFile.getPath());
            try {
                mRecorder.prepare();
            } catch (java.io.IOException ioe) {
                android.util.Log.e("[Monkey]", "IOException: " + android.util.Log.getStackTraceString(ioe));

            } catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " + android.util.Log.getStackTraceString(e));
            }
            try {
                mRecorder.start();
            } catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " + android.util.Log.getStackTraceString(e));
            }
        }
    }

    public static void stopRecorder() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

    public static double soundDb() {
        return 20 * Math.log10(getAmplitude());
    }

    public static double getAmplitude() {
        if (mRecorder != null)
            return (mRecorder.getMaxAmplitude());
        else
            return 0;

    }

    public static int chooseColor(double amplitude) {
        if (amplitude >= 15 && amplitude <= 25) {
            return Color.RED;
        } else if (amplitude >= 26 && amplitude <= 35) {
            return Color.YELLOW;
        } else if (amplitude >= 36 && amplitude <= 45) {
            return Color.GREEN;
        } else if (amplitude >= 46 && amplitude <= 55) {
            return Color.BLUE;
        } else if (amplitude >= 56 && amplitude <= 65) {
            return Color.MAGENTA;
        }
        return Color.BLACK;
    }
}