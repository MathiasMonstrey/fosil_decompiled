package com.fossil;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.Log;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.Ringtone;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class cns implements OnCompletionListener, OnPreparedListener {
    private static final String TAG = cns.class.getSimpleName();
    private static cns cAn;
    private int Pd = this.cAp.getStreamMaxVolume(4);
    private MediaPlayer cAo = new MediaPlayer();
    private AudioManager cAp = ((AudioManager) PortfolioApp.ZQ().getApplicationContext().getSystemService("audio"));
    private volatile boolean cAq;
    private volatile boolean cAr;
    private int cAs;
    private int cAt;
    private Runnable cAu = new C22331(this);
    private Handler timer = new Handler(PortfolioApp.ZQ().getMainLooper());

    class C22331 implements Runnable {
        final /* synthetic */ cns cAv;

        C22331(cns com_fossil_cns) {
            this.cAv = com_fossil_cns;
        }

        public void run() {
            if (this.cAv.cAo != null) {
                this.cAv.cAo.stop();
                if (this.cAv.cAr) {
                    this.cAv.ads();
                    this.cAv.cAp.setStreamVolume(4, this.cAv.cAs, 1);
                }
                Log.d(cns.TAG, "On play ringtone complete");
                this.cAv.cAq = false;
            }
        }
    }

    class C2234a implements Runnable {
        final /* synthetic */ cns cAv;
        private Ringtone cAw;
        private int cAx;

        C2234a(cns com_fossil_cns, Ringtone ringtone, int i) {
            this.cAv = com_fossil_cns;
            this.cAw = ringtone;
            this.cAx = i;
        }

        public void run() {
            this.cAv.m7254a(this.cAw, this.cAx, false);
        }
    }

    private cns() {
    }

    public static synchronized cns adq() {
        cns com_fossil_cns;
        synchronized (cns.class) {
            if (cAn == null) {
                cAn = new cns();
            }
            com_fossil_cns = cAn;
        }
        return com_fossil_cns;
    }

    public void m7260a(Ringtone ringtone) {
        m7261a(ringtone, 2);
    }

    public void m7261a(Ringtone ringtone, int i) {
        MFLogger.m12670d(TAG, "Inside " + TAG + ".playRingtone - ringtone=" + ringtone);
        if (ringtone != null) {
            this.cAr = true;
            if (this.cAo == null) {
                this.cAo = new MediaPlayer();
            }
            if (this.cAq) {
                MFLogger.m12670d(TAG, "On button stop ringtone event");
                ads();
                return;
            }
            MFLogger.m12670d(TAG, "On button play ringtone event");
            new Thread(new C2234a(this, ringtone, i)).start();
        }
    }

    public void m7262b(Ringtone ringtone) {
        if (ringtone != null) {
            if (this.cAo == null) {
                this.cAo = new MediaPlayer();
            }
            adr();
            new Thread(new C2234a(this, ringtone, 1)).start();
        }
    }

    public void adr() {
        if (this.cAo != null && this.cAo.isPlaying()) {
            MFLogger.m12670d(TAG, "On stop playing ringtone");
            this.cAo.stop();
            this.timer.removeCallbacks(this.cAu);
        }
        if (this.cAr) {
            this.cAp.setStreamVolume(4, this.cAs, 1);
            this.cAr = false;
        }
        this.cAq = false;
    }

    private synchronized void ads() {
        MFLogger.m12670d(TAG, "On release media event");
        if (this.cAq) {
            adr();
        }
        if (!this.cAr) {
            if (this.cAo != null) {
                this.cAo.reset();
                this.cAo.release();
                this.cAo = null;
            }
            this.cAr = false;
            this.cAq = false;
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.cAt > 0) {
            MFLogger.m12670d(TAG, "current loop is" + this.cAt);
            this.cAt--;
            this.cAo.seekTo(0);
            this.cAo.start();
            return;
        }
        this.cAo.stop();
        if (this.cAr) {
            ads();
            this.cAp.setStreamVolume(4, this.cAs, 1);
        }
        MFLogger.m12670d(TAG, "On play ringtone complete");
        this.cAq = false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.cAs = this.cAp.getStreamVolume(4);
        if (this.cAr) {
            this.cAp.setStreamVolume(4, this.Pd, 1);
        }
        this.cAo.start();
        this.timer.postDelayed(this.cAu, (long) (mediaPlayer.getDuration() * 2));
        this.cAq = true;
    }

    private void m7254a(Ringtone ringtone, int i, boolean z) {
        try {
            this.cAo.setOnPreparedListener(this);
            this.cAo.setOnCompletionListener(this);
            this.cAt = i - 1;
            MFLogger.m12671e(TAG, "Inside " + TAG + ".playRingtoneFromAsset - ringtone=" + ringtone.toRingtoneNameWithExtension());
            this.cAo.reset();
            if (TextUtils.isEmpty(ringtone.getId())) {
                InputStream open = PortfolioApp.ZQ().getAssets().open("ringtones/" + ringtone.toRingtoneNameWithExtension());
                File createTempFile = File.createTempFile("convertedFile", ".dat");
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                this.cAo.setDataSource(new FileInputStream(createTempFile).getFD());
            } else {
                this.cAo.setDataSource(PortfolioApp.ZQ(), Uri.parse(Media.INTERNAL_CONTENT_URI.toString().concat("/").concat(ringtone.getId())));
            }
            this.cAo.setAudioStreamType(4);
            this.cAo.prepare();
        } catch (FileNotFoundException e) {
            MFLogger.m12671e(TAG, "Error Inside " + TAG + ".playRingtoneFromAsset - Cant find ringtone, play default instead, ex=" + e.toString());
            Ringtone ringtone2 = new Ringtone(Constants.RINGTONE_DEFAULT, Constants.MP3_EXTENSION, -1, "");
            if (z) {
                MFLogger.m12671e(TAG, "Error Inside " + TAG + ".playRingtoneFromAsset - Cant find ringtone, play default instead");
            } else {
                m7254a(ringtone2, 2, true);
            }
        } catch (Exception e2) {
            MFLogger.m12671e(TAG, "Error when playing ringtone " + e2.toString());
        }
    }
}
