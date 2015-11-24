package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.io.*;

/**
 * GKislin
 * 30.10.2015.
 */
// TODO implements with ObjectOutputStream, ObjectInputStream
public class SerializeFileStorage extends AbstractFileStorage {

    public SerializeFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(Resume r, OutputStream os)  throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }

    }

    @Override
    protected Resume read(InputStream is) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();

        }
    }
}
