package design.patterns.social_networks;

import design.patterns.iterators.FacebookIterator;
import design.patterns.iterators.ProfileIterator;
import design.patterns.profile.Profile;

import java.util.ArrayList;
import java.util.List;

// Concrete Collection
public class Facebook implements SocialNetwork {

    private List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromFacebook(String profileEmail) {
        // here would be a POST request to one of the Facebook API endpoints.
        // instead, we emulate long network connection, which you would expect in the real life
        simulateNetworkLatency();
        System.out.println("""
                Facebook: Loading profile %s over the network...
                """.formatted(profileEmail));

        // ...and return test data
        return findProfile(profileEmail);
    }

    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
        // Here would be a POST request to one of the Facebook API endpoints.
        // Instead, we emulate long network connection, which you would expect
        // in the real life...
        simulateNetworkLatency();
        System.out.println("""
                Facebook: Loading %s list of %s over the network...
                """.formatted(contactType, profileEmail));

        // ... and return test data
        Profile profile = findProfile(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "coworkers", profileEmail);
    }
}
