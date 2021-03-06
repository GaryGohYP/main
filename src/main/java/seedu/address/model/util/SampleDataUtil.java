package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.doctor.Doctor;
import seedu.address.model.doctor.MedicalDepartment;
import seedu.address.model.patient.MedicalRecord;
import seedu.address.model.patient.Patient;
import seedu.address.model.person.Address;
import seedu.address.model.person.Appointment;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nric;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    // NOTE: Error when whitespace inserted Appointment
    public static final ArrayList<Appointment> SAMPLE_APPOINTMENT_LIST_A =
            new ArrayList<>(Arrays.asList(
                    new Appointment("22.11.2018,1300,1400,Bernice Yu,S2810085Z,Alex Yeoh,S3038746E")));
    public static final ArrayList<Appointment> SAMPLE_APPOINTMENT_LIST_B =
            new ArrayList<>(Arrays.asList(
                    new Appointment("22.11.2018,1300,1400,Bernice Yu,S2810085Z,Alex Yeoh,S3038746E"),
                    new Appointment("22.11.2018,1401,1430,Bernice Yu,S2810085Z,Charlotte Oliveiro,S1861343C"),
                    new Appointment("22.11.2018,1431,1445,Bernice Yu,S2810085Z,David Li,S3860937H")));
    public static final ArrayList<Appointment> SAMPLE_APPOINTMENT_LIST_C =
            new ArrayList<>(Arrays.asList(
                    new Appointment("22.11.2018,1401,1430,Bernice Yu,S2810085Z,Charlotte Oliveiro,S1861343C")));
    public static final ArrayList<Appointment> SAMPLE_APPOINTMENT_LIST_D =
            new ArrayList<>(Arrays.asList(
                    new Appointment("22.11.2018,1431,1445,Bernice Yu,S2810085Z,David Li,S3860937H")));

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Patient(new Name("Alex Yeoh"), new Nric("S3038746E"), new Phone("87438807"),
                    new Email("alexyeoh@example.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
                    getTagSet("hokkien only"), SAMPLE_APPOINTMENT_LIST_A,
                    new MedicalRecord("12.12.2018", "flu", "tamiflu", "")),
            new Doctor(new Name("Bernice Yu"), new Nric("S2810085Z"), new Phone("99272758"),
                    new Email("berniceyu" + "@example.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    getTagSet("colleagues", "friends"), SAMPLE_APPOINTMENT_LIST_B,
                    new MedicalDepartment("Neurology")),
            new Patient(new Name("Charlotte Oliveiro"), new Nric("S1861343C"), new Phone("93210283"),
                    new Email("charlotte@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    getTagSet("neighbours"), SAMPLE_APPOINTMENT_LIST_C,
                    new MedicalRecord("22.22.2017", "cough",
                            "Dextromethorphan", "take thrice a day")),
            new Patient(new Name("David Li"), new Nric("S3860937H"), new Phone("91031282"),
                    new Email("lidavid@example.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    getTagSet("family"), SAMPLE_APPOINTMENT_LIST_D,
                    new MedicalRecord("20.10.2018", "Stage 3 testicular cancer",
                            "Orchiectomy for both testicles", "15% chance of survival")),
            new Doctor(new Name("Irfan Ibrahim"), new Nric("S1536921C"), new Phone("92492021"), new Email("irfan"
                    + "@example.com"), new Address("Blk 47 Tampines Street 20, #17-35"), getTagSet("classmates"),
                    new MedicalDepartment("Obstetrics")),
            new Doctor(new Name("Roy Balakrishnan"), new Nric("S2271707C"), new Phone("92624417"),
                    new Email("royb@example.com"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                    getTagSet("colleagues"), new MedicalDepartment("Cardiology"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns an Appointment list containing the list of strings given.
     */
    public static ArrayList<Appointment> getAppointmentsList(String... strings) {
        return Arrays.stream(strings)
                .map(Appointment::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
