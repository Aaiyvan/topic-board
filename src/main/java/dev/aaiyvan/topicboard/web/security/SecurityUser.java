package dev.aaiyvan.topicboard.web.security;

import dev.aaiyvan.topicboard.domain.model.user.Role;
import dev.aaiyvan.topicboard.domain.model.user.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityUser implements UserDetails {

    UUID id;
    String username;
    String password;
    Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(
            final User user
    ) {
        this(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
        this.authorities = mapToGrantedAuthorities(new ArrayList<>(user.getRoles()));
    }

    private List<SimpleGrantedAuthority> mapToGrantedAuthorities(
            final List<Role> roles
    ) {
        return roles.stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private SecurityUser(
            final UUID id,
            final String username,
            final String password
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
