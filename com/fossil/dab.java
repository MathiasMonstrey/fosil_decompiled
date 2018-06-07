package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fsl.fitness.FitnessProviderImpl;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class dab extends ckb<C2593a, C2595c, C2594b> {

    public static final class C2593a implements C2132b {
        private final double cNh;
        private final double cNi;

        public C2593a(double d, double d2) {
            this.cNh = d;
            this.cNi = d2;
        }

        public double getLatitude() {
            return this.cNh;
        }

        public double getLongitude() {
            return this.cNi;
        }
    }

    public static final class C2594b implements C2131a {
        private int errorCode;

        public C2594b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C2595c implements C2133c {
        private final String cLm;

        public C2595c(String str) {
            this.cLm = str;
        }

        public String getAddress() {
            return this.cLm;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8065a((C2593a) c2132b);
    }

    protected void m8065a(C2593a c2593a) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Throwable th;
        Object e;
        InputStream inputStream2 = null;
        MFLogger.m12670d("GetCityName", "executeUseCase");
        String str = "https://maps.googleapis.com/maps/api/geocode/json?latlng=%f,%f";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format(Locale.US, str, new Object[]{Double.valueOf(c2593a.getLatitude()), Double.valueOf(c2593a.getLongitude())})).openConnection();
            httpURLConnection.setRequestProperty("Accept-Language", Locale.US.toString());
            httpURLConnection.setReadTimeout(FitnessProviderImpl.DEFAULT_DAILY_STEP_GOAL);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (SocketTimeoutException e2) {
                bufferedReader2 = null;
                inputStream2 = inputStream;
                try {
                    MFLogger.m12671e("GetCityName", "GetAddress - e=SocketTimeoutException");
                    abr().onError(new C2594b(404));
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e3) {
                            MFLogger.m12670d("GetCityName", "Exception when closing stream and reader e=" + e3);
                            return;
                        }
                    }
                    if (bufferedReader2 == null) {
                        bufferedReader2.close();
                    }
                } catch (Throwable th2) {
                    inputStream = inputStream2;
                    BufferedReader bufferedReader3 = bufferedReader2;
                    th = th2;
                    bufferedReader = bufferedReader3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            MFLogger.m12670d("GetCityName", "Exception when closing stream and reader e=" + e4);
                            throw th;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (ConnectException e5) {
                bufferedReader = null;
                try {
                    MFLogger.m12671e("GetCityName", "GetAddress - e=ConnectException");
                    abr().onError(new C2594b(404));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e32) {
                            MFLogger.m12670d("GetCityName", "Exception when closing stream and reader e=" + e32);
                            return;
                        }
                    }
                    if (bufferedReader == null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                MFLogger.m12670d("GetCityName", "GetAddress Exception - e=" + e);
                abr().onError(new C2594b(600));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e322) {
                        MFLogger.m12670d("GetCityName", "Exception when closing stream and reader e=" + e322);
                        return;
                    }
                }
                if (bufferedReader == null) {
                    bufferedReader.close();
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine).append("\n");
                }
                str = stringBuilder.toString();
                if (!str.equals("")) {
                    MFLogger.m12670d("GetCityName", "GetAddress jsonData=" + str);
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("results");
                    MFLogger.m12670d("GetCityName", "GetAddress jsonArray=" + jSONArray);
                    if (jSONArray != null) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                        MFLogger.m12670d("GetCityName", "GetAddress addressObject=" + jSONObject);
                        if (jSONObject != null) {
                            abr().onSuccess(new C2595c(jSONObject.getString("formatted_address")));
                        } else {
                            abr().onError(new C2594b(404));
                        }
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3222) {
                        MFLogger.m12670d("GetCityName", "Exception when closing stream and reader e=" + e3222);
                        return;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (SocketTimeoutException e7) {
                bufferedReader2 = bufferedReader;
                inputStream2 = inputStream;
                MFLogger.m12671e("GetCityName", "GetAddress - e=SocketTimeoutException");
                abr().onError(new C2594b(404));
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (bufferedReader2 == null) {
                    bufferedReader2.close();
                }
            } catch (ConnectException e8) {
                MFLogger.m12671e("GetCityName", "GetAddress - e=ConnectException");
                abr().onError(new C2594b(404));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader == null) {
                    bufferedReader.close();
                }
            } catch (Exception e9) {
                e = e9;
                MFLogger.m12670d("GetCityName", "GetAddress Exception - e=" + e);
                abr().onError(new C2594b(600));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader == null) {
                    bufferedReader.close();
                }
            }
        } catch (SocketTimeoutException e10) {
            bufferedReader2 = null;
            MFLogger.m12671e("GetCityName", "GetAddress - e=SocketTimeoutException");
            abr().onError(new C2594b(404));
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (bufferedReader2 == null) {
                bufferedReader2.close();
            }
        } catch (ConnectException e11) {
            bufferedReader = null;
            inputStream = null;
            MFLogger.m12671e("GetCityName", "GetAddress - e=ConnectException");
            abr().onError(new C2594b(404));
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader == null) {
                bufferedReader.close();
            }
        } catch (Exception e12) {
            e = e12;
            bufferedReader = null;
            inputStream = null;
            MFLogger.m12670d("GetCityName", "GetAddress Exception - e=" + e);
            abr().onError(new C2594b(600));
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader == null) {
                bufferedReader.close();
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }
}
