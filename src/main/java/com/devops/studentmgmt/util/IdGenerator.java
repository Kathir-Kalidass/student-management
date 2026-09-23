package com.devops.studentmgmt.util;

/**
 * Utility class that generates sequential integer IDs.
 */
public class IdGenerator {
    private int current = 0;

    public synchronized int nextId() {
        return ++current;
    }
}
