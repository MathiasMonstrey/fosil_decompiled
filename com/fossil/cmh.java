package com.fossil;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.support.v8.renderscript.Allocation;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class cmh implements xe<cme> {
    private static final String TAG = cmh.class.getSimpleName();

    public /* synthetic */ us m7078c(Object obj, int i, int i2) {
        return m7077a((cme) obj, i, i2);
    }

    public us<InputStream> m7077a(final cme com_fossil_cme, int i, int i2) {
        return new us<InputStream>(this) {
            final /* synthetic */ cmh cxu;

            public /* synthetic */ Object m7075d(Priority priority) throws Exception {
                return m7076e(priority);
            }

            public InputStream m7076e(Priority priority) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    if (com_fossil_cme.getData() == null) {
                        MFLogger.m12670d(cmh.TAG, ".Inside loadData, return due to model.getData() = null");
                        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    }
                    Bitmap bitmap;
                    List<Bitmap> arrayList = new ArrayList(5);
                    int i = 0;
                    for (BaseFeatureModel baseFeatureModel : com_fossil_cme.getData()) {
                        int i2;
                        if (baseFeatureModel instanceof ContactGroup) {
                            for (Contact contact : ((ContactGroup) baseFeatureModel).getContacts()) {
                                if (arrayList.size() < 5) {
                                    Object b;
                                    if (!TextUtils.isEmpty(contact.getPhotoThumbUri()) && dqq.jj(contact.getPhotoThumbUri()) != null) {
                                        b = dqq.m9400b(Long.valueOf((long) contact.getContactId()));
                                    } else if (contact.getContactId() == -100) {
                                        b = dqq.m9393A(PortfolioApp.ZQ().getResources().getDrawable(R.drawable.ic_notifications_calls));
                                    } else if (contact.getContactId() == -200) {
                                        b = dqq.m9393A(PortfolioApp.ZQ().getResources().getDrawable(R.drawable.ic_notifications_texts));
                                    } else {
                                        b = dqq.m9398a(contact);
                                    }
                                    arrayList.add(b);
                                }
                                i++;
                            }
                        }
                        int i3 = i;
                        MFLogger.m12670d(cmh.TAG, ".Inside loadData, done processing contact bitmap");
                        if (baseFeatureModel instanceof AppFilter) {
                            if (arrayList.size() < 5) {
                                PackageManager packageManager = PortfolioApp.ZQ().getPackageManager();
                                try {
                                    Drawable drawableForDensity;
                                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(((AppFilter) baseFeatureModel).getType(), Allocation.USAGE_SHARED);
                                    if (applicationInfo.icon != 0) {
                                        try {
                                            drawableForDensity = packageManager.getResourcesForApplication(applicationInfo).getDrawableForDensity(applicationInfo.icon, 480);
                                        } catch (Exception e) {
                                            Exception exception = e;
                                            drawableForDensity = PortfolioApp.ZQ().getPackageManager().getApplicationIcon(applicationInfo.packageName);
                                            MFLogger.m12670d(cmh.TAG, ".Inside loadData, get app icon exception=" + exception);
                                        }
                                    } else {
                                        drawableForDensity = PortfolioApp.ZQ().getPackageManager().getApplicationIcon(applicationInfo.packageName);
                                    }
                                    arrayList.add(dqq.m9393A(drawableForDensity));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            i2 = i3 + 1;
                        } else {
                            i2 = i3;
                        }
                        i = i2;
                    }
                    MFLogger.m12670d(cmh.TAG, ".Inside loadData, done processing app filter bitmap");
                    int i4 = 0;
                    for (Bitmap bitmap2 : arrayList) {
                        if (bitmap2 != null) {
                            i4 = Math.max(i4, Math.max(bitmap2.getWidth(), bitmap2.getHeight()));
                        }
                    }
                    MFLogger.m12670d(cmh.TAG, ".Inside loadData, bitmap target size=" + i4 + " ,itemCounter=" + i);
                    switch (i) {
                        case 0:
                            bitmap2 = null;
                            break;
                        case 1:
                            bitmap2 = (Bitmap) arrayList.get(0);
                            break;
                        case 2:
                            bitmap2 = dqq.m9395a((Bitmap) arrayList.get(0), (Bitmap) arrayList.get(1), i4);
                            break;
                        case 3:
                            bitmap2 = dqq.m9396a((Bitmap) arrayList.get(0), (Bitmap) arrayList.get(1), (Bitmap) arrayList.get(2), i4);
                            break;
                        case 4:
                            bitmap2 = dqq.m9397a((Bitmap) arrayList.get(0), (Bitmap) arrayList.get(1), (Bitmap) arrayList.get(2), (Bitmap) arrayList.get(3), i4);
                            break;
                        default:
                            Bitmap jl = dqq.jl("+" + String.valueOf((i - 4) + 1));
                            bitmap2 = dqq.m9397a((Bitmap) arrayList.get(0), (Bitmap) arrayList.get(1), (Bitmap) arrayList.get(2), jl, i4);
                            arrayList.add(jl);
                            break;
                    }
                    MFLogger.m12670d(cmh.TAG, ".Inside loadData, done switch itemCounter");
                    if (bitmap2 != null) {
                        bitmap2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    }
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e22) {
                    MFLogger.m12670d(cmh.TAG, "loadData exception=" + e22);
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
            }

            public void lG() {
            }

            public String getId() {
                try {
                    List<BaseFeatureModel> data = com_fossil_cme.getData();
                    StringBuilder stringBuilder = new StringBuilder();
                    if (data != null) {
                        for (BaseFeatureModel baseFeatureModel : data) {
                            if (baseFeatureModel instanceof AppFilter) {
                                stringBuilder.append(((AppFilter) baseFeatureModel).getType());
                            } else {
                                List contacts = ((ContactGroup) baseFeatureModel).getContacts();
                                if (!(contacts == null || contacts.isEmpty())) {
                                    stringBuilder.append(((Contact) contacts.get(0)).getFirstName()).append(((Contact) contacts.get(0)).getLastName());
                                }
                            }
                        }
                    }
                    MFLogger.m12670d(cmh.TAG, ".Inside getId, id=" + stringBuilder);
                    return stringBuilder.toString();
                } catch (Exception e) {
                    MFLogger.m12670d(cmh.TAG, ".Inside getId, exception=" + e);
                    return "";
                }
            }

            public void cancel() {
            }
        };
    }
}
