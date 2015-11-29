package ru.javawebinar.webapp.util;

import com.google.gson.*;
import ru.javawebinar.webapp.model.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by DPC on 29.11.2015.
 */
public class GsonResumeAdapter implements JsonSerializer<Resume>, JsonDeserializer<Resume> {

    @Override
    public JsonElement serialize(Resume resume, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject retValue = new JsonObject();
        retValue.addProperty("uuid", resume.getUuid());
        retValue.addProperty("name", resume.getFullName());

        JsonArray jContacts = new JsonArray();
        Map<ContactType, String> contactTypeStringMap = resume.getContacts();
        for (Map.Entry<ContactType, String> entry : contactTypeStringMap.entrySet()) {
            jContacts.add("ContactType : " + entry.getKey().name() + " ContactValue : " + entry.getValue());
        }
        retValue.add("contacts", jContacts);

        JsonArray jSections = new JsonArray();
        Map<SectionType, Section> sectionsMap = resume.getSections();
        for (Map.Entry<SectionType, Section> entry : sectionsMap.entrySet()) {
            SectionType type = entry.getKey();
            Section section = entry.getValue();
            retValue.addProperty("SectionType", type.name());
            switch (type) {
                case OBJECTIVE:
                    retValue.addProperty("TextSection", ((TextSection) section).getContent());
                    break;
                case ACHIEVEMENT:
                case QUALIFICATIONS:
                    List<String> jMultiSections = ((MultiTextSection) section).getLines();
                    JsonArray jMSections = new JsonArray();
                    for (String elem : jMultiSections){
                        jMSections.add(elem);
                    }
                    retValue.add("MultiTextSection", jMSections);
                    break;
                case EXPERIENCE:
                case EDUCATION:
                    break;
            }
            retValue.add("sections", jSections);




        }
        return retValue;
    }

    @Override
    public Resume deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Resume resume = new Resume();
        return resume;
    }


}
