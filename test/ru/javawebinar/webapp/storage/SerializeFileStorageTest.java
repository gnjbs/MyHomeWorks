package ru.javawebinar.webapp.storage;


import ru.javawebinar.webapp.Config;

/**
 * Created by DPC on 22.11.2015.
 */
public class SerializeFileStorageTest extends AbstractStorageTest {
    public SerializeFileStorageTest() {
        super(new SerializeFileStorage(Config.STORAGE));
    }
}