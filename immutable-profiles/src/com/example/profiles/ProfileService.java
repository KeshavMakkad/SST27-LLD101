package com.example.profiles;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("bad id");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("bad email");

        UserProfile p = new UserProfile.Builder(id, email).build();
        // later code keeps mutating...
        return p;
    }

    public void updateDisplayName(UserProfile p, String displayName) {
        if (p == null)
            throw new IllegalArgumentException("null profile");

        p = new UserProfile.Builder(p.getId(), p.getEmail())
                .setPhone(p.getPhone())
                .setDisplayName(displayName)
                .setAddress(p.getAddress())
                .setMarketingOptIn(p.isMarketingOptIn())
                .setTwitter(p.getTwitter())
                .setGithub(p.getGithub())
                .build();
    }
}
