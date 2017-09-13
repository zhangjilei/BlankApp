package org.blankapp;

public class Configuration {

    private boolean mLoggingEnabled = false;

    public Configuration() {
    }

    public boolean isLoggingEnabled() {
        return mLoggingEnabled;
    }

    public void setLoggingEnabled(boolean enabled) {
        this.mLoggingEnabled = enabled;
    }

    public static class Builder {
        private boolean mLoggingEnabled = false;

        public Builder setLoggingEnabled(boolean enabled) {
            this.mLoggingEnabled = enabled;
            return this;
        }

        public Configuration create() {
            Configuration configuration = new Configuration();

            configuration.mLoggingEnabled = mLoggingEnabled;

            return configuration;
        }

    }
}
