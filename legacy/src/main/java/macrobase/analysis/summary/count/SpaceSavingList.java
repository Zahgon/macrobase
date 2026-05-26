package macrobase.analysis.summary.count;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceSavingList extends ApproximateCount {

    private static final Logger log = LoggerFactory.getLogger(SpaceSavingList.class);

    Map<Integer, CounterToken> digest = new HashMap<>();

    CounterGroup groupHead = null;

    private final int maxSize;

    private double totalCount;

    @Override
    public double getTotalCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class CounterGroup {

        private double differential;

        private CounterGroup prev;

        private CounterGroup next;

        private CounterToken tokenList;

        private CounterGroup(double differential, CounterGroup prev, CounterGroup next, CounterToken counterToken) {
            this.differential = differential;
            this.prev = prev;
            this.next = next;
            this.tokenList = counterToken;
            counterToken.group = this;
        }

        public void removeIfEmpty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void addCounter(CounterToken t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // returns replaced token
        public CounterToken replaceOneToken(CounterToken newToken) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void removeToken(CounterToken token) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class CounterToken {

        private int item;

        private CounterGroup group;

        private CounterToken prev;

        private CounterToken next;

        private CounterToken(int item, CounterGroup group, CounterToken next) {
            this.item = item;
            this.group = group;
            this.next = next;
        }
    }

    @Override
    public double getCount(int item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void incrementCounter(CounterToken token, Double by) {
        CounterGroup currentGroup = token.group;
        // we are at the end of the groups (highest count)
        if (currentGroup.next == null) {
            // we are the only matching token
            if (currentGroup.tokenList == token && token.next == null) {
                currentGroup.differential += by;
            } else // insert a new token at the end
            {
                currentGroup.removeToken(token);
                CounterGroup newGroup = new CounterGroup(by, currentGroup, null, token);
                currentGroup.next = newGroup;
            }
        } else // perfect match on next group
        if (currentGroup.next.differential == by) {
            currentGroup.removeToken(token);
            currentGroup.next.addCounter(token);
        } else // we are between current and current.next; insert a new token
        if (currentGroup.next != null && currentGroup.next.differential > by) {
            currentGroup.next.differential -= by;
            // if this is the only token in the list, just increment
            if (currentGroup.tokenList == token && token.next == null) {
                currentGroup.differential += by;
            } else {
                currentGroup.removeToken(token);
                CounterGroup newGroup = new CounterGroup(by, currentGroup, currentGroup.next, token);
                currentGroup.next.prev = newGroup;
                currentGroup.next = newGroup;
            }
        } else // we fall after the next token in line
        if (currentGroup.next != null && currentGroup.next.differential < by) {
            currentGroup.removeToken(token);
            insertNextMatchingGroup(currentGroup, token, by);
        }
    }

    private void insertNextMatchingGroup(CounterGroup currentGroup, CounterToken token, double remaining) {
        // find the group we want to insert ourselves after
        CounterGroup gteGroup = currentGroup.next;
        CounterGroup prevGroup = null;
        while (remaining > 0 && gteGroup != null) {
            remaining -= gteGroup.differential;
            prevGroup = gteGroup;
            gteGroup = gteGroup.next;
            assert (gteGroup == null || gteGroup.prev == prevGroup);
        }
        // we should be the new tail node
        if (remaining > 0) {
            CounterGroup newGroup = new CounterGroup(remaining, prevGroup, null, token);
            if (prevGroup != null) {
                prevGroup.next = newGroup;
            }
        } else // we matched exactly!
        if (remaining == 0) {
            prevGroup.addCounter(token);
        } else // insert ourselves before the last node we visited
        {
            double delta = -remaining;
            // insert ourselves before...
            prevGroup.differential -= delta;
            CounterGroup newGroup = new CounterGroup(delta, prevGroup.prev, prevGroup, token);
            if (prevGroup == groupHead) {
                groupHead = newGroup;
                prevGroup.prev = newGroup;
            } else {
                prevGroup.prev.next = newGroup;
                prevGroup.prev = newGroup;
            }
        }
    }

    @Override
    public void observe(Integer item, double count) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<Integer, Double> getCounts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void multiplyAllCounts(Double by) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void debugPrint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SpaceSavingList(int maxSize) {
        this.maxSize = maxSize;
    }
}
