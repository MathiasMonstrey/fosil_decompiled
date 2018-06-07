package com.fossil.cloudimagelib;

public class Constants {

    public enum CalibrationType {
        TYPE_HOUR("calibration_hour"),
        TYPE_MINUTE("calibration_minute"),
        TYPE_SUB_EYE("calibration_subeye"),
        TYPE_COMPLETE("calibration_complete"),
        NONE("none");
        
        private String type;

        private CalibrationType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum DeviceType {
        TYPE_LARGE("device_large"),
        TYPE_MID("device_mid"),
        TYPE_SMALL("device_small"),
        NONE("none");
        
        private String type;

        private DeviceType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum DownloadAssetType {
        DEVICE,
        CALIBRATION,
        BOTH
    }

    public enum Feature {
        DEVICE("DEVICE"),
        CALIBRATION("CALIBRATION");
        
        private String feature;

        private Feature(String str) {
            this.feature = str;
        }

        public String getFeature() {
            return this.feature;
        }
    }

    public enum Resolution {
        MDPI("MDPI"),
        HDPI("HDPI"),
        XHDPI("XHDPI"),
        XXHDPI("XXHDPI");
        
        private String resolution;

        private Resolution(String str) {
            this.resolution = str;
        }

        public String getName() {
            return this.resolution;
        }
    }
}
