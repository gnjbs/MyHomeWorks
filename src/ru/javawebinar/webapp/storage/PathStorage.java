package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 * GKislin
 * 23.10.2015.
 */
// TODO Optional
public class  PathStorage extends AbstractFileStorage<Path>{
    protected final Path directory;

    @Override
    protected void write(Resume r, OutputStream os) throws IOException {

    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        return null;
    }
}
