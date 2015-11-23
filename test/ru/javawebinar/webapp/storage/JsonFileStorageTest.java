package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.Config;

/**
 * Created by DPC on 24.11.2015.
 */
public class JsonFileStorageTest extends AbstractStorageTest {
    public JsonFileStorageTest() {
        super(new JsonFileStorage(Config.STORAGE));
    }
}