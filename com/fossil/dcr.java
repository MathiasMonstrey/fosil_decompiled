package com.fossil;

import android.database.Cursor;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView.C1264v;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.ui.notifications.domain.model.ContactWrapper;
import com.portfolio.platform.view.FlexibleTextView;
import com.portfolio.platform.view.FossilNotificationImageView;
import java.util.List;

public class dcr extends dct<C2669b> implements SectionIndexer {
    private static final String TAG = dcr.class.getSimpleName();
    private List<ContactWrapper> cPA;
    private int cPM;
    private List<ContactGroup> cPV;
    private int cPW = 0;
    private int cPX = 1;
    private int cPY = 2;
    private C2658a cPZ;
    private AlphabetIndexer cQa;
    private final tz cow;

    public interface C2658a {
        void mo2274c(ContactWrapper contactWrapper, int i);

        void cd(int i, int i2);

        void mo2280d(ContactWrapper contactWrapper, int i);
    }

    public class C2669b extends C1264v implements OnClickListener {
        ConstraintLayout cPT;
        TextView cQb;
        ImageView cQc;
        TextView cQd;
        FossilNotificationImageView cQe;
        ImageView cQf;
        FlexibleTextView cQg;
        FlexibleTextView cQh;
        String cQi;
        String cQj;
        String cQk;
        int cQl;
        boolean cQm;
        final /* synthetic */ dcr cQn;
        int contactId;
        String phoneNumber;

        public C2669b(dcr com_fossil_dcr, View view) {
            this.cQn = com_fossil_dcr;
            super(view);
            this.cQb = (TextView) view.findViewById(R.id.pick_contact_title);
            this.cQc = (ImageView) view.findViewById(R.id.remove_contact);
            this.cQd = (TextView) view.findViewById(R.id.reassign_contact);
            this.cQe = (FossilNotificationImageView) view.findViewById(R.id.avatar);
            this.cQf = (ImageView) view.findViewById(R.id.add_contact);
            this.cPT = (ConstraintLayout) view.findViewById(R.id.container);
            this.cQg = (FlexibleTextView) view.findViewById(R.id.alpha);
            this.cQh = (FlexibleTextView) view.findViewById(R.id.pick_contact_phone);
            this.cQe.setTopRightBadge(true);
            this.cQf.setOnClickListener(this);
            this.cQc.setOnClickListener(this);
            this.cQd.setOnClickListener(this);
        }

        private void m8310a(Cursor cursor, int i, int i2) {
            cursor.moveToPosition(i2);
            MFLogger.m12670d(dcr.TAG, ".Inside render data, cursor move position=" + i2);
            this.cQi = cursor.getString(cursor.getColumnIndex("display_name"));
            this.cQj = cursor.getString(cursor.getColumnIndex("photo_thumb_uri"));
            this.contactId = cursor.getInt(cursor.getColumnIndex("contact_id"));
            this.cQl = cursor.getInt(cursor.getColumnIndex("has_phone_number"));
            this.phoneNumber = cursor.getString(cursor.getColumnIndex("data1"));
            this.cQk = cursor.getString(cursor.getColumnIndex("sort_key"));
            this.cQm = cursor.getInt(cursor.getColumnIndex("starred")) == 1;
            this.cQb.setText(this.cQi);
            Uri uri = null;
            if (!TextUtils.isEmpty(this.cQj)) {
                uri = Uri.parse(this.cQj);
            }
            this.cQn.cow.a(new cmg()).bc(new cmb(uri, this.cQi)).b(new xq[]{new cmn(PortfolioApp.ZQ())}).c(this.cQe.getFossilCircleImageView());
            if (TextUtils.isEmpty(this.cQj)) {
                this.cQe.avn();
                this.cQe.setBackground(gn.m10632c(PortfolioApp.ZQ(), R.drawable.oval_solid_light_grey));
            } else {
                this.cQe.avo();
                this.cQe.setBackgroundResource(R.color.transparent);
            }
            if (this.cQl == 1) {
                this.cQh.setVisibility(0);
                this.cQh.setText(this.phoneNumber);
            } else {
                this.cQh.setVisibility(8);
            }
            kU(i);
            MFLogger.m12670d(dcr.TAG, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            MFLogger.m12670d(dcr.TAG, "Inside renderData, Name =" + this.cQi + " ,hand=" + i + " , newSortKey=" + this.cQk);
            MFLogger.m12670d(dcr.TAG, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (i2 == this.cQn.getPositionForSection(this.cQn.getSectionForPosition(i2))) {
                this.cQg.setVisibility(0);
                this.cQg.setText(Character.toString(cnd.gn(this.cQk)));
                return;
            }
            this.cQg.setVisibility(8);
        }

        private void kS(int i) {
            this.cQe.a(R.drawable.ic_notifications_calls, this.cQn.cow);
            this.cQb.setText(PortfolioApp.ZQ().getResources().getString(R.string.all_call));
            this.cQg.setVisibility(8);
            this.contactId = -100;
            kU(i);
        }

        private void kT(int i) {
            this.cQe.a(R.drawable.ic_notifications_texts, this.cQn.cow);
            this.cQb.setText(PortfolioApp.ZQ().getResources().getString(R.string.all_text));
            this.cQg.setVisibility(8);
            this.contactId = -200;
            kU(i);
        }

        private void kU(int i) {
            ContactWrapper contactWrapper = null;
            for (ContactWrapper contactWrapper2 : this.cQn.cPA) {
                ContactWrapper contactWrapper22;
                if (contactWrapper22.getContact().getContactId() != this.contactId) {
                    contactWrapper22 = contactWrapper;
                }
                contactWrapper = contactWrapper22;
            }
            if (contactWrapper != null) {
                if (contactWrapper.isAdded()) {
                    this.cQc.setVisibility(0);
                    this.cQf.setVisibility(8);
                    this.cQd.setVisibility(8);
                } else {
                    this.cQf.setVisibility(0);
                    this.cQc.setVisibility(8);
                    this.cQd.setVisibility(8);
                }
                if (contactWrapper.getCurrentHandGroup() == 0 || contactWrapper.getCurrentHandGroup() == i) {
                    this.cQe.setHandNumber(null);
                    return;
                }
                this.cQe.setHandNumber(String.valueOf(contactWrapper.getCurrentHandGroup()));
                this.cQf.setVisibility(8);
                this.cQc.setVisibility(8);
                this.cQd.setVisibility(0);
                return;
            }
            if (this.cQn.kQ(this.contactId)) {
                this.cQc.setVisibility(0);
                this.cQf.setVisibility(8);
                this.cQd.setVisibility(8);
            } else {
                this.cQf.setVisibility(0);
                this.cQc.setVisibility(8);
                this.cQd.setVisibility(8);
            }
            int b = this.cQn.kR(this.contactId);
            if (b == 0 || b == i) {
                this.cQe.setHandNumber(null);
                return;
            }
            this.cQe.setHandNumber(String.valueOf(b));
            this.cQf.setVisibility(8);
            this.cQc.setVisibility(8);
            this.cQd.setVisibility(0);
        }

        public void onClick(View view) {
            if (rm() != -1) {
                switch (view.getId()) {
                    case R.id.reassign_contact:
                        if (this.cQn.cPZ != null) {
                            dri.cX(view);
                            this.cQn.cPZ.mo2280d(m8309D(rm(), true), rm());
                            MFLogger.m12670d(dcr.TAG, ".Inside Reassign Contact, contactId=" + this.contactId + " ,name =" + this.cQi + " ,hand=" + this.cQn.cPM + " ,rowPosition=" + rm());
                            return;
                        }
                        return;
                    case R.id.add_contact:
                        if (this.cQn.cPZ != null) {
                            dri.cX(view);
                            this.cQn.cPZ.mo2274c(m8309D(rm(), false), rm());
                            MFLogger.m12670d(dcr.TAG, ".Inside Add Contact, contactId=" + this.contactId + " name=" + this.cQi + " ,hand=" + this.cQn.cPM + " ,rowPosition=" + rm());
                            return;
                        }
                        return;
                    case R.id.remove_contact:
                        if (this.cQn.cPZ != null) {
                            dri.cX(view);
                            this.cQn.cPZ.cd(rm(), this.contactId);
                            MFLogger.m12670d(dcr.TAG, ".Inside Remove Contact, contactId=" + this.contactId + " ,name =" + this.cQi + " ,hand=" + this.cQn.cPM + " ,rowPosition=" + rm());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        private ContactWrapper m8309D(int i, boolean z) {
            Contact contact = new Contact();
            if (i == this.cQn.cPW) {
                contact.setContactId(-100);
                contact.setFirstName(PortfolioApp.ZQ().getResources().getString(R.string.all_call));
            } else if (i == this.cQn.cPX) {
                contact.setContactId(-200);
                contact.setFirstName(PortfolioApp.ZQ().getResources().getString(R.string.all_text));
            } else {
                contact.setContactId(this.contactId);
                contact.setFirstName(this.cQi);
                contact.setPhotoThumbUri(this.cQj);
            }
            ContactWrapper contactWrapper = new ContactWrapper(contact, null);
            if (i == this.cQn.cPW) {
                contactWrapper.setHasPhoneNumber(true);
                contactWrapper.getContact().setUseCall(true);
                contactWrapper.getContact().setUseSms(false);
            } else if (i == this.cQn.cPX) {
                contactWrapper.setHasPhoneNumber(true);
                contactWrapper.getContact().setUseCall(false);
                contactWrapper.getContact().setUseSms(true);
            } else {
                if (this.cQl == 1) {
                    contactWrapper.setHasPhoneNumber(true);
                    contactWrapper.setPhoneNumber(this.phoneNumber);
                } else {
                    contactWrapper.setHasPhoneNumber(false);
                }
                contactWrapper.getContact().setUseSms(true);
                contactWrapper.getContact().setUseCall(true);
                contactWrapper.setFavorites(this.cQm);
            }
            if (z) {
                contactWrapper.setCurrentHandGroup(this.cQn.kR(this.contactId));
            } else {
                contactWrapper.setCurrentHandGroup(this.cQn.cPM);
            }
            contactWrapper.setAdded(true);
            return contactWrapper;
        }
    }

    public /* synthetic */ C1264v mo1090c(ViewGroup viewGroup, int i) {
        return m8331p(viewGroup, i);
    }

    public dcr(Cursor cursor, tz tzVar, int i, List<ContactGroup> list, List<ContactWrapper> list2) {
        super(cursor);
        this.cow = tzVar;
        this.cPM = i;
        this.cPV = list;
        this.cPA = list2;
    }

    public Cursor swapCursor(Cursor cursor) {
        this.cQa = new AlphabetIndexer(cursor, cursor.getColumnIndex("display_name"), " ABCDEFGHIJKLMNOPQRTSUVWXYZ");
        this.cQa.setCursor(cursor);
        return super.swapCursor(cursor);
    }

    public void m8329a(C2669b c2669b, Cursor cursor, int i) {
        switch (c2669b.rp()) {
            case 123:
                c2669b.kS(this.cPM);
                MFLogger.m12670d(TAG, ".Inside ALL_CALL_VIEW_TYPE onBindViewHolder, position=" + i);
                return;
            case 456:
                c2669b.kT(this.cPM);
                MFLogger.m12670d(TAG, ".Inside ALL_TEXT_VIEW_TYPE onBindViewHolder, position=" + i);
                return;
            default:
                MFLogger.m12670d(TAG, ".Inside default onBindViewHolder, position=" + i);
                c2669b.m8310a(cursor, this.cPM, i - this.cPY);
                return;
        }
    }

    public C2669b m8331p(ViewGroup viewGroup, int i) {
        return new C2669b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pick_contact, viewGroup, false));
    }

    public int getItemViewType(int i) {
        if (i == this.cPW) {
            return 123;
        }
        if (i == this.cPX) {
            return 456;
        }
        return 789;
    }

    public int getItemCount() {
        return super.getItemCount() + this.cPY;
    }

    public Object[] getSections() {
        return this.cQa.getSections();
    }

    public int getSectionForPosition(int i) {
        return this.cQa.getSectionForPosition(i);
    }

    public int getPositionForSection(int i) {
        return this.cQa.getPositionForSection(i);
    }

    private boolean kQ(int i) {
        for (ContactGroup contacts : this.cPV) {
            for (Contact contactId : contacts.getContacts()) {
                if (contactId.getContactId() == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private int kR(int i) {
        for (ContactGroup contactGroup : this.cPV) {
            for (Contact contactId : contactGroup.getContacts()) {
                if (contactId.getContactId() == i) {
                    return contactGroup.getHour();
                }
            }
        }
        return 0;
    }

    public void ir(String str) {
        int i = 1;
        int i2 = (str.isEmpty() || PortfolioApp.ZQ().getResources().getString(R.string.all_call).toLowerCase().contains(str.toLowerCase())) ? 1 : 0;
        if (!(str.isEmpty() || PortfolioApp.ZQ().getResources().getString(R.string.all_text).toLowerCase().contains(str.toLowerCase()))) {
            i = 0;
        }
        this.cPY = 0;
        if (i2 != 0) {
            this.cPW = 0;
            this.cPY++;
        } else {
            this.cPW = -1;
        }
        if (i != 0) {
            this.cPX = this.cPW + 1;
            this.cPY++;
        } else {
            this.cPX = -1;
        }
        super.getFilter().filter(str);
    }

    public void m8328a(C2658a c2658a) {
        this.cPZ = c2658a;
    }
}
