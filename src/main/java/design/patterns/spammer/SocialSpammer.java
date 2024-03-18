package design.patterns.spammer;

import design.patterns.iterators.ProfileIterator;
import design.patterns.profile.Profile;
import design.patterns.social_networks.SocialNetwork;

// Client
public class SocialSpammer {

    public SocialNetwork network;

    public ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("Iterating over friends...");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("Iterating over coworkers...");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        System.out.println("""
                Send message to %s. Message body: %s
                """.formatted(email, message));
    }
}
