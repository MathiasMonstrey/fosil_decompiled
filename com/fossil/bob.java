package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public final class bob {
    public static boc<Long> byA = boc.m5378a("measurement.ad_id_cache_time", 10000, 10000);
    public static boc<Long> byB = boc.m5378a("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static boc<Long> byC = boc.m5378a("measurement.config.cache_time", 86400000, 3600000);
    public static boc<String> byD;
    public static boc<String> byE;
    public static boc<Integer> byF = boc.m5381q("measurement.upload.max_bundles", 100, 100);
    public static boc<Integer> byG = boc.m5381q("measurement.upload.max_batch_size", NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    public static boc<Integer> byH = boc.m5381q("measurement.upload.max_bundle_size", NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    public static boc<Integer> byI = boc.m5381q("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static boc<Integer> byJ = boc.m5381q("measurement.upload.max_events_per_day", 100000, 100000);
    public static boc<Integer> byK = boc.m5381q("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static boc<Integer> byL = boc.m5381q("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static boc<Integer> byM = boc.m5381q("measurement.upload.max_conversions_per_day", MFNetworkReturnCode.INTERNAL_SERVER_ERROR, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
    public static boc<Integer> byN = boc.m5381q("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static boc<Integer> byO = boc.m5381q("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static boc<String> byP;
    public static boc<Long> byQ = boc.m5378a("measurement.upload.backoff_period", 43200000, 43200000);
    public static boc<Long> byR = boc.m5378a("measurement.upload.window_interval", 3600000, 3600000);
    public static boc<Long> byS = boc.m5378a("measurement.upload.interval", 3600000, 3600000);
    public static boc<Long> byT = boc.m5378a("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static boc<Long> byU = boc.m5378a("measurement.upload.debug_upload_interval", 1000, 1000);
    public static boc<Long> byV = boc.m5378a("measurement.upload.minimum_delay", 500, 500);
    public static boc<Long> byW = boc.m5378a("measurement.alarm_manager.minimum_interval", 60000, 60000);
    public static boc<Long> byX = boc.m5378a("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    public static boc<Long> byY = boc.m5378a("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static boc<Long> byZ = boc.m5378a("measurement.upload.initial_upload_delay_time", 15000, 15000);
    private static boc<Boolean> bys = boc.m5379b("measurement.service_enabled", true, true);
    private static boc<Boolean> byt = boc.m5379b("measurement.service_client_enabled", true, true);
    private static boc<Boolean> byu = boc.m5379b("measurement.log_third_party_store_events_enabled", false, false);
    private static boc<Boolean> byv = boc.m5379b("measurement.log_installs_enabled", false, false);
    private static boc<Boolean> byw = boc.m5379b("measurement.log_upgrades_enabled", false, false);
    private static boc<Boolean> byx = boc.m5379b("measurement.log_androidId_enabled", false, false);
    public static boc<Boolean> byy = boc.m5379b("measurement.upload_dsid_enabled", false, false);
    public static boc<String> byz = boc.m5380f("measurement.log_tag", "FA", "FA-SVC");
    public static boc<Long> bza = boc.m5378a("measurement.upload.retry_time", 1800000, 1800000);
    public static boc<Integer> bzb = boc.m5381q("measurement.upload.retry_count", 6, 6);
    public static boc<Long> bzc = boc.m5378a("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static boc<Integer> bzd = boc.m5381q("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static boc<Integer> bze = boc.m5381q("measurement.audience.filter_result_max_count", MFNetworkReturnCode.RESPONSE_OK, MFNetworkReturnCode.RESPONSE_OK);
    public static boc<Long> bzf = boc.m5378a("measurement.service_client.idle_disconnect_millis", 5000, 5000);

    static {
        String str = UpPlatformSdkConstants.URI_SCHEME;
        byD = boc.m5380f("measurement.config.url_scheme", str, str);
        str = "app-measurement.com";
        byE = boc.m5380f("measurement.config.url_authority", str, str);
        str = "https://app-measurement.com/a";
        byP = boc.m5380f("measurement.upload.url", str, str);
    }
}
