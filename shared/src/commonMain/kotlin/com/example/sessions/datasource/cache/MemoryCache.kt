package com.example.sessions.datasource.cache

/**
 * A cache implementation based on a map
 * @param K The type of the key
 * @param V The type of the value
 */
class MemoryCache<K, V> {
    private val map = mutableMapOf<K, V>()

    /**
     * Adds the value
     * @property key The key for the value
     * @property value The value of the key
     */
    fun add(key: K, value: V) {
        map[key] = value
    }

    /**
     * Gets the value of the key or null when not exists
     * @property key The key of the desired value
     */
    fun get(key: K): V? {
        return map[key]
    }

    /**
     * Remove a value by it's key
     * @property key The key of the value to remove
     */
    fun remove(key: K) {
        map.remove(key)
    }
}