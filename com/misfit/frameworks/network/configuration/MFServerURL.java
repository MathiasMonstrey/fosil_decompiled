package com.misfit.frameworks.network.configuration;

public class MFServerURL {

    class MFProductionUrl {
        public static final String CUCUMBER_BASE_URL = "https://cucumber.misfit.com/api/v1";
        public static final String DEVELOPER_API_BASE_URL = "https://build.misfit.com";
        public static final String DEVELOP_API_BASE_URL = "https://build.misfit.com";
        public static final String HOME_BASE_URL = "https://home.misfit.com/shine/v8";
        public static final String LINK_BASE_URL = "https://link.misfit.com/flash-button/v1";
        public static final String SHINE_BASE_URL = "https://api.misfit.com/shine/v8/pedometers";
        public static final String URL_CALLBACK_RESET_PASSWORD = "https://sso.misfit.com/auth/resetpassword";

        MFProductionUrl() {
        }
    }

    class MFStagingUrl {
        public static final String CUCUMBER_BASE_URL = "https://cucumber-int.misfit.com/api/v1";
        public static final String DEVELOPER_API_BASE_URL = "https://build.int.misfit.com";
        public static final String DEVELOP_API_BASE_URL = "https://build.int.misfit.com";
        public static final String HOME_BASE_URL = "https://home.int.misfit.com/shine/v";
        public static final String LINK_BASE_URL = "https://link.int.misfit.com/flash-button/v1";
        public static final String SHINE_BASE_URL = "https://api.int.misfit.com/shine/v8/pedometers";
        public static final String URL_CALLBACK_RESET_PASSWORD = "https://sso.int.misfit.com/auth/resetpassword";

        MFStagingUrl() {
        }
    }
}
