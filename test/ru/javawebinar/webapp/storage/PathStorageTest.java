package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.Config;

/**
 * Created by DPC on 14.11.2015.
 */
public class PathStorageTest extends AbstractStorageTest{

    public PathStorageTest() {
        super(new DataStreamFileStorage(Config.STORAGE));
    }

}