package fitnessclub;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberListTest {

    @Test
    public void add() {
        MemberList members = new MemberList();

        Date dob = new Date(3,29,2003);
        Date expire = new Date(4,16,2025);
        Profile profile = new Profile("Jon" ,"Doe", dob);
        Location location = StudioManager.getLocation("piscataway");
        Member basic = new Basic(profile,expire,location);

        Date dob2 = new Date(3,29,2003);
        Date expire2 = new Date(4,16,2025);
        Profile profile2 = new Profile("Jon" ,"Doe", dob2);
        Location location2 = StudioManager.getLocation("piscataway");
        Member basic2 = new Basic(profile2,expire2,location2);

        Date dob3 = new Date(3,29,2004);
        Date expire3 = new Date(4,16,2025);
        Profile profile3 = new Profile("Joon" ,"Doe", dob3);
        Location location3 = StudioManager.getLocation("piscataway");
        Member family = new Family(profile3,expire3,location3);

        Date dob4 = new Date(3,29,2004);
        Date expire4 = new Date(4,16,2025);
        Profile profile4 = new Profile("Joon" ,"Doe", dob4);
        Location location4 = StudioManager.getLocation("piscataway");
        Member family2 = new Family(profile4,expire4,location4);

        Date dob5 = new Date(3,29,2004);
        Date expire5 = new Date(4,16,2025);
        Profile profile5 = new Profile("Joon" ,"Done", dob5);
        Location location5 = StudioManager.getLocation("piscataway");
        Member premium = new Family(profile5,expire5,location5);

        Date dob6 = new Date(3,29,2004);
        Date expire6 = new Date(4,16,2025);
        Profile profile6 = new Profile("Joon" ,"Done", dob6);
        Location location6 = StudioManager.getLocation("piscataway");
        Member premium2 = new Family(profile6,expire6,location6);

        assertTrue(members.add(basic));
        assertFalse(members.add(basic2));
        assertTrue(members.add(family));
        assertFalse(members.add(family2));
        assertTrue(members.add(premium));
        assertFalse(members.add(premium2));
    }

    @Test
    public void remove() {
        MemberList members = new MemberList();
        Date dob = new Date(3,29,2003);
        Date expire = new Date(4,16,2025);
        Profile profile = new Profile("Jon" ,"Doe", dob);
        Location location = StudioManager.getLocation("piscataway");
        Member basic = new Basic(profile,expire,location);
        members.add(basic);

        assertTrue(members.remove(basic));
        assertFalse(members.remove(basic));
    }
}