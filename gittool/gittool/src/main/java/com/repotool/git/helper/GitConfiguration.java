package com.repotool.git.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("spring")
public class GitConfiguration {

	private String giturl;

	public String getGiturl() {
		return giturl;
	}

	public void setGiturl(String giturl) {
		this.giturl = giturl;
	}
	
	
}
