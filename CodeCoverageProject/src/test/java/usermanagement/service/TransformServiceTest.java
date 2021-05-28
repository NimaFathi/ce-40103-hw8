package usermanagement.service;


import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;
import usermanagement.entity.Person;
import org.junit.Before;

@RunWith(MockitoJUnitRunner.class)
public class TransformServiceTest {

    private static final String NAME = "name";
    private static final String TEST_COMPANY = "Test";
    private static final Integer PERSON_ID = 1234;
    private Person person = new Person();
    private User user = new User();
    private TransformService traformer = new TransformService();

    @Test
    public void test_toUserDomain() {
        User newUser = traformer.toUserDomain(person);

        assertEquals(NAME, newUser.getFirstName());
        assertEquals(PERSON_ID, newUser.getUserId());
    }
    @Test
    public void test_toUserEntity() {
        Person newPerson = traformer.toUserEntity(user);

        assertEquals(NAME, newPerson.getfName());
        assertEquals(TEST_COMPANY, newPerson.getCompanyName());
    }

    @Before
    public void setup() {
        person.setfName(NAME);
        person.setPersonId(PERSON_ID);
        person.setCompanyName(TEST_COMPANY);
        user.setFirstName(NAME);
        user.setCompanyName(TEST_COMPANY);
    }
}
