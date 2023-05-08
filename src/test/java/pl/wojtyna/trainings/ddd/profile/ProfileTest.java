package pl.wojtyna.trainings.ddd.profile;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.wojtyna.trainings.ddd.crowdsorcery.profile.Profile;
import pl.wojtyna.trainings.ddd.crowdsorcery.profile.ProfileRepository;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void testGetProfile() throws Exception {
        Profile profile = new Profile();
        profile.setFirstName("John");
        profile.setLastName("Doe");
        profileRepository.save(profile);

        mockMvc.perform(get("/accounts/" + profile.getId())
                            .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.firstName", is("John")))
               .andExpect(jsonPath("$.lastName", is("Doe")));
    }
}

