package com.portfolio.platform.response.microapp;

import com.fossil.cfj;
import com.fossil.cst;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.model.microapp.Range;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MFGetVariantsResponse extends MFResponse {
    private List<cst> mMicroAppVariants = new ArrayList();
    private Range mRange;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject.has("_items")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("_items");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        cst com_fossil_cst = new cst();
                        if (jSONObject2.has("id")) {
                            com_fossil_cst.setId(jSONObject2.getString("id"));
                        }
                        if (jSONObject2.has("appId")) {
                            com_fossil_cst.setAppId(jSONObject2.getString("appId"));
                        }
                        if (jSONObject2.has("name")) {
                            com_fossil_cst.setName(jSONObject2.getString("name"));
                        }
                        if (jSONObject2.has("description")) {
                            com_fossil_cst.setDescription(jSONObject2.getString("description"));
                        }
                        if (jSONObject2.has(MicroAppVariant.COLUMN_MAJOR_NUMBER)) {
                            com_fossil_cst.setMajorNumber(jSONObject2.getInt(MicroAppVariant.COLUMN_MAJOR_NUMBER));
                        }
                        if (jSONObject2.has(MicroAppVariant.COLUMN_MINOR_NUMBER)) {
                            com_fossil_cst.setMinorNumber(jSONObject2.getInt(MicroAppVariant.COLUMN_MINOR_NUMBER));
                        }
                        if (jSONObject2.has("updatedAt")) {
                            com_fossil_cst.setUpdateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("updatedAt")).getMillis());
                        }
                        if (jSONObject2.has("createdAt")) {
                            com_fossil_cst.setCreateAt(ISODateTimeFormat.dateTimeNoMillis().parseDateTime(jSONObject2.getString("createdAt")).getMillis());
                        }
                        if (jSONObject2.has(MicroAppVariant.COLUMN_DECLARATION_FILES)) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(MicroAppVariant.COLUMN_DECLARATION_FILES);
                            List arrayList = new ArrayList();
                            if (jSONArray2.length() > 0) {
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                                    DeclarationFile declarationFile = new DeclarationFile();
                                    if (jSONObject3.has(DeclarationFile.COLUMN_FILE_ID)) {
                                        declarationFile.setFileId(jSONObject3.getString(DeclarationFile.COLUMN_FILE_ID));
                                    }
                                    if (jSONObject3.has("description")) {
                                        declarationFile.setDescription(jSONObject3.getString("description"));
                                    }
                                    if (jSONObject3.has("content")) {
                                        declarationFile.setContent(jSONObject3.getString("content"));
                                    }
                                    arrayList.add(declarationFile);
                                }
                            }
                            com_fossil_cst.setDeclarationFiles(arrayList);
                        }
                        this.mMicroAppVariants.add(com_fossil_cst);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONObject.has("_range")) {
            try {
                this.mRange = (Range) new cfj().c(jSONObject.getJSONObject("_range").toString(), Range.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<cst> getMicroAppVariations() {
        return this.mMicroAppVariants;
    }

    public Range getRange() {
        return this.mRange;
    }
}
