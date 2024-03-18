package design.patterns.social_networks;

import design.patterns.iterators.ProfileIterator;

// Iterable Collection
public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
