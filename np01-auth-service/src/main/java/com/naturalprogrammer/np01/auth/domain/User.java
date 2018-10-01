package com.naturalprogrammer.np01.auth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.naturalprogrammer.np01.lib001.scan.security.UserTag;
import com.naturalprogrammer.spring.lemon.commons.util.UserUtils;
import com.naturalprogrammer.spring.lemon.domain.AbstractUser;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usr")
@Getter @Setter
public class User extends AbstractUser<Long> {

    private static final long serialVersionUID = 2716710947175132319L;

    public static final int NAME_MIN = 1;
    public static final int NAME_MAX = 50;

	@JsonView(UserUtils.SignupInput.class)
	@NotBlank(message = "{blank.name}", groups = {UserUtils.SignUpValidation.class, UserUtils.UpdateValidation.class})
    @Size(min=NAME_MIN, max=NAME_MAX, groups = {UserUtils.SignUpValidation.class, UserUtils.UpdateValidation.class})
    @Column(nullable = false, length = NAME_MAX)
    private String name;
	
	@Override
	public UserTag toTag() {
		
		UserTag tag = new UserTag();
		tag.setName(name);
		return tag;
	}
}