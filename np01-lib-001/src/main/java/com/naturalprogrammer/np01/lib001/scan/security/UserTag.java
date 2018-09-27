package com.naturalprogrammer.np01.lib001.scan.security;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserTag implements Serializable {

	private static final long serialVersionUID = 8790753082114620569L;
	private String name;	
}
