package com.portfolio.platform.ui.debug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.fossil.ctj;
import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogcatActivity extends ctj {
    private C4942a cHP;
    private RecyclerView cHQ;
    private AsyncTask<Void, Void, Void> cHR;
    private boolean isRunning;

    class C49391 implements OnItemSelectedListener {
        final /* synthetic */ LogcatActivity cHS;

        C49391(LogcatActivity logcatActivity) {
            this.cHS = logcatActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.cHS.kb(i);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C4942a extends a<C4943b> {
        final /* synthetic */ LogcatActivity cHS;
        private List<String> cHU;

        private C4942a(LogcatActivity logcatActivity) {
            this.cHS = logcatActivity;
            this.cHU = new ArrayList();
        }

        public /* synthetic */ v m15722c(ViewGroup viewGroup, int i) {
            return m15723m(viewGroup, i);
        }

        public C4943b m15723m(ViewGroup viewGroup, int i) {
            return new C4943b(this.cHS, LayoutInflater.from(this.cHS).inflate(R.layout.logcat_item, viewGroup, false));
        }

        public void m15721a(C4943b c4943b, int i) {
            String str = (String) this.cHU.get(i);
            if (str != null && c4943b != null) {
                c4943b.cHX.setText(Html.fromHtml(str));
            }
        }

        public int getItemCount() {
            return this.cHU.size();
        }

        public void hR(final String str) {
            if (!this.cHS.isFinishing() && !this.cHS.isDestroyed()) {
                this.cHS.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C4942a cHW;

                    public void run() {
                        if (!this.cHW.cHU.contains(str)) {
                            this.cHW.cHU.add(0, str);
                            this.cHW.ds(0);
                            this.cHW.cHS.cHQ.dg(0);
                        }
                    }
                });
            }
        }

        public void clear() {
            this.cHU.clear();
            notifyDataSetChanged();
        }
    }

    class C4943b extends v {
        final /* synthetic */ LogcatActivity cHS;
        private TextView cHX;

        public C4943b(LogcatActivity logcatActivity, View view) {
            this.cHS = logcatActivity;
            super(view);
            this.cHX = (TextView) view.findViewById(R.id.tv_logcat_item);
        }
    }

    public static void bF(Context context) {
        context.startActivity(new Intent(context, LogcatActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_logcat);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_filter);
        spinner.getBackground().setColorFilter(Color.parseColor("#AA7744"), Mode.SRC_ATOP);
        SpinnerAdapter createFromResource = ArrayAdapter.createFromResource(this, R.array.debug_log_filter, 17367048);
        createFromResource.setDropDownViewResource(17367049);
        spinner.setAdapter(createFromResource);
        spinner.setOnItemSelectedListener(new C49391(this));
        this.cHQ = (RecyclerView) findViewById(R.id.logcat_text);
        this.cHQ.setHasFixedSize(true);
        h linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.cHQ.setLayoutManager(linearLayoutManager);
        this.cHP = new C4942a();
        this.cHQ.setAdapter(this.cHP);
    }

    private void kb(final int i) {
        if (!this.isRunning) {
            this.cHP.clear();
            this.isRunning = true;
            Toast.makeText(this, "Collecting log...", 0).show();
            this.cHR = new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ LogcatActivity cHS;

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m15718c((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m15717a((Void) obj);
                }

                protected Void m15718c(Void... voidArr) {
                    try {
                        String str = "";
                        if (i == 0) {
                            str = "logcat -v time -d " + PortfolioApp.ZQ().getPackageName() + ":V";
                        } else if (i == 1) {
                            str = "logcat -v time -d ButtonService:V BaseProfile:V TrackerProfile:V LinkProfile:V *:S";
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        int i = 0;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            i++;
                            stringBuilder.insert(0, readLine + "<br>");
                            if (i >= 50) {
                                this.cHS.cHP.hR(this.cHS.hQ(stringBuilder.toString()));
                                stringBuilder.setLength(0);
                                stringBuilder = new StringBuilder();
                                i = 0;
                            }
                        }
                        if (i > 0) {
                            this.cHS.cHP.hR(this.cHS.hQ(stringBuilder.toString()));
                        }
                        Runtime.getRuntime().exec("logcat -c");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                protected void m15717a(Void voidR) {
                    Toast.makeText(this.cHS, "Done", 0).show();
                    this.cHS.isRunning = false;
                }
            };
            this.cHR.execute(new Void[0]);
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.cHR != null) {
            this.cHR.cancel(true);
        }
    }

    private String hQ(String str) {
        Pattern compile = Pattern.compile("(E/[A-Za-z0-9_-]+)");
        Pattern compile2 = Pattern.compile("(I/[A-Za-z0-9_-]+)");
        Pattern compile3 = Pattern.compile("(W/[A-Za-z0-9_-]+)");
        CharSequence stringBuffer = new StringBuffer(str.length());
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "<font color=\"#d8152a\">" + matcher.group(1) + "</font>");
        }
        matcher.appendTail(stringBuffer);
        matcher = compile2.matcher(stringBuffer);
        CharSequence stringBuffer2 = new StringBuffer(str.length());
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer2, "<font color=\"#46a924\">" + matcher.group(1) + "</font>");
        }
        matcher.appendTail(stringBuffer2);
        matcher = compile3.matcher(stringBuffer2);
        StringBuffer stringBuffer3 = new StringBuffer(str.length());
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer3, "<font color=\"#f0da23\">" + matcher.group(1) + "</font>");
        }
        matcher.appendTail(stringBuffer3);
        return stringBuffer3.toString();
    }
}
