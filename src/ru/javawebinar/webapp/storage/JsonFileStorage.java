package ru.javawebinar.webapp.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.javawebinar.webapp.model.Resume;

import java.io.*;

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
        try (DataOutputStream dos = new DataOutputStream(os)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(r);
            dos.writeUTF(json);
        }

    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            Resume r = new Gson().fromJson(dis.readUTF(), Resume.class);
            System.out.println(r);
            return r;
        }
    }

    @Override
    public boolean isSectionSupported() {
        return false;
    }
}
