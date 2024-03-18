package design.patterns.iterators;

import design.patterns.profile.Profile;


// Iterator
public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
