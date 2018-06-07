package android.support.v8.renderscript;

import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class BaseObj {
    private boolean mDestroyed = false;
    private long mID;
    RenderScript mRS;

    BaseObj(long j, RenderScript renderScript) {
        renderScript.validate();
        this.mRS = renderScript;
        this.mID = j;
    }

    void setID(long j) {
        if (this.mID != 0) {
            throw new RSRuntimeException("Internal Error, reset of object ID.");
        }
        this.mID = j;
    }

    long getID(RenderScript renderScript) {
        this.mRS.validate();
        if (this.mDestroyed) {
            throw new RSInvalidStateException("using a destroyed object.");
        } else if (this.mID == 0) {
            throw new RSRuntimeException("Internal error: Object id 0.");
        } else if (renderScript == null || renderScript == this.mRS) {
            return this.mID;
        } else {
            throw new RSInvalidStateException("using object with mismatched context.");
        }
    }

    android.renderscript.BaseObj getNObj() {
        return null;
    }

    void checkValid() {
        if (this.mID == 0 && getNObj() == null) {
            throw new RSIllegalArgumentException("Invalid object.");
        }
    }

    private void helpDestroy() {
        Object obj = 1;
        synchronized (this) {
            if (this.mDestroyed) {
                obj = null;
            } else {
                this.mDestroyed = true;
            }
        }
        if (obj != null) {
            ReadLock readLock = this.mRS.mRWLock.readLock();
            readLock.lock();
            if (this.mRS.isAlive()) {
                this.mRS.nObjDestroy(this.mID);
            }
            readLock.unlock();
            this.mRS = null;
            this.mID = 0;
        }
    }

    protected void finalize() throws Throwable {
        helpDestroy();
        super.finalize();
    }

    public void destroy() {
        if (this.mDestroyed) {
            throw new RSInvalidStateException("Object already destroyed.");
        }
        helpDestroy();
    }

    public int hashCode() {
        return (int) ((this.mID & 268435455) ^ (this.mID >> 32));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.mID != ((BaseObj) obj).mID) {
            return false;
        }
        return true;
    }
}
