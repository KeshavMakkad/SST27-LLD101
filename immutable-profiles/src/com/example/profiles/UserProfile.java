package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(Builder userProfileBuilder) {
        this.id = userProfileBuilder.id;
        this.email = userProfileBuilder.email;
        this.phone = userProfileBuilder.phone;
        this.displayName = userProfileBuilder.displayName;
        this.address = userProfileBuilder.address;
        this.marketingOptIn = userProfileBuilder.marketingOptIn;
        this.twitter = userProfileBuilder.twitter;
        this.github = userProfileBuilder.github;
    }

    public static final class Builder {
        private final String id;
        private final String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public Builder(String id, String email) {
            this.id = id;
            this.email = email;
        }

        public Builder(String id, String email, String phone) {
            this(id, email);
            this.phone = phone;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setMarketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public Builder setTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public Builder setGithub(String github) {
            this.github = github;
            return this;
        }

        public UserProfile build() {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);

            if (displayName != null && displayName.length() > 100)
                displayName = displayName.substring(0, 100);

            return new UserProfile(this);
        }
    }

    // dont need to make deep copy as all fields return copies and not ref

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAddress() {
        return address;
    }

    public boolean isMarketingOptIn() {
        return marketingOptIn;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getGithub() {
        return github;
    }
}
