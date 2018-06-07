package com.fossil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.ContactProviderImpl;
import com.fossil.wearables.fsl.contact.EmailAddress;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.table.TableUtils;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class cop extends ContactProviderImpl {
    public static final String TAG = cop.class.getSimpleName();
    private final String cBh = "contactgroup";

    class C22621 implements UpgradeCommand {
        final /* synthetic */ cop cBi;

        C22621(cop com_fossil_cop) {
            this.cBi = com_fossil_cop;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            MFLogger.m12670d(cop.TAG, " ---- UPGRADE DB ENTOURAGE, table CONTACTGROUP");
            sQLiteDatabase.execSQL("ALTER TABLE contactgroup ADD COLUMN deviceFamily int");
            MFLogger.m12670d(cop.TAG, " ---- UPGRADE DB ENTOURAGE, table CONTACTGROUP SUCCESS");
            StringBuilder stringBuilder = new StringBuilder();
            Object aaa = PortfolioApp.ZQ().aaa();
            if (TextUtils.isEmpty(aaa)) {
                this.cBi.removeAllContactGroups();
                return;
            }
            stringBuilder.append("UPDATE ").append("contactgroup").append(" SET deviceFamily = ").append(DeviceIdentityUtils.getDeviceFamily(aaa).ordinal());
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }
    }

    class C22632 implements UpgradeCommand {
        final /* synthetic */ cop cBi;

        C22632(cop com_fossil_cop) {
            this.cBi = com_fossil_cop;
        }

        public void execute(SQLiteDatabase sQLiteDatabase) {
            try {
                int i;
                MFLogger.m12670d(cop.TAG, "Inside .doInBackground upgrade contact");
                List a = this.cBi.m7384a(sQLiteDatabase);
                Cursor query = sQLiteDatabase.query(true, "contactgroup", new String[]{"id", BaseFeatureModel.COLUMN_COLOR, "name", BaseFeatureModel.COLUMN_HAPTIC, "timestamp", BaseFeatureModel.COLUMN_ENABLED, "deviceFamily"}, null, null, null, null, null, null);
                List<ContactGroup> arrayList = new ArrayList();
                String aaa = PortfolioApp.ZQ().aaa();
                if (TextUtils.isEmpty(aaa)) {
                    i = -1;
                } else {
                    i = DeviceHelper.getDeviceFamily(aaa).getValue();
                }
                if (query != null && i > 0 && DeviceHelper.gf(aaa)) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        String string = query.getString(query.getColumnIndex(BaseFeatureModel.COLUMN_COLOR));
                        aaa = query.getString(query.getColumnIndex("name"));
                        String string2 = query.getString(query.getColumnIndex(BaseFeatureModel.COLUMN_HAPTIC));
                        int i2 = query.getInt(query.getColumnIndex("timestamp"));
                        int i3 = query.getInt(query.getColumnIndex(BaseFeatureModel.COLUMN_ENABLED));
                        int i4 = query.getInt(query.getColumnIndex("deviceFamily"));
                        int i5 = query.getInt(query.getColumnIndex("id"));
                        if (i4 == i) {
                            ContactGroup contactGroup = new ContactGroup();
                            contactGroup.setColor(string);
                            contactGroup.setName(aaa);
                            contactGroup.setHaptic(string2);
                            contactGroup.setTimestamp((long) i2);
                            contactGroup.setEnabled(i3 == 1);
                            contactGroup.setDeviceFamily(i4);
                            contactGroup.setDbRowId(i5);
                            if (!(a == null || a.isEmpty())) {
                                int a2 = this.cBi.m7389d(a, contactGroup.getDbRowId());
                                if (a2 > 0) {
                                    MFLogger.m12670d(cop.TAG, "Find contact, contactId=" + a2);
                                    cos aA = cnq.acd().acy().aA(String.valueOf(a2), MFDeviceFamily.fromInt(i4).toString());
                                    if (aA != null) {
                                        contactGroup.setHour(aA.getHour());
                                        contactGroup.setVibrationOnly(aA.isVibrationOnly());
                                    }
                                }
                            }
                            MFLogger.m12670d(cop.TAG, "Add contact=" + contactGroup);
                            if (!contactGroup.isVibrationOnly()) {
                                arrayList.add(contactGroup);
                            }
                        }
                        query.moveToNext();
                    }
                    query.close();
                }
                sQLiteDatabase.execSQL("CREATE TABLE contactgroup_copy (id INTEGER PRIMARY KEY AUTOINCREMENT, color VARCHAR, haptic VARCHAR, timestamp BIGINT, enabled INTEGER, name VARCHAR, deviceFamily INTEGER, hour INTEGER, isVibrationOnly INTEGER);");
                if (!arrayList.isEmpty()) {
                    for (ContactGroup contactGroup2 : arrayList) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(BaseFeatureModel.COLUMN_COLOR, contactGroup2.getColor());
                        contentValues.put(BaseFeatureModel.COLUMN_HAPTIC, contactGroup2.getHaptic());
                        contentValues.put("timestamp", Long.valueOf(contactGroup2.getTimestamp()));
                        contentValues.put("name", contactGroup2.getName());
                        contentValues.put(BaseFeatureModel.COLUMN_ENABLED, Boolean.valueOf(contactGroup2.isEnabled()));
                        contentValues.put("deviceFamily", Integer.valueOf(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue()));
                        contentValues.put(AppFilter.COLUMN_HOUR, Integer.valueOf(contactGroup2.getHour()));
                        contentValues.put(AppFilter.COLUMN_IS_VIBRATION_ONLY, Boolean.valueOf(contactGroup2.isVibrationOnly()));
                        contentValues.put("id", Integer.valueOf(contactGroup2.getDbRowId()));
                        sQLiteDatabase.insert("contactgroup_copy", null, contentValues);
                    }
                }
                sQLiteDatabase.execSQL("DROP TABLE contactgroup;");
                sQLiteDatabase.execSQL("ALTER TABLE contactgroup_copy RENAME TO contactgroup;");
                MFLogger.m12670d(cop.TAG, "Migration complete");
            } catch (Exception e) {
                MFLogger.m12671e(cop.TAG, "Error inside " + cop.TAG + ".upgrade - e=" + e);
            }
        }
    }

    class C22683 implements UpgradeCommand {
        final /* synthetic */ cop cBi;

        class C22641 implements Callable<Boolean> {
            final /* synthetic */ SQLiteDatabase cBj;
            final /* synthetic */ List cBk;
            final /* synthetic */ C22683 cBl;

            C22641(C22683 c22683, SQLiteDatabase sQLiteDatabase, List list) {
                this.cBl = c22683;
                this.cBj = sQLiteDatabase;
                this.cBk = list;
            }

            public /* synthetic */ Object call() throws Exception {
                return xT();
            }

            public Boolean xT() throws Exception {
                try {
                    this.cBj.execSQL("CREATE TABLE unique_contact (id INTEGER PRIMARY KEY AUTOINCREMENT, firstName VARCHAR, lastName VARCHAR, contactId BIGINT, companyName VARCHAR, photoThumbUri VARCHAR, useCall INTEGER, useEmail INTEGER, useSms INTEGER, contact_group_id INTEGER);");
                    MFLogger.m12670d(cop.TAG, "Create new contact unique table complete, uniqueContactListSize=" + this.cBk.size());
                    for (Contact contact : this.cBk) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("id", Integer.valueOf(contact.getDbRowId()));
                        contentValues.put("firstname", contact.getFirstName());
                        contentValues.put(Constants.PROFILE_KEY_LAST_NAME, contact.getLastName());
                        contentValues.put("contactId", Integer.valueOf(contact.getContactId()));
                        contentValues.put("companyName", contact.getCompanyName());
                        contentValues.put("photoThumbUri", contact.getPhotoThumbUri());
                        contentValues.put("useCall", Boolean.valueOf(contact.isUseCall()));
                        contentValues.put("useEmail", Boolean.valueOf(contact.isUseEmail()));
                        contentValues.put("useSms", Boolean.valueOf(contact.isUseSms()));
                        contentValues.put("contact_group_id", Integer.valueOf(contact.getContactGroup().getDbRowId()));
                        MFLogger.m12670d(cop.TAG, "Put contact with contact id=" + contact.getDbRowId() + ", contactGroupId=" + contact.getContactGroup().getDbRowId());
                        this.cBj.insert("unique_contact", null, contentValues);
                    }
                    this.cBj.execSQL("DROP TABLE contact;");
                    this.cBj.execSQL("ALTER TABLE unique_contact RENAME TO contact;");
                    MFLogger.m12670d(cop.TAG, "Done remove duplicate for contact table");
                    return Boolean.valueOf(true);
                } catch (Exception e) {
                    MFLogger.m12671e(cop.TAG, "Exception when execute transaction put contact e=" + e);
                    return Boolean.valueOf(false);
                }
            }
        }

        class C22652 implements Callable<Boolean> {
            final /* synthetic */ SQLiteDatabase cBj;
            final /* synthetic */ C22683 cBl;
            final /* synthetic */ List cBm;

            C22652(C22683 c22683, SQLiteDatabase sQLiteDatabase, List list) {
                this.cBl = c22683;
                this.cBj = sQLiteDatabase;
                this.cBm = list;
            }

            public /* synthetic */ Object call() throws Exception {
                return xT();
            }

            public Boolean xT() throws Exception {
                try {
                    this.cBj.execSQL("CREATE TABLE unique_contactgroup (id INTEGER PRIMARY KEY AUTOINCREMENT, color VARCHAR, haptic VARCHAR, timestamp BIGINT, enabled INTEGER, name VARCHAR, deviceFamily INTEGER, hour INTEGER, isVibrationOnly INTEGER);");
                    MFLogger.m12670d(cop.TAG, "Create new contact group unique table complete, uniqueContactGroupListSize=" + this.cBm.size());
                    for (ContactGroup contactGroup : this.cBm) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(BaseFeatureModel.COLUMN_COLOR, contactGroup.getColor());
                        contentValues.put(BaseFeatureModel.COLUMN_HAPTIC, contactGroup.getHaptic());
                        contentValues.put("timestamp", Long.valueOf(contactGroup.getTimestamp()));
                        contentValues.put("name", contactGroup.getName());
                        contentValues.put(BaseFeatureModel.COLUMN_ENABLED, Boolean.valueOf(contactGroup.isEnabled()));
                        contentValues.put("deviceFamily", Integer.valueOf(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue()));
                        contentValues.put(AppFilter.COLUMN_HOUR, Integer.valueOf(contactGroup.getHour()));
                        contentValues.put(AppFilter.COLUMN_IS_VIBRATION_ONLY, Boolean.valueOf(contactGroup.isVibrationOnly()));
                        contentValues.put("id", Integer.valueOf(contactGroup.getDbRowId()));
                        MFLogger.m12670d(cop.TAG, "Put contact group with contact group id=" + contactGroup.getDbRowId());
                        this.cBj.insert("unique_contactgroup", null, contentValues);
                    }
                    this.cBj.execSQL("DROP TABLE contactgroup;");
                    this.cBj.execSQL("ALTER TABLE unique_contactgroup RENAME TO contactgroup;");
                    return Boolean.valueOf(true);
                } catch (Exception e) {
                    MFLogger.m12671e(cop.TAG, "Exception when execute put unique contact group, e=" + e);
                    return Boolean.valueOf(false);
                }
            }
        }

        class C22663 implements Callable<Boolean> {
            final /* synthetic */ SQLiteDatabase cBj;
            final /* synthetic */ C22683 cBl;
            final /* synthetic */ List cBn;

            C22663(C22683 c22683, SQLiteDatabase sQLiteDatabase, List list) {
                this.cBl = c22683;
                this.cBj = sQLiteDatabase;
                this.cBn = list;
            }

            public /* synthetic */ Object call() throws Exception {
                return xT();
            }

            public Boolean xT() throws Exception {
                try {
                    this.cBj.execSQL("CREATE TABLE unique_phone_number (id INTEGER PRIMARY KEY AUTOINCREMENT, phone_number_id INTEGER, number VARCHAR);");
                    for (PhoneNumber phoneNumber : this.cBn) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("id", Integer.valueOf(phoneNumber.getDbRowId()));
                        contentValues.put("phone_number_id", Integer.valueOf(phoneNumber.getContact().getDbRowId()));
                        contentValues.put("number", phoneNumber.getNumber());
                        MFLogger.m12670d(cop.TAG, "Put phone number with contact id=" + phoneNumber.getContact().getDbRowId() + ", id=" + phoneNumber.getDbRowId());
                        this.cBj.insert("unique_phone_number", null, contentValues);
                    }
                    this.cBj.execSQL("DROP TABLE phonenumber;");
                    this.cBj.execSQL("ALTER TABLE unique_phone_number RENAME TO phonenumber;");
                    return Boolean.valueOf(true);
                } catch (Exception e) {
                    MFLogger.m12671e(cop.TAG, "Exception when execute insert phone number, e=" + e);
                    return Boolean.valueOf(false);
                }
            }
        }

        class C22674 implements Callable<Boolean> {
            final /* synthetic */ C22683 cBl;

            C22674(C22683 c22683) {
                this.cBl = c22683;
            }

            public /* synthetic */ Object call() throws Exception {
                return xT();
            }

            public Boolean xT() throws Exception {
                try {
                    TableUtils.clearTable(this.cBl.cBi.databaseHelper.getConnectionSource(), EmailAddress.class);
                    return Boolean.valueOf(true);
                } catch (Exception e) {
                    MFLogger.m12671e(cop.TAG, "Exception when drop email address table, e=" + e);
                    return Boolean.valueOf(false);
                }
            }
        }

        public void execute(android.database.sqlite.SQLiteDatabase r14) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:54:0x0233 in {10, 13, 16, 18, 23, 24, 25, 30, 40, 43, 45, 52, 56, 59, 60, 65, 74, 80, 87, 89, 91, 92, 94, 99, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r13 = this;
            r0 = com.fossil.cop.TAG;
            r1 = "------- Enter upgrade database version 5 --------";
            com.misfit.frameworks.common.log.MFLogger.m12672i(r0, r1);
            r0 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x0220 }
            r1 = "------- Start upgrade database version 5 --------";	 Catch:{ Exception -> 0x0220 }
            com.misfit.frameworks.common.log.MFLogger.m12672i(r0, r1);	 Catch:{ Exception -> 0x0220 }
            r1 = 1;	 Catch:{ Exception -> 0x0220 }
            r2 = "contact";	 Catch:{ Exception -> 0x0220 }
            r0 = 10;	 Catch:{ Exception -> 0x0220 }
            r3 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0220 }
            r0 = 0;	 Catch:{ Exception -> 0x0220 }
            r4 = "id";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 1;	 Catch:{ Exception -> 0x0220 }
            r4 = "firstName";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 2;	 Catch:{ Exception -> 0x0220 }
            r4 = "lastName";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 3;	 Catch:{ Exception -> 0x0220 }
            r4 = "contactId";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 4;	 Catch:{ Exception -> 0x0220 }
            r4 = "companyName";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 5;	 Catch:{ Exception -> 0x0220 }
            r4 = "photoThumbUri";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 6;	 Catch:{ Exception -> 0x0220 }
            r4 = "useCall";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 7;	 Catch:{ Exception -> 0x0220 }
            r4 = "useEmail";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 8;	 Catch:{ Exception -> 0x0220 }
            r4 = "useSms";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r0 = 9;	 Catch:{ Exception -> 0x0220 }
            r4 = "contact_group_id";	 Catch:{ Exception -> 0x0220 }
            r3[r0] = r4;	 Catch:{ Exception -> 0x0220 }
            r4 = 0;	 Catch:{ Exception -> 0x0220 }
            r5 = 0;	 Catch:{ Exception -> 0x0220 }
            r6 = "contactId";	 Catch:{ Exception -> 0x0220 }
            r7 = 0;	 Catch:{ Exception -> 0x0220 }
            r8 = 0;	 Catch:{ Exception -> 0x0220 }
            r9 = 0;	 Catch:{ Exception -> 0x0220 }
            r0 = r14;	 Catch:{ Exception -> 0x0220 }
            r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0220 }
            r0 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x0220 }
            r2 = "Query cursor for contact success";	 Catch:{ Exception -> 0x0220 }
            com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r2);	 Catch:{ Exception -> 0x0220 }
            r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0220 }
            r2.<init>();	 Catch:{ Exception -> 0x0220 }
            if (r1 == 0) goto L_0x013a;	 Catch:{ Exception -> 0x0220 }
        L_0x0063:
            r1.moveToFirst();	 Catch:{ Exception -> 0x0220 }
        L_0x0066:
            r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            if (r0 != 0) goto L_0x0137;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x006c:
            r0 = "id";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r3 = r1.getInt(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = "firstName";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = r1.getString(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r4 = "lastName";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r4 = r1.getString(r4);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r5 = "contactId";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r5 = r1.getColumnIndex(r5);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r5 = r1.getInt(r5);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r6 = "companyName";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r6 = r1.getColumnIndex(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r6 = r1.getString(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r7 = "photoThumbUri";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r7 = r1.getString(r7);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r8 = "useCall";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r8 = r1.getColumnIndex(r8);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r8 = r1.getInt(r8);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r9 = "useEmail";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r9 = r1.getColumnIndex(r9);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r9 = r1.getInt(r9);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r10 = "useSms";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r10 = r1.getColumnIndex(r10);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r10 = r1.getInt(r10);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r11 = "contact_group_id";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r11 = r1.getColumnIndex(r11);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r11 = r1.getInt(r11);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12 = new com.fossil.wearables.fsl.contact.Contact;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.<init>();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setContactId(r5);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setLastName(r4);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setFirstName(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setCompanyName(r6);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setPhotoThumbUri(r7);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = 1;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            if (r8 != r0) goto L_0x0131;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x00e7:
            r0 = 1;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x00e8:
            r12.setUseCall(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = 1;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            if (r9 != r0) goto L_0x0133;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x00ee:
            r0 = 1;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x00ef:
            r12.setUseEmail(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = 1;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            if (r10 != r0) goto L_0x0135;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x00f5:
            r0 = 1;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
        L_0x00f6:
            r12.setUseSms(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = new com.fossil.wearables.fsl.contact.ContactGroup;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0.<init>();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0.setDbRowId(r11);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setContactGroup(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r12.setDbRowId(r3);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r2.add(r12);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r1.moveToNext();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            goto L_0x0066;
        L_0x010f:
            r0 = move-exception;
            r2 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r3.<init>();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r4 = "Exception when query cursor contact, e=";	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = r3.append(r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = r0.toString();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            com.misfit.frameworks.common.log.MFLogger.m12671e(r2, r0);	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0 = r13.cBi;	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r0.aes();	 Catch:{ Exception -> 0x010f, all -> 0x0232 }
            r1.close();
        L_0x0130:
            return;	 Catch:{ Exception -> 0x0220 }
        L_0x0131:
            r0 = 0;	 Catch:{ Exception -> 0x0220 }
            goto L_0x00e8;	 Catch:{ Exception -> 0x0220 }
        L_0x0133:
            r0 = 0;	 Catch:{ Exception -> 0x0220 }
            goto L_0x00ef;	 Catch:{ Exception -> 0x0220 }
        L_0x0135:
            r0 = 0;	 Catch:{ Exception -> 0x0220 }
            goto L_0x00f6;	 Catch:{ Exception -> 0x0220 }
        L_0x0137:
            r1.close();
        L_0x013a:
            r0 = r2.isEmpty();	 Catch:{ Exception -> 0x0220 }
            if (r0 != 0) goto L_0x0152;
        L_0x0140:
            r0 = r13.cBi;	 Catch:{ Exception -> 0x0237 }
            r0 = r0.databaseHelper;	 Catch:{ Exception -> 0x0237 }
            r0 = r0.getConnectionSource();	 Catch:{ Exception -> 0x0237 }
            r1 = new com.fossil.cop$3$1;	 Catch:{ Exception -> 0x0237 }
            r1.<init>(r13, r14, r2);	 Catch:{ Exception -> 0x0237 }
            com.j256.ormlite.misc.TransactionManager.callInTransaction(r0, r1);	 Catch:{ Exception -> 0x0237 }
        L_0x0152:
            r0 = "select contactgroup.id, contactgroup.color, contactgroup.deviceFamily, contactgroup.enabled, contactgroup.haptic, contactgroup.hour, contactgroup.isVibrationOnly, contactgroup.name, contactgroup.timestamp from contactgroup,contact where contact.contact_group_id = contactgroup.id";	 Catch:{ Exception -> 0x0220 }
            r1 = 0;	 Catch:{ Exception -> 0x0220 }
            r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0220 }
            r1 = r14.rawQuery(r0, r1);	 Catch:{ Exception -> 0x0220 }
            r0 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x0220 }
            r2 = "Query cursor for contact group success";	 Catch:{ Exception -> 0x0220 }
            com.misfit.frameworks.common.log.MFLogger.m12670d(r0, r2);	 Catch:{ Exception -> 0x0220 }
            r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0220 }
            r2.<init>();	 Catch:{ Exception -> 0x0220 }
            if (r1 == 0) goto L_0x0249;	 Catch:{ Exception -> 0x0220 }
        L_0x0169:
            r1.moveToFirst();	 Catch:{ Exception -> 0x0220 }
        L_0x016c:
            r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            if (r0 != 0) goto L_0x0246;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
        L_0x0172:
            r0 = "color";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = r1.getString(r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r3 = "name";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r3 = r1.getString(r3);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r4 = "haptic";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r4 = r1.getString(r4);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r5 = "timestamp";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r5 = r1.getColumnIndex(r5);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r5 = r1.getInt(r5);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r6 = "enabled";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r6 = r1.getColumnIndex(r6);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r6 = r1.getInt(r6);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r7 = "deviceFamily";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r7 = r1.getInt(r7);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r8 = "id";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r8 = r1.getColumnIndex(r8);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r8 = r1.getInt(r8);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r9 = "hour";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r9 = r1.getColumnIndex(r9);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r9 = r1.getInt(r9);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r10 = "isVibrationOnly";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r10 = r1.getColumnIndex(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r10 = r1.getInt(r10);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11 = new com.fossil.wearables.fsl.contact.ContactGroup;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.<init>();	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setColor(r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setName(r3);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setHaptic(r4);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r4 = (long) r5;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setTimestamp(r4);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = 1;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            if (r6 != r0) goto L_0x0242;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
        L_0x01e1:
            r0 = 1;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
        L_0x01e2:
            r11.setEnabled(r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setDeviceFamily(r7);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setDbRowId(r8);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r11.setHour(r9);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = 1;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            if (r10 != r0) goto L_0x0244;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
        L_0x01f1:
            r0 = 1;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
        L_0x01f2:
            r11.setVibrationOnly(r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r2.add(r11);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r1.moveToNext();	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            goto L_0x016c;
        L_0x01fd:
            r0 = move-exception;
            r2 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r3.<init>();	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r4 = "Exception when query cursor contact group, e=";	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = r3.append(r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = r0.toString();	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            com.misfit.frameworks.common.log.MFLogger.m12671e(r2, r0);	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0 = r13.cBi;	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r0.aes();	 Catch:{ Exception -> 0x01fd, all -> 0x02df }
            r1.close();
            goto L_0x0130;
        L_0x0220:
            r0 = move-exception;
            r0.printStackTrace();
            r0 = r13.cBi;
            r0.aes();
        L_0x0229:
            r0 = com.fossil.cop.TAG;
            r1 = "------- Exit upgrade database version 5 --------";
            com.misfit.frameworks.common.log.MFLogger.m12672i(r0, r1);
            goto L_0x0130;
        L_0x0232:
            r0 = move-exception;
            r1.close();	 Catch:{ Exception -> 0x0220 }
            throw r0;	 Catch:{ Exception -> 0x0220 }
        L_0x0237:
            r0 = move-exception;	 Catch:{ Exception -> 0x0220 }
            r0.printStackTrace();	 Catch:{ Exception -> 0x0220 }
            r0 = r13.cBi;	 Catch:{ Exception -> 0x0220 }
            r0.aes();	 Catch:{ Exception -> 0x0220 }
            goto L_0x0130;	 Catch:{ Exception -> 0x0220 }
        L_0x0242:
            r0 = 0;	 Catch:{ Exception -> 0x0220 }
            goto L_0x01e2;	 Catch:{ Exception -> 0x0220 }
        L_0x0244:
            r0 = 0;	 Catch:{ Exception -> 0x0220 }
            goto L_0x01f2;	 Catch:{ Exception -> 0x0220 }
        L_0x0246:
            r1.close();
        L_0x0249:
            r0 = r2.isEmpty();	 Catch:{ Exception -> 0x0220 }
            if (r0 != 0) goto L_0x0261;
        L_0x024f:
            r0 = r13.cBi;	 Catch:{ Exception -> 0x02e4 }
            r0 = r0.databaseHelper;	 Catch:{ Exception -> 0x02e4 }
            r0 = r0.getConnectionSource();	 Catch:{ Exception -> 0x02e4 }
            r1 = new com.fossil.cop$3$2;	 Catch:{ Exception -> 0x02e4 }
            r1.<init>(r13, r14, r2);	 Catch:{ Exception -> 0x02e4 }
            com.j256.ormlite.misc.TransactionManager.callInTransaction(r0, r1);	 Catch:{ Exception -> 0x02e4 }
        L_0x0261:
            r0 = "select phonenumber.id, phonenumber.number, phonenumber.phone_number_id from phonenumber,contact where contact.id = phonenumber.phone_number_id ";	 Catch:{ Exception -> 0x0220 }
            r1 = 0;	 Catch:{ Exception -> 0x0220 }
            r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0220 }
            r1 = r14.rawQuery(r0, r1);	 Catch:{ Exception -> 0x0220 }
            r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0220 }
            r0.<init>();	 Catch:{ Exception -> 0x0220 }
            r2 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x0220 }
            r3 = "Query cursor for phone number success";	 Catch:{ Exception -> 0x0220 }
            com.misfit.frameworks.common.log.MFLogger.m12670d(r2, r3);	 Catch:{ Exception -> 0x0220 }
            if (r1 == 0) goto L_0x02f2;	 Catch:{ Exception -> 0x0220 }
        L_0x0278:
            r1.moveToFirst();	 Catch:{ Exception -> 0x0220 }
        L_0x027b:
            r2 = r1.isAfterLast();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            if (r2 != 0) goto L_0x02ef;	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
        L_0x0281:
            r2 = "phone_number_id";	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2 = r1.getColumnIndex(r2);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r3 = "number";	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r3 = r1.getString(r3);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r4 = "id";	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r4 = r1.getInt(r4);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r5 = new com.fossil.wearables.fsl.contact.Contact;	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r5.<init>();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r5.setDbRowId(r2);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2 = new com.fossil.wearables.fsl.contact.PhoneNumber;	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2.<init>();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2.setDbRowId(r4);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2.setNumber(r3);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r2.setContact(r5);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r0.add(r2);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r1.moveToNext();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            goto L_0x027b;
        L_0x02bc:
            r0 = move-exception;
            r2 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r3.<init>();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r4 = "Exception when query cursor phone number, e=";	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r0 = r3.append(r0);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r0 = r0.toString();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            com.misfit.frameworks.common.log.MFLogger.m12671e(r2, r0);	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r0 = r13.cBi;	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r0.aes();	 Catch:{ Exception -> 0x02bc, all -> 0x0325 }
            r1.close();
            goto L_0x0130;	 Catch:{ Exception -> 0x0220 }
        L_0x02df:
            r0 = move-exception;	 Catch:{ Exception -> 0x0220 }
            r1.close();	 Catch:{ Exception -> 0x0220 }
            throw r0;	 Catch:{ Exception -> 0x0220 }
        L_0x02e4:
            r0 = move-exception;	 Catch:{ Exception -> 0x0220 }
            r0.printStackTrace();	 Catch:{ Exception -> 0x0220 }
            r0 = r13.cBi;	 Catch:{ Exception -> 0x0220 }
            r0.aes();	 Catch:{ Exception -> 0x0220 }
            goto L_0x0130;	 Catch:{ Exception -> 0x0220 }
        L_0x02ef:
            r1.close();
        L_0x02f2:
            r1 = r0.isEmpty();	 Catch:{ Exception -> 0x0220 }
            if (r1 != 0) goto L_0x030a;
        L_0x02f8:
            r1 = r13.cBi;	 Catch:{ Exception -> 0x032a }
            r1 = r1.databaseHelper;	 Catch:{ Exception -> 0x032a }
            r1 = r1.getConnectionSource();	 Catch:{ Exception -> 0x032a }
            r2 = new com.fossil.cop$3$3;	 Catch:{ Exception -> 0x032a }
            r2.<init>(r13, r14, r0);	 Catch:{ Exception -> 0x032a }
            com.j256.ormlite.misc.TransactionManager.callInTransaction(r1, r2);	 Catch:{ Exception -> 0x032a }
        L_0x030a:
            r0 = r13.cBi;	 Catch:{ Exception -> 0x0335 }
            r0 = r0.databaseHelper;	 Catch:{ Exception -> 0x0335 }
            r0 = r0.getConnectionSource();	 Catch:{ Exception -> 0x0335 }
            r1 = new com.fossil.cop$3$4;	 Catch:{ Exception -> 0x0335 }
            r1.<init>(r13);	 Catch:{ Exception -> 0x0335 }
            com.j256.ormlite.misc.TransactionManager.callInTransaction(r0, r1);	 Catch:{ Exception -> 0x0335 }
        L_0x031c:
            r0 = com.fossil.cop.TAG;	 Catch:{ Exception -> 0x0220 }
            r1 = "------- Done upgrade database version 5 --------";	 Catch:{ Exception -> 0x0220 }
            com.misfit.frameworks.common.log.MFLogger.m12672i(r0, r1);	 Catch:{ Exception -> 0x0220 }
            goto L_0x0229;	 Catch:{ Exception -> 0x0220 }
        L_0x0325:
            r0 = move-exception;	 Catch:{ Exception -> 0x0220 }
            r1.close();	 Catch:{ Exception -> 0x0220 }
            throw r0;	 Catch:{ Exception -> 0x0220 }
        L_0x032a:
            r0 = move-exception;	 Catch:{ Exception -> 0x0220 }
            r0.printStackTrace();	 Catch:{ Exception -> 0x0220 }
            r0 = r13.cBi;	 Catch:{ Exception -> 0x0220 }
            r0.aes();	 Catch:{ Exception -> 0x0220 }
            goto L_0x0130;	 Catch:{ Exception -> 0x0220 }
        L_0x0335:
            r0 = move-exception;	 Catch:{ Exception -> 0x0220 }
            r0.printStackTrace();	 Catch:{ Exception -> 0x0220 }
            goto L_0x031c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fossil.cop.3.execute(android.database.sqlite.SQLiteDatabase):void");
        }

        C22683(cop com_fossil_cop) {
            this.cBi = com_fossil_cop;
        }
    }

    class C22694 implements Callable<Boolean> {
        final /* synthetic */ cop cBi;

        C22694(cop com_fossil_cop) {
            this.cBi = com_fossil_cop;
        }

        public /* synthetic */ Object call() throws Exception {
            return xT();
        }

        public Boolean xT() throws Exception {
            try {
                TableUtils.clearTable(this.cBi.databaseHelper.getConnectionSource(), ContactGroup.class);
                TableUtils.clearTable(this.cBi.databaseHelper.getConnectionSource(), Contact.class);
                TableUtils.clearTable(this.cBi.databaseHelper.getConnectionSource(), PhoneNumber.class);
                TableUtils.clearTable(this.cBi.databaseHelper.getConnectionSource(), EmailAddress.class);
                return Boolean.valueOf(true);
            } catch (Exception e) {
                MFLogger.m12671e(cop.TAG, "Inside .forceClearAllTables exception when drop all table, e=" + e);
                return Boolean.valueOf(false);
            }
        }
    }

    public cop(Context context, String str) {
        super(context, str);
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        Map<Integer, UpgradeCommand> dbUpgrades = super.getDbUpgrades();
        if (dbUpgrades == null) {
            dbUpgrades = new HashMap();
        }
        dbUpgrades.put(Integer.valueOf(2), new C22621(this));
        dbUpgrades.put(Integer.valueOf(4), new C22632(this));
        dbUpgrades.put(Integer.valueOf(5), new C22683(this));
        return dbUpgrades;
    }

    private void aes() {
        try {
            TransactionManager.callInTransaction(this.databaseHelper.getConnectionSource(), new C22694(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int m7389d(List<jt<Integer, Integer>> list, int i) {
        for (jt jtVar : list) {
            if (((Integer) jtVar.first).intValue() == i) {
                return ((Integer) jtVar.second).intValue();
            }
        }
        return -1;
    }

    private List<jt<Integer, Integer>> m7384a(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(true, "contact", new String[]{"contactId", "contact_group_id"}, null, null, null, null, null, null);
        List<jt<Integer, Integer>> arrayList = new ArrayList();
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(query.getColumnIndex("contactId"));
                int i2 = query.getInt(query.getColumnIndex("contact_group_id"));
                MFLogger.m12670d(TAG, "Add pair contactGroupid=" + i2 + ", contacId=" + i);
                arrayList.add(new jt(Integer.valueOf(i2), Integer.valueOf(i)));
                query.moveToNext();
            }
            query.close();
        }
        return arrayList;
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public List<Integer> getLocalContactId() {
        Exception e;
        List<Integer> arrayList = new ArrayList();
        try {
            for (String[] strArr : getContactDao().queryRaw("SELECT contactId FROM contact", new String[0]).getResults()) {
                int parseInt = Integer.parseInt(strArr[0]);
                arrayList.add(Integer.valueOf(parseInt));
                MFLogger.m12670d(TAG, ".Inside step 1 - get Id on local DB, contactId=" + parseInt);
            }
        } catch (SQLException e2) {
            e = e2;
            MFLogger.m12670d(TAG, ".Inside step 1 , SQLiteException, ex=" + e);
            e.printStackTrace();
            return arrayList;
        } catch (SQLiteException e3) {
            e = e3;
            MFLogger.m12670d(TAG, ".Inside step 1 , SQLiteException, ex=" + e);
            e.printStackTrace();
            return arrayList;
        }
        return arrayList;
    }

    public List<Integer> getContactGroupId(List<Integer> list) {
        Exception e;
        List<Integer> arrayList = new ArrayList();
        try {
            for (String[] strArr : getContactDao().queryRaw("SELECT contact_group_id FROM contact WHERE contactId IN " + transformInCondition(list), new String[0]).getResults()) {
                int parseInt = Integer.parseInt(strArr[0]);
                arrayList.add(Integer.valueOf(parseInt));
                MFLogger.m12670d(TAG, ".Inside step 3 - get contact group Id, contactGroupId=" + parseInt);
            }
        } catch (SQLException e2) {
            e = e2;
            MFLogger.m12670d(TAG, ".Inside step 3 , SQLiteException, ex=" + e);
            e.printStackTrace();
            return arrayList;
        } catch (SQLiteException e3) {
            e = e3;
            MFLogger.m12670d(TAG, ".Inside step 3 , SQLiteException, ex=" + e);
            e.printStackTrace();
            return arrayList;
        }
        return arrayList;
    }

    public void removeLocalRedundantContact(List<Integer> list) {
        final StringBuilder transformInCondition = transformInCondition(list);
        try {
            TransactionManager.callInTransaction(this.databaseHelper.getConnectionSource(), new Callable<Boolean>(this) {
                final /* synthetic */ cop cBi;

                public /* synthetic */ Object call() throws Exception {
                    return xT();
                }

                public Boolean xT() throws Exception {
                    try {
                        this.cBi.getContactDao().queryRaw("DELETE FROM contact WHERE contactId NOT IN " + transformInCondition, new String[0]);
                        MFLogger.m12670d(cop.TAG, ".Inside step 4 - remove redundant contact, executed sql, IN condition=DELETE FROM contact WHERE contactId NOT IN " + transformInCondition);
                        return Boolean.valueOf(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        MFLogger.m12670d(cop.TAG, ".Inside step 4 - remove redundant contact, exception=" + e);
                        return Boolean.valueOf(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, ".Inside step 4 - remove redundant contact, Exception outside, exception=" + e);
        }
    }

    public void m7401T(List<Integer> list) {
        final StringBuilder transformInCondition = transformInCondition(list);
        try {
            TransactionManager.callInTransaction(this.databaseHelper.getConnectionSource(), new Callable<Boolean>(this) {
                final /* synthetic */ cop cBi;

                public /* synthetic */ Object call() throws Exception {
                    return xT();
                }

                public Boolean xT() throws Exception {
                    try {
                        this.cBi.getContactGroupDao().queryRaw("DELETE FROM contactgroup WHERE id NOT IN " + transformInCondition, new String[0]);
                        MFLogger.m12670d(cop.TAG, ".Inside step 5 - remove redundant contact group, executed sql=DELETE FROM contactgroup WHERE id NOT IN " + transformInCondition);
                        return Boolean.valueOf(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        MFLogger.m12670d(cop.TAG, ".Inside step 5 - remove redundant contact group, Exception outside, exception=" + e);
                        return Boolean.valueOf(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, ".Inside step 5 - remove redundant contact group, Exception, exception=" + e);
        }
    }

    public void removePhoneNumber(List<Integer> list) {
        final StringBuilder transformInCondition = transformInCondition(list);
        try {
            TransactionManager.callInTransaction(this.databaseHelper.getConnectionSource(), new Callable<Boolean>(this) {
                final /* synthetic */ cop cBi;

                public /* synthetic */ Object call() throws Exception {
                    return xT();
                }

                public Boolean xT() throws Exception {
                    try {
                        this.cBi.getPhoneNumberDao().queryRaw("DELETE FROM phonenumber WHERE phone_number_id NOT IN " + transformInCondition, new String[0]);
                        MFLogger.m12670d(cop.TAG, ".Inside step 6 - remove phone number, executed sql=DELETE FROM phonenumber WHERE phone_number_id NOT IN " + transformInCondition);
                        return Boolean.valueOf(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        MFLogger.m12670d(cop.TAG, ".Inside step 6 - remove phone number, exception=" + e);
                        return Boolean.valueOf(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, ".Inside step 6 - remove phone number, exception=" + e);
        }
    }

    public void removePhoneNumberByContactGroupId(final int i) {
        try {
            TransactionManager.callInTransaction(this.databaseHelper.getConnectionSource(), new Callable<Boolean>(this) {
                final /* synthetic */ cop cBi;

                public /* synthetic */ Object call() throws Exception {
                    return xT();
                }

                public Boolean xT() throws Exception {
                    try {
                        this.cBi.getPhoneNumberDao().queryRaw("DELETE FROM phonenumber WHERE phone_number_id = '" + i + "'", new String[0]);
                        MFLogger.m12670d(cop.TAG, ".Inside removePhoneNumberByContactGroupId, executed sql=DELETE FROM phonenumber WHERE phone_number_id = '" + i + "'");
                        return Boolean.valueOf(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        MFLogger.m12670d(cop.TAG, ".Inside removePhoneNumberByContactGroupId, exception=" + e);
                        return Boolean.valueOf(false);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            MFLogger.m12670d(TAG, ".Inside removePhoneNumberByContactGroupId, exception=" + e);
        }
    }

    public Contact getContactById(int i) {
        try {
            return (Contact) getContactDao().queryForEq("contactId", Integer.valueOf(i)).get(0);
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "getContactById, ex=" + e);
            e.printStackTrace();
            return null;
        }
    }

    private StringBuilder transformInCondition(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append(intValue2);
        }
        stringBuilder.append(")");
        return stringBuilder;
    }
}
