package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventStore.class.getName();

    static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(SerializationProxyV1.class);
            }
            if (readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(SerializationProxyV1.class);
            }
            return readClassDescriptor;
        }
    }

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
            } else {
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                readAndClearStore.addEvents(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair).getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    public static synchronized PersistedEvents readAndClearStore() {
        Closeable movedClassObjectInputStream;
        PersistedEvents persistedEvents;
        Closeable closeable;
        Throwable e;
        Closeable closeable2 = null;
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            Context applicationContext = FacebookSdk.getApplicationContext();
            try {
                movedClassObjectInputStream = new MovedClassObjectInputStream(new BufferedInputStream(applicationContext.openFileInput(PERSISTED_EVENTS_FILENAME)));
                try {
                    persistedEvents = (PersistedEvents) movedClassObjectInputStream.readObject();
                    Utility.closeQuietly(movedClassObjectInputStream);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Throwable e2) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", e2);
                    }
                } catch (FileNotFoundException e3) {
                    closeable = movedClassObjectInputStream;
                    Utility.closeQuietly(closeable);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        persistedEvents = null;
                    } catch (Throwable e4) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", e4);
                        persistedEvents = null;
                    }
                    if (persistedEvents == null) {
                        persistedEvents = new PersistedEvents();
                    }
                    return persistedEvents;
                } catch (Exception e5) {
                    e4 = e5;
                    try {
                        Log.w(TAG, "Got unexpected exception while reading events: ", e4);
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                            persistedEvents = null;
                        } catch (Throwable e42) {
                            Log.w(TAG, "Got unexpected exception when removing events file: ", e42);
                            persistedEvents = null;
                        }
                        if (persistedEvents == null) {
                            persistedEvents = new PersistedEvents();
                        }
                        return persistedEvents;
                    } catch (Throwable th) {
                        e42 = th;
                        closeable2 = movedClassObjectInputStream;
                        Utility.closeQuietly(closeable2);
                        try {
                            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        } catch (Throwable e22) {
                            Log.w(TAG, "Got unexpected exception when removing events file: ", e22);
                        }
                        throw e42;
                    }
                }
            } catch (FileNotFoundException e6) {
                closeable = null;
                Utility.closeQuietly(closeable);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                persistedEvents = null;
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
                return persistedEvents;
            } catch (Exception e7) {
                e42 = e7;
                movedClassObjectInputStream = null;
                Log.w(TAG, "Got unexpected exception while reading events: ", e42);
                Utility.closeQuietly(movedClassObjectInputStream);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                persistedEvents = null;
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
                return persistedEvents;
            } catch (Throwable th2) {
                e42 = th2;
                Utility.closeQuietly(closeable2);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                throw e42;
            }
            if (persistedEvents == null) {
                persistedEvents = new PersistedEvents();
            }
        }
        return persistedEvents;
    }

    private static void saveEventsToDisk(PersistedEvents persistedEvents) {
        Closeable objectOutputStream;
        Throwable e;
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", e);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e3) {
                    }
                    Utility.closeQuietly(objectOutputStream);
                } catch (Throwable th) {
                    e = th;
                    Utility.closeQuietly(objectOutputStream);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            objectOutputStream = null;
            Log.w(TAG, "Got unexpected exception while persisting events: ", e);
            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            Utility.closeQuietly(objectOutputStream);
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            Utility.closeQuietly(objectOutputStream);
            throw e;
        }
    }
}
