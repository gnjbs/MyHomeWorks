package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * GKislin
 * 30.10.2015.
 */
// TODO Optional try implements section
public class JsonFileStorage extends AbstractFileStorage {

    public JsonFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(Resume r, OutputStream os) throws IOException {

    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        return null;
    }

    @Override
    public boolean isSectionSupported() {
        return false;
    }
}
