package org.pac4j.core.profile;

import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.profile.definition.CommonProfileDefinition;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * This class is the base implementation with the default attribute getters which can be retrieved for most profiles.
 *
 * @author Jerome Leleu
 * @since 1.3.0
 */
public class CommonProfile extends UserProfile {

    private static final long serialVersionUID = -1856159870249261877L;

    /**
     * Return the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return (String) getAttribute(CommonProfileDefinition.EMAIL);
    }

    /**
     * Return the first name of the user.
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return (String) getAttribute(CommonProfileDefinition.FIRST_NAME);
    }

    /**
     * Return the family name of the user.
     *
     * @return the family name of the user
     */
    public String getFamilyName() {
        return (String) getAttribute(CommonProfileDefinition.FAMILY_NAME);
    }

    /**
     * Return the displayed name of the user. It can be the username or the first and last names (separated by a space).
     *
     * @return the displayed name of the user
     */
    public String getDisplayName() {
        return (String) getAttribute(CommonProfileDefinition.DISPLAY_NAME);
    }

    /**
     * Return the username of the user. It can be a login or a specific username.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return (String) getAttribute(Pac4jConstants.USERNAME);
    }

    /**
     * Return the gender of the user.
     *
     * @return the gender of the user
     */
    public Gender getGender() {
        final Gender gender = (Gender) getAttribute(CommonProfileDefinition.GENDER);
        if (gender == null) {
            return Gender.UNSPECIFIED;
        } else {
            return gender;
        }
    }

    /**
     * Return the locale of the user.
     *
     * @return the locale of the user
     */
    public Locale getLocale() {
        return (Locale) getAttribute(CommonProfileDefinition.LOCALE);
    }

    /**
     * Return the url of the picture of the user.
     *
     * @return the url of the picture of the user.
     */
    public URI getPictureUrl() {
        return (URI) getAttribute(CommonProfileDefinition.PICTURE_URL);
    }

    /**
     * Return the url of the profile of the user.
     *
     * @return the url of the profile of the user.
     */
    public URI getProfileUrl() {
        return (URI) getAttribute(CommonProfileDefinition.PROFILE_URL);
    }

    /**
     * Return the location of the user.
     *
     * @return the location of the user
     */
    public String getLocation() {
        return (String) getAttribute(CommonProfileDefinition.LOCATION);
    }

    /**
     * Retrieve the audience (for the JwtProfile and OidcProfile).
     *
     * @return the audience
     */
    @SuppressWarnings("unchecked")
    protected List<String> retrieveAudience() {
        final Object audience = getAttribute(CommonProfileDefinition.AUDIENCE);
        if (audience instanceof String) {
            return Collections.singletonList((String) audience);
        } else if (audience instanceof String[]) {
            return Arrays.asList((String[]) audience);
        } else if (audience instanceof List) {
            return (List<String>) audience;
        } else {
            return null;
        }
    }
}
