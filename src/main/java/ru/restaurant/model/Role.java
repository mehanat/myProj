package ru.restaurant.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by �������� on 23.04.2016.
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

        @Override
        public String getAuthority() {
            return name();
        }

}
