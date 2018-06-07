package com.misfit.ble.obfuscated;

import com.misfit.ble.obfuscated.ba.C4463a;
import com.misfit.ble.obfuscated.ba.C4464b;
import com.misfit.ble.setting.sam.MultipleAlarmSettings;
import com.misfit.ble.shine.ShineActionID;
import com.misfit.ble.shine.ShineProfile.ActionResult;
import com.misfit.ble.shine.ShineProfile.ConfigurationCallback;
import com.misfit.ble.shine.ShineProfile.ResultCode;
import com.misfit.ble.shine.ShineProperty;
import com.misfit.ble.util.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class bj extends br {
    protected static final String TAG = LogUtils.m15475b(bj.class);
    private ConfigurationCallback gO;
    private List<MultipleAlarmSettings> hY;
    private long hZ = 0;
    private byte[] hd;

    public bj(C4463a c4463a, ConfigurationCallback configurationCallback, List<MultipleAlarmSettings> list) {
        super(ShineActionID.SET_MULTIPLE_ALARMS, "phaseSetMultipleAlarms", c4463a, null);
        this.gO = configurationCallback;
        this.hY = list;
        be();
    }

    public void start() {
        m14787c(mo4827a(em.class));
    }

    public void mo4821a(boolean z) {
        if (this.ho instanceof em) {
            bn();
        }
        super.mo4821a(z);
    }

    private void be() {
        byte size = (byte) (((this.hY.size() * 3) + 2) + 4);
        ByteBuffer allocate = ByteBuffer.allocate(size);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) 0);
        allocate.put(size);
        for (MultipleAlarmSettings multipleAlarmSettings : this.hY) {
            byte alarmHour = multipleAlarmSettings.getAlarmHour();
            byte f = (byte) ((hb.m15167f(multipleAlarmSettings.isAlarmRepeat()) << 7) | multipleAlarmSettings.getAlarmMinute());
            allocate.put(multipleAlarmSettings.getAlarmDay());
            allocate.put(f);
            allocate.put(alarmHour);
        }
        byte[] copyOfRange = Arrays.copyOfRange(allocate.array(), 0, allocate.array().length - 4);
        this.hZ = hd.m15176a(copyOfRange.length, copyOfRange);
        allocate.putInt(hb.m15168g(this.hZ));
        this.hd = allocate.array();
        this.iz = (long) this.hd.length;
    }

    public void mo4828a(int i, int i2, int i3) {
        if (i != 0) {
            m14820b(C4464b.RESULT_DATA_TRANSFER_FAILED);
        } else if (i3 >= i2) {
            if (!this.iC) {
                m14822e(this.ho);
            }
            bn();
        }
    }

    protected void mo4822b(ew ewVar, int i, ap apVar) {
        super.mo4822b(ewVar, i, apVar);
        if (i == 1) {
            m14820b(m14778a(apVar));
        } else if (i == 2) {
            m14820b(C4464b.RESULT_TIMED_OUT);
        } else if (i == 3) {
            m14820b(C4464b.RESULT_UNSUPPORTED);
        }
    }

    protected void mo4820a(ew ewVar, int i) {
        super.mo4820a(ewVar, i);
        if (i == 1) {
            m14820b(C4464b.RESULT_RECEIVE_RESPONSE_FAILED);
        } else if (i == 2) {
            m14820b(C4464b.RESULT_TIMED_OUT);
        } else if (ewVar instanceof em) {
            em emVar = (em) ewVar;
            if (emVar.cV().result != (byte) 0) {
                bn();
                m14820b(C4464b.RESULT_REQUEST_ERROR);
            } else if (emVar.mC) {
                m14820b(C4464b.RESULT_SUCCESS);
            } else {
                m14817a(new ck(this.hd));
            }
        }
    }

    protected ew mo4827a(Class<? extends ew> cls) {
        ew emVar;
        if (cls.equals(em.class)) {
            emVar = new em();
            emVar.m15069a((short) -24160, 0, (long) this.hd.length, (long) this.hd.length);
            return emVar;
        } else if (!cls.equals(cv.class)) {
            return null;
        } else {
            emVar = new cv();
            emVar.m15022c((short) -24160);
            return emVar;
        }
    }

    public Set<String> aI() {
        return new HashSet(Arrays.asList(new String[]{"3dda0003-957f-7d4a-34a6-74696673696d", "3dda0004-957f-7d4a-34a6-74696673696d"}));
    }

    public JSONObject aH() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (MultipleAlarmSettings toJSON : this.hY) {
                jSONArray.put(toJSON.toJSON());
            }
            jSONObject.put("multipleAlarmSettingsList", jSONArray);
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
        }
        return jSONObject;
    }

    protected Class<? extends ew> aO() {
        return cv.class;
    }

    protected void aP() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(ShineProperty.MULTIPLE_ALARMS_CRC, Long.valueOf(this.hZ));
        this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.SUCCEEDED, this.fT), hashtable);
    }

    protected void aQ() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(ShineProperty.MULTIPLE_ALARMS_CRC, Integer.valueOf(0));
        this.gO.onConfigCompleted(aR(), new ActionResult(ResultCode.FAILED, this.fT), hashtable);
    }

    protected boolean bf() {
        return false;
    }
}
