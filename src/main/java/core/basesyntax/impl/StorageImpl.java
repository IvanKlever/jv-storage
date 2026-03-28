package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_ARRAY = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE_ARRAY];
        this.values = (V[]) new Object[SIZE_ARRAY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && this.keys[i] == null)
                    || (this.keys[i] != null && this.keys[i].equals(key))) {
                this.values[i] = value;
                return;
            }
        }
        if (size < this.keys.length) {
            this.keys[size] = key;
            this.values[size] = value;
            size++;
        } else {
            System.out.println("The storage is full");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && this.keys[i] == null)
                    || (this.keys[i] != null && this.keys[i].equals(key))) {
                return this.values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
